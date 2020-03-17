package levelTravel.Pack.Steps.HotelDestSteps;

import levelTravel.Pack.Pages.HotelDescPage.Classes.HotelFirstDescPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HotelFirstDescSteps extends ScenarioSteps {

    private HotelFirstDescPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickShareDd() {
        page.clickShareDd();
    }

    @Step
    public void selectAnyMessenger(boolean b) {
        page.selectAnyMessenger(b);
    }

    //////////////////////////////////////////////////////

    @Step
    public void getMainHeadingText() {
        page.getMainHeadingText();
    }

    @Step
    public void getDescHotelText() {
        page.getDescHotelText();
    }

    /////////////////////////////////////////////////////

    @Step
    public void clickPriceButton() {
        page.clickPriceButton();
    }

    @Step
    public void clickAskPriceButton() {
        page.clickAskPriceButton();
    }

    /////////////////////////////////////////////////////

    @Step
    public void clickWishListIcon() {
        page.clickWishListIcon();
    }

    /////////////////////////////////////////////////////

    @Step
    public void selectAnyPhotoSwitch(boolean b) {
        page.selectAnyPhotoSwitch(b);
    }

    @Step
    public void selectPhotoCross() {
        page.selectPhotoCross();
    }

    @Step
    public void selectAnyPhotoFromCarousel(int number) {
        page.selectAnyPhotoFromCarousel(number);
    }

    /////////////////////////////////////////////////////

    @Step
    public void selectAnyElementFromOptionBar(int number) {
        page.selectAnyElementFromOptionBar(number);
    }

    //////////////////////////////////////////////////////

    @Step
    public void selectAnyDataFromDateList(int number) {
        page.selectAnyDataFromDateList(number);
    }

    //////////////////////////////////////////////////////

    @Step
    public void clickAllToursButton() {
        page.clickAllToursButton();
    }

    @Step
    public void clickMomentConfirmationCb(boolean b) {
        page.clickMomentConfirmationCb(b);
    }

    //////////////////////////////////////////////////////////

    @Step
    public void clickTourOperatorDd() {
        page.clickTourOperatorDd();
    }

    @Step
    public void selectAnyTourOperatorFromList(int number) {
        page.selectAnyTourOperatorFromList(number);
    }

    @Step
    public void clickDoneButton() {
        page.clickDoneButton();
    }

    //////////////////////////////////////////////////////

    @Step
    public void selectAnyOfferButton(int number) {
        page.selectAnyOfferButton(number);
    }

    @Step
    public void selectAnyOfferDdFromList(int number) {
        page.selectAnyOfferDdFromList(number);
    }

    @Step
    public void selectAnyOfferFromOfferDdList(int number) {
        page.selectAnyOfferFromOfferDdList(number);
    }
}
