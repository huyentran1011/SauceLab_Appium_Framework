package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pagesUI.ShoppingCartPageUI;

public class ShoppingCartPage extends BasePage {
    private final AppiumDriver driver;
    private final Platform platform;

    public ShoppingCartPage(AppiumDriver driver) {
        this.driver = driver;
        platform = Platform.valueOf(getPlatformName(driver));
    }

    @Step("Verify total Product Quantity in Shopping Cart should be {0}.")
    public Boolean isTotalProductQuantityCorrect(int numberItems){
        String locator = ShoppingCartPageUI.TOTAL_ITEMS.get(platform);
        return isDisplayed(driver, locator, String.valueOf(numberItems));
    }

    @Step("Verify total Product Price in Shopping Cart should be {0}.")
    public Boolean isTotalProductPriceCorrect( float totalProductPrice){
        String locator = ShoppingCartPageUI.TOTAL_PRICE.get(platform);
        String formattedValue = String.format("%.2f", totalProductPrice);
        return isDisplayed(driver, locator, formattedValue);
    }

    @Step("Verify the Product {0} with color is {1} is displayed in the Shopping Cart.")
    public Boolean verifyProductIsDisplayed(String productName, String color){
        String locator = ShoppingCartPageUI.PRODUCT_NAME_AND_COLOR.get(platform);
        return isDisplayed(driver, locator, productName, color);
    }

    @Step("Verify the Product {0} with color is {1} has unit price is {2}.")
    public Boolean isProductPriceCorrect(String productName, String color, float price){
        String locator = ShoppingCartPageUI.PRODUCT_UNIT_PRICE.get(platform);
        if(platform.equals(Platform.ANDROID)){
            return scrollUntilDisplay(driver, locator, 10, productName, String.valueOf(price)).isDisplayed();
        }else {
            return scrollUntilDisplay(driver, locator, 10, productName, color, String.valueOf(price)).isDisplayed();
        }
    }

    @Step("Verify the Product {0} with color is {1} has quantity is {2}.")
    public Boolean isProductQuantityCorrect(String productName, String color, int numberOfItems){
        String locator = ShoppingCartPageUI.PRODUCT_QUANTITY.get(platform);
        if(platform.equals(Platform.ANDROID)){
            return scrollUntilDisplay(driver, locator, 10, productName, String.valueOf(numberOfItems)).isDisplayed();
        }
        return scrollUntilDisplay(driver, locator, 10, productName, color, String.valueOf(numberOfItems)).isDisplayed();
    }

    @Step("Click on Minus Icon of the Product {0} with color is {1}.")
    public void clickOnMinusIconOfProductItem(String productName, String color){
        String locator = ShoppingCartPageUI.SUBTRACT_MINUS_ICON.get(platform);
        clickOnElement(driver, locator, productName, color);
    }

    @Step("Click on Add Icon of the Product {0} with color is {1}.")
    public void clickOnAddIconOfProductItem(String productName, String color){
        String locator = ShoppingCartPageUI.ADD_PLUS_ICON.get(platform);
        clickOnElement(driver, locator, productName, color);
    }

    @Step("Click on Remove Button of the Product {0} with color is {1}.")
    public void clickOnRemoveButtonOfProductItem(String productName, String color){
        String locator = ShoppingCartPageUI.REMOVE_ITEM_BUTTON.get(platform);
        clickOnElement(driver, locator, productName, color);
    }

    @Step("Click on Checkout Button in the Shopping Cart.")
    public void clickOnCheckoutButton(){
        String locator = ShoppingCartPageUI.CHECKOUT_BUTTON.get(platform);
        clickOnElement(driver, locator);
    }
}
