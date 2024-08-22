package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;

public class ProjectsStepDefs extends BaseTest {
    private BaseTest baseTest;

    DashboardPage dashboardPage;

    public ProjectsStepDefs(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Then("add project page is displayed")
    public void addProjectPageIsDisplayed() {
        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @When("user clicks add project button")
    public void userClicksAddProjectButton() {
        dashboardPage = new DashboardPage(baseTest.driver);
    }
}
