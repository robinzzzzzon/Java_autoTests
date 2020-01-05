package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson15_HandlesOfPages {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //В этом примере будет рассмотрена ситуация с переключением на новое появляющееся окно и обратно.
        //Итак: получаем наш первый урл:
        driver.get("https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        //Теперь запоминаем наш урл, создав стрингу и положив нее результат метода getWindowHandle():
        String mainHandleWindow = driver.getWindowHandle();

        //Кликаем по ссылке для появления окна:
        driver.findElement(By.xpath("//a[text()='Oracle BSD License.']")).click();

        //Создаем цикл forEach, в котором проходимся методом getWindowHandle()
        //и при получении последнего хэндла, переходим на него методом switchTo:
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        //Теперь т.к. мы запомнили наш первый хэндл и положили его в переменную mainHandleWindow,
        //то мы можем переключиться на него снова:
        driver.switchTo().window(mainHandleWindow);

        //Выполняем клик по линке на стр. №1, чтобы убедиться что хэндл вернулся обратно:
        driver.findElement(By.xpath("//a[text()='jdk-8u231-windows-i586.exe']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
