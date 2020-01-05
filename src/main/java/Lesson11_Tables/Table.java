package Lesson11_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Table {

    //создаем 2 переменные:
    private WebElement tableElement;
    private WebDriver driver;

    //создаем конструктор:
    public Table(WebElement webElement, WebDriver driver){
        this.tableElement = webElement;
        this.driver = driver;
    }


    //метод получения строк. делаем возвращаемый метод, внутри которого создаем лист,
    // в который помещаем значение параметра tableElement из конструктора объекта класса при создании:
    public List<WebElement> getRows(){
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

    //Создаем возвращаемый метод для получения всех заголовков таблицы. В рамках метода запиливается отдельный элемент, куда помещается первая строка.
    //Далее создается лист в который помещается результат выполнения поиска элементов "th" в элементе нашей строки:
    public List<WebElement> getHeadings(){
        WebElement headingsRow = tableElement.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headingColumns = headingsRow.findElements(By.xpath(".//th"));
        return headingColumns;
    }

    //Возвращаемый метод создания листа-листов, в котором будут лежать уже все ячейки как объекты отдельно.
    //Сначала создаем лист и помещаем в него результат выполнения getRows(), затем создаем ArrayList List'ов.
    //Теперь проходим циклом по нашему листу со строками и при каждой итерации создаем лист в который помещаем результат поиска td-элементов в каждой из строк коллекции rows.
    //Ну и теперь так же в рамках цикла добавляем каждый такой лист как объект в наш ArrayList листов rowsWithColumns и возвращаем его.
    public List<List<WebElement>> getRowsWithColumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row: rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    //Итак, здесь мы подаем номер столбца и номер строки. Далее создаем лист листов и помещаем туда результат от getRowsWithColumns().
    //Теперь создаем элемент, в который помещаем результат поиска по получившейся двумерной коллекции,
    //ну и возвращаем объявленный String на элементе методом getText().
    public String getValueFromCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber -1).get(columnNumber - 1);
        return cell.getText();
    }

    //Теперь самое сложное:
    //Создаем возвращаемый метод с листом мапов.
    //Внутри сначала получаем локальную коллекцию "поячеечно" результатом от getRowsWithColumns().
    //Теперь создаем наш лист мапов. Пока пустой. Так же создаем  объект мапы с ключом типа String и объектами типа WebElement.
    //Создаем лист в который помещаем результат метода получения листа заголовков.
    //Циклом foreach мы проходимя по коллекции с ячейками rowsWithColumns, при каждой итерации создавая ХэшМапу.
    //Помимо этого, в рамках каждой итерации у нас прогоняется цикл for до длины листа headingColumns, в котором при каждой итерации создается стринга со значением заголовка,
    //А также создается вэбЭлемент в который помещается значение строки с ячейками по номеру == номеру итерации и все это кладется в нашу мапу rowByHeadings.
    //Наконец при каждом выходе из for в рамках каждой итерации foreach, наша мапа со значениями кладется в ArrayList с мапами.
    //Ну и разумеется мы возвращаем полученную коллекцию.
    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingColumns = getHeadings();

        for (List<WebElement> row: rowsWithColumns) {
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++) {
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }

    //Тоже самое, что и 1я версия, только здесь мы ищем по номеру строки и заголовку:
    public String getValueFromCell(int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        return rowsWithColumnsByHeadings.get(rowNumber -1).get(columnName).getText();
    }

}
