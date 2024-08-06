package pages.administration;

import elements.Button;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.projects.BaseProjectPage;

public class ProjectsPage extends BaseProjectPage {
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By PROJECT_TYPE_RADIOBUTTON_LOCATOR = By.cssSelector("[name='suite_mode']");
    private final String PROJECT_EDIT_BUTTON_LOCATOR_VALUE = "//*[text() = 'replace']/../..//div[@data-testid='projectEditButton']";

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public Button getAddProjectButton() {
        return new Button(pageDriver, ADD_PROJECT_BUTTON_LOCATOR);
    }

    public RadioButton getProjectTypeRadioButton() {
        return new RadioButton(pageDriver, PROJECT_TYPE_RADIOBUTTON_LOCATOR);
    }

    public Button getProjectEditButton(String projectName) {
        return new Button(pageDriver, By.xpath(PROJECT_EDIT_BUTTON_LOCATOR_VALUE.replace("replace", projectName)));
    }
}
