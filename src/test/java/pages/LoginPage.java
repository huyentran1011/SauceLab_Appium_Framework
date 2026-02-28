package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pagesUI.LoginPageUI;


public class LoginPage extends BasePage {
    private final AppiumDriver driver;
    private final Platform platform;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        platform = Platform.valueOf(getPlatformName(driver));
    }

    @Step("Get Page Title text.")
    public String getPageTitle(){
        String locator = LoginPageUI.PAGE_TITLE.get(platform);
        return getText(driver, locator);
    }

    @Step("Input Username with value is {0}.")
    public void inputUsername(String username){
        String locator = LoginPageUI.USERNAME_TEXTBOX.get(platform);
        if(platform == Platform.IOS){
            setValueNoiOSKeyboard(driver, locator, username);
        }else{
            sendKeysToElement(driver, locator, username);
        }
    }

    @Step("Input Password with value is {0}.")
    public void inputPassword(String password){
        String locator = LoginPageUI.PASSWORD_TEXTBOX.get(platform);
        if(platform == Platform.IOS){
           setValueNoiOSKeyboard(driver, locator, password);
        }else{
            sendKeysToElement(driver, locator, password);
        }
    }

    @Step("Click on Login button.")
    public void clickLoginButton(){
        String locator = LoginPageUI.LOGIN_BUTTON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Get error message of Username textbox.")
    public String getUsernameErrorMsg(){
        String locator = LoginPageUI.USERNAME_ERROR_MSG.get(platform);
        return getText(driver, locator);
    }

    @Step("Get error message of Password textbox.")
    public String getPasswordErrorMsg(){
        String locator = LoginPageUI.PASSWORD_ERROR_MSG.get(platform);
        return getText(driver, locator);
    }

    @Step("Login in to System by Username is {0} and Password is {1}.")
    public void loginToSystem(String username, String password){
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }

}
