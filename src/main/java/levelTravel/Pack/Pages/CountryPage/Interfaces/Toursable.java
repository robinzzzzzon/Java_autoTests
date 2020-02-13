package levelTravel.Pack.Pages.CountryPage.Interfaces;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryToursBlockPage;
import levelTravel.Pack.Pages.HotelDescPage.HotelFirstDescPage;
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

    public void clickFirstWishListButton(boolean b);

    public void clickAnyWishListButton(int number);

    /////////////////////////////////////////////////////////////

    public void clickFirstExploreHotel(boolean b);

    public void clickAnyExploreHotel(int number);

    /////////////////////////////////////////////////////////////

    public void clickFirstHotelPriceLink(boolean b);

    public void clickAnyHotelPriceLink(int number);

    ////////////////////////////////////////////////////////////

    public String getAnyNameHotelText(int number);

    public void clickFirstNameHotelLink(boolean b);

    public void clickAnyNameHotelLink(int number);
}
