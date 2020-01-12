package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.Pages.HelperClass.WaitMethodClass;
import net.serenitybdd.core.pages.WebElementFacade;
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

public class CountryFilterBLockPageTest {

    private WebDriver driver;
    private CountryFiltersBlockPage countryFiltersBlockPage;
    private WaitMethodClass waiter;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://level.travel/search/Moscow-RU-to-Any-TR-departure-23.01.2020-for-5..9-nights-2-adults-0-kids-1..5-stars");
        countryFiltersBlockPage = new CountryFiltersBlockPage();
        waiter = new WaitMethodClass(driver);
    }

    @Test
    public void selectMomentConfirmationTours(){
        countryFiltersBlockPage.switchMomentConfirmTumbler(true)
                //.selectAnyPriceTower(abstractCountryFiltersPage.getAnyPriceTower(3))
                .writeMinIntervalPrice("30000")
                .writeMaxIntervalPrice("60000");
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).size() > 0);

    }

    @Test
    public void selectStarsOfHotel() {
        //countryFiltersPage.clickAnyStars(abstractCountryFiltersPage.getInputOfStarsHotel(3));
        countryFiltersBlockPage.selectAnyStarsHotel(3, 3);
        countryFiltersBlockPage.selectAnyStarsHotel(3, 3);
        Assert.assertFalse(driver.findElements(By.xpath("//ul[@class='checkbox-group__list filter-stars__list']/li")).get(3).isSelected());
    }

    @Test
    public void writeHotelNameTest() {
        countryFiltersBlockPage.writeHotelName("Green Nature Diamond Hotel");
        //waiter.waitWhileElementWillBePresent(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div"), 4);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).size() == 1);
    }

    @Test
    public void getAnyRatingTest(){
        countryFiltersBlockPage.selectRatingHotel(1)
                .selectDistanceToSea(1);
        Assert.assertFalse(driver.findElements(By.xpath("//ul[@class='switcher__list filter-rating__switcher-list']/li")).get(3).isSelected()
                                                            && driver.findElements(By.xpath("//ul[@class='switcher__list distance__switcher-list']/li")).get(2).isSelected());
    }

    @Test
    public void privateBeachTest(){
        countryFiltersBlockPage.selectPrivateBeachInput(false);
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='checkbox-group__item-container filter-beach__item-container']/input")).isSelected());
    }

    @Test
    public void typeBeachTest(){
        //countryFiltersBlockPage.selectAllTypeOfBeach(countryFiltersBlockPage.getTypesOfBeachList());
        Assert.assertNotNull(driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")));
    }

    @Test
    public void typeOfFoodTest(){
        //countryFiltersBlockPage.selectTypeFood(2);
        countryFiltersBlockPage.selectTypeFood(6);
//        countryFiltersPage.showAllTypesFood();
        Assert.assertTrue(driver.findElements(By.xpath("//ul[@class='checkbox-group__list filter-pansion__list']//label")).get(6).isDisplayed());
    }


    @Test
    public void RegionTests(){
        //countryFiltersBlockPage.showAllRegions();
        countryFiltersBlockPage.selectAnyRegion(6);
        //countryFiltersBlockPage.selectAllRegions();
        Assert.assertTrue(driver.findElements(By.xpath("//ul[@class='checkbox-group__list filter-region__list']//li//input")).get(6).isEnabled());
        }

    @Test
    public void TypeHotelTests(){
        countryFiltersBlockPage.selectHotelType(3);
        Assert.assertEquals("Активный", driver.findElements(By.xpath("//ul[@class='checkbox-group__list filter-category__list']//label")).get(2).getText());
    }

    @Test
    public void WiFiTests(){
        //countryFiltersPage.getWiFiRb();
        //countryFiltersPage.getWiFiLabel();
        //List<WebElementFacade> elements = countryFiltersBlockPage.getWiFiRb();
        //countryFiltersBlockPage.selectWiFiInput(elements, 2);
        Assert.assertFalse(driver.findElements(By.xpath("//ul[@class='radio-group']//div")).get(1).isSelected());

    }

    @Test
    public void WaterGameTest(){
        countryFiltersBlockPage.selectWaterGame(2);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).size() > 0);
    }

    @Test
    public void HoTelFacilitiesTest(){
        countryFiltersBlockPage.selectHotelFacility(3);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).size() > 0);
    }

    @Test
    public void FamilyWithChild(){
        countryFiltersBlockPage.selectFamilyWithChildren(2);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).size() > 0);
    }

    @Test
    public void TourOperatorsTest(){
        countryFiltersBlockPage.selectAllTourOperators();
        Assert.assertTrue(driver.findElements(By.xpath("//ul[@class='checkbox-group__list filter-operator__list']//li")).get(4).isDisplayed());
        //countryFiltersPage.selectAnyTourOperator(6);
    }

    @Test
    public void clearFilterTest(){
        //countryFiltersPage.clickAllClearFilter();
//        countryFiltersPage.selectTypeFood(6);
//        countryFiltersPage.clickLocalClearFilter();
        countryFiltersBlockPage.selectRatingHotel(3)
                .selectDistanceToSea(2);
        countryFiltersBlockPage.clickFewLocalClearFilter();
        Assert.assertFalse(driver.findElements(By.xpath("//div[@class='filter-rating']//li")).get(2).isSelected());
    }



    @After
    public void tearDown(){
        driver.quit();
    }

}
