package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class UserStep extends BaseStep {

    public UserStep() {
        super();
    }

    public DashboardPage successfulLogin(User user) {
        login(user);

        return new DashboardPage();
    }

    public LoginPage incorrectLogin(User user) {
        login(user);

        return new LoginPage();
    }

    private void login(User user) {
        loginPage = new LoginPage();

        loginPage.setEmailValue(user.getUsername());
        loginPage.setPasswordValue(user.getPassword());
        loginPage.clickLogin();
    }
}
