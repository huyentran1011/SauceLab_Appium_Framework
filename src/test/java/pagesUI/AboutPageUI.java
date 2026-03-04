package pagesUI;

import enums.Platform;

import java.util.Map;

public class AboutPageUI {
    public final static Map<Platform, String> APP_VERSION_TEXT = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/versionTV",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='About ']/following-sibling::XCUIElementTypeStaticText"
    );
}
