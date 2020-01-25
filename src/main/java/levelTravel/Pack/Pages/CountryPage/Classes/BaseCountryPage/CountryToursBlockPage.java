package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Toursable;
import levelTravel.Pack.Pages.HotelDescPage.HotelFirstDescPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-20.01.2020-for-5..9-nights-2-adults-0-kids-1..5-stars")
public class CountryToursBlockPage extends AbstractBasePage implements Toursable {

    public CountryToursBlockPage clickRecommendFilter() {
        find(recommendationFilter).click();
        return new CountryToursBlockPage();
    }

    public CountryToursBlockPage clickPriceFilter() {
        find(priceFilter).click();
        return new CountryToursBlockPage();
    }

    public CountryToursBlockPage clickRateFilter() {
        find(rateFilter).click();
        return new CountryToursBlockPage();
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getWishListHeartButtons() {
        return findAll(wishListHeartButtons);
    }

    public CountryToursBlockPage clickFirstWishListButton(boolean b) {
        WebElement element = getWishListHeartButtons().get(0);
        if (!element.isSelected() == b) {
            element.click();
        }
        return this;
    }

    public CountryToursBlockPage clickAnyWishListButton(int number) {
        List<WebElementFacade> webElements = getWishListHeartButtons();
        webElements.get(number - 1).click();
        return this;
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getExploreHotelButtons() {
        return findAll(exploreHotelButtons);
    }

    public HotelFirstDescPage clickFirstExploreHotel(boolean b) {
        WebElement element = getExploreHotelButtons().get(0);
        if (!element.isSelected() == b) {
            element.click();
        }
        return new HotelFirstDescPage();
    }

    public HotelFirstDescPage clickAnyExploreHotel(int number) {
        List<WebElementFacade> webElements = getExploreHotelButtons();
        webElements.get(number - 1).click();
        return new HotelFirstDescPage();
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getHotelPriceLinks() {
        return findAll(hotelPriceLinks);
    }

    public HotelFirstDescPage clickFirstHotelPriceLink(boolean b) {
        WebElement element = getHotelPriceLinks().get(0);
        if (!element.isSelected() == b) {
            element.click();
        }
        return new HotelFirstDescPage();
    }

    public HotelFirstDescPage clickAnyHotelPriceLink(int number) {
        List<WebElementFacade> webElements = getHotelPriceLinks();
        webElements.get(number - 1).click();
        return new HotelFirstDescPage();
    }

    ////////////////////////////////////////////////////////////

    private List<WebElementFacade> getNameHotelLinks() {
        return findAll(nameHotelLinks);
    }

    public String getAnyNameHotelText(int number) {
        List<WebElementFacade> webElements = getNameHotelLinks();
        return webElements.get(number).getText();
    }

    public HotelFirstDescPage clickFirstNameHotelLink(boolean b) {
        WebElement element = getNameHotelLinks().get(0);
        if (!element.isSelected() == b) {
            element.click();
        }
        return new HotelFirstDescPage();
    }

    public HotelFirstDescPage clickAnyNameHotelLink(int number) {
        List<WebElementFacade> webElements = getNameHotelLinks();
        webElements.get(number - 1).click();
        return new HotelFirstDescPage();
    }
}
