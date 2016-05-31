package polyu_af;

/**
 * Created by liushanchen on 16/5/28.
 */
public class TestUnit {
    private String className;
    private String methodName;
    private String Exception;

    public String setQualifyName() {
        return className+"#"+methodName;
    }

    public TestUnit(String className, String methodName, String exception) {
        this.className = className;
        Exception = exception;
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public String getException() {
        return Exception;
    }

    public String getMethodName() {
        return methodName;
    }
}
