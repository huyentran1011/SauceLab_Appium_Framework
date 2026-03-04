package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pagesUI.NavigationUI;

public class NavigationMenu extends BasePage {
    private final AppiumDriver driver;
    private final Platform platform;

    public NavigationMenu(AppiumDriver driver) {
        this.driver = driver;
        platform = Platform.valueOf(getPlatformName(driver));
    }

    @Step("Click on Cart icon.")
    public void clickOnCartIcon(){
        String locator = NavigationUI.SHOPPING_CART_ICON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Click on Menu icon.")
    public void clickOnMenuIcon(){
        String locator = NavigationUI.VIEW_MENU_ICON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Click on Catalog menu.")
    public void clickOnCatalogMenu(){
        String locator = NavigationUI.CATALOG_MENU_ITEM.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Click on Login menu.")
    public void clickLoginMenu(){
        String locator = NavigationUI.LOGIN_MENU_ITEM.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Click on Logout menu.")
    public void clickLogoutMenu(){
        String locator = NavigationUI.LOGOUT_MENU_ITEM.get(platform);
        clickOnElement(driver, locator);
    }


    @Step("Verify the Confirm Logout dialog is displayed or not.")
    public Boolean isLogoutDialogDisplayed(){
        String locator = NavigationUI.LOGOUT_DIALOG.get(platform);
        if(platform == Platform.ANDROID){
            return isDisplayed(driver, locator);
        }else {
            System.out.println("This method is only for Android!!");
            return false;
        }

    }

    @Step("Get title in the Confirm Logout dialog.")
    public String getLogoutDialogTitle(){
        String locator = NavigationUI.LOGOUT_DIALOG.get(platform);
        if(platform == Platform.ANDROID){
            return getText(driver, locator);
        }else {
            System.out.println("This method is only for Android!!");
            return "";
        }
    }

    @Step("Get message in the Confirm Logout dialog.")
    public String getLogoutDialogMessage(){
        String locator = NavigationUI.LOGOUT_DIALOG_MSG.get(platform);
        if (platform == Platform.ANDROID){
            return getText(driver, locator);
        } else {
            System.out.println("This method is only for Android!!");
            return "";
        }
    }

    @Step("Click on Cancel Logout button.")
    public void clickCancelLogout(){
        String locator = NavigationUI.LOGOUT_DIALOG_CANCEL_BTN.get(platform);

        if (platform == Platform.ANDROID){
            clickOnElement(driver, locator);
        }else {
            System.out.println("This method is only for Android!!");
        }
    }

    @Step("Click on Confirm Logout button.")
    public void clickConfirmLogout(){
        String locator = NavigationUI.LOGOUT_DIALOG_LOGOUT_BTN.get(platform);

        if (platform == Platform.ANDROID){
            clickOnElement(driver, locator);
        }else {
            System.out.println("This method is only for Android!!");
        }
    }

    @Step("Logout of system.")
    public void logout(){
        clickOnMenuIcon();
        clickLogoutMenu();
        String locator = NavigationUI.LOGOUT_DIALOG_LOGOUT_BTN.get(platform);
        if (platform == Platform.ANDROID){
            clickOnElement(driver, locator);
        }
    }

    @Step("Access to GeoLocation page")
    public void clickOnGeoLocationMenu(){
        String locator = NavigationUI.GEO_LOCATION_MENU_ITEM.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Access to About page")
    public void clickOnAboutMenu(){
        String locator = NavigationUI.ABOUT_MENU_ITEM.get(platform);
        clickOnElement(driver, locator);
    }
}
