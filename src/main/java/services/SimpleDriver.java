package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Code/Java/AQA27/AQA27Onl/AQA27Onl/src/test/resources/chromedriver");

        return new ChromeDriver();
    }
}
