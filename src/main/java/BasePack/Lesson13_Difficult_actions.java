package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class Lesson13_Difficult_actions {

    static WebDriver driver;

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.ebay.com/");

        //Эти элементы просто для примера имитации сложных действий мыши:
        WebElement link = driver.findElement(By.xpath("//div[4]/div[1]/ul[1]/li[3]"));
        WebElement element = driver.findElement(By.xpath("//div[4]/div[1]/ul[1]/li[4]"));

        //Для имитиации таких действий существует класс Action. Создадим экземпляр класса:
        Actions action = new Actions(driver);

        //Пример наведения на элемент:
        action.moveToElement(link).build().perform();

        //Пример перетаскивания какого-то элемента из точки A в точку B:
        action.dragAndDrop(element, link).build().perform();
        //По сути тоже перетаскивание, сначала мы нажимаем и держим, затем передвигаем элемент в назначенную точку:
        action.clickAndHold(element).moveToElement(link).release().build().perform();

        //Имитация 2го клика:
        action.doubleClick(element);
        //Имитация нажатия правой кнопкой мыши:
        action.contextClick(element);

        //Можно создать не только экземпляр класса Actions, но и экземпляр класса Action:
        Action action1 = action.clickAndHold(element).moveToElement(link).release().build();
        action1.perform();

        driver.quit();

    }

}
