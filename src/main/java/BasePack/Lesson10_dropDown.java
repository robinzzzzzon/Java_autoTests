package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson10_dropDown {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://gsuite.google.com/signup/basic/welcome");

        dropDownClickable("Бразилия");

        //Вся работа с чекбоксами сводится к 2м кликам:
//        WebElement element1 = driver.findElement(By.xpath("//c-wiz[5]/div[1]/div[2]/div[1]/div[1]"));
//        element1.click();
//        WebElement element2 = driver.findElement(By.xpath("//c-wiz[5]/div[1]/div[2]/div[1]/div[2]//span[text()='Бразилия']/parent::div"));
//        element2.click();

    }

    static void dropDownClickable(String anyCountry){
        String baseElementPath = "//c-wiz[5]/div[1]/div[2]/div[1]/div[1]";
        driver.findElement(By.xpath(baseElementPath)).click();
        String countryName = "//c-wiz[5]/div[1]/div[2]/div[1]/div[2]//span[text()='%s']/parent::div";
        driver.findElement(By.xpath(String.format(countryName, anyCountry))).click();
    }

}



