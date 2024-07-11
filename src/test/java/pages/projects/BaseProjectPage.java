package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseProjectPage extends BasePage {
    private final By NAME_INPUT_LOCATOR = By.id("name");

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return NAME_INPUT_LOCATOR;
    }

    public WebElement getNameInput() {
        return pageDriver.findElement(NAME_INPUT_LOCATOR);
    }
}
