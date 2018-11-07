import app.FormyProjectApplication;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.ReportPage;
import pages.WebFormPage;
import pages.WelcomePage;

/**
 * Selenium Grid is a proxy server that routes commands to remote browser instances.
 * It spreads the load of testing across several machines and those machines can run different
 * browsers and browser versions and different platforms as well.
 * With Selenium Grid one server acts as the hub and routes JSON formatted test commands to
 * one or more registered grid nodes to access browser instances.
 * A hub is: a central point from where tests are executed; a list of servers that
 * provide access to browser instances or web server nodes.
 * Nodes are where tests are run.
 * Each node is a machine that has their own Individual Selenium instances.
 * Selenium Grid allows running tests in parallel on multiple machines and gives the ability
 * to manage different browser versions and browser configuration centrally.
 *
 *
 * Preconditions to run tests on Remote Web Server:
 * 1) start up Selenium Grid hub with Selenium Server Standalone:
 * java -jar selenium-server-standalone-<version>.jar -role hub
 * To confirm that the hub is up and running, go to default port: localhost:4444/grid/console.
 * 2) register a node to the hub:
 * java -jar selenium-server-standalone-<version>.jar -role node -hub http://localhost:4444
 */
@RunWith(JUnit4.class)
public class WebFormRemoteTest {

  private static final String HUB_URL = "http://172.28.242.28:4444/wd/hub";

  private final WebDriver webDriver;
  private final FormyProjectApplication application;
  private final WelcomePage welcomePage;
  private final WebFormPage webFormPage;
  private final ReportPage reportPage;

  public WebFormRemoteTest() throws MalformedURLException {
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability("platform", "LINUX");
    webDriver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
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
    Assert
        .assertEquals("The form was successfully submitted!", reportPage.getSuccessfulAlertText());
  }

  @After
  public void closeWebDriver() {
    webDriver.quit();
  }
}
