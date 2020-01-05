package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson17_VisibleElements {


    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //В этом примере разберем isSelected/isEnabled/isDisplayed:
        //Переходим на линку и далее на диалоговое окно входа:
        driver.get("https://level.travel/");

        driver.findElement(By.xpath("//span[text()='Вход']/parent::div")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Получаем элементы дизейбл-баттона "Продолжить" и ссылки на вк:
        WebElement button1 = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        WebElement link2 = driver.findElement(By.xpath("//li[@class='vk']//a"));
        //Тут все просто, если кнопка "Продолжить" != isEnabled(Задизейблена), то кликаем по линке vk:
        if(!button1.isEnabled()) {
           link2.click();
        }

        //Пример 2: Получаем адрес джава, а также адреса 2х радиобаттонов на странице:
        driver.get("https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");

        WebElement RB1 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u231-oth-JPR'])[1]"));
        WebElement RB2 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u231-oth-JPR'])[2]"));

        //Проверяем выбран ли радиобаттон №2:
        System.out.println(RB2.isSelected());

        //Если РБ1 != isSelected() то кликаем по RB1:
        if(!RB1.isSelected()) RB1.click();

        //Получаем адрес Ebay и 2х элементов на странице, один из которых по дефолту не видим:
        driver.get("https://ebay.com");

        WebElement elem1 = driver.findElement(By.xpath("(//a[text()='Электроника'])[2]"));
        WebElement elem2 = driver.findElement(By.xpath("//a[text()='Умный дом']"));

        //Проверяем видимость обоих:
        System.out.println(elem1.isDisplayed());
        System.out.println(elem2.isDisplayed());

        //Если первая линка видна, то кликаем по ней, иначе кликаем по второй линке:
        if (elem1.isDisplayed()) elem1.click();
        else elem2.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
