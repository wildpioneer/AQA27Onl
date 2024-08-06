package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void test2() {
        userStep
                .successfulLogin(ReadProperties.username(), ReadProperties.password());

        projectStep
                .addProject("sdfsd");
    }

}
