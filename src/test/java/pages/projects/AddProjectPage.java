package pages.projects;

import baseEntities.BasePage;
import elements.Button;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BaseProjectPage {
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("accept");
    private final By PROJECT_TYPE_RADIOBUTTON_LOCATOR = By.cssSelector("[name='suite_mode']");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public Button getAddProjectButton() {
        return new Button(pageDriver, ADD_PROJECT_BUTTON_LOCATOR);
    }

    public RadioButton getProjectTypeRadioButton() {
        return new RadioButton(pageDriver, PROJECT_TYPE_RADIOBUTTON_LOCATOR);
    }
}
