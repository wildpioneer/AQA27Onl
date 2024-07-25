package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIElement> uiElementsList;
    private List<String> valueList;

    /*
    Реализовать поиск этого элемента на основании локатора
    Реализовать метод выбора значения по порядковому номеру
    Реализовать метод выбора значения по атрибуту value
    Реализовать метод выбора значения по тексту
    */

    /**
     * Поиск элемента производиться по атрибуту name
     * @param driver
     * @param by
     */
    public RadioButton(WebDriver driver, By by) {
        uiElementsList = new ArrayList<>();

        for (WebElement element : driver.findElements(by)) {
            UIElement uiElement = new UIElement(driver, element);
            uiElementsList.add(uiElement);
            valueList.add(uiElement.getAttribute("value"));
        }
    }

    public void selectByIndex(int index) {
        if (index >= 0 && index < uiElementsList.size()) {
            uiElementsList.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Индекс больше размера коллекции");
        }
    }

    public void selectByValueSimple(String value) {
        for (UIElement uiElement : uiElementsList) {
            if (uiElement.getAttribute("value").equals(value)) {
                uiElement.click();
                return;
            }
        }

        throw new IllegalArgumentException("Элемента с таким value не существует");
    }

    public void selectByValue(String value) {
        int index = valueList.indexOf(value);
        if (index >= 0) {
            uiElementsList.get(index).click();
        } else {
            throw new IllegalArgumentException("Элемента с таким value не существует");
        }
    }

    public void selectByText(String text) {
        for (UIElement uiElement : uiElementsList) {
            UIElement parent = uiElement.getParentElement();

            if (parent.findElements(By.tagName("strong")).size() > 0) {
                if (parent.findElement(By.tagName("strong")).getText().equals(text)) {
                    uiElement.click();
                    return;
                }
            } else {
                if (parent.findElement(By.tagName("p")).getText().equals(text)) {
                    uiElement.click();
                    return;
                }
            }
        }

        throw new IllegalArgumentException("Элемента с таким текстом не существует");
    }
}
