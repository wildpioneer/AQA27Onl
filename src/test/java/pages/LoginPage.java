package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // Блок описания локатор для элементов
    @FindBy(id = "name")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "button_primary")
    public WebElement loginButton;

    @FindBy(className = "error-text")
    public WebElement errorTextLabel;

    private final By ERROR_FIELDTEXT_LOCATOR = By.className("loginpage-message");

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return loginButton;
    }

    // Блок атомарных методов
    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getErrorTextElement() {
        return errorTextLabel;
    }

    public WebElement getErrorFieldTextElement() {
        return pageDriver.findElement(ERROR_FIELDTEXT_LOCATOR);
    }

    public void setEmailValue(String value) {
        emailInput.sendKeys(value);
    }

    public void setPasswordValue(String value) {
        getPasswordInput().sendKeys(value);
    }

    public void clickLogin() {
        getLoginButton().click();
    }
}
