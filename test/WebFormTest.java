import app.FormyProjectApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ReportPage;
import pages.WebFormPage;
import pages.WelcomePage;

@RunWith(JUnit4.class)
public class WebFormTest {

    private final WebDriver webDriver;
    private final FormyProjectApplication application;
    private final WelcomePage welcomePage;
    private final WebFormPage webFormPage;
    private final ReportPage reportPage;

    public WebFormTest() {
        webDriver = new ChromeDriver();
        application = new FormyProjectApplication(webDriver);
        welcomePage = new WelcomePage(webDriver);
        webFormPage = new WebFormPage(webDriver);
        reportPage = new ReportPage(webDriver);
    }

    @Test
    public void completeWebFormTest() {
        application.openFormyProjectApplication("http://formy-project.herokuapp.com/");
        welcomePage.openWebForm();
        webFormPage.fillFirstName("John")
                .fillLastName("Phillips")
                .fillJobTitle("Constructor")
                .selectHighSchool()
                .selectPreferNotToSayMySex()
                .selectYearsOfExperience("2-4")
                .fillDate("11/30/2018")
                .submitWebForm();
        Assert.assertEquals("The form was successfully submitted!", reportPage.getSuccessfulAlertText());
    }

    @After
    public void closeWebDriver() {
        webDriver.quit();
    }
}
