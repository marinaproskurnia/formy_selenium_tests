package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExplicitWaitUtils;

/**
 * Complete Web Form for Formy project member registration.
 */
public class WebFormPage {

    private final ExplicitWaitUtils waitUtils;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "job-title")
    private WebElement jobTitle;

    @FindBy(id = "radio-button-1")
    private WebElement highSchool;

    @FindBy(id = "checkbox-3")
    private WebElement preferNotToSay;

    @FindBy(id = "select-menu")
    private WebElement yearsOfExperience;

    @FindBy(id = "datepicker")
    private WebElement date;

    @FindBy(css = ".btn-primary")
    private WebElement submit;

    public WebFormPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        waitUtils = new ExplicitWaitUtils(webDriver, 5);
    }

    public WebFormPage fillFirstName(String name) {
        waitUtils.waitForVisibilityOf(firstName).sendKeys(name);
        return this;
    }

    public WebFormPage fillLastName(String name) {
        waitUtils.waitForVisibilityOf(lastName).sendKeys(name);
        return this;
    }

    public WebFormPage fillJobTitle(String title) {
        waitUtils.waitForVisibilityOf(jobTitle).sendKeys(title);
        return this;
    }

    public WebFormPage selectHighSchool() {
        waitUtils.waitForVisibilityOf(highSchool).click();
        return this;
    }

    public WebFormPage selectPreferNotToSayMySex() {
        waitUtils.waitForVisibilityOf(preferNotToSay).click();
        return this;
    }

    public WebFormPage selectYearsOfExperience(String timeRange) {
        openYearsOfExperienceMenu();
        selectTimeRangeOfExperience(timeRange);
        return this;
    }

    public WebFormPage fillDate(String dateValue) {
        waitUtils.waitForVisibilityOf(date).sendKeys(dateValue);
        return this;
    }

    public void submitWebForm() {
        waitUtils.waitForVisibilityOf(submit).click();
    }

    private void selectTimeRangeOfExperience(String timeRange) {
        String timeRangeXpath = String.format("//option[text()='%s']", timeRange);
        waitUtils.waitForVisibilityOf(By.xpath(timeRangeXpath)).click();
    }

    private void openYearsOfExperienceMenu() {
        waitUtils.waitForVisibilityOf(yearsOfExperience);
    }
}
