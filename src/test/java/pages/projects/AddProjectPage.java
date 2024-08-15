package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BaseProjectPage {
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");

    public AddProjectPage() {
        super();
    }

    public AddProjectPage setProjectName(String projectName) {
        // Реализация ввода значения в соответствующее поле

        return this;
    }
}
