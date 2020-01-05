package levelTravel.Pack.test.MoreDifficultyTests;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.Pages.CountryPage.Classes.CountryList.TurkeyPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchBlockPage;
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

public class GetResultContentTest {

    private WebDriver driver;
    private StartSearchBlockPage searchBlockPage;
    private CountryFiltersBlockPage filtersBlockPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://level.travel/");
        searchBlockPage = new StartSearchBlockPage(driver);
        filtersBlockPage = new CountryFiltersBlockPage(driver);
    }

    @Test
    public void checkEnableResultOfSearch(){
        searchBlockPage.clickCountryInput()
                .clickGettingPopularCountry(searchBlockPage.getPopularCountry(1))
                .clickCalendarInput()
                .selectCalendarDate(searchBlockPage.getCalendarDateForWholeYear(3, 2, 2))
                .clickCountOfNights()
                .plusNight()
                .clickCountOfPassengers()
                .minusPassenger();
                filtersBlockPage = (TurkeyPage) searchBlockPage.clickSearchButton("Turk");
                filtersBlockPage.selectAnyPriceTower(filtersBlockPage.getAnyPriceTower(2));
       List <WebElement> webElements = driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']//div"));
       Assert.assertTrue(webElements.get(0).isDisplayed() && webElements.size() > 200);
       Assert.assertNotNull(webElements);
    }



    @After
    public void TearDown(){
        driver.quit();
    }
}
