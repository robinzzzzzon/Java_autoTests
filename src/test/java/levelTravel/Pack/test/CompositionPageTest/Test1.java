package levelTravel.Pack.test.CompositionPageTest;

import levelTravel.Pack.StartUpPage.Classes.StartPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test1 {

    private WebDriver driver;
    private StartPage startPage;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://level.travel/");
        startPage = new StartPage(driver);
    }

    @Test
    public void test1(){
        startPage.doCorrectSignUp();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
