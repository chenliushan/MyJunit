package polyu_af;

/**
 * Created by liushanchen on 16/5/28.
 */
public class TestUnit {
    private String className;
    private String methodName;
    private String exception;
    private String firstTrace;
    private boolean isPassing;

    public String getQualifyName() {
        return className+"#"+methodName;
    }

    public TestUnit(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    public TestUnit(String className, String methodName, String exception, String trace) {
        this.isPassing =false;
        this.className = className;
        this.exception = exception;
        this.methodName = methodName;
        this.firstTrace = trace;
    }

    public boolean isPassing() {
        return isPassing;
    }

    public void setPassing(boolean passing) {
        isPassing = passing;
    }

    public String getClassName() {
        return className;
    }

    public String getException() {
        return exception;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getTrace() {
        return firstTrace;
    }


}
