package levelTravel.Pack.Steps.CombinedSteps;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersFragmentPage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryToursFragmentPage;
import levelTravel.Pack.Pages.HotelDescPage.HotelFirstDescPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchFragmentPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.Assertions;

import java.util.List;

public class CombinedSteps extends ScenarioSteps {

    private StartSearchFragmentPage searchPage;
    private CountryFiltersFragmentPage filtersPage;
    private CountryToursFragmentPage toursPage;
    private HotelFirstDescPage hotelFirstPage;

    @Step
    public void openPage(){
        searchPage.open();
    }

    @Step
    public void clickCountryInput() {
        searchPage.clickCountryInput();
    }

    @Step
    public void selectPopularCountry(int number){
        searchPage.selectPopularCountry(number);
    }

    @Step
    public void selectWholeCountry(int number){
        searchPage.selectWholeCountry(number);
    }

    @Step
    public void clickSearchButton(String countryName){
        searchPage.clickSearchButton(countryName);
    }

    //////////////////////////////////////////////

    @Step
    public void switchMomentConfirmTumbler(boolean b) {
        filtersPage.switchMomentConfirmTumbler(b);
    }

    @Step
    public void selectAnyPriceTower(int number) {
        filtersPage.selectAnyPriceTower(number);
    }

    @Step
    public void selectFirstAndLastStars() {
        filtersPage.selectFirstAndLastStars();
    }

    @Step
    public void selectAllStars() {
        filtersPage.selectAllStars();
    }

    @Step
    public void writeHotelName(String hotelName) {
        filtersPage.writeHotelName(hotelName);
    }

    @Step
    public void selectDistanceToSea(int number) {
        filtersPage.selectDistanceToSea(number);
    }

    @Step
    public void selectAllFoodType() {
        filtersPage.selectAllFoodType();
    }

    @Step
    public void clickLocalClearFilter() {
        filtersPage.clickLocalClearFilter();
    }

    //////////////////////////////////////////////////////

    @Step
    public void clickPriceFilter() {
        toursPage.clickPriceFilter();
    }

    @Step
    public void clickRateFilter() {
        toursPage.clickRateFilter();
    }

    @Step
    public void clickAnyWishListButton(int number) {
        toursPage.clickAnyWishListButton(number);
    }

    @Step
    public void clickAnyExploreHotel(int number) {
        toursPage.clickAnyExploreHotel(number);
    }

    @Step
    public void clickAnyHotelPriceLink(int number) {
        toursPage.clickAnyHotelPriceLink(number);
    }

    @Step
    public void clickAnyNameHotelLink(int number) {
        toursPage.clickAnyNameHotelLink(number);
    }

    //////////////////////////////////////////////////////

    @Step
    public void clickFavoriteButton(){
        hotelFirstPage.clickFavoriteButton();
    }

    @Step
    public void selectAnyPhoto(int number){
        hotelFirstPage.selectAnyPhoto(number);
    }

    /////////////////////////////////////////////////////

    @Step
    public void checkToursResultGreaterNull() {
        filtersPage.find("//div[@class='overlay_container']").waitUntilNotVisible();
        List<WebElementFacade> facade = filtersPage.findAll("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div");
        Assertions.assertThat(facade.size() > 0).isTrue();
    }

    /////////////////////////////////////////////////////////////

    @Step
    public String getCurrentHandle(){
        return getDriver().getWindowHandle();
    }

    @Step
    public void switchToNextHandle(){
        for (String tab : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(tab);
        }
    }

    @Step
    public void switchToInitHandle(){
        getDriver().switchTo().window(getCurrentHandle());
    }

}
