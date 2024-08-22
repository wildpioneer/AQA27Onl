package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BaseProjectPage {
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By PAGE_TITLE_LOCATOR = By.cssSelector("[data-testid='testCaseContentHeaderTitle']");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return waitsService.presenceOfElementLocated(PAGE_TITLE_LOCATOR)
                .getText()
                .trim()
                .equals("Add Project");
    }
}
