package pages;

import base.BasePage;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pagesUI.CheckoutPageUI;


public class CheckoutPage extends BasePage {
    private final AppiumDriver driver;
    private final Platform platform;

    public CheckoutPage(AppiumDriver driver) {
        this.driver = driver;
        platform = Platform.valueOf(getPlatformName(driver));
    }

    @Step("Input full name with value is {0}.")
    public void inputFullName(String fullName){
        String locator = CheckoutPageUI.FULL_NAME_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, fullName);
    }

    @Step("Input address 1 with value is {0}.")
    public void inputAddress1(String address){
        String locator = CheckoutPageUI.ADDRESS1_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, address);
    }

    @Step("Input address 2 with value is {0}.")
    public void inputAddress2(String address){
        String locator = CheckoutPageUI.ADDRESS2_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, address);
    }

    @Step("Input city with value is {0}.")
    public void inputCity(String city){
        String locator = CheckoutPageUI.CITY_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, city);
    }

    @Step("Input state with value is {0}.")
    public void inputState(String state){
        String locator = CheckoutPageUI.STATE_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, state);
    }

    @Step("Input country with value is {0}.")
    public void inputCountry(String country){
        String locator = CheckoutPageUI.COUNTRY_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, country);
    }

    @Step("Input zip code with value is {0}.")
    public void inputZipcode(String zipcode){
        String locator = CheckoutPageUI.ZIP_CODE_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, zipcode);
    }

    @Step("Click on Payment button.")
    public void clickPayment(){
        String locator = CheckoutPageUI.PAYMENT_BUTTON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Input payment full name with value is {0}.")
    public void inputPaymentFullName(String fullName){
        String locator = CheckoutPageUI.PAYMENT_FULL_NAME_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, fullName);
    }

    @Step("Input payment card number with values is {0}.")
    public void inputPaymentCardNumber(String cardNumber){
        String locator = CheckoutPageUI.PAYMENT_CARD_NUMBER_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, cardNumber);
    }

    @Step("Input expiration date of payment card with value is {0}.")
    public void inputPaymentExpDate(String expDate){
        String locator = CheckoutPageUI.PAYMENT_EXP_DATE_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, expDate);
    }

    @Step("Input Security Code of payment card with value is {0}.")
    public void inputPaymentSecurityCode(String code){
        String locator = CheckoutPageUI.PAYMENT_SECURITY_TEXTBOX.get(platform);
        sendKeysToElement(driver, locator, code);
    }

    @Step("Click on Review Order button.")
    public void clickReviewOrderButton(){
        String locator = CheckoutPageUI.REVIEW_ORDER_BUTTON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Get number of Total Items.")
    public String getTotalItems(){
        String locator = CheckoutPageUI.TOTAL_ITEM.get(platform);
        return getText(driver, locator);
    }

    @Step("Get number of Total Amount.")
    public String getTotalAmount(){
        String locator = CheckoutPageUI.TOTAL_AMOUNT.get(platform);
        return getText(driver, locator);
    }

    @Step("Click on Place Order button")
    public void clickPlaceOrderButton(){
        String locator = CheckoutPageUI.PLACE_ORDER_BUTTON.get(platform);
        clickOnElement(driver, locator);
    }

    @Step("Get Checkout Complete text.")
    public String getCheckoutCompleteText(){
        String locator = CheckoutPageUI.CHECK_OUT_COMPLETE_TEXT.get(platform);
        return getText(driver, locator);
    }
}
