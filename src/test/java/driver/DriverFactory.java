package driver;

import base.GlobalConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    public static AppiumDriver createDriver(String platformName, String deviceName, String automationName, String server, String port, String appName){
        platformName = platformName.toUpperCase();
        AppiumDriver driver;
        String appPath = System.getProperty("user.dir") + "/src/test/resources/apps/" + appName;
        String serverURL = server + ":" + port;
        try{
        if(platformName.equalsIgnoreCase( "android")){
            // Define desired capabilities using UiAutomator2Options (for Android)
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName(deviceName)
                    .setAutomationName(automationName)
                    .setApp(appPath);

            // Connect to Appium server
            URI appiumServerURI = new URI(serverURL);
            URL appiumSeverURL = appiumServerURI.toURL();

            // Initialize driver
            driver = new AndroidDriver(appiumSeverURL, options);

        }else{
            // Define desired capabilities using UiAutomator2Options (for iOS)
            XCUITestOptions options = new XCUITestOptions()
                    .setDeviceName(deviceName)
                    .setAutomationName(automationName)
                    .setApp(appPath);

            // Connect to Appium server
            URI appiumServerURI = new URI(serverURL);
            URL appiumSeverURL = appiumServerURI.toURL();

            // Initialize driver
            driver = new IOSDriver(appiumSeverURL, options);
        }
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Verify driver is initialized
        System.err.println("Appium driver failed to initialize!");
        System.out.println("✅ Appium setup completed successfully.");

    } catch (MalformedURLException e) {
        System.err.println("❌ Invalid Appium server URL: " + e.getMessage());
        throw new RuntimeException(e);
    } catch (Exception e) {
        System.err.println("❌ Error during Appium setup: " + e.getMessage());
        throw new RuntimeException(e);
    }
    return driver;
    }
}
