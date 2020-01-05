package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryToursBlockPage;
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

public class CountryToursBlockPageTest {

    private WebDriver driver;
    private CountryToursBlockPage countryToursBlockPage;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://level.travel/search/Moscow-RU-to-Any-TR-departure-23.01.2020-for-5..9-nights-2-adults-0-kids-1..5-stars");
        countryToursBlockPage = new CountryToursBlockPage(driver);
    }

    @Test
    public void clickAnyFilters(){
        countryToursBlockPage.clickRecommendFilter();
        WebElement element = driver.findElement(By.xpath("//button[text()='по рекомендации']"));
        String s = element.getAttribute("class");
        String ss = "sorting__link sorting__link--active";
        Assert.assertEquals(s, ss);
    }

    @Test
    public void clickWishListVariation(){
        //countryToursBlockPage.clickFirstWishListButton();
        countryToursBlockPage.clickAnyWishListButton(3);
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[3]//a"));
        Assert.assertTrue(webElements.size() == 4);
    }

    @Test
    public void selectAnyExploreHotel(){
        //countryToursBlockPage.clickFirstExploreHotel();
        countryToursBlockPage.clickAnyExploreHotel(3);
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Посмотреть цены']")).isDisplayed());
    }

    @Test
    public void selectAnyPriceLinkHotel(){
        //countryToursBlockPage.clickFirstHotelPriceLink();
        countryToursBlockPage.clickAnyHotelPriceLink(2);
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Посмотреть цены']")).isDisplayed());
    }

    @Test
    public void selectAnyNameLinkHotel(){
        //countryToursBlockPage.clickFirstNameHotelLink();
        //countryToursBlockPage.clickAnyNameHotelLink(2);
        countryToursBlockPage.getAnyNameHotelText(3);
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Посмотреть цены']")).isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
