package services;

import org.openqa.selenium.WebDriver;

public class StaticBrowser {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new BrowsersService().getDriver();
        }
        return driver;
    }

    public static void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
