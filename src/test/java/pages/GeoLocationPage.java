package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pagesUI.GeoLocationPageUI;

public class GeoLocationPage extends BasePage {
    private final AppiumDriver driver;
    private final Platform platform;

    public GeoLocationPage(AppiumDriver driver) {
        this.driver = driver;
        platform = Platform.valueOf(getPlatformName(driver));
    }

    @Step("Get current longitude.")
    public String getLongitude(){
        String locator = GeoLocationPageUI.LONGITUDE_TEXT.get(platform);
        return getText(driver, locator);
    }

    @Step("Get current latitude.")
    public String getLatitude(){
        String locator = GeoLocationPageUI.LATITUDE_TEXT.get(platform);
        return getText(driver, locator);
    }
}
