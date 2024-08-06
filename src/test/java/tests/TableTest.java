package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.Table;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TableTest extends BaseTest {

    @Test
    public void testTable() {
        userStep
                .successfulLogin(ReadProperties.username(), ReadProperties.password());

        driver.get("https://aqa2704.testrail.io/index.php?/admin/projects/overview");

        Table table = new Table(driver, By.cssSelector("table.grid"));
        table.getCell("Project", "wp_test_02", 1)
                .getAsEditButton()
                .click();
    }
}
