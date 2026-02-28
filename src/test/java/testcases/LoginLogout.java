package testcases;

import POJO.LoginData;
import base.BaseTest;
import data.LoginPageData;
import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.NavigationMenu;
import pages.PageGenerator;
import pages.ProductsPage;
import utils.JsonUtils;

public class LoginLogout extends BaseTest {
    private AppiumDriver driver;
    private LoginPage loginPage;
    private NavigationMenu navigationPage;
    private ProductsPage productsPage;
    protected Platform platform;

    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        LoginData data =
                JsonUtils.readObject("loginData.json", LoginData.class);

        return new Object[][] { { data } };
    }

    @Parameters({"platformName", "deviceName", "automationName", "server", "port", "appName"})
    @BeforeMethod
    public void beforeTest(String platformName, String deviceName, String automationName, String server, String port, String appName){
        driver = setUp(platformName, deviceName, automationName, server, port, appName);
        this.platform = Platform.valueOf(platformName.toUpperCase());

        navigationPage = PageGenerator.getNavigationMenu(driver);
        navigationPage.clickOnMenuIcon();
        navigationPage.clickLoginMenu();
        loginPage = PageGenerator.getLoginPage(driver);
    }

    @Description("Login without Username.")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "loginData")
    public void TC01_loginFailedWithoutUsername(LoginData data){
        loginPage.inputPassword(data.password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getUsernameErrorMsg(), LoginPageData.USERNAME_ERROR_MSG.get(platform));
    }

    @Description("Login without Password.")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "loginData")
    public void TC02_loginFailedWithoutPassword(LoginData data){
        loginPage.inputUsername(data.username);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getPasswordErrorMsg(), LoginPageData.PASSWORD_ERROR_MSG.get(platform));
    }

    @Description("Login success with correct Username and Password.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "loginData")
    public void TC03_loginSuccess(LoginData data){
        loginPage.inputUsername(data.username);
        loginPage.inputPassword(data.password);
        loginPage.clickLoginButton();

        productsPage = PageGenerator.getProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }

    @Description("Verify Confirm Logout Dialog in iOS version.")
    @Severity(SeverityLevel.MINOR)
    public void TC04_verifyLogoutDialog(LoginData data){
        loginPage.inputUsername(data.username);
        loginPage.inputPassword(data.password);
        loginPage.clickLoginButton();

        navigationPage = PageGenerator.getNavigationMenu(driver);
        navigationPage.clickOnMenuIcon();
        navigationPage.clickLogoutMenu();

        Assert.assertTrue(navigationPage.isLogoutDialogDisplayed());
        Assert.assertEquals(navigationPage.getLogoutDialogTitle(), "Log Out");
        Assert.assertEquals(navigationPage.getLogoutDialogMessage(), "Are you sure you want to logout");
    }

    @Description("Verify Cancel logout in iOS version.")
    @Severity(SeverityLevel.MINOR)
    public void TC05_cancelLogout(LoginData data){

        loginPage.inputUsername(data.username);
        loginPage.inputPassword(data.password);
        loginPage.clickLoginButton();

        navigationPage = PageGenerator.getNavigationMenu(driver);
        navigationPage.clickOnMenuIcon();
        navigationPage.clickLogoutMenu();
        navigationPage.clickCancelLogout();

        productsPage = PageGenerator.getProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }

    @Description("Logout Success.")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "loginData")
    public void TC04_logoutSuccess(LoginData data){
        loginPage.inputUsername(data.username);
        loginPage.inputPassword(data.password);
        loginPage.clickLoginButton();

        navigationPage = PageGenerator.getNavigationMenu(driver);
        navigationPage.logout();
        Assert.assertEquals(loginPage.getPageTitle(), "Login");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        tearDown();
    }
}
