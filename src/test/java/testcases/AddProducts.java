package testcases;

import POJO.ProductData;
import POJO.ProductVariation;
import base.BaseTest;
import enums.Platform;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utils.JsonUtils;

import java.util.List;

public class AddProducts extends BaseTest {
    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;
    private NavigationMenu navigationMenu;
    private ShoppingCartPage shoppingCartPage;
    protected Platform platform;

    @DataProvider(name = "singleProductTypeData")
    public Object[][] tc01_productData(){
        ProductData data =
                JsonUtils.readObject("singleProductsData.json", ProductData.class);

        return new Object[][] { { data } };
    }

    @DataProvider(name = "multipleProductTypesData")
    public Object[][] tc02_multipleProductsData() {

        List<ProductData> dataList =
                JsonUtils.readList("multipleProductsData.json", ProductData[].class);

        /**
         * Return ProductData
         * Test run 1 → ProductData #1
         * Test run 2 → ProductData #2
         * Test run 3 → ProductData #3
         */
        /*
        return dataList.stream()
                .map(data -> new Object[]{data})
                .toArray(Object[][]::new);
         */

        /**
         * Return List<ProductData>
         *
         */
        return new Object[][] {
                { dataList }
        };
    }


    @Parameters({"platformName", "deviceName", "automationName", "server", "port", "appName"})
    @BeforeMethod
    public void beforeTest(String platformName, String deviceName, String automationName, String server, String port, String appName){
        driver = setUp(platformName, deviceName, automationName, server, port, appName);
        this.platform = Platform.valueOf(platformName.toUpperCase());
        productsPage = PageGenerator.getProductsPage(driver);
    }

    @Description("Add the same product with different color and quantity to Shopping Card.")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "singleProductTypeData")
    public void TC01_AddSingleProductTypeToCart(ProductData product){
        int totalNumberOfItem = 0;
        float totalPrice = 0;

        String productName = product.productName;

        /** Open product details */
        productsPage.clickOnAProduct(productName);
        productDetailPage = PageGenerator.getProductDetailPage(driver);

        /** Add product into shopping cart with different color and quantity */
        for(ProductVariation v: product.variations){
            productDetailPage.selectProductColor(v.color);
            productDetailPage.inputProductQuantity(v.quantity);
            productDetailPage.clickOnAddToCartButton();
        }

        /** Click on Shopping Cart Icon */
        navigationMenu = PageGenerator.getNavigationMenu(driver);
        navigationMenu.clickOnCartIcon();

        /** Verify product, color and quantity in Shopping Cart is correct */
        shoppingCartPage = PageGenerator.getShoppingCartPage(driver);
        for(ProductVariation v:product.variations){
            Assert.assertTrue(shoppingCartPage.isProductPriceCorrect(productName, v.color, v.unitPrice));
            Assert.assertTrue(shoppingCartPage.isProductQuantityCorrect(productName, v.color, v.quantity));
            totalNumberOfItem += v.quantity;
            totalPrice += (v.quantity * v.unitPrice);
        }
        Assert.assertTrue(shoppingCartPage.isTotalProductQuantityCorrect(totalNumberOfItem));
        Assert.assertTrue(shoppingCartPage.isTotalProductPriceCorrect(totalPrice));
    }

    @Description("Add different type of products to Shopping Card.")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "multipleProductTypesData")
    public void TC02_AddMultipleProductTypeToCard(List<ProductData> multiProducts){
        /**
         * Android app has a bug on this test case.
         * */
        int totalNumberOfItem = 0;
        float totalProductPrice = 0;

        /** Add product into shopping cart with different color and quantity */
        for(ProductData product: multiProducts){
            productsPage.clickOnAProduct(product.productName);
            productDetailPage = PageGenerator.getProductDetailPage(driver);
            for(ProductVariation variation: product.variations){
                productDetailPage.selectProductColor(variation.color);
                productDetailPage.inputProductQuantity(variation.quantity);
                productDetailPage.clickOnAddToCartButton();

                totalNumberOfItem += variation.quantity;
                totalProductPrice += (variation.unitPrice * variation.quantity);
            }
            navigationMenu = PageGenerator.getNavigationMenu(driver);
            navigationMenu.clickOnCatalogMenu();
        }

        /** Click on Shopping Cart Icon */
        navigationMenu = PageGenerator.getNavigationMenu(driver);
        navigationMenu.clickOnCartIcon();

        /** Verify product, color and quantity in Shopping Cart is correct */
        shoppingCartPage = PageGenerator.getShoppingCartPage(driver);
        for(ProductData product:multiProducts){
            for(ProductVariation variation: product.variations){
                Assert.assertTrue(shoppingCartPage.isProductPriceCorrect(product.productName, variation.color, variation.unitPrice));
                Assert.assertTrue(shoppingCartPage.isProductQuantityCorrect(product.productName, variation.color, variation.quantity));
            }
        }

        Assert.assertTrue(shoppingCartPage.isTotalProductQuantityCorrect(totalNumberOfItem));
        Assert.assertTrue(shoppingCartPage.isTotalProductPriceCorrect(totalProductPrice));
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        tearDown();
    }
}
