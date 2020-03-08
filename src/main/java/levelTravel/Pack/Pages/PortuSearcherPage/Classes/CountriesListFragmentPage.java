package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Countryable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class CountriesListFragmentPage extends AbstractBasePage implements Countryable {

    BaseMethods methods = new BaseMethods();

    private List<WebElementFacade> getCountryLinksList(){
        return methods.getAnyList(countryLinksList);
    }

    public void selectAnyCountry(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getCountryLinksList());
    }
}
