package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.Pages.CountryPage.Classes.CountryList.*;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchBlockPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import levelTravel.Pack.Pages.HelperClass.WaitMethodClass;

import java.util.concurrent.TimeUnit;

public class StartSearchBlockPageTest {

    private WebDriver driver;
    private StartSearchBlockPage startSearchBlockPage;
    private WaitMethodClass waiter;



        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://level.travel/");
            startSearchBlockPage = new StartSearchBlockPage();
            waiter = new WaitMethodClass(driver);
        }


        @Test
        public void correctFindTurkeyToursForFamilyWithoutChildren(){
            startSearchBlockPage.clickCountryInput()
                    .clickGettingPopularCountry(startSearchBlockPage.getPopularCountry(1))
                    .clickCalendarInput()
                    .selectCalendarDate(startSearchBlockPage.getCalendarDateForWholeYear(4, 3, 2));
                    //TurkeyPage turkeyPage = (TurkeyPage) startSearchBlockPage.clickSearchButton("Turk");
                    //waiter.waitWhileElementWillBeClickable(By.xpath("//div[@class='filter-budget__cols']//button"), 10);
                    Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='search-page-title']")).getText().contains("ц"));

        }

        @Test
        public void correctFindEgyptToursForFamilyWithChildren(){
            startSearchBlockPage.clickCountryInput()
                    .clickGettingWholeCountry(startSearchBlockPage.getWholeCountry(14))
                    .clickCalendarInput()
                    .selectCalendarDate(startSearchBlockPage.getCalendarDateForWholeYear(2, 4, 3))
                    .clickCountOfPassengers()
                    .selectVariationAddChild(startSearchBlockPage.getVariableAddChildren(4));
                    EgyptPage egypt = (EgyptPage) startSearchBlockPage.clickSearchButton("Egy");
                    Assert.assertTrue(driver.findElement(By.xpath("//span[@class='included-icons']")).isDisplayed());
        }

        @Test
        public void correctFindTurkeyToursNotDefCountPassengers(){
        startSearchBlockPage.clickCountryInput()
                .clickGettingPopularCountry(startSearchBlockPage.getPopularCountry(2))
                .clickCalendarInput()
                .selectCalendarDate(startSearchBlockPage.getCalendarDateForWholeYear(2, 4, 1))
                .clickCountOfPassengers()
                .plusPassenger()
                .minusPassenger()
                .minusPassenger()
                .selectVariationAddChild(startSearchBlockPage.getVariableAddChildren(4));
        ThaiPage thaiPage = (ThaiPage) startSearchBlockPage.clickSearchButton("Thai");
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='toggle-switch__button']")).isDisplayed());
    }

        @Test
        public void correctFindTurkeyToursOnNotDefaultNights(){
            startSearchBlockPage.clickCountryInput()
                    .clickGettingPopularCountry(startSearchBlockPage.getPopularCountry(4))
                    .clickCalendarInput()
                    .selectCalendarDate(startSearchBlockPage.getCalendarDateForWholeYear(3, 2, 3))
                    .clickCountOfNights()
                    .minusNight()
                    .add2Nights(true);
            VietnamPage vietnamPage = (VietnamPage) startSearchBlockPage.clickSearchButton("Viet");
            Assert.assertFalse(driver.findElements(By.xpath("//ul[@class='checkbox-group__list filter-stars__list']/li")).isEmpty()
                                        && !driver.findElement(By.xpath("//div[text()='Звёздность отеля']")).isDisplayed());
        }

        @Test
        public void correctFindTurkeyToursOnNotDefaultStartPlace(){
            startSearchBlockPage.clickCountryInput()
                    .clickGettingPopularCountry(startSearchBlockPage.getPopularCountry(5))
                    .clickCalendarInput()
                    .selectCalendarDate(startSearchBlockPage.getCalendarDateForWholeYear(4, 2, 2))
                    .clickStartPlaceInput()
                    .clearStartPlaceInput()
                    .clickSelectingStartPlace("Самара");
            RussiaPage russiaPage = (RussiaPage) startSearchBlockPage.clickSearchButton("Rus");
            Assert.assertTrue(driver.findElements(By.xpath("//div[@class='ReactVirtualized__Grid ReactVirtualized__List']//div")).size() > 0);
        }

        @Test
        public void correctFindRussiaToursComplete(){
        startSearchBlockPage.clickCountryInput()
                .clickGettingPopularCountry(startSearchBlockPage.getPopularCountry(5))
                .clickCalendarInput()
                .clickAdd2Days()
                .selectCalendarDate(startSearchBlockPage.getCalendarDateForWholeYear(4, 2, 1))
                .clickCountOfNights()
                .plusNight()
                .minusNight()
                .add2Nights(true)
                .clickCountOfPassengers()
                .selectVariationAddChild(startSearchBlockPage.getVariableAddChildren(9))
                .clickStartPlaceInput()
                .clearStartPlaceInput()
                .clickSelectingStartPlace("Самара");
            RussiaPage russiaPage = (RussiaPage) startSearchBlockPage.clickSearchButton("Rus");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='search_container']")).isEnabled());
    }

        @Test
        public void correctFindToursWithWriteCountry() {
            //Добавить явное ожидание в классовый метод а не здесь.
            //Посмотреть, почему не отрабатывает эмуляция Enter из метода:
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startSearchBlockPage.writeAnyCountryName("Рим");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startSearchBlockPage.clickCalendarInput()
                    .selectCalendarDate(startSearchBlockPage.getCalendarDateForWholeYear(3, 2, 2))
                    .clickCountOfNights()
                    .add2Nights(true)
                    .clickCountOfPassengers()
                    .selectVariationAddChild(startSearchBlockPage.getVariableAddChildren(3));
                    ItalyPage italyPage = (ItalyPage) startSearchBlockPage.clickSearchButton("Ita");
                    Assert.assertEquals("Загружаем туры в Рим, Италия", italyPage.getTextLoadingHeading());
        }

        @Test
        public void tryFindToursWithEmptyCountryField() {
            startSearchBlockPage.clickConfirmButtonWithAnyEmptyFields();
            Assert.assertNotNull(startSearchBlockPage.getErrors());
            Assert.assertFalse(startSearchBlockPage.getErrors().isEmpty());
            Assert.assertTrue(startSearchBlockPage.isErrorVisible("Куда бы вы хотели полететь?"));
        }

        @Test
        public void tryFindToursWithNoCreateCountry() {
            startSearchBlockPage.writeAnyCountryName("SomePlace")
                                .clickConfirmButtonWithAnyEmptyFields();
            Assert.assertNotNull(startSearchBlockPage.getErrors());
            Assert.assertFalse(startSearchBlockPage.getErrors().isEmpty());
            Assert.assertTrue(startSearchBlockPage.isErrorVisible("Куда бы вы хотели полететь?"));
        }



        @After
        public void tearDown(){
            driver.quit();
        }
}

