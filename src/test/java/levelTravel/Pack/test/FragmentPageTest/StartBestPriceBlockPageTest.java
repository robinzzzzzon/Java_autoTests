package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.Pages.StartUpPage.Classes.StartBestPriceBlockPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StartBestPriceBlockPageTest {

    private WebDriver driver;
    private StartBestPriceBlockPage startBestPriceBlockPage;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://level.travel/");
        startBestPriceBlockPage = new StartBestPriceBlockPage();
    }

    @Test
    public void clickCityStartDD(){
        startBestPriceBlockPage.clickCityStartDD();
        List<WebElement> webElements = driver.findElements(By.xpath("//select[@data-reactid='.2.0.0.0.1.1']//option"));
        Assert.assertTrue(webElements.get(3).isDisplayed());
    }

    @Test
    public void selectAnyStartCity(){
        startBestPriceBlockPage.clickCityStartDD()
                .selectAnyStartCity(4);
        WebElement element = driver.findElement(By.xpath("//div[@class='ps-departures_input']/label"));
        Assert.assertEquals("Казани", element.getText());
    }

    @Test
    public void selectAnyCountOfNights(){
        startBestPriceBlockPage.selectAnyCountOfNights(3);
        Assert.assertFalse(driver.findElements(By.xpath("//div[@class='price-stat-columns-wrap']//a")).isEmpty());
    }

    @Test
    public void selectAnyCountry(){
        startBestPriceBlockPage.selectAnyCountry(4);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='price-stat-columns-wrap']//a")).get(0).isDisplayed());
    }

    @Test
    public void selectAnyPriceOfGraph(){
        startBestPriceBlockPage.selectAnyPriceOfGraph(36, "Turk");
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']//div")).size() != 0);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
