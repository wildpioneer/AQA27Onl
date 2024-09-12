package stepsDefs;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import services.BrowsersService;

public class LoginStepDefs extends BaseTest {
    private BaseTest baseTest;

    LoginPage loginPage;

    public LoginStepDefs(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("open login page")
    @Step
    public void openLoginPage() {
        baseTest.driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(baseTest.driver);
    }

    // Атомарные
    @When("set username {string}")
    public void setUsername(String username) {
        loginPage.setEmailValue(username);
    }

    @When("set password {string}")
    public void setPassword(String password) {
        loginPage.setPasswordValue(password);
    }

    @When("user clicks login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }

    // Комплексные
    @When("login with username {} and password {}")
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

    // Проверки
    @Then("dashboard page is displayed")
    public void isDashboardPageDisplayed() {
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String errorMsg) {
        Assert.assertEquals(loginPage.getErrorTextElement().getText(), errorMsg);
    }
}
