package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson7_links {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://github.com/");

        WebElement linkEnterprise = driver.findElement(By.xpath("//nav[1]/ul[1]/li[2]/a[1]"));
        System.out.println(linkEnterprise.getText());
        linkEnterprise.click();

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//tbody[1]/tr[3]/td[2]/div[1]/a[1]")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@class='_8esh']")).click();
        driver.navigate().back();
        driver.quit();

    }
}
