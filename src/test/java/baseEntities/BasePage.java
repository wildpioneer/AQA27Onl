package baseEntities;

import configuration.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import pages.LoginPage;
import services.WaitsService;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage extends LoadableComponent<BasePage> {
    private Logger logger = LogManager.getLogger(this);

    protected final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 30;

    public BasePage() {
        get();
    }

    protected void load() {
        open(ReadProperties.getUrl() + getPagePath());
    }

    protected void isLoaded() {
        if (!isPageOpened()) {
            logger.error("Page is not opened: " + this.getClass().getSimpleName());
            throw new Error("Page is not loaded");
        }
    }

    protected abstract By getPageIdentifier();
    protected abstract String getPagePath();

    public boolean isPageOpened() {
            return $(getPageIdentifier())
                    .shouldBe(visible, Duration.ofSeconds(WAIT_FOR_PAGE_LOADED_IN_SECONDS))
                    .isDisplayed();
    }
}
