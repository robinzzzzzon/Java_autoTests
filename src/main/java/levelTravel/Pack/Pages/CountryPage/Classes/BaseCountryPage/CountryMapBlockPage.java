package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Mapable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-20.01.2020-for-5..9-nights-2-adults-0-kids-1..5-stars")
public class CountryMapBlockPage extends AbstractBasePage implements Mapable {

    public CountryMapBlockPage clickMaximizeButton() {
        find(mapMaximizeButton).click();
        return this;
    }

    public CountryMapBlockPage clickZoomIn() {
        find(zoomInButton).click();
        return this;
    }

    public CountryMapBlockPage clickZoomOut() {
        find(zoomOutButton).click();
        return this;
    }

    public CountryMapBlockPage clickBarAndCafe() {
        find(barAndCafeButton).click();
        return this;
    }

    public CountryMapBlockPage clickTheaterButton() {
        find(theaterButton).click();
        return this;
    }

    public CountryMapBlockPage clickShoppingButton() {
        find(shoppingButton).click();
        return this;
    }

    public WebElement getAnyDynamicGraph(int number) {
        List<WebElementFacade> webElements = findAll(priceDynamicGraphs);
        return webElements.get(number - 1);
    }

    public CountryMapBlockPage selectAnyDynamicGraph(@NotNull WebElement element) {
        element.click();
        return new CountryMapBlockPage();
    }
}
