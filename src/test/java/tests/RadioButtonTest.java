package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.projects.AddProjectPage;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonTest() {
        userStep
                .successfulLogin(ReadProperties.username(), ReadProperties.password());

        driver.get("https://aqa2704.testrail.io/index.php?/admin/projects/add");

        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.getProjectTypeRadioButton().selectByText("Use multiple test suites to manage cases");

        driver.get("https://aqa2704.testrail.io/index.php?/admin/subscription#");
        RadioButton tmpRadioButton = new RadioButton(driver, By.cssSelector("[name='db_type']"));
        tmpRadioButton.selectByText("MySQL Export");
        tmpRadioButton.selectByText("3");
    }
}
