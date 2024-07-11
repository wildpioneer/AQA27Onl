package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import services.StaticBrowser;

public class StaticLoginPage {
    // Блок описания локатор для элементов
    private final By EMAIL_INPUT_LOCATOR = By.id("name");
    private final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private final By LOGIN_BUTTON_LOCATOR = By.id("button_primary");

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return StaticBrowser.getDriver().findElement(EMAIL_INPUT_LOCATOR);
    }


}
