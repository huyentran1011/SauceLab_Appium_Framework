package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasePage {
    public static BasePage getBasePage(){
        return new BasePage();
    }

    private By getElementByLocator(String prefixLocator){
        By by = null;
        if(prefixLocator.toUpperCase().startsWith("ACCESSIBILITYID")){
            by = AppiumBy.accessibilityId(prefixLocator.substring(16));
        }else if(prefixLocator.toUpperCase().startsWith("ID")){
            by = AppiumBy.id(prefixLocator.substring(3));
        } else if(prefixLocator.toUpperCase().startsWith("CLASSNAME")){
            by = AppiumBy.className(prefixLocator.substring(10));
        } else if(prefixLocator.toUpperCase().startsWith("UIAUTOMATOR")){
            by = AppiumBy.androidUIAutomator(prefixLocator.substring(12));
        } else if(prefixLocator.toUpperCase().startsWith("XPATH")){
            by = AppiumBy.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported!");
        }
        return by;
    }

    public String getPlatformName(AppiumDriver driver){
        return driver.getCapabilities().getPlatformName().toString();
    }

    protected WebElement getElement(AppiumDriver driver, String locator){
        return driver.findElement(getElementByLocator(locator));
    }

    protected List<WebElement> getElementList(AppiumDriver driver, String locator){
        return driver.findElements(getElementByLocator(locator));
    }

    private String castParameter(String locator, String...restParameter){
        return String.format(locator, (Object[]) restParameter);
    }

    protected WebElement getElement(AppiumDriver driver, String locator, String... restParameter){
        return driver.findElement(getElementByLocator(castParameter(locator, restParameter)));
    }

    protected List<WebElement> getElementList(AppiumDriver driver, String locator, String... restParameter){
        return driver.findElements(getElementByLocator(castParameter(locator, restParameter)));
    }

    protected void clickOnElement(AppiumDriver driver, String locator){;
        WaitUtils.waitForElementClickable(driver, getElementByLocator(locator));
        getElement(driver, locator).click();
    }

    protected void clickOnElement(AppiumDriver driver, String locator, String... restParameter){;
        WaitUtils.waitForElementClickable(driver, getElementByLocator(castParameter(locator, restParameter)));
        getElement(driver, castParameter(locator, restParameter)).click();
    }

    protected void sendKeysToElement(AppiumDriver driver, String locator, String text){
        WaitUtils.waitForElementVisible(driver, getElementByLocator(locator));
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(text);
    }

    protected Boolean isDisplayed(AppiumDriver driver, String locator){
        WaitUtils.waitForElementVisible(driver, getElementByLocator(locator));
        return getElement(driver, locator).isDisplayed();
    }

    protected Boolean isDisplayed(AppiumDriver driver, String locator, String... restParameter){
        WaitUtils.waitForElementVisible(driver, getElementByLocator(castParameter(locator, restParameter)));
        return getElement(driver, castParameter(locator, restParameter)).isDisplayed();
    }

    protected String getText(AppiumDriver driver, String locator){
        WaitUtils.waitForElementVisible(driver, getElementByLocator(locator));
        return getElement(driver, locator).getText();
    }

    protected String getText(AppiumDriver driver, String locator, String... restParameter){
        WaitUtils.waitForElementVisible(driver, getElementByLocator(castParameter(locator, restParameter)));
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }

    protected void scrollToTextAndroid(AppiumDriver driver, String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }

    protected void scrollToTextIOS(AppiumDriver driver, String text) {
        driver.findElement(AppiumBy.iOSNsPredicateString(
                "label CONTAINS '" + text + "'"
        ));
    }

    protected void scrollToText(AppiumDriver driver,  String text) {
        String platformName = String.valueOf(driver.getCapabilities().getPlatformName());
        if (platformName.equalsIgnoreCase("android")) {
            scrollToTextAndroid(driver, text);
        } else {
            scrollToTextIOS(driver, text);
        }
    }

    public void swipeUp(AppiumDriver driver) {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.6);
        int endY = (int) (size.height * 0.4);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(300),
                PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeInsideElement(AppiumDriver driver, WebElement element) {

        Rectangle rect = element.getRect();

        int startX = rect.x + rect.width / 2;
        int startY = rect.y + (int)(rect.height * 0.8);
        int endY = rect.y + (int)(rect.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX, startY));

        swipe.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(600),
                PointerInput.Origin.viewport(),
                startX, endY));

        swipe.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }


    public boolean isEndOfList(AppiumDriver driver) {

        String previousSource = driver.getPageSource();

        swipeUp(driver);

        String newSource = driver.getPageSource();

        return previousSource.equals(newSource);
    }

    public WebElement scrollUntilVisible(AppiumDriver driver, String locator, int maxScrolls) {

        for (int i = 0; i < maxScrolls; i++) {
            List<WebElement> elements = getElementList(driver, locator);
            if (!elements.isEmpty()) {
                return elements.getFirst();
            }
            swipeUp(driver); // custom swipe method
        }

        throw new RuntimeException("Element not found after scrolling.");
    }

    public WebElement scrollUntilVisible(AppiumDriver driver, String locator, int maxScrolls, String... restParameter) {

        for (int i = 0; i < maxScrolls; i++) {
            List<WebElement> elements = getElementList(driver, locator, restParameter);
            if (!elements.isEmpty()) {
                return elements.getFirst();
            }
            swipeUp(driver);
        }
        throw new RuntimeException("Element not found after scrolling.");
    }

    public WebElement scrollUntilDisplay(AppiumDriver driver, String locator, int maxScrolls) {

        for (int i = 0; i < maxScrolls; i++) {
            List<WebElement> elements = getElementList(driver, locator);
            if (!elements.isEmpty() && elements.getFirst().isDisplayed()) {
                System.out.println("Element is found: " + elements.getFirst());
                return elements.getFirst();
            }
            System.out.println("Scroll to found element.");
            swipeUp(driver); // custom swipe method
        }

        throw new RuntimeException("Element not display after scrolling.");
    }

    public WebElement scrollUntilDisplay(AppiumDriver driver, String locator, int maxScrolls, String... restParameter) {

        for (int i = 0; i < maxScrolls; i++) {
            List<WebElement> elements = getElementList(driver, locator, restParameter);
            if (!elements.isEmpty() && elements.getFirst().isDisplayed()) {
                return elements.getFirst();
            }
            swipeUp(driver);
        }
        throw new RuntimeException("Element not display after scrolling.");
    }

    /**
     * Set text WITHOUT opening the iOS keyboard.
     * Works on Simulator & real devices.
     */
    public void setValueNoiOSKeyboard(AppiumDriver driver, String locator, String value) {
        Map<String, Object> args = new HashMap<>();
        args.put("elementId", ((RemoteWebElement) getElement(driver,locator)).getId());
        args.put("value", value);

        driver.executeScript("mobile: setValue", args);
    }
}
