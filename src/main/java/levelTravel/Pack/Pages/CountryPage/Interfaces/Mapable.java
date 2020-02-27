package levelTravel.Pack.Pages.CountryPage.Interfaces;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryMapBlockPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Mapable {

    By mapMaximizeButton = By.xpath("//div[@class='map-expand-btn']/button");
    By zoomInButton = By.xpath("//div[@class='lt-map-zoom-controls']/button[1]");
    By zoomOutButton = By.xpath("//div[@class='lt-map-zoom-controls']/button[2]");
    By barAndCafeButton = By.xpath("//div[@class='lt-map-layers-controls__buttons']//button[1]");
    By theaterButton = By.xpath("//div[@class='lt-map-layers-controls__buttons']//button[2]");
    By shoppingButton = By.xpath("//div[@class='lt-map-layers-controls__buttons']//button[3]");
    By priceDynamicGraphs = By.xpath("//div[@class='col_month_inside'][1]//a");

    public CountryMapBlockPage clickMaximizeButton();

    public CountryMapBlockPage clickZoomIn();

    public CountryMapBlockPage clickZoomOut();

    public CountryMapBlockPage clickBarAndCafe();

    public CountryMapBlockPage clickTheaterButton();

    public CountryMapBlockPage clickShoppingButton();

    public CountryMapBlockPage selectAnyDynamicGraph(int elementNumber);
}
