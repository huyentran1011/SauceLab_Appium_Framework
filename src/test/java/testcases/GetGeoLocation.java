package testcases;
import base.BaseTest;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GeoLocationPage;
import pages.NavigationMenu;
import pages.PageGenerator;

public class GetGeoLocation extends BaseTest {
    private AppiumDriver driver;
    protected Platform platform;
    private GeoLocationPage geoLocationPage;
    private NavigationMenu navigationMenu;

    @Parameters({"platformName", "deviceName", "automationName", "server", "port", "appName"})
    @BeforeMethod
    public void beforeTest(String platformName, String deviceName, String automationName, String server, String port, String appName){
        driver = setUp(platformName, deviceName, automationName, server, port, appName);
        this.platform = Platform.valueOf(platformName.toUpperCase());
    }

    @Description("Get Longitude and Latitude.")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void TC01_getCurrentLocation(){
        navigationMenu = PageGenerator.getNavigationMenu(driver);
        navigationMenu.clickOnMenuIcon();
        navigationMenu.clickOnGeoLocationMenu();
        geoLocationPage = PageGenerator.getGeoLocationPage(driver);
        geoLocationPage.acceptAlert(driver);
        Assert.assertEquals(geoLocationPage.getLongitude(), "13.45143");
        Assert.assertEquals(geoLocationPage.getLatitude(), "52.50032");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        tearDown();
    }
}
