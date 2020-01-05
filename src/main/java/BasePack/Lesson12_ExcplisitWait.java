package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Lesson12_ExcplisitWait {

    //Хорошая практика- выносить драйвер и ждуна в сатику за мэйн метод т.к. они нам будут доступны везде в рамках нашего класса.
    static WebDriver driver;
    static WebDriverWait waiter;

    public static void main(String[] args) {


            System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            waiter = new WebDriverWait(driver, 5);

            //driver.manage().window().maximize();
            //driver.manage().window().setSize(new Dimension(900, 500));

            driver.get("https://gsuite.google.com/signup/basic/welcome");

            //Пример задания явного ожидания по отображению одного из элементов:
            waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Приступим!']")));

            dropDownClickable("Бразилия");


        }

    static void dropDownClickable(String anyCountry){
        String baseElementPath = "//c-wiz[5]/div[1]/div[2]/div[1]/div[1]";
        String countryName = "//c-wiz[5]/div[1]/div[2]/div[1]/div[2]//span[text()='%s']/parent::div";
        //Пример явного ожидания видимости одного из элементов:
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(baseElementPath)));
        driver.findElement(By.xpath(baseElementPath)).click();
        driver.findElement(By.xpath(String.format(countryName, anyCountry))).click();
        //Пример явного ожидания невидимости одного из элементов:
        waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(countryName)));
    }
}
