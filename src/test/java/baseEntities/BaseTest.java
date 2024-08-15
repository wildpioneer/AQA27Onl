package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import configuration.ReadProperties;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import steps.ProjectStep;
import steps.UserStep;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected UserStep userStep;
    protected ProjectStep projectStep;

    //Test Data
    protected User admin;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl = ReadProperties.getUrl();
    }

    @BeforeMethod
    public void setup() {
        open(ReadProperties.getUrl());

        userStep = new UserStep();
        projectStep = new ProjectStep();

        admin = new User();
        admin.setUsername(ReadProperties.username());
        admin.setPassword(ReadProperties.password());
    }
}
