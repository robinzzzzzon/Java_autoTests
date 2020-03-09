package levelTravel.Pack.Steps.StartPageSteps;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersFragmentPage;

import levelTravel.Pack.Pages.CountryPage.Classes.CountryList.ItalyPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchFragmentPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class SearchSteps {

    private StartSearchFragmentPage page;
    private CountryFiltersFragmentPage countryFiltersFragmentPage;
    private ItalyPage italyPage;

    @Step
    public void openPage() {
        page.open();
    }

    @Step
    public void writeAnyCountryName(String anyCountryName) {
        page.writeAnyCountryName(anyCountryName);
    }

    @Step
    public void clickCountryInput() {
        page.clickCountryInput();
    }

    @Step
    public void selectPopularCountry(int number) {
        page.selectPopularCountry(number);
    }

    @Step
    public void selectWholeCountry(int number) {
        page.selectWholeCountry(number);
    }

    @Step
    public String getErrorByText(int errorNumber) {
        return page.getErrorByText(errorNumber);
    }

    @Step
    public boolean checkIsErrorVisible(String message) {
        return page.isErrorVisible(message);
    }

    @Step
    public void clickCalendarInput() {
        page.clickCalendarInput();
    }

    @Step
    public void add2Days() {
        page.add2Days();
    }

    @Step
    public void selectCalendarDate(int row, int column, int countSwitch) {
        page.selectCalendarDate(row, column, countSwitch);
    }

    @Step
    public void clickCountOfNights() {
        page.clickCountOfNights();
    }

    @Step
    public void minusNight() {
        page.minusNight();
    }

    @Step
    public void plusNight() {
        page.plusNight();
    }

    @Step
    public void addMaxCountNights(boolean b) {
        page.addMaxCountNights(b);
    }

    @Step
    public void addMinCountNights(boolean b) {
        page.addMinCountNights(b);
    }

    @Step
    public void add2Nights(boolean b) {
        page.add2Nights(b);
    }

    @Step
    public void clickCountOfPassengers() {
        page.clickCountOfPassengers();
    }

    @Step
    public void selectVariationAddChild(int childNumber) {
        page.selectVariationAddChild(childNumber);
    }

    @Step
    public void minusPassenger() {
        page.minusPassenger();
    }

    @Step
    public void plusPassenger() {
        page.plusPassenger();
    }

    @Step
    public void addMaxPassenger(boolean b) {
        page.addMaxPassenger(b);
    }

    @Step
    public void clickStartPlaceInput() {
        page.clickStartPlaceInput();
    }

    @Step
    public void clearStartPlaceInput() {
        page.clearStartPlaceInput();
    }

    @Step
    public void writeStartPlaceInput(String anyPlace) {
        page.writeStartPlaceInput(anyPlace);
    }

    @Step
    public void typeIntoString(String anyString){
        page.typeIntoString(anyString);
    }

    @Step
    public void clickSelectingStartPlace(String startPlace) {
        page.clickSelectingStartPlace(startPlace);
    }

    @Step
    public void clickSearchButton(String countryName) {
        page.clickSearchButton(countryName);
    }

    @Step
    public void clickConfirmButtonWithAnyEmptyFields() {
        page.clickConfirmButtonWithAnyEmptyFields();
    }

    @Step
    public void selectSwitcher(){
        countryFiltersFragmentPage.switchMomentConfirmTumbler(true);
    }

    ///////////////////////////////////////////////////////

    @Step
    public void checkContainsPartOfHeading(String s) {
        Assertions.assertThat(countryFiltersFragmentPage.find((By.xpath("//h1[@class='search-page-title']"))).getText()).contains(s);
    }

    @Step
    public void isDisplayedTransportVariation() {
        Assertions.assertThat(countryFiltersFragmentPage.find(By.xpath("//span[@class='included-icons']")).isDisplayed());
    }

    @Step
    public void isSelectMomentConfirmSwitcher() {
        page.find("//div[@class='overlay_container']").waitUntilNotVisible();
        Assertions.assertThat(countryFiltersFragmentPage.find(By.xpath("//span[@class='toggle-switch__button']")).isSelected()).isFalse();
    }

    @Step
    public void isVisibleHotelStarsList() {
        Assertions.assertThat(countryFiltersFragmentPage.findAll(By.xpath("//ul[@class='checkbox-group__list filter-stars__list']/li")).isEmpty()
                && !countryFiltersFragmentPage.find(By.xpath("//div[text()='Звёздность отеля']")).isDisplayed()).isFalse();
    }

    @Step
    public void checkGetToursList() {
        Assertions.assertThat(countryFiltersFragmentPage.findAll(By.xpath("//div[@class='ReactVirtualized__Grid ReactVirtualized__List']//div")).size() > 0);
    }

    @Step
    public void isEnabledSearchInput() {
        page.find("//div[@class='overlay_container']").waitUntilNotVisible();
        Assertions.assertThat(countryFiltersFragmentPage.find(By.xpath("//div[@class='search_container']")).isEnabled()).isTrue();
    }

    @Step
    public void checkEqualHeadingText(String s) {
        Assertions.assertThat(italyPage.getTextLoadingHeading()).isEqualTo(s);
    }

    @Step
    public void checkVisibleErrorByAnyEmptyRequiredField() {
        Assertions.assertThat(page.isErrorVisible("Куда бы вы хотели полететь?")).isTrue();
    }

    @Step
    public void checkVisibleHeadingOfEmptyToursList(String s) {
        Assertions.assertThat(page.find("//div[@class='empty-search-title']").getText()).isEqualTo(s);
    }

}
