package levelTravel.Pack.Pages.CountryPage.Interfaces;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryToursFragmentPage;
import org.openqa.selenium.By;

public interface Toursable {

    By recommendationFilter = By.xpath("//div[@class='sorting']/button[1]");
    By priceFilter = By.xpath("//div[@class='sorting']/button[2]");
    By rateFilter = By.xpath("//div[@class='sorting']/button[3]");
    By wishListHeartButtons = By.xpath("//a[@class='wishlist-heart hotel__wishlist-button']");
    By exploreHotelButtons = By.xpath("//div[@class='explore-hotel-button']/a");
    By hotelPriceLinks = By.xpath("//span[@class='hotel__price']/parent::a");
    By nameHotelLinks = By.xpath("//a[@class='hotel-explore-link']");

    CountryToursFragmentPage clickRecommendFilter();

    CountryToursFragmentPage clickPriceFilter();

    CountryToursFragmentPage clickRateFilter();

    /////////////////////////////////////////////////////////////

    void clickFirstWishListButton(boolean b);

    void clickAnyWishListButton(int number);

    /////////////////////////////////////////////////////////////

    void clickFirstExploreHotel(boolean b);

    void clickAnyExploreHotel(int number);

    /////////////////////////////////////////////////////////////

    void clickFirstHotelPriceLink(boolean b);

    void clickAnyHotelPriceLink(int number);

    ////////////////////////////////////////////////////////////

    String getAnyNameHotelText(int number);

    void clickFirstNameHotelLink(boolean b);

    void clickAnyNameHotelLink(int number);
}
