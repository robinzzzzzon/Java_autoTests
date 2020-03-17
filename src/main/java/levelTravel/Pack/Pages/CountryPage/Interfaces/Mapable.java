package levelTravel.Pack.Pages.CountryPage.Interfaces;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryMapFragmentPage;
import org.openqa.selenium.By;

public interface Mapable {

    By mapMaximizeButton = By.xpath("//div[@class='map-expand-btn']/button");
    By zoomInButton = By.xpath("//div[@class='lt-map-zoom-controls']/button[1]");
    By zoomOutButton = By.xpath("//div[@class='lt-map-zoom-controls']/button[2]");
    By barAndCafeButton = By.xpath("//div[@class='lt-map-layers-controls__buttons']//button[1]");
    By theaterButton = By.xpath("//div[@class='lt-map-layers-controls__buttons']//button[2]");
    By shoppingButton = By.xpath("//div[@class='lt-map-layers-controls__buttons']//button[3]");
    By priceDynamicGraphs = By.xpath("//div[@class='col_month_inside'][1]//a");

    CountryMapFragmentPage clickMaximizeButton();

    CountryMapFragmentPage clickZoomIn();

    CountryMapFragmentPage clickZoomOut();

    CountryMapFragmentPage clickBarAndCafe();

    CountryMapFragmentPage clickTheaterButton();

    CountryMapFragmentPage clickShoppingButton();

    CountryMapFragmentPage selectAnyDynamicGraph(int elementNumber);
}
