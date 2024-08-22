package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    public TopMenuPage topMenuPage;

    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");
    private final By ADD_PROJECT_BUTTON_LOCATOR = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getAddProjectButton() {
        return waitsService.presenceOfElementLocated(ADD_PROJECT_BUTTON_LOCATOR);
    }
}
