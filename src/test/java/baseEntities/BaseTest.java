package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import steps.UserStep;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

        userStep = new UserStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
