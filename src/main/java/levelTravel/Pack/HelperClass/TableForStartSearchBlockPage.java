package levelTravel.Pack.HelperClass;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableForStartSearchBlockPage {

    //создаем 2 переменные:
    private WebElement tableElement;
    private WebDriver driver;

    //создаем конструктор:
    public TableForStartSearchBlockPage(WebElement webElement, WebDriver driver){
        this.tableElement = webElement;
        this.driver = driver;
    }


    //метод получения строк. делаем возвращаемый метод, внутри которого создаем лист,
    // в который помещаем значение параметра tableElement из конструктора объекта класса при создании:
    private List<WebElement> getRows(){
        return tableElement.findElements(By.xpath(".//tr"));
    }

    //Возвращаемый метод создания листа-листов, в котором будут лежать уже все ячейки как объекты отдельно.
    //Сначала создаем лист и помещаем в него результат выполнения getRows(), затем создаем ArrayList List'ов.
    //Теперь проходим циклом по нашему листу со строками и при каждой итерации создаем лист в который помещаем результат поиска td-элементов в каждой из строк коллекции rows.
    //Ну и теперь так же в рамках цикла добавляем каждый такой лист как объект в наш ArrayList листов rowsWithColumns и возвращаем его.
    @NotNull
    private List<List<WebElement>> getRowsWithColumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<>();
        for (WebElement row: rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    //Итак, здесь мы подаем номер столбца и номер строки. Далее создаем лист листов и помещаем туда результат от getRowsWithColumns().
    //Теперь создаем элемент, в который помещаем результат поиска по получившейся двумерной коллекции,
    //ну и возвращаем объявленный String на элементе методом getText().
    public WebElement getValueFromCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        return rowsWithColumns.get(rowNumber -1).get(columnNumber - 1);
    }
}
