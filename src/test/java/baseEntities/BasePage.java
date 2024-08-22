package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

public abstract class BasePage {
    protected WebDriver pageDriver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;
        waitsService = new WaitsService(driver);
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return pageDriver.findElement(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        pageDriver.get(ReadProperties.getUrl() + pagePath);
    }
}
