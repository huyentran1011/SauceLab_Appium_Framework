package pagesUI;

import enums.Platform;

import java.util.Map;

public class ProductDetailPageUI {

    public static final Map<Platform, String> PRODUCT_COLOR_ICON = Map.of(
            Platform.ANDROID, "accessibilityId=%s color",
            Platform.IOS, "accessibilityId=%sColorUnSelected Icons"
    );

    public static final Map<Platform, String> ADD_TO_CART_BUTTON = Map.of(
            Platform.ANDROID, "accessibilityId=Tap to add product to cart",
            Platform.IOS, "accessibilityId=Add To Cart"
    );

    public static final Map<Platform, String> ADD_PLUS_ICON = Map.of(
            Platform.ANDROID, "accessibilityId=Increase item quantity",
            Platform.IOS, "accessibilityId=AddPlus Icons"
    );

    public static final Map<Platform, String> PRODUCT_QUANTITY_TEXT = Map.of(
            Platform.ANDROID, "id=com.saucelabs.mydemoapp.android:id/noTV",
            Platform.IOS, "accessibilityId=Amount"
    );

    public static final Map<Platform, String> SUBTRACT_MINUS_ICON = Map.of(
            Platform.ANDROID, "accessibilityId=Decrease item quantity",
            Platform.IOS, "accessibilityId=SubtractMinus Icons"
    );

    public static final Map<Platform, String> BACK_TO_PRODUCTS_BUTTON = Map.of(
            Platform.ANDROID, "accessibilityId=",
            Platform.IOS, "accessibilityId=Products"
    );
}
