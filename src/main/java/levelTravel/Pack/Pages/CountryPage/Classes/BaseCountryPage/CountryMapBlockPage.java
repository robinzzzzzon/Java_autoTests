package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Mapable;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountryMapBlockPage extends AbstractBasePage implements Mapable {

    public CountryMapBlockPage(WebDriver driver) {
        super(driver);
    }


    public CountryMapBlockPage clickMaximizeButton(){
        driver.findElement(mapMaximizeButton).click();
        return this;
    }

    public CountryMapBlockPage clickZoomIn(){
        driver.findElement(zoomInButton).click();
        return this;
    }
    public CountryMapBlockPage clickZoomOut(){
        driver.findElement(zoomOutButton).click();
        return this;
    }

    public CountryMapBlockPage clickBarAndCafe(){
        driver.findElement(barAndCafeButton).click();
        return this;
    }

    public CountryMapBlockPage clickTheaterButton(){
        driver.findElement(theaterButton).click();
        return this;
    }

    public CountryMapBlockPage clickShoppingButton(){
        driver.findElement(shoppingButton).click();
        return this;
    }

    public WebElement getAnyDynamicGraph(int number){
        List<WebElement> webElements = driver.findElements(priceDynamicGraphs);
        return webElements.get(number - 1);
    }

    public CountryMapBlockPage selectAnyDynamicGraph(@NotNull WebElement element){
        element.click();
        return new CountryMapBlockPage(driver);
    }
}
