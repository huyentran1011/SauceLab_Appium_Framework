package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pagesUI.ProductDetailPageUI;

import static java.lang.Integer.valueOf;

public class ProductDetailPage extends BasePage {
    private final AppiumDriver driver;
    private final Platform platform;

    public ProductDetailPage(AppiumDriver driver) {
        this.driver = driver;
        platform = Platform.valueOf(getPlatformName(driver));
    }

    @Step("Select product color with value is {0}")
    public void selectProductColor(String color){
        String locator = ProductDetailPageUI.PRODUCT_COLOR_ICON.get(platform);
        clickOnElement(driver, locator, color);
    }

    @Step("Click on Plus icon")
    public void clickOnPlusIcon(){
        String locator = ProductDetailPageUI.ADD_PLUS_ICON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Input Product Quantity with value is {0}")
    public void inputProductQuantity(int expectedQuantity){
        String locator = ProductDetailPageUI.PRODUCT_QUANTITY_TEXT.get(platform);
        String amountText = getText(driver, locator);
        int currentQuantity = Integer.parseInt(amountText);
        int diffAmount = expectedQuantity - currentQuantity;
        if(diffAmount > 0){
            while(diffAmount !=0 ){
                clickOnPlusIcon();
                diffAmount--;
            }
        } else if (diffAmount < 0) {
            while(diffAmount !=0 ){
                clickOnMinusIcon();
                diffAmount++;
            }
        }
    }

    @Step("Click on Minus icon.")
    public void clickOnMinusIcon(){
        String locator = ProductDetailPageUI.SUBTRACT_MINUS_ICON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Click on Add To Cart button.")
    public void clickOnAddToCartButton(){
        String locator = ProductDetailPageUI.ADD_TO_CART_BUTTON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Click on Back button to back to Product list..")
    public void clickBackToProductsButton(){
        String locator = ProductDetailPageUI.BACK_TO_PRODUCTS_BUTTON.get(platform);
        clickOnElement(driver, locator);
    }
}
