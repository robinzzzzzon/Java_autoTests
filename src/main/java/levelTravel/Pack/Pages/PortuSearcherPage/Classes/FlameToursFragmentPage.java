package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Flameable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class FlameToursFragmentPage extends AbstractBasePage implements Flameable {

    BaseMethods methods = new BaseMethods();

    private List<WebElementFacade> getCityList(){
        return methods.getAnyList(cityList);
    }

    public void selectAnyCity(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getCityList());
    }

    public void selectFirstAndLastCity(){
        methods.selectFirstAndLastElements(getCityList());
    }

    public void selectAllCities(){
        methods.selectAllElements(getCityList());
    }

    //////////////////////////////////////

    private List<WebElementFacade> getToursNameList(){
        return methods.getAnyList(toursNameList);
    }

    public String getAnyToursName(int anyNumber){
        return methods.getTextFromAnyElementOfList(getToursNameList(), anyNumber);
    }

    //////////////////////////////////////

    //Не уверен что будет нужно, но пока оставлю.
    private List<WebElementFacade> getToursRateList(){
        return methods.getAnyList(toursRateList);
    }

    public String getAnyToursRate(int anyNumber){
        return methods.getTextFromAnyElementOfList(getToursRateList(), anyNumber);
    }

    //////////////////////////////////////

    private List<WebElementFacade> getPriceList(){
        return methods.getAnyList(priceList);
    }

    public String getAnyPrice(int anyNumber){
        return methods.getTextFromAnyElementOfList(getPriceList(), anyNumber);
    }

    //////////////////////////////////////

    private List<WebElementFacade> getCurrencyList(){
        return methods.getAnyList(currencyList);
    }

    public String getAnyCurrency(int anyNumber){
        return methods.getTextFromAnyElementOfList(getCurrencyList(), anyNumber);
    }

    /////////////////////////////////////

    private List<WebElementFacade> getPriceForCountOfPeoplesList(){
        return methods.getAnyList(priceForCountOfPeoplesList);
    }

    public String getAnyPriceForCountOfPeoples(int anyNumber){
        return methods.getTextFromAnyElementOfList(getPriceForCountOfPeoplesList(), anyNumber);
    }

    ////////////////////////////////////////

    private List<WebElementFacade> getDateToursList(){
        return methods.getAnyList(dateToursList);
    }

    public String getAnyDate(int anyNumber) {
        return methods.getTextFromAnyElementOfList(getDateToursList(), anyNumber);
    }

    ///////////////////////////////////////

    private List<WebElementFacade> getCountOfNights(){
        return methods.getAnyList(countOfNights);
    }

    public String getAnyCountOfNights(int anyNumber) {
        return methods.getTextFromAnyElementOfList(getCountOfNights(), anyNumber);
    }

    ///////////////////////////////////////

    private List<WebElementFacade> getWannaTourButtonsList(){
        return methods.getAnyList(wannaTourButtonsList);
    }

    public void selectAnyTourFromFlameList(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getWannaTourButtonsList());
    }

    //////////////////////////////////////

    public void clickShowMoreButton(){
        methods.selectAnyElement(showMoreTours);
    }
}
