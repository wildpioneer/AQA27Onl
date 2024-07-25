package elements;

import org.openqa.selenium.*;
import services.WaitsService;

import java.util.List;

public class UIElement implements WebElement {
    private WaitsService waitsService;
    private WebElement webElement;
    private WebDriver driver;

    public UIElement(WebDriver driver, By by) {
        this.driver = driver;
        waitsService = new WaitsService(driver);
        webElement = waitsService.presenceOfElementLocated(by);
    }

    @Override
    public void click() {
        try {
            webElement.click();
        } catch (ElementNotInteractableException ex) {
            moveToElement();
            webElement.click();
        }
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        // ToDo: Как улучшить?
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return List.of();
    }

    @Override
    public WebElement findElement(By by) {
        //return driver.findElement(by);
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return "";
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

    public void moveToElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
