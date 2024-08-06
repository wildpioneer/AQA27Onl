package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement tableElement;
    private WebDriver driver;
    private List<String> columnHeaders;
    private List<TableRow> tableRows;


    /**
     * Данный элемент идентифицируется по тэгу <table></table> с уникальными аттрибутами
     * @param driver
     * @param by
     */
    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.tableElement = new UIElement(driver, by);
        this.columnHeaders = new ArrayList<>();
        this.tableRows = getRows();

        for (WebElement element : tableElement.findElements(By.tagName("th"))) {
            columnHeaders.add(element.getText());
        }
    }

    public void getCell(int columnIndex, int rowIndex, int targetColumnIndex) {
        //ToDo:
    }

    public TableCell getCell(String columnName, String uniqueValue, int targetColumnIndex) {
        int columnIndex = columnHeaders.lastIndexOf(columnName);

        for (TableRow row : tableRows) {
            if (row.getCell(columnIndex).getAsUIElement().getText().equals(uniqueValue)) {
                return row.getCell(targetColumnIndex);
            }
        }

        return null;
    }

    public TableCell getCell(String columnName, String uniqueValue, String targetColumnName) {
        int targetColumnIndex = columnHeaders.lastIndexOf(targetColumnName);

        return getCell(columnName, uniqueValue, targetColumnIndex);
    }


    public List<TableRow> getRows() {
        List<UIElement> rows = tableElement.findUIElements(By.xpath("//tr[@class!='header']"));
        List<TableRow> tableRows = new ArrayList<>();

        for (UIElement row : rows) {
            tableRows.add(new TableRow(driver, row));
        }

        return tableRows;
    }
}
