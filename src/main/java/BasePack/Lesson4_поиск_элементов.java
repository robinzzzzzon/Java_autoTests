package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson4_поиск_элементов {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://github.com/");

        WebElement inputLogin = driver.findElement(By.xpath("//input[@id='user[login]']"));
        inputLogin.sendKeys("Qwerty1");
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='user[email]']"));
        inputEmail.sendKeys("Qwerty2");
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='user[password]']"));
        inputPassword.sendKeys("123456");
        WebElement buttonSignUp = driver.findElement(By.xpath("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']"));
        buttonSignUp.click();





        driver.quit();
    }
}
