package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class BaseProjectPage extends BasePage {
    private final By NAME_INPUT_LOCATOR = By.id("name");

    public BaseProjectPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return NAME_INPUT_LOCATOR;
    }

    @Override
    protected String getPagePath() {
        return "";
    }

    public WebElement getNameInput() {
        return $(NAME_INPUT_LOCATOR);
    }
}
