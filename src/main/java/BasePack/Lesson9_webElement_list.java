package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson9_webElement_list {

    static WebDriver driver;


    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://market.yandex.ru/");

        WebElement linkBytovTech = driver.findElement(By.xpath("//span[text()='Бытовая техника']"));
        linkBytovTech.click();
        WebElement linkFreeze = driver.findElement(By.xpath("//div[2]/ul[1]/li[1]/div[1]/a[1]"));
        linkFreeze.click();


        //Получаем списки элементов и помещаем их в колекцию:
        List <WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='_178jz2CyDL']//div[2]//div[1]//div[1]//fieldset[1]//ul[1]//input[@type='checkbox']"));
        System.out.println(checkboxes.size());
        System.out.println(checkboxes.get(3).isSelected());

        //Здесь, находим именно спаны для кликабельности элементов:
        List <WebElement> checkboxesClicable = driver.findElements(By.xpath("//div[2]/div[2]/div[1]/div[1]/fieldset[1]/ul[1]//span[@class='NVoaOvqe58']"));
        checkboxesClicable.get(3).click();

        //Пробегаемся по чекбоксам циклом foreach:
        for (WebElement checkbox : checkboxesClicable) {
            checkbox.click();
        }

    }

}
