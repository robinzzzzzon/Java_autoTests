package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.Pages.CountryPage.Classes.CountryList.TurkeyPage;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.BestPricable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@DefaultUrl("https://level.travel/")
public class StartBestPriceBlockPage extends AbstractBasePage implements BestPricable {

    public StartBestPriceBlockPage clickCityStartDD() {
        find(cityStartDD).click();
        return this;
    }

    private List<WebElementFacade> getStartCityList() {
        return findAll(cityStartList);
    }

    public StartBestPriceBlockPage selectAnyStartCity(int number) {
        List<WebElementFacade> webElements = getStartCityList();
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage();
    }

    public StartBestPriceBlockPage selectLastStartCity() {
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
        return new StartBestPriceBlockPage();
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getCountOfNightsList() {
        return findAll(countPfNightsList);
    }

    public StartBestPriceBlockPage selectAnyCountOfNights(int number) {
        List<WebElementFacade> webElements = getCountOfNightsList();
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage();
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getCountryGraphList() {
        return findAll(countryGraphList);
    }

    public StartBestPriceBlockPage selectAnyCountry(int number) {
        if (number > 5) {
            find(invisibleCountryDD).click();
            List<WebElementFacade> webElements = getCountryGraphList();
            scrolling(200, 1000);
            webElements.get(number - 1).waitUntilEnabled().click();
        }
        List<WebElementFacade> webElements = getCountryGraphList();
        scrolling(200, 1000);
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage();
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getPriceGraphList() {
        return findAll(priceColumnList);
    }

    public CountryFiltersBlockPage selectAnyPriceOfGraph(int number, String countryName) {
        List<WebElementFacade> webElements = getPriceGraphList();
        webElements.get(number - 1).click();
        //return new CountryFactory(getDriver()).createCountry(countryName);
        return new CountryFiltersBlockPage();
    }

    private void scrolling(int number, int waitMs) {
        JavascriptExecutor JSE = (JavascriptExecutor) getDriver();
        String s = "window.scrollBy(0, %s)";
        JSE.executeScript(String.format(s, number), "");
        waiter(waitMs);
    }

    private void waiter(int waitMs) {
        try {
            Thread.sleep(waitMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
