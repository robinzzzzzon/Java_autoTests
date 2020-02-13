package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Toursable;
import levelTravel.Pack.Pages.HotelDescPage.HotelFirstDescPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-28.02.2020-for-7-nights-2-adults-0-kids-1..5-stars")
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

    public void clickFirstWishListButton(boolean b) {
        selectFirstFromAnyList(getWishListHeartButtons(), b);
    }

    public void clickAnyWishListButton(int number) {
        selectAnyFromAnyList(getWishListHeartButtons(), number);
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getExploreHotelButtons() {
        return findAll(exploreHotelButtons);
    }

    public void clickFirstExploreHotel(boolean b) {
        selectFirstFromAnyList(getExploreHotelButtons(), b);
    }

    public void clickAnyExploreHotel(int number) {
        selectAnyFromAnyList(getExploreHotelButtons(), number);
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getHotelPriceLinks() {
        return findAll(hotelPriceLinks);
    }

    public void clickFirstHotelPriceLink(boolean b) {
        selectFirstFromAnyList(getHotelPriceLinks(), b);
    }

    public void clickAnyHotelPriceLink(int number) {
        selectAnyFromAnyList(getHotelPriceLinks(), number);
    }

    ////////////////////////////////////////////////////////////

    private List<WebElementFacade> getNameHotelLinks() {
        return findAll(nameHotelLinks);
    }

    public String getAnyNameHotelText(int number) {
        List<WebElementFacade> webElements = getNameHotelLinks();
        return webElements.get(number).getText();
    }

    public void clickFirstNameHotelLink(boolean b) {
        selectFirstFromAnyList(getNameHotelLinks(), b);
    }

    public void clickAnyNameHotelLink(int number) {
        selectAnyFromAnyList(getNameHotelLinks(), number);
    }

    ///////////////////////////////////////////////////////////////////

    private void selectAnyFromAnyList(List<WebElementFacade> list, int anyNumber){
        WebElement element = list.get(anyNumber);
        element.click();
    }

    private void selectFirstFromAnyList(List<WebElementFacade> list, boolean b){
        WebElement element = list.get(0);
        if (!element.isSelected() == b){
            element.click();
        }
    }
}
