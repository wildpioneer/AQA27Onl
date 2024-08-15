package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.UserStep;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.setEmailValue(ReadProperties.username());
        loginPage.setPasswordValue(ReadProperties.password());
        loginPage.clickLogin();

        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Test
    public void shortSuccessLoginTest() {
        Assert.assertTrue(
                userStep.successfulLogin(admin)
                        .isPageOpened());
    }

    @Test
    public void incorrectEmailLoginTest() {
        User incorrectUser = new User();
        incorrectUser.setUsername("asdasd");
        incorrectUser.setPassword(ReadProperties.password());

        Assert.assertEquals(userStep.incorrectLogin(incorrectUser)
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
