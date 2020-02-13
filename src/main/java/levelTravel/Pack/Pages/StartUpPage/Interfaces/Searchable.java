package levelTravel.Pack.Pages.StartUpPage.Interfaces;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchBlockPage;
import org.openqa.selenium.By;


public interface Searchable {

    By searchCountryInput = By.xpath("//input[@data-reactid='.0.0.0.0.0.0']");
    By popularCountriesList = By.xpath("//ul[@data-reactid='.0.0.0.0.0.1.0.0.0']//li");
    By wholeCountriesList = By.xpath("//ul[@data-reactid='.0.0.0.0.0.1.0.0.1']//li");
    ///////////////////////
    By calendarInput = By.xpath("//span[@data-reactid='.0.0.0.0.1.0.0']");
    By switchToNextMonth = By.xpath("//div[@class='calendar-next-month']");
    String calendarTBody = "//tbody[@data-reactid='.0.0.0.0.1.2.0.1:$%s-2020.1.1']";
    By add2days = By.xpath("//span[@data-reactid='.0.0.0.0.1.2.0.2.1.0.1']");
    /////////////////////
    By dayIntervalDD = By.xpath("//span[text()='7 ночей']");
    By minusDay = By.xpath("//div[@data-reactid='.0.0.0.0.2.2.0.0']");
    By plusDay = By.xpath("//div[@data-reactid='.0.0.0.0.2.2.0.2']");
    By plusOrMinus2Days = By.xpath("//span[@data-reactid='.0.0.0.0.2.2.2.0.1']");
    ////////////////////////
    By countOfPassengersDD = By.xpath("//div[text()='2 взрослых']");
    By minusPassenger = By.xpath("//div[@data-reactid='.0.0.0.0.3.2.0.0']");
    By plusPassenger = By.xpath("//div[@data-reactid='.0.0.0.0.3.2.0.2']");
    By addChildrenDD = By.xpath("//select[@data-reactid='.0.0.0.0.3.2.1.1.0']");
    By childVaryingList = By.xpath("//select[@data-reactid='.0.0.0.0.3.2.1.1.0']//option");
    /////////////////////////
    By startPlaceInput = By.xpath("//input[@data-reactid='.0.0.0.0.4.1']");
    String startPlaceList = "//div[@class='search-form-departure-select search-form-floating']//li[text()='%s']";
    By searchButton = By.xpath("//button[@data-reactid='.0.0.0.1.0']");

    /////////////////////////
    By errorListByClass = By.xpath("//div[@class='input-error']");
    String errorListByText = "//div[text()='%s']";


    /////////////////////////////
    void writeAnyCountryName(String anyPlace);

    void clickCountryInput();

    void clickGettingPopularCountry(int number);

    void clickGettingWholeCountry(int number);

    /////////////////////////////

    boolean isErrorVisible(String message);

    /////////////////////////////

    void clickCalendarInput();

    void clickAdd2Days();

    void selectCalendarDate(int row, int column, int countSwitch);

    /////////////////////////////////////////////////////////////////////////
    void clickCountOfNights();

    void minusNight();

    void plusNight();

    void addMaxCountNights(boolean b);

    void addMinCountNights(boolean b);

    void add2Nights(boolean b);

    //////////////////////
    void clickCountOfPassengers();

    void selectVariationAddChild(int childNumber);

    void minusPassenger();

    void plusPassenger();

    void addMaxPassenger(boolean b);

    void clickStartPlaceInput();

    void clearStartPlaceInput();

    void writeStartPlaceInput(String anyString);

    void clickSelectingStartPlace(String startPlace);

    //////////////////////////////////////
    CountryPage clickSearchButton(String countryName);

    void clickConfirmButtonWithAnyEmptyFields();
}
