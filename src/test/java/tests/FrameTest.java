package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        WebElement button = driver.findElement(By.cssSelector("button[aria-label='Bold']")); // Принадлежит original HTML

        //driver.switchTo().frame(0); // index
        //driver.switchTo().frame("mce_0_ifr"); // nameOrID

        WebElement frame = driver.findElement(By.cssSelector("iframe.tox-edit-area__iframe"));
        driver.switchTo().frame(frame); // WebElement

        WebElement element = driver.findElement(By.id("tinymce"));                           // Принадлежит frame HTML

        driver.switchTo().parentFrame(); // вернет на 1 уровень вверх/назад

        driver.switchTo().defaultContent(); // вернемся в основной документ

        WebElement button1 = driver.findElement(By.cssSelector("button[aria-label='Bold']")); // Принадлежит original HTML
    }
}
