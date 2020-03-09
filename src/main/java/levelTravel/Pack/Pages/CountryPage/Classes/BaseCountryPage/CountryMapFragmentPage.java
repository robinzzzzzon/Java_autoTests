package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Mapable;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-15.04.2020-for-7-nights-2-adults-0-kids-1..5-stars")
public class CountryMapFragmentPage extends AbstractBasePage implements Mapable {

    BaseMethods methods = new BaseMethods();

    public CountryMapFragmentPage clickMaximizeButton() {
        methods.selectAnyElement(mapMaximizeButton);
        return this;
    }

    public CountryMapFragmentPage clickZoomIn() {
        methods.selectAnyElement(zoomInButton);
        return this;
    }

    public CountryMapFragmentPage clickZoomOut() {
        methods.selectAnyElement(zoomOutButton);
        return this;
    }

    public CountryMapFragmentPage clickBarAndCafe() {
        methods.selectAnyElement(barAndCafeButton);
        return this;
    }

    public CountryMapFragmentPage clickTheaterButton() {
        methods.selectAnyElement(theaterButton);
        return this;
    }

    public CountryMapFragmentPage clickShoppingButton() {
        methods.selectAnyElement(shoppingButton);
        return this;
    }

    private List<WebElementFacade> getPriceDynamicGraphs() {
        return methods.getAnyList(priceDynamicGraphs);
    }

    public CountryMapFragmentPage selectAnyDynamicGraph(int elementNumber) {
        methods.selectAnyElementFromList(elementNumber, getPriceDynamicGraphs());
        return new CountryMapFragmentPage();
    }
}
