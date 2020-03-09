package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.HelperClasses.CountryFactory;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.BestPricable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.Iterator;
import java.util.List;

@DefaultUrl("https://level.travel/")
public class StartBestPriceFragmentPage extends AbstractBasePage implements BestPricable {

    BaseMethods methods = new BaseMethods();

    public void clickCityStartDD() {
        methods.selectAnyElement(cityStartDD);
    }

    private List<WebElementFacade> getStartCityList() {
        return methods.getAnyList(cityStartList);
    }

    public void selectAnyStartCity(int number) {
        methods.selectAnyElementFromList(number, getStartCityList());
    }

    public void selectLastStartCity() {
        //Вариант попроще: создаем LinkedList и в него результат выполнения нашего getStartCityList, где уже достаточно просто через getLast() кликнуть на элемент.
//        LinkedList<WebElementFacade> list = new LinkedList<>(getStartCityList());
//        list.getLast().click();
//        return new StartBestPriceBlockPage();
        //Вариант поправильнее:
        //Здесь мы создаем итератор для нашего листа и дальше уже проходимся по нашему списку выполняя каждый раз проверку на hasNext
        List<WebElementFacade> list = getStartCityList();
        Iterator<WebElementFacade> iterator = list.iterator();
        for (WebElementFacade element : list) {
            iterator.next();
            if (!iterator.hasNext()) {
                element.click();
            }
        }
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getCountOfNightsList() {
        return methods.getAnyList(countPfNightsList);
    }

    public void selectAnyCountOfNights(int number) {
        methods.selectAnyElementFromList(number, getCountOfNightsList());

    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getCountryGraphList() {
        return methods.getAnyList(countryGraphList);
    }

    public void selectAnyCountry(int number) {
        if (number > 5) {
            find(invisibleCountryDD).click();
            List<WebElementFacade> webElements = getCountryGraphList();
            methods.scrolling(300);
            webElements.get(number - 1).waitUntilEnabled().click();
        } else{
            List<WebElementFacade> webElements = getCountryGraphList();
            methods.scrolling(300);
            webElements.get(number - 1).click();
        }
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getPriceGraphList() {
        return methods.getAnyList(priceColumnList);
    }

    public AbstractBasePage selectAnyPriceOfGraph(int number, String countryName) {
        methods.selectAnyElementFromList(number, getPriceGraphList());
        return new CountryFactory().createCountry(countryName);
    }

}
