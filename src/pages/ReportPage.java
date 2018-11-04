package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWaitUtils;

/**
 * Thanks for submitting a Web Form.
 */
public class ReportPage {

    private final ExplicitWaitUtils waitUtils;

    @FindBy(css = ".alert-success")
    private WebElement successfulAlert;

    public ReportPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        waitUtils = new ExplicitWaitUtils(webDriver, 5);
    }

    public String getSuccessfulAlertText() {
        return waitUtils.waitForVisibilityOf(successfulAlert).getText();
    }
}
