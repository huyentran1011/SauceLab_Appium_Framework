package pagesUI;
import enums.Platform;
import java.util.Map;

public class ProductsPageUI {
    public static final Map<Platform, String> PAGE_TITLE = Map.of(
            Platform.ANDROID, "accessibilityId=title",
            Platform.IOS, "xpath=//XCUIElementTypeOther[@name='Catalog-screen']/XCUIElementTypeOther[3]"
    );

    public static final Map<Platform, String> PRODUCT_ITEM = Map.of(
            Platform.ANDROID, "xpath=//android.view.ViewGroup[android.widget.TextView[@content-desc='Product Title' and @text='%s']]/android.widget.ImageView[@content-desc='Product Image']",
            Platform.IOS, "xpath=//XCUIElementTypeStaticText[@name='Product Name' and contains(@label,'%s')]"
    );

    public static final Map<Platform, String>  SORT_PRODUCTS_BTN = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/sortIV",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name='Button']"
    );

    public static final Map<Platform, String> ASCENDING_BY_NAME_OPTION = Map.of(
            Platform.ANDROID, "accessibilityId=Ascending order by name",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name='Name - Ascending']"
    );

    public static final Map<Platform, String> DESCENDING_BY_NAME_OPTION = Map.of(
            Platform.ANDROID, "accessibilityId=Descending order by name",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name='Name - Descending']"
    );

    public static final Map<Platform, String> ASCENDING_BY_PRICE_OPTION = Map.of(
            Platform.ANDROID, "accessibilityId=Ascending order by price",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name='Price - Ascending']"
    );

    public static final Map<Platform, String> DESCENDING_BY_PRICE_OPTION = Map.of(
            Platform.ANDROID, "accessibilityId=Descending order by price",
            Platform.IOS, "xpath=//XCUIElementTypeButton[@name='Price - Descending']"
    );


}
