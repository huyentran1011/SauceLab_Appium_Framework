package base;

public class GlobalConstants {
    private static GlobalConstants globalInstance;
    private GlobalConstants(){}

    public static synchronized GlobalConstants getGlobalInstance(){
        return globalInstance == null? new GlobalConstants() :  globalInstance;
    }

    // SYSTEM INFO
    private final String projectPath = System.getProperty("user.dir");
    private final String appiumServerURL = "http://127.0.0.1:4723";
    private final String androidAppPath = projectPath + "/src/test/resources/apps/mda-2.2.0-25.apk";
    private final String iOSAppPath = projectPath + "/src/test/resources/apps/MyDemoApp.app";

    // RETRY FAILED CASE
    private final int numberOfRetry = 3;

    // WAIT TIME
    private final long longTimeOut = 30;
    private final long shortTimeOut = 15;

    public String getAppiumServerURL(){return  appiumServerURL; }
    public String getProjectPath() {
        return projectPath;
    }
    public String getAndroidAppPath() {return androidAppPath; }
    public String getiOSAppPath() {return iOSAppPath; }
    public long getLongTimeOut() {
        return longTimeOut;
    }
    public long getShortTimeOut() {
        return shortTimeOut;
    }


}
