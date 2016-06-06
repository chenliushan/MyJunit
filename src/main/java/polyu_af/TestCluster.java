package polyu_af;

import java.util.List;

/**
 * Created by liushanchen on 16/5/28.
 */

/**
 * A cluster of test - one test class which contains a list of test units
 */
public class TestCluster {
    private boolean successful;
    private int failureCount;
    private int runCount;
    private List<TestUnit> failureTestList = null;

    public TestCluster(int failureCount, int runCount, boolean successful) {
        this.failureCount = failureCount;
        this.runCount = runCount;
        this.successful = successful;
    }

    public void setFailureTestList(List<TestUnit> failureTestList) {
        this.failureTestList = failureTestList;
    }

    public int getFailureCount() {
        return failureCount;
    }

    public List<TestUnit> getFailureTestList() {
        return failureTestList;
    }

    public int getRunCount() {
        return runCount;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
