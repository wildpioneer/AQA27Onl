package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    public TopMenuPage topMenuPage;

    private static final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");

    public DashboardPage() {
        super();

        topMenuPage = new TopMenuPage();
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public void openPageByUrl() {
        super.load();
    }
}
