package tests;

import configuration.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StaticLoginPage;
import services.StaticBrowser;

public class StaticLoginTest {

    @BeforeMethod
    public void beforeMethod() {
        StaticBrowser.getDriver().get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void afterMethod() {
        StaticBrowser.closeBrowser();
    }

    @Test
    public void successLoginTest() {
        StaticLoginPage loginPage = new StaticLoginPage();
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
    }

    @Test
    public void successLoginTest1() {
        StaticLoginPage loginPage = new StaticLoginPage();
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
    }
}
