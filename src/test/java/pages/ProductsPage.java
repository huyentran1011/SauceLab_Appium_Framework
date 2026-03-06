package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pagesUI.NavigationUI;
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

    @Step("Click on Sort Button")
    public void clickOnSortButton(){
        String locator = ProductsPageUI.SORT_PRODUCTS_BTN.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Select sort by ascending of name")
    public void clickOnNameAscending(){
        String locator = ProductsPageUI.ASCENDING_BY_NAME_OPTION.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Select sort by descending of name")
    public void clickOnNameDescending(){
        String locator = ProductsPageUI.DESCENDING_BY_NAME_OPTION.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Select sort by ascending of price")
    public void clickOnPriceAscending(){
        String locator = ProductsPageUI.ASCENDING_BY_PRICE_OPTION.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Select sort by descending of price")
    public void clickOnPriceDescending(){
        String locator = ProductsPageUI.DESCENDING_BY_PRICE_OPTION.get(platform);
        clickOnElement(driver, locator);
    }
}
