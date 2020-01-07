package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Mapable;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountryMapBlockPage extends AbstractBasePage implements Mapable {

    public CountryMapBlockPage clickMaximizeButton(){
        find(mapMaximizeButton).click();
        return this;
    }

    public CountryMapBlockPage clickZoomIn(){
        find(zoomInButton).click();
        return this;
    }
    public CountryMapBlockPage clickZoomOut(){
        find(zoomOutButton).click();
        return this;
    }

    public CountryMapBlockPage clickBarAndCafe(){
        find(barAndCafeButton).click();
        return this;
    }

    public CountryMapBlockPage clickTheaterButton(){
        find(theaterButton).click();
        return this;
    }

    public CountryMapBlockPage clickShoppingButton(){
        find(shoppingButton).click();
        return this;
    }

    public WebElement getAnyDynamicGraph(int number){
        List<WebElementFacade> webElements = findAll(priceDynamicGraphs);
        return webElements.get(number - 1);
    }

    public CountryMapBlockPage selectAnyDynamicGraph(@NotNull WebElement element){
        element.click();
        return new CountryMapBlockPage();
    }
}
