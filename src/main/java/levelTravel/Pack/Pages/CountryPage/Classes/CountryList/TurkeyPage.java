package levelTravel.Pack.Pages.CountryPage.Classes.CountryList;


import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryMapBlockPage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryToursBlockPage;
import org.openqa.selenium.WebDriver;
;

public class TurkeyPage extends CountryFiltersBlockPage {

    public TurkeyPage(WebDriver driver) {
        super(driver);
    }

    CountryFiltersBlockPage countryFiltersBlockPage = new CountryFiltersBlockPage(driver);
    CountryMapBlockPage countryMapBlockPage = new CountryMapBlockPage(driver);
    CountryToursBlockPage countryToursBlockPage = new CountryToursBlockPage(driver);

}
