package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson14_Alerts {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        driver.findElement(By.xpath("//a[text()='jdk-8u231-windows-x64.exe']")).click();

        //Пример того, как работать с алертами.
        // Подобной конструкцией мы переключаем наш драйвер на алерт с подтверждением:
        driver.switchTo().alert().accept();

        driver.get("https://google.com");

        //Такой конструкцией, мы можем исполнять js скрипты.
        //В данном случае мы сами создаем алерт с последующим отказом от действия:
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("confirm('Are you sure?');");

        //Таким образом мы можем задавать задержку потоку.
        // Теперь наше след. действие будет выполнено через 3 сек:
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();

        driver.quit();
    }
}
