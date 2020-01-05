package BasePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lesson1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.seleniumhq.org/");
    }
}
