package levelTravel.Pack.Pages.StartUpPage.Interfaces;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchBlockPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public interface Searchable {

    By searchCountryInput = By.xpath("//input[@data-reactid='.0.0.0.0.0.0']");
    By popularCountriesList = By.xpath("//ul[@data-reactid='.0.0.0.0.0.1.0.0.0']//li");
    By wholeCountriesList = By.xpath("//ul[@data-reactid='.0.0.0.0.0.1.0.0.1']//li");
    //////////////////////
    By calendarInput = By.xpath("//span[@data-reactid='.0.0.0.0.1.0.0']");
    By switchToNextMonth = By.xpath("//div[@class='calendar-next-month']");
    String calendarTBody = "//tbody[@data-reactid='.0.0.0.0.1.2.0.1:$%s-2020.1.1']";
    By add2days = By.xpath("//span[@data-reactid='.0.0.0.0.1.2.0.2.1.0.1']");
    ///////////////////////
    By dayIntervalDD = By.xpath("//span[text()='7 ночей']");
    By minusDay = By.xpath("//div[@data-reactid='.0.0.0.0.2.2']//i");
    By plusDay = By.xpath("//div[@data-reactid='.0.0.0.0.2.2.0.2']/i");
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
    public StartSearchBlockPage writeAnyCountryName(String anyPlace);

    public StartSearchBlockPage clickCountryInput();

    public WebElement getPopularCountry(int elementNumber);

    public StartSearchBlockPage clickGettingPopularCountry(WebElement webElement);

    public WebElement getWholeCountry(int elementNumber);

    public StartSearchBlockPage clickGettingWholeCountry(WebElement webElement);

    /////////////////////////////
    public List<WebElementFacade> getErrors();

    public String getErrorByText (int number);

    public boolean isErrorVisible(String message);

    /////////////////////////////
    public StartSearchBlockPage clickCalendarInput();

    public WebElement getCalendarDateForWholeYear(int row, int column, int countSwitch);

    public StartSearchBlockPage clickAdd2Days();

    public StartSearchBlockPage selectCalendarDate(WebElement webElement);

    ////////////////////////////////////////////////////////////////////////////////
    public StartSearchBlockPage clickCountOfNights();

    public StartSearchBlockPage minusNight();

    public StartSearchBlockPage plusNight();

    public StartSearchBlockPage add2Nights(boolean b);

    /////////////////////////////
    public StartSearchBlockPage clickCountOfPassengers();

    void addChildren();

    public WebElement getVariableAddChildren(int variationChild);

    public StartSearchBlockPage selectVariationAddChild(WebElement webElement);

    public StartSearchBlockPage minusPassenger();

    public StartSearchBlockPage plusPassenger();

    public StartSearchBlockPage clickStartPlaceInput();

    public StartSearchBlockPage clearStartPlaceInput();

    public StartSearchBlockPage writeStartPlaceInput(String anyString);

    public StartSearchBlockPage clickSelectingStartPlace(String startPlace);

    //////////////////////////////////////
    public CountryPage clickSearchButton(String countryName);

    public void clickConfirmButtonWithAnyEmptyFields();
}
