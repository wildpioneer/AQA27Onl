package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class UserStep extends BaseStep {

    public UserStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Успешный логин")
    public DashboardPage successfulLogin(String username, String password) {
        login(username, password);

        return dashboardPage;
    }

    @Step(value = "Некорректный логин")
    public LoginPage incorrectLogin(String username, String password) {
        login(username, password);

        return loginPage;
    }

    private void login(String username, String password) {
        loginPage.setEmailValue(username);
        loginPage.setPasswordValue(password);
        loginPage.clickLogin();
    }
}
