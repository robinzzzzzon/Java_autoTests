package levelTravel.Pack.CountryPage.Classes.CountryList;

import levelTravel.Pack.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.CountryPage.Classes.BaseCountryPage.CountryMapBlockPage;
import levelTravel.Pack.CountryPage.Classes.BaseCountryPage.CountryToursBlockPage;
import org.openqa.selenium.WebDriver;

public class RussiaPage extends CountryFiltersBlockPage {

    public RussiaPage(WebDriver driver) {
        super(driver);
    }

    CountryFiltersBlockPage countryFiltersBlockPage = new CountryFiltersBlockPage(driver);
    CountryMapBlockPage countryMapBlockPage = new CountryMapBlockPage(driver);
    CountryToursBlockPage countryToursBlockPage = new CountryToursBlockPage(driver);

}
