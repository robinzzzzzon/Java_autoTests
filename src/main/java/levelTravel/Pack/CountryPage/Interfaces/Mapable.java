package levelTravel.Pack.CountryPage.Interfaces;

import levelTravel.Pack.CountryPage.Classes.BaseCountryPage.CountryMapBlockPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface Mapable {

    By mapMaximizeButton = By.xpath("//div[@class='map-expand-btn']/button");
    By zoomInButton = By.xpath("//div[@class='map-zoom-control']/button[1]");
    By zoomOutButton = By.xpath("//div[@class='map-zoom-control']/button[2]");
    By barAndCafeButton = By.xpath("//button[@class='layer-control-btn'][1]");
    By theaterButton = By.xpath("//button[@class='layer-control-btn'][2]");
    By shoppingButton = By.xpath("//button[@class='layer-control-btn'][3]");
    By priceDynamicGraphs = By.xpath("//div[@class='col_month_inside'][1]//a");

    public CountryMapBlockPage clickMaximizeButton();

    public CountryMapBlockPage clickZoomIn();

    public CountryMapBlockPage clickZoomOut();

    public CountryMapBlockPage clickBarAndCafe();

    public CountryMapBlockPage clickTheaterButton();

    public CountryMapBlockPage clickShoppingButton();

    public WebElement getAnyDynamicGraph(int number);

    public CountryMapBlockPage selectAnyDynamicGraph(WebElement element);
}
