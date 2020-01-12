package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CountryFiltersBlockPageSteps {

    CountryFiltersBlockPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void switchMomentConfirmTumbler(boolean b) {
        page.switchMomentConfirmTumbler(b);
    }

    @Step
    public void selectAnyPriceTower(int number) {
        page.selectAnyPriceTower(number);
    }

    @Step
    public void writeMinIntervalPrice(String anyPrice) {
        page.writeMinIntervalPrice(anyPrice);
    }

    @Step
    public void writeMaxIntervalPrice(String anyPrice) {
        page.writeMaxIntervalPrice(anyPrice);
    }

    @Step
    public void clickAnyStars(int number){
        page.clickAnyStars(number);
    }

    @Step
    public void selectAnyStarsHotel(int spanNumber, int inputNumber){
        page.selectAnyStarsHotel(spanNumber, inputNumber);
    }

    @Step
    public void writeHotelName(String hotelName) {
        page.writeHotelName(hotelName);
    }


    @Step
    public void selectRatingHotel(int number) {
        page.selectRatingHotel(number);
    }

    @Step
    public void selectDistanceToSea(int number) {
        page.selectDistanceToSea(number);
    }

    @Step
    public void selectPrivateBeachInput(boolean b){
        page.selectPrivateBeachInput(b);
    }

    @Step
    public void selectTypeOfBeach(int number, boolean b){
        page.selectTypeOfBeach(number, b);
    }

    @Step
    public void selectAllTypeOfBeach(){
        page.selectAllTypeOfBeach();
    }

    @Step
    public void selectTypeFood(int number){
        page.selectTypeFood(number);
    }

    @Step
    public void selectRegionType(int number){
        page.selectRegionType(number);
    }

    @Step
    public void selectAnyRegion(int number){
        page.selectAnyRegion(number);
    }

    @Step
    public void selectAllRegions(){
        page.selectAllRegions();
    }

    @Step
    public void selectHotelType(int number){
        page.selectHotelType(number);
    }

    @Step
    public void selectWiFiInput(int elementNumber, boolean b){
        page.selectWiFiInput(elementNumber, b);
    }

    @Step
    public void selectWaterGame(int number){
        page.selectWaterGame(number);
    }

    @Step
    public void selectHotelFacility(int number){
        page.selectHotelFacility(number);
    }

    @Step
    public void selectFamilyWithChildren(int number){
        page.selectFamilyWithChildren(number);
    }

    @Step
    public void selectAnyTourOperator(int number){
        page.selectAnyTourOperator(number);
    }

    @Step
    public void selectAllTourOperators(){
        page.selectAllTourOperators();
    }

    @Step
    public void clickLocalClearFilter(){
        page.clickLocalClearFilter();
    }

    @Step
    public void clickFewLocalClearFilter(){
        page.clickFewLocalClearFilter();
    }

    @Step
    public void clickAllClearFilter(){
        page.clickAllClearFilter();
    }

    ///////////////////////////////////////////////////////////////////////

    @Step
    public void checkToursResultGreaterNull(int number){
        Assertions.assertThat(page.findAll("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).size().isGreaterThan(number);
    }

    @Step
    public void checkIsNotSelectedCheckBox(int number){
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-stars__list']/li").get(number).isSelected()).isFalse();
    }

    @Step
    public void checkToursResultEqually(int number){
        String s = "//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[%s]";
        WebElement element = page.find(By.xpath(String.format(s, number))).waitUntilVisible();
        Assertions.assertThat(element.isEnabled()).isTrue();
    }

    @Step
    public void isEnabledAnyElementOfRateList(int number){
        Assertions.assertThat(page.findAll("//ul[@class='switcher__list filter-rating__switcher-list']/li").get(number - 1).isEnabled()).isTrue();
    }

    @Step
    public void isEnabledAnyElementOfDistanceList(int number){
        Assertions.assertThat(page.findAll("//ul[@class='switcher__list distance__switcher-list']/li").get(number - 1).isEnabled()).isTrue();
    }

    @Step
    public void checkSelectedPBCheckBox(boolean b){
        if (b){
            Assertions.assertThat(page.find("//div[@class='checkbox-group__item-container filter-beach__item-container']/input").isSelected()).isTrue();
        }
        Assertions.assertThat(page.find("//div[@class='checkbox-group__item-container filter-beach__item-container']/input").isSelected()).isFalse();
    }

    @Step
    public void checkSizeOfToursList(){
        Assertions.assertThat(page.findAll("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).isNotNull();
    }

    @Step
    public void isDisplayedAnyCbOfFoodList(int number){
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-pansion__list']//label").get(number).isDisplayed()).isTrue();
    }

    @Step
    public void isEnabledAnyElementOfRegionList(int number){
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-region__list']//li//input").get(number).isEnabled()).isTrue();
    }

    @Step
    public void checkEqualString(String s){
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-category__list']//label").get(2).getText()).isEqualTo(s);
    }

    @Step
    public void isSelectedRbWifi(int number){
        Assertions.assertThat(page.findAll("//ul[@class='radio-group']//div").get(number).isSelected()).isFalse();
    }

    @Step
    public void isSelectedAnyTourOperator(int number){
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-operator__list']//li").get(number).isDisplayed()).isTrue();
    }

    @Step
    public void isSelectedAnyFilter(int number){
        Assertions.assertThat(page.findAll("//div[@class='filter-rating']//li").get(number).isDisplayed()).isTrue();
    }

}
