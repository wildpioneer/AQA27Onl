package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TableCell {
    private UIElement cellElement;
    private WebDriver driver;

    public TableCell(WebDriver driver, UIElement cellElement) {
        this.driver = driver;
        this.cellElement = cellElement;
    }

    public UIElement getAsUIElement() {
        return cellElement;
    }

    public Button getAsEditButton() {
        return new Button(driver, cellElement.findUIElement(By.className("icon-small-edit")));
    }
}
