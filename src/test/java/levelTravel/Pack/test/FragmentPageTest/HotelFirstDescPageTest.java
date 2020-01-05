package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.Pages.HotelDescPage.HotelFirstDescPage;
import levelTravel.Pack.Pages.HotelDescPage.HotelSecondDescPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HotelFirstDescPageTest {

    private WebDriver driver;
    private HotelFirstDescPage hotelFirstDescPage;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://level.travel/hotels/57212-Kleopatra_Alis_Hotel?request_id=MjEzfDIyNXwwfDk4M3x8MjAyMC0wMS0zMCwyMDIwLTAxLTMwfDB8Nyw3fDF8MHx8fDA%3D&offer_price=9540&offer_nights=7&offer_date=2020-01-30");
        hotelFirstDescPage = new HotelFirstDescPage(driver);
    }

    @Test
    public void clickCircleHeader(){
        hotelFirstDescPage.clickCircleHeader();
    }

    @Test
    public void clickFavoriteAndSeePriceBtn(){
        hotelFirstDescPage.clickSeePriceButton();
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='pansion-price hot']")).size() > 0);
    }

    @Test
    public void clickPhotos(){
        hotelFirstDescPage.selectAnyPhoto(2);
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='rtee-button rtee-controls-close']")).isEnabled());
    }

    @Test
    public void selectAnyPriceByDate(){
        hotelFirstDescPage.selectAnyPriceByDate(3);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='pansion-price hot']")).size() > 0);
    }

    @Test
    public void selectFoodVar(){
        hotelFirstDescPage.clickFoodChoiceDD()
                .selectAnyFoodVariation(2);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='pansion-price hot']")).size() > 0);
    }

    @Test
    public void selectBestPriceVar(){
        hotelFirstDescPage.clickBestPriceDD()
                .selectAnyPriceVariation(2);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='pansion-price hot']")).size() > 0);
    }

    @Test
    public void selectAnyResultOfferList(){
        HotelSecondDescPage hotelSecondDescPage = hotelFirstDescPage.selectAnyResultOfferList(3);
        Assert.assertNotNull(hotelSecondDescPage.getHeadingText());
    }

    @Test
    public void selectMoreInfoAboutOffersVariation(){
        hotelFirstDescPage.selectMoreInfoAboutOffersVariation(1);
        Assert.assertFalse(driver.findElements(By.xpath("//div[@class='lt-hotel-flights']//li")).isEmpty());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
