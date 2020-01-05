package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson6_inputs {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://github.com/");

        WebElement inputLogin = driver.findElement(By.xpath("//input[@id='user[login]']"));
        inputLogin.sendKeys("Jackson123");
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='user[email]']"));
        inputEmail.sendKeys("testQwerty@gmail.com");
        System.out.println(inputEmail.getAttribute("value"));
        inputEmail.clear();
        inputEmail.sendKeys("testQwerty123@gmail.com");
        WebElement inputPass = driver.findElement(By.xpath("//input[@id='user[password]']"));
        inputPass.sendKeys("123456");
        WebElement buttonSignUp = driver.findElement(By.xpath("//div[2]/div[1]/form[1]/button[1]"));
        buttonSignUp.submit();
        driver.navigate().back();
        driver.quit();
    }
}
