package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void infoAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[. = 'Click for JS Confirm']"));

        driver.findElement(By.xpath("//button[. = 'Click for JS Alert']")).click();
        Thread.sleep(2000);

        if (waitsService.alertIsPresent() != null) {
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals(alert.getText(), "I am a JS Alert");
            alert.accept();
        }

        button.click();


        Thread.sleep(2000);
    }

    @Test
    public void confirmAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Confirm']")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();

        Thread.sleep(2000);
        Assert.assertEquals(waitsService.waitVisibilityOf(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        alert.sendKeys("Everything is OK!");
        alert.accept();

        Thread.sleep(2000);
    }

}
