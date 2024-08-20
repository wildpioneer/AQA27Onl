package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSmoke extends BaseTest {

    @Test
    public void shortSuccessLoginTest() {
        System.out.println("Smoke Test");
        Assert.assertTrue(
                userStep.successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
        Assert.assertTrue(true);
    }

    @Test
    public void incorrectEmailLoginTest() {
        System.out.println("Smoke Test");
        Assert.assertEquals(userStep.incorrectLogin("asdasd", ReadProperties.password())
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}
