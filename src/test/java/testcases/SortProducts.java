package testcases;

import base.BaseTest;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.NavigationMenu;
import pages.PageGenerator;
import pages.ProductsPage;

public class SortProducts extends BaseTest {
    private AppiumDriver driver;
    protected Platform platform;
    private ProductsPage productsPage;

    @Parameters({"platformName", "deviceName", "automationName", "server", "port", "appName"})
    @BeforeMethod
    public void beforeTest(String platformName, String deviceName, String automationName, String server, String port, String appName){
        driver = setUp(platformName, deviceName, automationName, server, port, appName);
        this.platform = Platform.valueOf(platformName.toUpperCase());
        productsPage = PageGenerator.getProductsPage(driver);

    }

    @Description("Sort Product By Ascending Name")
    @Step
    @Test
    public void TC01_SortByAscendingName(){
        productsPage.clickOnSortButton();
        productsPage.clickOnNameAscending();
    }


    @Test
    public void TC02_SortByDescendingName(){
        productsPage.clickOnSortButton();
        productsPage.clickOnNameDescending();
    }

    @Test
    public void TC03_SortByAscendingPrice(){
        productsPage.clickOnSortButton();
        productsPage.clickOnPriceAscending();
    }

    @Test
    public void TC04_SortByDescendingName(){
        productsPage.clickOnSortButton();
        productsPage.clickOnPriceDescending();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        tearDown();
    }
}
