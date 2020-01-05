package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Lesson5_buttons {

    public static void main(String[] args) {


        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://github.com/");

        WebElement buttonSignIn = driver.findElement(By.xpath("//div[1]/div[2]/div[2]/a[1]"));
        buttonSignIn.click();
        driver.navigate().back();
        WebElement buttonSignUp = driver.findElement(By.xpath("//div[1]/div[2]/div[2]/a[2]"));
        buttonSignUp.click();
        driver.navigate().back();
        WebElement buttonSignUpYourTeam = driver.findElement(By.xpath ("//a[@class='btn-mktg btn-large-mktg btn-outline-mktg Bump-link']"));
        buttonSignUpYourTeam.click();
        driver.navigate().back();
        driver.quit();


    }
}
