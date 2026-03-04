package pagesUI;

import enums.Platform;

import java.util.Map;

public class GeoLocationPageUI {
    public final static Map<Platform, String> LONGITUDE_TEXT = Map.of(
            Platform.ANDROID, "xpath=//XCUIElementTypeStaticText[@name='Longitude']/following-sibling::XCUIElementTypeStaticText[1]",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Longitude']/following-sibling::XCUIElementTypeStaticText[1]"
    );

    public final static Map<Platform, String> LATITUDE_TEXT = Map.of(
            Platform.ANDROID, "xpath=//XCUIElementTypeStaticText[@name='Latitude']/following-sibling::XCUIElementTypeStaticText[1]",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Latitude']/following-sibling::XCUIElementTypeStaticText[1]"
    );
}
