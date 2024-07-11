package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import services.BrowsersService;
import tests.BaseTest;

public class LoginPage extends BasePage {
    // Блок описания локатор для элементов
    private final By EMAIL_INPUT_LOCATOR = By.id("name");
    private final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private final By LOGIN_BUTTON_LOCATOR = By.id("button_primary");

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        pageDriver = driver;
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return pageDriver.findElement(EMAIL_INPUT_LOCATOR);
    }

    public WebElement getPasswordInput() {
        return pageDriver.findElement(PASSWORD_INPUT_LOCATOR);
    }

    public WebElement getLoginButton() {
        return pageDriver.findElement(LOGIN_BUTTON_LOCATOR);
    }

    public void setEmailValue(String value) {
        getEmailInput().sendKeys(value);
    }

    public void setPasswordValue(String value) {
        getPasswordInput().sendKeys(value);
    }

    public void clickLogin() {
        getLoginButton().click();
    }


    // Блок функциональных методов
    public void login(String email, String password) {
        getEmailInput().sendKeys(email);
    }
}
