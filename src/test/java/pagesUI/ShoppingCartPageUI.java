package pagesUI;

import enums.Platform;

import java.util.Map;

public class ShoppingCartPageUI {
    public final static Map<Platform, String> PAGE_TITLE = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/productTV",
            Platform.IOS, "accessibilityId=My Cart"
    );
    public final static Map<Platform, String> CHECKOUT_BUTTON = Map.of(
            Platform.ANDROID, "accessibilityId=Confirms products for checkout",
            Platform.IOS, "accessibilityId=ProceedToCheckout"
    );

    public final static Map<Platform, String> TOTAL_ITEMS = Map.of(
            Platform.ANDROID, "xpath=//android.widget.LinearLayout[android.widget.TextView[@text='Total:']]/android.widget.TextView[@text='%s Items']",
            Platform.IOS, "xpath=//XCUIElementTypeOther[XCUIElementTypeStaticText[@label='Total:']]/XCUIElementTypeStaticText[@value='%s Items']"
    );

    public final static Map<Platform, String> TOTAL_PRICE = Map.of(
            Platform.ANDROID, "xpath=//android.widget.LinearLayout[android.widget.TextView[@text='Total:']]/android.widget.TextView[@text='$ %s']",
            Platform.IOS, "xpath=//XCUIElementTypeOther[XCUIElementTypeStaticText[@label='Total:']]/XCUIElementTypeStaticText[@value='$%s']"
    );

    public final static Map<Platform, String> PRODUCT_NAME_AND_COLOR = Map.of(
            Platform.ANDROID, "xpath=//android.widget.TextView[contains(@text,'%s')]",
            Platform.IOS, "xpath=//XCUIElementTypeCell[XCUIElementTypeStaticText[contains(@label,'%s')]]/XCUIElementTypeStaticText[@name='%s']"
    );

    public final static Map<Platform, String> SUBTRACT_MINUS_ICON = Map.of(
            Platform.ANDROID, "xpath=//android.view.ViewGroup[android.widget.TextView[@text='%s']]/following-sibling::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView[@content-desc='Decrease item quantity']",
            Platform.IOS, "xpath=//XCUIElementTypeCell[XCUIElementTypeStaticText[@label='%s'] and XCUIElementTypeStaticText[@name='%s']]/XCUIElementTypeButton[@label='SubtractMinus Icons']"
    );

    public final static Map<Platform, String> ADD_PLUS_ICON = Map.of(
            Platform.ANDROID, "xpath=//android.view.ViewGroup[android.widget.TextView[@text='%s']]/following-sibling::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView[@content-desc='Increase item quantity']",
            Platform.IOS, "xpath=//XCUIElementTypeCell[XCUIElementTypeStaticText[@label='%s'] and XCUIElementTypeStaticText[@name='%s']]/XCUIElementTypeButton[@label='AddPlus Icons']"
    );

    public final static Map<Platform, String> PRODUCT_QUANTITY = Map.of(
            Platform.ANDROID, "xpath=//android.view.ViewGroup[android.widget.TextView[contains(@text,'%s')]]/following-sibling::android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='%s']",
            Platform.IOS, "xpath=//XCUIElementTypeCell[XCUIElementTypeStaticText[contains(@label,'%s')] and XCUIElementTypeStaticText[@name='%s']]/XCUIElementTypeStaticText[@label='%s']"
    );

    public final static Map<Platform, String> PRODUCT_UNIT_PRICE = Map.of(
            Platform.ANDROID, "xpath=//android.view.ViewGroup[android.widget.TextView[@text='%s']]/android.widget.TextView[@text='$ %s']",
            Platform.IOS, "xpath=//XCUIElementTypeCell[XCUIElementTypeStaticText[contains(@label,'%s')] and XCUIElementTypeStaticText[@name='%s']]/XCUIElementTypeStaticText[@label='$ %s']"
    );

    public final static Map<Platform, String> REMOVE_ITEM_BUTTON = Map.of(
            Platform.ANDROID, "xpath=//android.view.ViewGroup[android.widget.TextView[@text='%s']]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@text='Remove Item']",
            Platform.IOS, "xpath=//XCUIElementTypeCell[XCUIElementTypeStaticText[@label='%s'] and XCUIElementTypeStaticText[@name=%s]]/XCUIElementTypeButton[@label='Remove Item']"
    );

}
