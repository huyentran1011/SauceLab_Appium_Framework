package testcases;

import base.BaseTest;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.NavigationMenu;
import pages.PageGenerator;

public class AboutInfo extends BaseTest {
    private AppiumDriver driver;
    protected Platform platform;
    private AboutPage aboutPage;
    private NavigationMenu navigationMenu;

    @Parameters({"platformName", "deviceName", "automationName", "server", "port", "appName"})
    @BeforeMethod
    public void beforeTest(String platformName, String deviceName, String automationName, String server, String port, String appName){
        driver = setUp(platformName, deviceName, automationName, server, port, appName);
        this.platform = Platform.valueOf(platformName.toUpperCase());

        navigationMenu = PageGenerator.getNavigationMenu(driver);
        navigationMenu.clickOnMenuIcon();
        navigationMenu.clickOnAboutMenu();
        aboutPage = PageGenerator.getAboutPage(driver);
    }

    @Test
    public void TC01_GetAppVersion(){
        Assert.assertEquals(aboutPage.getAppVersion(), "V.2.2.0-build 25");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        tearDown();
    }
}
