package levelTravel.Pack.Pages.StartUpPage.Interfaces;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.Pages.CountryPage.Classes.CountryList.TurkeyPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartBestPriceBlockPage;
import org.openqa.selenium.By;


public interface BestPricable {

    By cityStartDD = By.xpath("//div[@class='ps-departures_input']");
    By cityStartList = By.xpath("//div[@class='ps-departures_input']//option");
    By countPfNightsList = By.xpath("//div[@class='ps-nights']//div");
    By countryGraphList = By.xpath("//div[@class='ps-countries_visible']//div");
    By invisibleCountryDD = By.xpath("//div[@class='ps-countries_visible_item more_item']");
    By priceColumnList = By.xpath("//div[@class='price-stat-columns-wrap']//a");
    By priceListRightButton = By.xpath("//div[@class='ps_arrows-right']");

    public StartBestPriceBlockPage clickCityStartDD();

    public StartBestPriceBlockPage selectAnyStartCity(int number);

    //////////////////////////////////////////////////////////////
    public StartBestPriceBlockPage selectAnyCountOfNights(int number);

    //////////////////////////////////////////////////////////////
    public StartBestPriceBlockPage selectAnyCountry(int number);

    public StartBestPriceBlockPage selectLastStartCity();

    //////////////////////////////////////////////////////////////
    public CountryFiltersBlockPage selectAnyPriceOfGraph(int number, String countryName);
}
