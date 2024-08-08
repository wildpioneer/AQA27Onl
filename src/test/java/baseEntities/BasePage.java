package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver pageDriver;
    protected final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 60;

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;

        waitForOpen();
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        try {
            return pageDriver.findElement(getPageIdentifier()).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void openPageByUrl(String pagePath) {
        pageDriver.get(ReadProperties.getUrl() + pagePath);
    }

    public void waitForOpen() {
        int tryCount = 0;
        int maxCount = WAIT_FOR_PAGE_LOADED_IN_SECONDS / ReadProperties.timeout();
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator && (tryCount < maxCount)) {
            tryCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page is not opened");
        }
    }
}
