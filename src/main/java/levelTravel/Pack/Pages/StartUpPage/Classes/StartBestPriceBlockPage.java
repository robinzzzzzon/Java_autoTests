package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.Pages.CountryPage.Classes.CountryList.TurkeyPage;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.BestPricable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://level.travel/")
public class StartBestPriceBlockPage extends PageObject implements BestPricable {

    public StartBestPriceBlockPage clickCityStartDD(){
        find(cityStartDD).click();
        return this;
    }

     private List<WebElementFacade> getStartCityList(){
        return findAll(cityStartList);
    }

    public StartBestPriceBlockPage selectAnyStartCity(int number){
        List <WebElementFacade> webElements = getStartCityList();
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage();
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getCountOfNightsList(){
        return findAll(countPfNightsList);
    }

    public StartBestPriceBlockPage selectAnyCountOfNights(int number){
        List <WebElementFacade> webElements = getCountOfNightsList();
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage();
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getCountryGraphList(){
        return findAll(countryGraphList);
    }

    public StartBestPriceBlockPage selectAnyCountry(int number){
        if (number > 5) {
            find(invisibleCountryDD).click();
            List <WebElementFacade> webElements = getCountryGraphList();
            webElements.get(number - 1).click();
        }
        List <WebElementFacade> webElements = getCountryGraphList();
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage();
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getPriceGraphList(){
        return findAll(priceColumnList);
    }

    public CountryFiltersBlockPage selectAnyPriceOfGraph(int number, String countryName){
        List<WebElementFacade> webElements = getPriceGraphList();
        webElements.get(number - 1).click();
        //return new CountryFactory(getDriver()).createCountry(countryName);
        return new CountryFiltersBlockPage();
    }

}
