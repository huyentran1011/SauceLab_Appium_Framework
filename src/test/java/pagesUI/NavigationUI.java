package pagesUI;

import enums.Platform;

import java.util.Map;

public class NavigationUI {
    public static final Map<Platform, String> VIEW_MENU_ICON = Map.of(
            Platform.ANDROID, "accessibilityId=View menu",
            Platform.IOS, "accessibilityId=More-tab-item"
    );

    public static final Map<Platform, String> SHOPPING_CART_ICON = Map.of(
            Platform.ANDROID, "accessibilityId=Displays number of items in your cart",
            Platform.IOS, "accessibilityId=Cart-tab-item"
    );

    public static final Map<Platform, String> CATALOG_MENU_ITEM = Map.of(
            Platform.ANDROID, "xpath=//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Catalog']",
            Platform.IOS, "accessibilityId=Catalog-tab-item"
    );
    public static final Map<Platform, String> WEB_VIEW_MENU_ITEM = Map.of(
            Platform.ANDROID, "uiautomator=new UiSelector().text('WebView')",
            Platform.IOS, "accessibilityId=Webview-menu-item"
    );

    public static final Map<Platform, String> QA_CODE_MENU_ITEM = Map.of(
            Platform.ANDROID, "uiautomator=new UiSelector().text('QR Code Scanner')",
            Platform.IOS, "accessibilityId=QR Code Scanner"
    );
    public static final Map<Platform, String> GEO_LOCATION_MENU_ITEM = Map.of(
            Platform.ANDROID, "uiautomator=new UiSelector().text('Geo Location')",
            Platform.IOS, "accessibilityId=GeoLocation-menu-item"
    );
    public static final Map<Platform, String> DRAWING_MENU_ITEM = Map.of(
            Platform.ANDROID, "uiautomator=new UiSelector().text('Drawing')",
            Platform.IOS, "accessibilityId=Drawing-menu-item"
    );

    public static final Map<Platform, String> ABOUT_MENU_ITEM = Map.of(
            Platform.ANDROID, "xpath=//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='About']",
            Platform.IOS, "accessibilityId=About-menu-item"
    );
    public static final Map<Platform, String> FINGER_PRINT_MENU_ITEM = Map.of(
            Platform.ANDROID, "uiautomator=new UiSelector().text('FingerPrint')",
            Platform.IOS, ""
    );
    public static final Map<Platform, String> FACE_ID_MENU_ITEM = Map.of(
            Platform.ANDROID, "",
            Platform.IOS, "accessibilityId=Biometrics-menu-item"
    );
    public static final Map<Platform, String> LOGIN_MENU_ITEM = Map.of(
            Platform.ANDROID, "accessibilityId=Login Menu Item",
            Platform.IOS, "accessibilityId=LogOut-menu-item"
    );
    public static final Map<Platform, String> LOGOUT_MENU_ITEM = Map.of(
            Platform.ANDROID, "accessibilityId=Logout Menu Item",
            Platform.IOS, "accessibilityId=LogOut-menu-item"
    );

    public static final Map<Platform, String>  LOGOUT_DIALOG = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/parentPanel",
            Platform.IOS, ""
    );
    public static final Map<Platform, String>  LOGOUT_DIALOG_TITLE = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/alertTitle",
            Platform.IOS, ""
    );
    public static final Map<Platform, String>  LOGOUT_DIALOG_MSG = Map.of(
            Platform.ANDROID, "uiautomator=new UiSelector().resourceId('android:id/message')",
            Platform.IOS, ""
    );
    public static final Map<Platform, String>  LOGOUT_DIALOG_CANCEL_BTN = Map.of(
            Platform.ANDROID, "id=android:id/button2",
            Platform.IOS, ""
    );
    public static final Map<Platform, String>  LOGOUT_DIALOG_LOGOUT_BTN = Map.of(
            Platform.ANDROID, "id=android:id/button1",
            Platform.IOS, ""
    );
}
