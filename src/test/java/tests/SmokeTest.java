package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTest {

    @Test
    public void validateIKTCalculation() throws InterruptedException {
        WebDriver driver = new BrowsersService().getDriver();

        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");

        WebElement weight = driver.findElement(By.name("weight"));
        WebElement height = driver.findElement(By.name("height"));
        WebElement button = driver.findElement(By.id("calc-mass-c"));

        weight.sendKeys("58");
        weight.sendKeys(Keys.TAB);

        height.sendKeys("183");
        button.click();

        Thread.sleep(2000);

        WebElement result = driver.findElement(By.id("imt-result"));

        Assert.assertEquals(result.getText(), "17.3 - Недостаточная (дефицит) масса тела");

        driver.quit();
    }
}
