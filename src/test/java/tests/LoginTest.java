package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.UserStep;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailValue(ReadProperties.username());
        loginPage.setPasswordValue(ReadProperties.password());
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Test
    public void shortSuccessLoginTest() {
        Assert.assertTrue(
                userStep.successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(userStep.incorrectLogin("asdasd", ReadProperties.password())
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

    @Test
    public void incorrectPswLoginTest() {
/*
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), "asdas");

        Assert.assertEquals(loginPage.getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
*/
    }
}
