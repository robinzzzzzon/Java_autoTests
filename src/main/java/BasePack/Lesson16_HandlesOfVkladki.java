package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson16_HandlesOfVkladki {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //В этом примере будет рассмотрена ситуация с переключением на новую вкладку и обратно.
        //Итак: получаем наш первый урл:
        driver.get("https://policies.google.com/privacy?gl=RU&hl=ru");
        //Теперь запоминаем наш урл, создав стрингу и положив в нее результат метода getWindowHandle():
        String mainHandleWindow = driver.getWindowHandle();

        //Кликаем по ссылке для появления окна:
        driver.findElement(By.xpath("//a[text()='свяжитесь с нами']")).click();

        //Создаем цикл forEach, в котором проходимся методом getWindowHandle()
        //и при получении последнего хэндла, переходим на него методом switchTo:
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //на новой вкладке выполняем действие:
        driver.findElement(By.xpath("//span[text()='русский\u200E']/parent::div")).click();

        //переключаемся на первую табу:
        driver.switchTo().window(mainHandleWindow);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Выполняем действие на первой табе:
        driver.findElement(By.xpath("//a[text()='Перейти в аккаунт Google']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
