package baseEntities;

import configuration.ReadProperties;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import steps.ProjectStep;
import steps.UserStep;
import utils.Director;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected ProjectStep projectStep;


    //Test Data
    protected User admin;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

        userStep = new UserStep(driver);
        projectStep = new ProjectStep(driver);

        driver.get(ReadProperties.getUrl());

        admin = Director.getAdmin();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
