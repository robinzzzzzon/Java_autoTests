package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public interface Flameable {

    By cityList = By.xpath("//div[@class='htours_cities']/div");
    By toursNameList = By.xpath("//div[@class='htours_packages']//div[@class='packages_item_name']");
    By toursRateList = By.xpath("//div[@class='htours_packages']//div[@class='packages_item_rating']");
    By priceList = By.xpath("//div[@class='htours_packages']//div[@class='packages_item_price']/span[1]");
    By currencyList = By.xpath("//div[@class='htours_packages']//div[@class='packages_item_price']/span[2]");
    By priceForCountOfPeoplesList = By.xpath("//div[@class='packages_item_details_l']//div[1]");
    By dateToursList = By.xpath("//div[@class='packages_item_details_l']//div[2]");
    By countOfNights = By.xpath("//div[@class='packages_item_details_l']//div[3]");
    By wannaTourButtonsList = By.xpath("//div[@class='htours_packages']//div[@class='packages_item_details_r']");
    By showMoreTours = By.xpath("//div[@class='htours_packages_more']");

    //добавить скролл!

    void selectAnyCity(int anyNumber);

    void selectFirstAndLastCity();

    void selectAllCities();

    //////////////////////////////////////

    String getAnyToursName(int anyNumber);

    //////////////////////////////////////

    String getAnyToursRate(int anyNumber);

    //////////////////////////////////////

    String getAnyPrice(int anyNumber);

    //////////////////////////////////////

    String getAnyCurrency(int anyNumber);

    /////////////////////////////////////

    String getAnyPriceForCountOfPeoples(int anyNumber);

    ////////////////////////////////////////

    String getAnyDate(int anyNumber);

    ///////////////////////////////////////

    String getAnyCountOfNights(int anyNumber);

    ///////////////////////////////////////

    void selectAnyTourFromFlameList(int anyNumber);

    //////////////////////////////////////

    void clickShowMoreButton();
}
