package utils;

import base.GlobalConstants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static void waitForElementVisible(AppiumDriver driver, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalInstance().getShortTimeOut())).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementInvisible(AppiumDriver driver, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalInstance().getShortTimeOut())).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForElementClickable(AppiumDriver driver, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.getGlobalInstance().getLongTimeOut())).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
