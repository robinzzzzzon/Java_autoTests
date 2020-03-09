package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;

public class CountryWholePage extends AbstractBasePage {

    private By mainHeading = By.xpath("//h1[@class='search-page-title']/span");

    CountryFiltersFragmentPage countryFiltersFragmentPage = new CountryFiltersFragmentPage();
    CountryToursFragmentPage countryToursFragmentPage = new CountryToursFragmentPage();
    CountryMapFragmentPage countryMapFragmentPage = new CountryMapFragmentPage();

    public String getMainHeadingText() {
        return find(mainHeading).getText();
    }
}
