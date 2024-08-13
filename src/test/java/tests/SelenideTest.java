package tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;

@Listeners({SoftAsserts.class})
public class SelenideTest {

    @BeforeSuite
    public void setupBrowser() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = ReadProperties.getUrl();


        //Configuration.browser = ReadProperties.browserName();
        Configuration.browser = Browsers.CHROME;
        Configuration.headless = false;

        // Set browser size
/*
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println(width + "x" + height);
        Configuration.browserSize = width + "x" + height;
        //Configuration.browserSize = "1920x1080";
*/
        Configuration.fastSetValue = true;
        //Configuration.pageLoadTimeout = 30000;
        //Configuration.timeout = ReadProperties.timeout() * 1000;

        Configuration.assertionMode = AssertionMode.SOFT;
    }

    @BeforeMethod
    public void openBrowser() {
        //open(ReadProperties.getUrl());
        open("/");
        //WebDriverRunner.driver().getWebDriver().manage().window().maximize();
    }

    @Test
    public void simpleTest() {
        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        //Assert.assertEquals($("[data-testid='testCaseContentHeaderTitle']").text(), "All Projects");

        $("[data-testid='testCaseContentHeaderTitle']")
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        open("index.php?/admin/projects/overview");

        $$(By.className("hoverSensitive"))
                .shouldHave(size(5))
                .find(text("wp_test_03"))
                .find(By.tagName("a"))
                .click();

        $("#announcement_display")
                .should(exist, Duration.ofSeconds(3))
                .shouldBe(visible)
                .shouldNotHave(text("Country"));

        $("#announcement_display").val("New Value");
        //sleep(3000);
    }

    @Test
    public void simpleTest1() {
        SelenideElement username = $(By.id("name"));
        username.setValue(ReadProperties.username());

        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        //Assert.assertEquals($("[data-testid='testCaseContentHeaderTitle']").text(), "All Projects");

        $("[data-testid='testCaseContentHeaderTitle']")
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        open("index.php?/admin/projects/overview");

        ElementsCollection elements = $$(By.className("hoverSensitive"));

        $$(By.className("hoverSensitive"))
                .shouldHave(size(5))
                .find(text("wp_test_03"))
                .find(By.tagName("a"))
                .click();

        $("#announcement_display")
                .should(exist, Duration.ofSeconds(3))
                .shouldBe(visible)
                .shouldNotHave(text("Country"));

        $("#announcement_display").val("New Value");
        //sleep(3000);
    }

    @Test
    public void fileTest() {
/*
        open("https://the-internet.herokuapp.com/upload");

        String filePath = SelenideTest.class.getClassLoader().getResource("download.png").getPath();

        $("#file-upload")
                .uploadFile(new File(filePath));
        $("#file-upload")
                .submit();

        sleep(3000);
*/

        open("https://the-internet.herokuapp.com/download");

        String uri = $("#content a").download().toURI().toString();
        System.out.println(uri);

        SelenideElement element1 = $(byText("some-file.txt"));
        SelenideElement element2 = $(byTextCaseInsensitive("linkedin post_ne_ashrav.png"));

        SelenideElement parent = element1.parent();
    }
}
