package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }
}
