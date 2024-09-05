package tests.gui;

import baseEntities.BaseGuiTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginGuiTest extends BaseGuiTest {

    @Test
    public void shortSuccessLoginTest() {
        Assert.assertTrue(
                userStep.successfulLogin(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
        Assert.assertTrue(true);
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(userStep.incorrectLogin("asdasd", ReadProperties.password())
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}
