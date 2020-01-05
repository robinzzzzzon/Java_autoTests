package BasePack;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Lesson21_Download_Files {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //В этом примере мы научимся загружать аттачи при помощи Селениум:
        //Переходим на сайт google и находим все необходимые локаторы:
        driver.get("https://www.google.ru/imghp?hl=ru&tab=ri&ogbl");
        driver.findElement(By.xpath("//span[@class='BwoPOe']")).click();
        driver.findElement(By.xpath("//a[@class='qbtbha qbtbtxt qbclr']")).click();
        //Когда доходим до элемента(как правило это input с типом "file", то мы не кликаем, а как и положено,
        //передаем при помощи sendkeys() наш путь до файла на локальной тачке с указанием расширения и все.
        //Все работает:
        driver.findElement(By.xpath("//input[@id='qbfile' and @type='file']")).sendKeys("C:\\Users\\Feelmax\\Pictures\\Saved Pictures\\zIFyTlu.jpg");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
