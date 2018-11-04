package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utilities for explicit wait for visibility of Web elements on Formy application HTML pages.
 */
public class ExplicitWaitUtils {

    private final WebDriverWait wait;

    public ExplicitWaitUtils(WebDriver webDriver, long timeOutInSeconds) {
        wait = new WebDriverWait(webDriver, timeOutInSeconds);
    }

    public WebElement waitForVisibilityOf(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitForVisibilityOf(By webElementLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
    }
}
