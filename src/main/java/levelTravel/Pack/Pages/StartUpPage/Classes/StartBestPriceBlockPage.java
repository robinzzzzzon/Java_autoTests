package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClass.CountryFactory;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.BestPricable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

@DefaultUrl("https://level.travel/")
public class StartBestPriceBlockPage extends AbstractBasePage implements BestPricable {

    public void clickCityStartDD() {
        find(cityStartDD).click();
    }

    private List<WebElementFacade> getStartCityList() {
        return findAll(cityStartList);
    }

    public void selectAnyStartCity(int number) {
        selectAnyFromAnyList(getStartCityList(), number);
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
        return findAll(countPfNightsList);
    }

    public void selectAnyCountOfNights(int number) {
        selectAnyFromAnyList(getCountOfNightsList(), number);
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getCountryGraphList() {
        return findAll(countryGraphList);
    }

    public void selectAnyCountry(int number) {
        if (number > 5) {
            find(invisibleCountryDD).click();
            List<WebElementFacade> webElements = getCountryGraphList();
            scrolling(300);
            webElements.get(number - 1).waitUntilEnabled().click();
        } else{
            List<WebElementFacade> webElements = getCountryGraphList();
            scrolling(300);
            webElements.get(number - 1).click();
        }
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getPriceGraphList() {
        return findAll(priceColumnList);
    }

    public AbstractBasePage selectAnyPriceOfGraph(int number, String countryName) {
        selectAnyFromAnyList(getPriceGraphList(), number);
        return new CountryFactory().createCountry(countryName);
    }

    ////////////////////////////////////////////////////////////////////////////////

    private void selectAnyFromAnyList(List<WebElementFacade> list, int number){
        WebElement element = list.get(number - 1);
        element.click();
    }

    private void scrolling(int number) {
        JavascriptExecutor JSE = (JavascriptExecutor) getDriver();
        String s = "window.scrollBy(0, %s)";
        JSE.executeScript(String.format(s, number), "");
        waiter();
    }

    private void waiter() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
