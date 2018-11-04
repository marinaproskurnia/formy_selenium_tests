package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Welcome page of Form project application.
 */
public class WelcomePage {

    @FindBy(css = "a[href='/form']")
    private WebElement form;

    public WelcomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void openWebForm() {
        form.click();
    }
}
