package baseEntities;

import com.codeborne.selenide.WebDriverRunner;
import configuration.ReadProperties;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.ProjectStep;
import steps.UserStep;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected ProjectStep projectStep;

    //Test Data
    protected User admin;

    @BeforeMethod
    public void setup() {
        open(ReadProperties.getUrl());

        driver = WebDriverRunner.driver().getWebDriver();

        userStep = new UserStep(driver);
        projectStep = new ProjectStep(driver);

        admin = new User();
        admin.setUsername(ReadProperties.username());
        admin.setPassword(ReadProperties.password());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
