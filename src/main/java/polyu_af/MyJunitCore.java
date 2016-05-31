package polyu_af;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by liushanchen on 16/5/26.
 */
public class MyJunitCore {
    private static Logger logger = LogManager.getLogger(MyJunitConstants.MyJunitLogName);
    private static Logger loggerM = LogManager.getLogger(MyJunitConstants.MLogName);
    private static Logger loggerVar = LogManager.getLogger(MyJunitConstants.VarLogName);

    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            logger.error("illegal input parameter");
            return;
        }
        JUnitCore core = new JUnitCore();
        for (int i = 0; i < args.length; i++) {
            Result result = processTest(core, args[i]);
            TestCluster testCluster = getReportObj(result);
            logReport(testCluster);
        }
    }

    private static Result processTest(JUnitCore core, String classMethodName) throws ClassNotFoundException {

        String[] classAndMethod = classMethodName.split("#");
        Request request = null;
        if (classAndMethod.length == 1) {
            request = Request.aClass(Class.forName(classAndMethod[0]));
        } else if (classAndMethod.length == 2) {
            request = Request.method(Class.forName(classAndMethod[0]), classAndMethod[1]);
        } else {
            logger.error("illegal input parameter");
            return null;
        }

        core.addListener(new RingingListener());
        return core.run(request);
    }

    private static TestCluster getReportObj(Result result) {
        if (result == null) {
            return null;
        }
        TestCluster testCluster = new TestCluster(result.getFailureCount(),
                result.getRunCount(), result.wasSuccessful());
        List<TestUnit> unitList = new ArrayList<TestUnit>();
        for (Failure f : result.getFailures()) {
            Description d = f.getDescription();
            TestUnit tu = new TestUnit(d.getClassName(), d.getMethodName(), f.getException().toString());
            unitList.add(tu);
        }
        testCluster.setFailureTestList(unitList);
        return testCluster;
    }

    private static void logReport(TestCluster testCluster) {
        if (testCluster == null) {
            return;
        }
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonStr = gson.toJson(testCluster);
        logger.info(jsonStr);
        //        logger.info("Successful:" + result.wasSuccessful());
        //        logger.info("FailureCount:" + result.getFailureCount());
        //        logger.info("RunCount:" + result.getRunCount());
    }


    private static class RingingListener extends RunListener {
        @Override
        public void testFailure(Failure failure) throws Exception {
            super.testFailure(failure);
//            loggerVar.info("########################");
//            loggerM.info("########################"+ failure.getDescription().getClassName() + "#" + failure.getDescription().getMethodName());
//            logger.info("testFailure.getException:" + failure.getException());
        }

        @Override
        public void testFinished(Description description) throws Exception {
            super.testFinished(description);
            loggerM.info(MyJunitConstants.TestFinish+ description.getClassName() + "#" + description.getMethodName());

//            loggerVar.info("-----------------");
        }

        @Override
        public void testStarted(Description description) throws Exception {
            super.testStarted(description);
            loggerM.info(MyJunitConstants.TestStart+ description.getClassName() + "#" + description.getMethodName());

        }


        @Override
        public void testRunFinished(Result result) throws Exception {
            super.testRunFinished(result);


        }

        @Override
        public void testRunStarted(Description description) throws Exception {
            super.testRunStarted(description);
        }


    }
}
