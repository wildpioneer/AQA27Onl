package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import services.WaitsService;

import java.time.Duration;

public abstract class BasePage extends LoadableComponent<BasePage> {
    protected WebDriver pageDriver;
    protected final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 60;

    public BasePage(WebDriver driver) {
        this.pageDriver = driver;

        get();
    }

    protected void load() {
        pageDriver.get(ReadProperties.getUrl() + getPagePath());
    }

    protected void isLoaded() {
        if (!isPageOpened()) throw new Error("Page is not loaded");
    }


    protected abstract By getPageIdentifier();
    protected abstract String getPagePath();

    public boolean isPageOpened() {
        try {
            return new WaitsService(pageDriver, Duration.ofSeconds(WAIT_FOR_PAGE_LOADED_IN_SECONDS))
                    .waitVisibilityOf(getPageIdentifier()).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
