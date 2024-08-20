package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRegression extends BaseTest {

    @Test
    public void shortSuccessLoginTest() {
        System.out.println("Regression Test");
        Assert.assertTrue(
                userStep.successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
        Assert.assertTrue(true);
    }

    @Test
    public void incorrectEmailLoginTest() {
        System.out.println("Regression Test");
        Assert.assertEquals(userStep.incorrectLogin("asdasd", ReadProperties.password())
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}
