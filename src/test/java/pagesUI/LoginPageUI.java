package pagesUI;
import enums.Platform;
import java.util.Map;

public class LoginPageUI {
    public static final Map<Platform, String>  PAGE_TITLE = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/loginTV",
            Platform.IOS, ""
    );

    public static final Map<Platform, String>  USERNAME_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/nameET",
            Platform.IOS, "xpath=//XCUIElementTypeTextField"
    );

    public static final Map<Platform, String>  PASSWORD_TEXTBOX = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/passwordET",
            Platform.IOS, "xpath=//XCUIElementTypeSecureTextField"
    );
    public static final Map<Platform, String>  LOGIN_BUTTON = Map.of(
            Platform.ANDROID, "accessibilityId=Tap to login with given credentials",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name=\"Login\"]"
    );
    public static final Map<Platform, String>  USERNAME_ERROR_MSG = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/nameErrorTV",
            Platform.IOS, "accessibilityId=Username is required"
    );
    public static final Map<Platform, String>  OK_BUTTON = Map.of(
            Platform.ANDROID, "",
            Platform.IOS, "accessibilityId=OK"
    );
    public static final Map<Platform, String>  PASSWORD_ERROR_MSG = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/passwordErrorTV",
            Platform.IOS, "accessibilityId=Password is required"
    );

}
