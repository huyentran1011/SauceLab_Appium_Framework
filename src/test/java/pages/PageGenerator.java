package pages;

import io.appium.java_client.AppiumDriver;

public class PageGenerator {
    public static NavigationMenu getNavigationMenu(AppiumDriver driver){
        return new NavigationMenu(driver);
    }
    public static LoginPage getLoginPage(AppiumDriver driver){
        return new LoginPage(driver);
    }
    public static ProductsPage getProductsPage(AppiumDriver driver){
        return new ProductsPage(driver);
    }

    public static ProductDetailPage getProductDetailPage(AppiumDriver driver){
        return new ProductDetailPage(driver);
    }
    public static ShoppingCartPage getShoppingCartPage(AppiumDriver driver){
        return new ShoppingCartPage(driver);
    }

    public static CheckoutPage getCheckoutPage(AppiumDriver driver){
        return new CheckoutPage(driver);
    }

    public static GeoLocationPage getGeoLocationPage(AppiumDriver driver){ return new GeoLocationPage(driver);}

    public static AboutPage getAboutPage(AppiumDriver driver){ return new AboutPage(driver);}
}
