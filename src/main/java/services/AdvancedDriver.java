package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--silent");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");

        return options;
    }
}
