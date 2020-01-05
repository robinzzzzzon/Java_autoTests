package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson19_Klava_emulate {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //В этом примере мы рассмотрим имитацию ввода с клавиатуры:
        //Переходим на сайт википедии:
        driver.get("https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D0%BA%D0%B8%D0%BF%D0%B5%D0%B4%D0%B8%D1%8F");

        //ТЕперь находим локатор инпута поиска:
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
        //Передаем туда значение:
        searchInput.sendKeys("Неаполь");
        //Теперь с помощью класса Keys передаем имитацию нажатия ENTER:
        searchInput.sendKeys(Keys.ENTER);

        //Это здесь для декорации :)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Допустим возвращаемся обратно на начальную страницу:
        driver.navigate().back();
        //Теперь еще раз находим этот же инпут. Это приходится делать каждый раз при обновлении страницы т.к.
        //теряется UID нашего элемента, который передается при каждом формировании DOM дерева страницы.
        searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
        //Еще раз вводим значение в инпут и нажимаем Enter:
        searchInput.sendKeys("олимпиада 80");
        searchInput.sendKeys(Keys.ENTER);


        //Дубль 3) Ищем этот же локатор и передаем в него значение:
        searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchInput.sendKeys("ЧМ 2000");
        //ТЕперь вариация ввода хоткеев выделения/выреза/вставки, сначала определяем локаторы и помещаем их в стрингу:
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        String cutAll = Keys.chord(Keys.CONTROL, "x");
        String pasteAll = Keys.chord(Keys.CONTROL, "v");

        //Собсна выполняем:
        searchInput.sendKeys(selectAll);
        searchInput.sendKeys(cutAll);
        searchInput.sendKeys(pasteAll);
        searchInput.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}


