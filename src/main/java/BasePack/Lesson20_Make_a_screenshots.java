package BasePack;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Lesson20_Make_a_screenshots {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //В этом примере мы научимся делать скриншоты с помощью Selenium:
        //Переходим на сайт википедии:
        driver.get("https://ru.wikipedia.org/wiki/%D0%92%D0%B8%D0%BA%D0%B8%D0%BF%D0%B5%D0%B4%D0%B8%D1%8F");

        //Находим локатор инпута поиска:
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
        //Передаем туда значение:
        searchInput.sendKeys("Неаполь");
        //Теперь с помощью класса Keys передаем имитацию нажатия ENTER:
        searchInput.sendKeys(Keys.ENTER);

        //Итак, для начала создаем объект класса Date,
        //далее создаем объект класса SimpleDateFormat где объекту передаем параметр формирования шаблона даты:
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yy_mm_dd");
        //Теперь создаем стрингу и помещаем туда наш шаблон на котором вызываем метод format(), помещаем методу на вход объект даты и делаем приписку с расширением.
        String filename = format.format(date) + ".png";

        //Создаем такую вот конструкцию:
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //И теперь вот такую конструкцию с обработкой исключения. Все готово.
        //Мы можем вызывать эту функцию и делать скриншоты в любом месте теста.
        //Это очень удобно, особенно на большом проекте:
        try {
            FileHandler.copy(screenshot, new File("C:\\Users\\Feelmax\\IdeaProjects\\mavenTest\\screenshots\\" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
