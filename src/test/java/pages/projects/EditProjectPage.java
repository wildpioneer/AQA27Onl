package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProjectPage extends BaseProjectPage {
    private final By EDIT_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By COMPLETE_PROJECT_CHECKBOX_LOCATOR = By.id("is_completed");

    public EditProjectPage(WebDriver driver) {
        super(driver);
    }
}
