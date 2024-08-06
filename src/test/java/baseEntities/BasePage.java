package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver pageDriver;

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract WebElement getPageIdentifier();

    public boolean isPageOpened() {
        return getPageIdentifier().isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        pageDriver.get(ReadProperties.getUrl() + pagePath);
    }

    public void refresh() {
        PageFactory.initElements(pageDriver, this);
    }
}
