package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class CssSelectorTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssSelectorsTest() {
        driver.get("file:/Users/aleksandr.trostyanko/Documents/Work/TeachMeSkills/Code/Java/AQA27/AQA27Onl/AQA27Onl/src/test/resources/index.html");

        // Поиск по id
        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());

        // Поиск по class name
        Assert.assertTrue(driver.findElement(By.className("newsletter")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());

        // Поиск по tag name
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

        // Поиск по нескольким значениям в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        // Поиск по tag и значению из аттрибута class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        // Использование 2х уровневой иерархии для поиска дочернего элемента
        Assert.assertEquals(2, driver.findElements(By.cssSelector("#Lastname .markup")).size());
        Assert.assertEquals(2, driver.findElement(By.id("Lastname")).findElements(By.cssSelector(".markup")).size());

        //
        // Использование 4х уровневой иерархии для поиска дочернего элемента
        Assert.assertTrue(driver.findElement(By.cssSelector("body #helpIntro div.intro #Lastname")).isDisplayed());
        WebElement body = driver.findElement(By.tagName("body"));
        WebElement helpIntro = body.findElement(By.id("helpIntro"));
        WebElement divIntro = helpIntro.findElement(By.cssSelector("div.intro"));
        WebElement lastname = divIntro.findElement(By.id("Lastname"));
        Assert.assertTrue(lastname.isDisplayed());

        // Поиск всех элементов с тэгом h1 или p
        Assert.assertEquals(8, driver.findElements(By.cssSelector("h1, p")).size());

        // Поиск всех элементов с тэгом p у которых непосредственный родитель с тэгом div
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());

        // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэго ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());
    }
}