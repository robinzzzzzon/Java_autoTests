package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CountryPage extends PageObject {

    private By mainHeading = By.xpath("//h1[@class='search-page-title']/span");

    CountryFiltersBlockPage countryFiltersBlockPage = new CountryFiltersBlockPage();
    CountryToursBlockPage countryToursBlockPage = new CountryToursBlockPage(getDriver());
    CountryMapBlockPage countryMapBlockPage = new CountryMapBlockPage(getDriver());

    public String getMainHeadingText() {
        return find(mainHeading).getText();
    }
}
