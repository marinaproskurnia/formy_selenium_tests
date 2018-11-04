package app;

import org.openqa.selenium.WebDriver;

/**
 * This is a simple site that has form components that can be used for testing purposes.
 */
public class FormyProjectApplication {

    private final WebDriver driver;

    public FormyProjectApplication(WebDriver driver) {
        this.driver = driver;
    }

    public void openFormyProjectApplication(String url) {
        driver.get(url);
    }
}
