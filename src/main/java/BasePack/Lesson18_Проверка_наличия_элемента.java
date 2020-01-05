package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson18_Проверка_наличия_элемента {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //В этом примере рассмотрим, как просто определить наличие элементов:
        //Переходим на гитхаб:
        driver.get("https://github.com/");

        System.out.println(driver.findElement(By.xpath("//a[@href='/login']")).isEnabled());

        //Создаем лист вэбэлементов, в который помещаем результат выполнения метода и проверяем размер коллекции:
        List<WebElement> webElements = driver.findElements(By.xpath("//a"));
        System.out.println(webElements.size());

        //Простенький вариант проверки наличия элемента(ов):
        if(driver.findElements(By.xpath("//a[text()='Sign in']")).size() > 0) System.out.println("Elements was found");
        else System.out.println("Elements wasn't found");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
