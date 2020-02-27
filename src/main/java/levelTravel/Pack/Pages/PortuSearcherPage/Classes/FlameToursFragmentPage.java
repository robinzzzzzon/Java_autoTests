package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Flameable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class FlameToursFragmentPage extends AbstractBasePage implements Flameable {

    private List<WebElementFacade> getCityList(){
        return findAll(cityList);
    }

    public void selectAnyCity(int anyNumber){
        selectAnyElementFromAnyList(getCityList(), anyNumber);
    }

    public void selectFirstAndLastCity(){
        selectFirstAndLastElementsFromAnyLists(getCityList());
    }

    public void selectAllCities(){
        selectAllElementsFromAnyList(getCityList());
    }

    //////////////////////////////////////

    private List<WebElementFacade> getToursNameList(){
        return findAll(toursNameList);
    }

    public String getAnyToursName(int anyNumber){
        return getAnyTextFromAnyElement(getToursNameList(), anyNumber);
    }

    //////////////////////////////////////

    //Не уверен что будет нужно, но пока оставлю.
    private List<WebElementFacade> getToursRateList(){
        return findAll(toursRateList);
    }

    public String getAnyToursRate(int anyNumber){
        return getAnyTextFromAnyElement(getToursRateList(), anyNumber);
    }

    //////////////////////////////////////

    private List<WebElementFacade> getPriceList(){
        return findAll(priceList);
    }

    public String getAnyPrice(int anyNumber){
        return getAnyTextFromAnyElement(getPriceList(), anyNumber);
    }

    //////////////////////////////////////

    private List<WebElementFacade> getCurrencyList(){
        return findAll(currencyList);
    }

    public String getAnyCurrency(int anyNumber){
        return getAnyTextFromAnyElement(getCurrencyList(), anyNumber);
    }

    /////////////////////////////////////

    private List<WebElementFacade> getPriceForCountOfPeoplesList(){
        return findAll(priceForCountOfPeoplesList);
    }

    public String getAnyPriceForCountOfPeoples(int anyNumber){
        return getAnyTextFromAnyElement(getPriceForCountOfPeoplesList(), anyNumber);
    }

    ////////////////////////////////////////

    private List<WebElementFacade> getDateToursList(){
        return findAll(dateToursList);
    }

    public String getAnyDate(int anyNumber) {
        return getAnyTextFromAnyElement(getDateToursList(), anyNumber);
    }

    ///////////////////////////////////////

    private List<WebElementFacade> getCountOfNights(){
        return findAll(countOfNights);
    }

    public String getAnyCountOfNights(int anyNumber) {
        return getAnyTextFromAnyElement(getCountOfNights(), anyNumber);
    }

    ///////////////////////////////////////

    private List<WebElementFacade> getWannaTourButtonsList(){
        return findAll(wannaTourButtonsList);
    }

    public void selectAnyTourFromFlameList(int anyNumber){
        selectAnyElementFromAnyList(getWannaTourButtonsList(), anyNumber);
    }

    //////////////////////////////////////

    public void clickShowMoreButton(){
        find(showMoreTours).waitUntilClickable().click();
    }

    //////////////////////////////////////

    private void selectAnyElementFromAnyList(List<WebElementFacade> list, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        element.click();
    }

    private void selectFirstAndLastElementsFromAnyLists(List<WebElementFacade> list){
        LinkedList<WebElementFacade> linkedList = new LinkedList<>(list);
        linkedList.getFirst().click();
        linkedList.getLast().click();
    }

    private void selectAllElementsFromAnyList (List<WebElementFacade> list){
        for (WebElementFacade elementFacade: list) {
            elementFacade.click();
        }
    }

    private String getAnyTextFromAnyElement(List<WebElementFacade> list, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        return element.getText();
    }
}
