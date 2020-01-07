package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryMapBlockPage;
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

public class CountryMapBlockPageTest {

    private WebDriver driver;
    private CountryMapBlockPage countryMapBlockPage;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://level.travel/search/Moscow-RU-to-Any-TR-departure-02.02.2020-for-7-nights-1-adults-0-kids-1..5-stars");
        countryMapBlockPage = new CountryMapBlockPage();
    }

    @Test
    public void clickMaxButton(){
        countryMapBlockPage.clickMaximizeButton();
        WebElement element = driver.findElement(By.xpath("//button[text()='Свернуть карту']"));
        Assert.assertTrue(element.isEnabled());
    }

    @Test
    public void clickZoomInAndOut(){
        countryMapBlockPage.clickMaximizeButton()
                           .clickZoomIn()
                           .clickZoomOut();
        WebElement element = driver.findElement(By.xpath("//canvas[@class='mapboxgl-canvas']"));
        Assert.assertNotNull(element);
    }

    @Test
    public void clickTheaterAndShops(){
        countryMapBlockPage.clickMaximizeButton()
                            .clickShoppingButton()
                            .clickTheaterButton();
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='search-page__map']//div[@class='mapboxgl-marker ']"));
        Assert.assertTrue(webElements.size() > 0);
    }

    @Test
    public void selectDynamicGraphs(){
        countryMapBlockPage.clickMaximizeButton()
                            .selectAnyDynamicGraph(countryMapBlockPage.getAnyDynamicGraph(3));
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='hotels-list']//div"));
        Assert.assertTrue(webElements.get(0).isEnabled());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
