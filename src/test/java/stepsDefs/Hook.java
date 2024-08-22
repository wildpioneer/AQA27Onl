package stepsDefs;

import baseEntities.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import services.BrowsersService;

public class Hook extends BaseTest {
    private BaseTest baseTest;

    public Hook(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    // Подготовительные
    @Before(value = "@gui")
    public void initBrowser() {
        baseTest.driver = new BrowsersService().getDriver();
    }

    @Before(value = "@gui and @smoke", order = 10002)
    public void initSmokeTest1() {
        System.out.println("initSmokeTest1 started...");
    }

    @Before(value = "@gui and @smoke", order = 10001)
    public void initSmokeTest2() {
        System.out.println("initSmokeTest2 started...");
    }

    @Before(value = "@api")
    public void initService() {
        baseTest.service = "Service is on";
    }

    @After(value = "@gui")
    public void closeBrowser() {
        baseTest.driver.quit();
    }
}
