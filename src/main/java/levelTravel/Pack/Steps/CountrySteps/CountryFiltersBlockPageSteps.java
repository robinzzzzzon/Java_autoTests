package levelTravel.Pack.Steps.CountrySteps;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CountryFiltersBlockPageSteps {

    CountryFiltersBlockPage page;

    @Step
    public void openPage() {
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
    public void pasteBufferPrice(boolean b){
        page.putAnyPriceInPriceInput(b);
    }

    @Step
    public void selectAnyStarsHotel(boolean b, int spanNumber, int inputNumber) {
        page.selectAnyStarsHotel(b, spanNumber, inputNumber);
    }

    @Step
    public void selectFirstAndLastStars(){
        page.selectFirstAndLastStars();
    }

    @Step
    public void selectAllStars(){
        page.selectAllStars();
    }

    @Step
    public void writeHotelName(String hotelName) {
        page.writeHotelName(hotelName);
    }

    @Step
    public void writeHotelNameFromBuffer(String anyHotelName){
        page.writeHotelNameFromBuffer(anyHotelName);
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
    public void selectPrivateBeachInput(boolean b) {
        page.selectPrivateBeachInput(b);
    }

    @Step
    public void selectTypeOfBeach(int number, boolean b) {
        page.selectTypeOfBeach(number, b);
    }

    @Step
    public void selectAllTypeOfBeach() {
        page.selectAllTypeOfBeach();
    }

    @Step
    public void selectTypeFood(int number) {
        page.selectTypeFood(number);
    }

    @Step
    public void selectRegionType(int number) {
        page.selectRegionType(number);
    }

    @Step
    public void selectAnyRegion(int number) {
        page.selectAnyRegion(number);
    }

    @Step
    public void selectAllRegions() {
        page.selectAllRegions();
    }

    @Step
    public void selectHotelType(int number) {
        page.selectHotelType(number);
    }

    @Step
    public void selectWiFiInput(int elementNumber, boolean b) {
        page.selectWiFiInput(elementNumber, b);
    }

    @Step
    public void selectWaterGame(int number) {
        page.selectWaterGame(number);
    }

    @Step
    public void selectHotelFacility(int number) {
        page.selectHotelFacility(number);
    }

    @Step
    public void selectFamilyWithChildren(int number) {
        page.selectFamilyWithChildren(number);
    }

    @Step
    public void selectAnyTourOperator(int number) {
        page.selectAnyTourOperator(number);
    }

    @Step
    public void selectAllTourOperators() {
        page.selectAllTourOperators();
    }

    @Step
    public void clickLocalClearFilter() {
        page.clickLocalClearFilter();
    }

    @Step
    public void clickFewLocalClearFilter() {
        page.clickFewLocalClearFilter();
    }

    @Step
    public void clickAllClearFilter() {
        page.clickAllClearFilter();
    }

    ///////////////////////////////////////////////////////////////////////
    //Стэпы с проверками:

    @Step
    public void checkToursResultGreaterNull() {
        page.find("//div[@class='overlay_container']").waitUntilNotVisible();
        List<WebElementFacade> facade = page.findAll("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div");
        Assertions.assertThat(facade.size() > 0).isTrue();
    }

    @Step
    public void checkToursResultGreaterAnyNumber(int number) {
        page.find("//div[@class='overlay_container']").waitUntilNotVisible();
        Assertions.assertThat(page.findAll("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).size().isGreaterThan(number);
    }

    @Step
    public void checkPriceInputsIsNotNull(){
        List<WebElementFacade> list = page.findAll("//div[@class='filter-budget__fields']//input");
        Assertions.assertThat(!(list.get(0).getValue().isEmpty() && list.get(1).getValue().isEmpty())).isTrue();
    }

    @Step
    public void checkSelectingCheckBox(boolean b, int number) {
        if(!b){
            Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-stars__list']/li").get(number).isSelected()).isFalse();
        }
        else{
            Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-stars__list']/li").get(number).isSelected()).isTrue();
        }
    }

    @Step
    public void checkCountSelectingCB(int number){
        List<WebElementFacade> list = page.findAll("//ul[@class='checkbox-group__list filter-stars__list']//span[@class='checkbox__custom']");
        List<WebElementFacade> selectedList = new ArrayList<>();
        for (WebElementFacade element: list) {
            if(element.isSelected()){
                selectedList.add(element);
            }
        }
        Assertions.assertThat(selectedList.size() == number).isTrue();
    }

    @Step
    public void checkToursResultIsPresent(int number) {
        String s = "//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[%s]";
        WebElement element = page.find(By.xpath(String.format(s, number))).waitUntilVisible();
        Assertions.assertThat(element.isEnabled()).isTrue();
    }

    @Step
    public void checkVisibleEmptyResults() {
        page.find("//div[@class='overlay_container']").waitUntilNotVisible();
        WebElement element = page.find("//div[@class='no-results']");
        Assertions.assertThat(element.isEnabled()).isTrue();
    }

    @Step
    public void checkActivateElementsOfRating(int number) {
        List<WebElementFacade> list = page.findAll("//ul[@class='switcher__list filter-rating__switcher-list']//li");
        List<WebElementFacade> activatedList = new ArrayList<>();
        for (WebElementFacade element: list) {
            if(element.getAttribute("class").contains("active")){
                activatedList.add(element);
            }
        }
        Assertions.assertThat(activatedList.size() == number).isTrue();
    }

    @Step
    public void compareRatingOfGetResultList(){
        page.find("//div[@class='overlay_container']").waitUntilNotVisible();
        List<WebElementFacade> toursRatingList = page.findAll("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div//span[@class='hotel-rating-value']");
        List<WebElementFacade> goodRatingList = new ArrayList<>();
        for (WebElementFacade element: toursRatingList) {
            double rate = Double.parseDouble(element.getText());
            if(rate >= 9.0){
                goodRatingList.add(element);
            }
        }
        Assertions.assertThat(goodRatingList.size() == toursRatingList.size()).isTrue();
    }

    @Step
    public void isEnabledAnyElementOfDistanceList(int number) {
        Assertions.assertThat(page.findAll("//ul[@class='switcher__list distance__switcher-list']/li").get(number - 1).isEnabled()).isTrue();
    }

    @Step
    public void checkSelectedPBCheckBox(boolean b) {
        if (b) {
            Assertions.assertThat(page.find("//div[@class='checkbox-group__item-container filter-beach__item-container']/input").isSelected()).isTrue();
        }
        Assertions.assertThat(page.find("//div[@class='checkbox-group__item-container filter-beach__item-container']/input").isSelected()).isFalse();
    }

    @Step
    public void checkSizeOfToursList() {
        Assertions.assertThat(page.findAll("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div")).isNotNull();
    }

    @Step
    public void isDisplayedAnyCbOfFoodList(int number) {
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-pansion__list']//label").get(number).isDisplayed()).isTrue();
    }

    @Step
    public void isEnabledAnyElementOfRegionList(int number) {
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-region__list']//li//input").get(number).isEnabled()).isTrue();
    }

    @Step
    public void checkEqualString(String s) {
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-category__list']//label").get(2).getText()).isEqualTo(s);
    }

    @Step
    public void isSelectedRbWifi(int number) {
        Assertions.assertThat(page.findAll("//ul[@class='radio-group']//div").get(number).isSelected()).isFalse();
    }

    @Step
    public void isSelectedAnyTourOperator(int number) {
        Assertions.assertThat(page.findAll("//ul[@class='checkbox-group__list filter-operator__list']//li").get(number).isDisplayed()).isTrue();
    }

    @Step
    public void isSelectedAnyFilter(int number) {
        Assertions.assertThat(page.findAll("//div[@class='filter-rating']//li").get(number).isDisplayed()).isTrue();
    }

}
