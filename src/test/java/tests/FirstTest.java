package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.AdvancedDriver;
import services.BrowsersService;
import services.SimpleDriver;

import java.time.Duration;

public class FirstTest {

    @Test
    public void simpleDriverTest() throws InterruptedException {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();

        Thread.sleep(3000);

        driver.quit();
    }

    @Test
    public void advancedDriverTest() throws InterruptedException {
        AdvancedDriver advancedDriver = new AdvancedDriver();
        WebDriver driver = advancedDriver.getDriver();

        Thread.sleep(3000);

        driver.quit();
    }

    @Test
    public void browserDriverTest() throws InterruptedException {
        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();

        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        Thread.sleep(2000);
        //driver.manage().window().setPosition(new Point(400, 500));
        //driver.manage().window().setSize(new Dimension(500, 500));
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

        driver.quit();
    }
}
