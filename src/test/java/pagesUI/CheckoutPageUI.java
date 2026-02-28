package pagesUI;

import enums.Platform;

import java.util.Map;

public class CheckoutPageUI {
    public final static Map<Platform, String> FULL_NAME_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/fullNameET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Full Name*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> ADDRESS1_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/address1ET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Address Line 1*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> ADDRESS2_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/address2ET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Address Line 2*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> CITY_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/cityET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='City*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> STATE_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/stateET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='State/Region']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> ZIP_CODE_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/zipET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Zip Code*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> COUNTRY_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/countryET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Country*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> PAYMENT_BUTTON = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/paymentBtn",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name='To Payment']"
    );

    public final static Map<Platform, String> PAYMENT_FULL_NAME_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/nameET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Full Name*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> PAYMENT_CARD_NUMBER_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/cardNumberET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Card Number*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> PAYMENT_EXP_DATE_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/expirationDateET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Expiration Date*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> PAYMENT_SECURITY_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/securityCodeET",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Security Code*']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"
    );

    public final static Map<Platform, String> REVIEW_ORDER_BUTTON = Map.of(
            Platform.ANDROID, "accessibilityId=Saves payment info and launches screen to review checkout data",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name='Review Order']"
    );

    public final static Map<Platform, String> TOTAL_ITEM = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/itemNumberTV",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Total:']/following-sibling::XCUIElementTypeStaticText"
    );

    public final static Map<Platform, String> TOTAL_AMOUNT = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/totalAmountTV",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Total:']/following-sibling::XCUIElementTypeStaticText[1]"
    );

    public final static Map<Platform, String> PLACE_ORDER_BUTTON = Map.of(
            Platform.ANDROID, "accessibilityId=Completes the process of checkout",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name='Place Order']"
    );

    public final static Map<Platform, String> CHECK_OUT_COMPLETE_TEXT = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/completeTV",
            Platform.IOS, "accessibilityId=Checkout Complete"
    );
}
