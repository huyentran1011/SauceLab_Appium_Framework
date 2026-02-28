package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pagesUI.ProductsPageUI;

public class ProductsPage extends BasePage {
    private final AppiumDriver driver;
    private final Platform platform;

    public ProductsPage(AppiumDriver driver) {
        this.driver = driver;
        platform = Platform.valueOf(getPlatformName(driver));
    }

    @Step("Get page Title of Products Page.")
    public String getPageTitle(){
        String locator = ProductsPageUI.PAGE_TITLE.get(platform);
        return getText(driver, locator);
    }


    @Step("Access to Product {0}")
    public void clickOnAProduct(String productName){
        String locator = ProductsPageUI.PRODUCT_ITEM.get(platform);
        scrollUntilDisplay(driver, locator, 10, productName).click();
    }
}
