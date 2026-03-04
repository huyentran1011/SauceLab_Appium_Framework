package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pagesUI.AboutPageUI;


public class AboutPage extends BasePage {

    private final AppiumDriver driver;
    private final Platform platform;

    public AboutPage(AppiumDriver driver) {
        this.driver = driver;
        platform = Platform.valueOf(getPlatformName(driver));
    }

    @Step("Get App version.")
    public String getAppVersion(){
        String locator = AboutPageUI.APP_VERSION_TEXT.get(platform);
        return getText(driver, locator);
    }
}
