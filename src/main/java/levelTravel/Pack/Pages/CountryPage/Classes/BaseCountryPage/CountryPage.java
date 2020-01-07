package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;

public class CountryPage extends AbstractBasePage {

    private By mainHeading = By.xpath("//h1[@class='search-page-title']/span");

    CountryFiltersBlockPage countryFiltersBlockPage = new CountryFiltersBlockPage();
    CountryToursBlockPage countryToursBlockPage = new CountryToursBlockPage();
    CountryMapBlockPage countryMapBlockPage = new CountryMapBlockPage();

    public String getMainHeadingText() {
        return find(mainHeading).getText();
    }
}
