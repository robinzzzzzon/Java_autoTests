package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Toursable;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-PT-departure-15.04.2020-for-7-nights-2-adults-0-kids-1..5-stars")
public class CountryToursBlockPage extends AbstractBasePage implements Toursable {

    BaseMethods methods = new BaseMethods();

    public CountryToursBlockPage clickRecommendFilter() {
        methods.selectAnyElement(recommendationFilter);
        return new CountryToursBlockPage();
    }

    public CountryToursBlockPage clickPriceFilter() {
        methods.selectAnyElement(priceFilter);
        return new CountryToursBlockPage();
    }

    public CountryToursBlockPage clickRateFilter() {
        methods.selectAnyElement(rateFilter);
        return new CountryToursBlockPage();
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getWishListHeartButtons() {
        return methods.getAnyList(wishListHeartButtons);
    }

    public void clickFirstWishListButton(boolean b) {
        selectFirstFromAnyList(getWishListHeartButtons(), b);
    }

    public void clickAnyWishListButton(int number) {
        methods.selectAnyElementFromList(number, getWishListHeartButtons());
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getExploreHotelButtons() {
        return methods.getAnyList(exploreHotelButtons);
    }

    public void clickFirstExploreHotel(boolean b) {
        selectFirstFromAnyList(getExploreHotelButtons(), b);
    }

    public void clickAnyExploreHotel(int number) {
        methods.selectAnyElementFromList(number, getExploreHotelButtons());
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getHotelPriceLinks() {
        return methods.getAnyList(hotelPriceLinks);
    }

    public void clickFirstHotelPriceLink(boolean b) {
        selectFirstFromAnyList(getHotelPriceLinks(), b);
    }

    public void clickAnyHotelPriceLink(int number) {
        methods.selectAnyElementFromList(number, getHotelPriceLinks());
    }

    ////////////////////////////////////////////////////////////

    private List<WebElementFacade> getNameHotelLinks() {
        return methods.getAnyList(nameHotelLinks);
    }

    public String getAnyNameHotelText(int number) {
        return methods.getTextFromAnyElementOfList(getNameHotelLinks(), number);
    }

    public void clickFirstNameHotelLink(boolean b) {
        selectFirstFromAnyList(getNameHotelLinks(), b);
    }

    public void clickAnyNameHotelLink(int number) {
        methods.selectAnyElementFromList(number, getNameHotelLinks());
    }

    ///////////////////////////////////////////////////////////////////

    private void selectFirstFromAnyList(List<WebElementFacade> list, boolean b) {
        WebElement element = list.get(0);
        if (!element.isSelected() == b) {
            element.click();
        }
    }
}
