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
}
