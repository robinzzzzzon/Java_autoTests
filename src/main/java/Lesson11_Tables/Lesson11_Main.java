package Lesson11_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson11_Main {

    static WebDriver driver;

    public static void main(String[] args) {


        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/html/html_tables.asp");

        //Работа с таблицами, сложная задача, но ее можно разрешить. Для этого мы опишем отдельный класс с методами.
        //Перед тем как создать класс, получим xPath таблицы:
        //Теперь идем в соседний класс
        WebElement tableElement = driver.findElement(By.xpath("//table[@id='customers']"));

        Table table = new Table(tableElement, driver);
        System.out.println(table.getRows());
        System.out.println(table.getRowsWithColumns());
        System.out.println(table.getRows().size());

        System.out.println(table.getValueFromCell(3, 3));
        System.out.println(table.getValueFromCell(2, "Company"));

        driver.quit();

    }

}
