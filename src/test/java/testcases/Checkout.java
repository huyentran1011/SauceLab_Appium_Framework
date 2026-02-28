package testcases;

import POJO.*;
import base.BaseTest;
import enums.Platform;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utils.JsonUtils;


public class Checkout extends BaseTest {
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private NavigationMenu navigationMenu;
    private ShoppingCartPage shoppingCartPage;
    private LoginPage loginPage;
    private CheckoutPage checkoutPage;
    protected Platform platform;

    @Parameters({"platformName", "deviceName", "automationName", "server", "port", "appName"})
    @BeforeMethod
    public void beforeTest(String platformName, String deviceName, String automationName, String server, String port, String appName){
        driver = setUp(platformName, deviceName, automationName, server, port, appName);
        this.platform = Platform.valueOf(platformName.toUpperCase());

        productsPage = PageGenerator.getProductsPage(driver);
    }

    @DataProvider(name = "checkoutData")
    public Object[][] checkoutData(){
        CheckoutData data =
                JsonUtils.readObject("checkoutData.json", CheckoutData.class);

        return new Object[][] { { data } };

    }

    @Description("Check out success.")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "checkoutData")
    public void TC01_Checkout(CheckoutData checkoutData){
        int totalNumberOfItem = 0;
        float totalProductPrice = 0;

        /** Add products to shopping cart */
        for(ProductData product: checkoutData.products){
            productsPage.clickOnAProduct(product.productName);
            productDetailPage = PageGenerator.getProductDetailPage(driver);
            for(ProductVariation variation: product.variations){
                productDetailPage.selectProductColor(variation.color);
                productDetailPage.inputProductQuantity(variation.quantity);
                productDetailPage.clickOnAddToCartButton();

                totalNumberOfItem += variation.quantity;
                totalProductPrice += (variation.unitPrice * variation.quantity);
            }
        }

        /** Click on Cart icon to access to Shopping Cart screen */
        navigationMenu = PageGenerator.getNavigationMenu(driver);
        navigationMenu.clickOnCartIcon();

        /** Verify products are added correctly */
        shoppingCartPage = PageGenerator.getShoppingCartPage(driver);

        for(ProductData product:checkoutData.products){
            for(ProductVariation variation: product.variations){
                Assert.assertTrue(shoppingCartPage.isProductPriceCorrect(product.productName, variation.color, variation.unitPrice));
                Assert.assertTrue(shoppingCartPage.isProductQuantityCorrect(product.productName, variation.color, variation.quantity));
            }
        }

        Assert.assertTrue(shoppingCartPage.isTotalProductQuantityCorrect(totalNumberOfItem));
        Assert.assertTrue(shoppingCartPage.isTotalProductPriceCorrect(totalProductPrice));

        /** Click on Checkout button to check out */
        shoppingCartPage.clickOnCheckoutButton();

        /** Login */
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.loginToSystem(checkoutData.loginAccount.username, checkoutData.loginAccount.password);

        /** Input shipping info */
        checkoutPage = PageGenerator.getCheckoutPage(driver);
        checkoutPage.inputFullName(checkoutData.shippingInfo.fullName);
        checkoutPage.inputAddress1(checkoutData.shippingInfo.address1);
        checkoutPage.inputAddress2(checkoutData.shippingInfo.address2);
        checkoutPage.inputCity(checkoutData.shippingInfo.city);
        checkoutPage.inputState(checkoutData.shippingInfo.state);
        checkoutPage.inputCountry(checkoutData.shippingInfo.country);
        checkoutPage.inputZipcode(checkoutData.shippingInfo.zipcode);
        checkoutPage.clickPayment();

        /** Input Billing info */
        checkoutPage.inputPaymentFullName(checkoutData.billingInfo.fullName);
        checkoutPage.inputPaymentCardNumber(checkoutData.billingInfo.cardNumber);
        checkoutPage.inputPaymentExpDate(checkoutData.billingInfo.expDate);
        checkoutPage.inputPaymentSecurityCode(checkoutData.billingInfo.securityCode);
        checkoutPage.clickReviewOrderButton();

        /** Verify Total product quantity and total Price */
        Assert.assertEquals(checkoutPage.getTotalItems(), totalNumberOfItem + " Items");
        float totalPrice = (float) (totalProductPrice + 5.99);
        String formattedTotalPrice = String.format("%.2f", totalPrice);
        Assert.assertEquals(checkoutPage.getTotalAmount(), "$ " + formattedTotalPrice);

        /** Click on Place Order button */
        checkoutPage.clickPlaceOrderButton();
        Assert.assertEquals(checkoutPage.getCheckoutCompleteText(), "Checkout Complete");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        tearDown();
    }

}
