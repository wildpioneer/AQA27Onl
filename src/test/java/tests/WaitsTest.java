package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsTest extends BaseTest {

    @Test
    public void presenceOfElementTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Assert.assertFalse(button.isDisplayed());

        WebElement loading = driver.findElement(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Thread.sleep(10000);
        Assert.assertFalse(loading.isDisplayed());

        Assert.assertTrue(driver.findElement(By.id("finish")).isDisplayed());
    }

    @Test
    public void presenceOfElementTest1() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(0));

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement button = waitsService.elementToBeClickable(By.tagName("button"));
        button.click();
        Assert.assertTrue(waitsService.invisibilityOf(button));

        WebElement loading = waitsService.waitVisibilityOf(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(waitsService.invisibilityOf(loading));

        Assert.assertTrue(waitsService.waitVisibilityOf(By.id("finish")).isDisplayed());
    }
}
