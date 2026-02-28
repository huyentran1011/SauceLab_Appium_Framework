package base;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeSuite;

import java.io.File;


public abstract class BaseTest {
    protected static AppiumDriver driver;
    public static AppiumDriver getDriver() {
        return driver;
    }

    public AppiumDriver setUp(String platformName, String deviceName, String automationName, String server, String port, String appName){
        return DriverFactory.createDriver(platformName, deviceName, automationName, server, port, appName);
    }

    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeSuite
    public void deleteFileInReport() {
        deleteAllFileInFolder("allure-results");
        deleteAllFileInFolder("allure-report");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.getGlobalInstance().getProjectPath() + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void resetApp() {
        driver.resetInputState();
    }

}
