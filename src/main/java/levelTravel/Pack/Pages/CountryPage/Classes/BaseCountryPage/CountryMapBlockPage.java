package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Mapable;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-15.04.2020-for-7-nights-2-adults-0-kids-1..5-stars")
public class CountryMapBlockPage extends AbstractBasePage implements Mapable {

    BaseMethods methods = new BaseMethods();

    public CountryMapBlockPage clickMaximizeButton() {
        methods.selectAnyElement(mapMaximizeButton);
        return this;
    }

    public CountryMapBlockPage clickZoomIn() {
        methods.selectAnyElement(zoomInButton);
        return this;
    }

    public CountryMapBlockPage clickZoomOut() {
        methods.selectAnyElement(zoomOutButton);
        return this;
    }

    public CountryMapBlockPage clickBarAndCafe() {
        methods.selectAnyElement(barAndCafeButton);
        return this;
    }

    public CountryMapBlockPage clickTheaterButton() {
        methods.selectAnyElement(theaterButton);
        return this;
    }

    public CountryMapBlockPage clickShoppingButton() {
        methods.selectAnyElement(shoppingButton);
        return this;
    }

    private List<WebElementFacade> getPriceDynamicGraphs() {
        return methods.getAnyList(priceDynamicGraphs);
    }

    public CountryMapBlockPage selectAnyDynamicGraph(int elementNumber) {
        methods.selectAnyElementFromList(elementNumber, getPriceDynamicGraphs());
        return new CountryMapBlockPage();
    }
}
