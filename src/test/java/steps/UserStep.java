package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class UserStep extends BaseStep {

    public UserStep(WebDriver driver) {
        super(driver);
    }

    public DashboardPage successfulLogin(User user) {
        login(user);

        return new DashboardPage(driver);
    }

    public LoginPage incorrectLogin(User user) {
        login(user);

        return new LoginPage(driver);
    }

    private void login(User user) {
        loginPage = new LoginPage(driver);

        loginPage.setEmailValue(user.getUsername());
        loginPage.setPasswordValue(user.getPassword());
        loginPage.clickLogin();
    }
}
