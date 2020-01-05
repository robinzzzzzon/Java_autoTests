package levelTravel.Pack.CountryPage.Interfaces;

import levelTravel.Pack.CountryPage.Classes.BaseCountryPage.CountryToursBlockPage;
import levelTravel.Pack.HotelDescPage.HotelFirstDescPage;
import org.openqa.selenium.By;

public interface Toursable {

    By recommendationFilter = By.xpath("//div[@class='sorting']/button[1]");
    By priceFilter = By.xpath("//div[@class='sorting']/button[2]");
    By rateFilter = By.xpath("//div[@class='sorting']/button[3]");
    By wishListHeartButtons = By.xpath("//a[@class='wishlist-heart hotel__wishlist-button']");
    By exploreHotelButtons = By.xpath("//div[@class='explore-hotel-button']/a");
    By hotelPriceLinks = By.xpath("//span[@class='hotel__price']/parent::a");
    By nameHotelLinks = By.xpath("//a[@class='hotel-explore-link']");

    public CountryToursBlockPage clickRecommendFilter();

    public CountryToursBlockPage clickPriceFilter();

    public CountryToursBlockPage clickRateFilter();

    /////////////////////////////////////////////////////////////

    public CountryToursBlockPage clickFirstWishListButton(boolean b);

    public CountryToursBlockPage clickAnyWishListButton(int number);

    /////////////////////////////////////////////////////////////

    public HotelFirstDescPage clickFirstExploreHotel(boolean b);

    public HotelFirstDescPage clickAnyExploreHotel(int number);

    /////////////////////////////////////////////////////////////

    public HotelFirstDescPage clickFirstHotelPriceLink(boolean b);

    public HotelFirstDescPage clickAnyHotelPriceLink(int number);

    ////////////////////////////////////////////////////////////

    public String getAnyNameHotelText(int number);

    public HotelFirstDescPage clickFirstNameHotelLink(boolean b);

    public HotelFirstDescPage clickAnyNameHotelLink(int number);
}
