package pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.LoggerTest;

public class LoginPage extends BasePage {
    private Logger logger = LogManager.getLogger(LoginPage.class);

    // Блок описания локатор для элементов
    private final By EMAIL_INPUT_LOCATOR = By.id("name");
    private final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("button_primary");
    private final By ERROR_TEXT_LOCATOR = By.className("error-text");
    private final By ERROR_FIELDTEXT_LOCATOR = By.className("loginpage-message");


    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return LOGIN_BUTTON_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return "";
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

    public WebElement getErrorTextElement() {
        return pageDriver.findElement(ERROR_TEXT_LOCATOR);
    }

    public WebElement getErrorFieldTextElement() {
        return pageDriver.findElement(ERROR_FIELDTEXT_LOCATOR);
    }

    public void setEmailValue(String value) {
        logger.info(value);
        getEmailInput().sendKeys(value);
    }

    public void setPasswordValue(String value) {
        logger.info(value);
        getPasswordInput().sendKeys(value);
    }

    public void clickLogin() {
        getLoginButton().click();
    }
}
