package levelTravel.Pack.test.HotelFirstDescTests;

import levelTravel.Pack.Steps.HotelDestSteps.HotelFirstDescSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class FirstDescTests {

    @Steps
    HotelFirstDescSteps steps;

    @Managed(driver="chrome")
    WebDriver driver;

    @Test
    public void getMainHeadingText(){
        steps.openPage();
        steps.getMainHeadingText();
    }

    @Test
    public void getDescHotelText(){
        steps.openPage();
        steps.getDescHotelText();
    }

    @Test
    public void selectAnyMessenger(){
        steps.openPage();
        steps.clickShareDd();
        steps.selectAnyMessenger(true);
    }

    @Test
    public void clickPriceButton(){
        steps.openPage();
        steps.clickPriceButton();
    }

    @Test
    public void clickAskPriceButton(){
        steps.openPage();
        steps.clickAskPriceButton();
    }

    @Test
    public void clickWishListIcon() {
        steps.openPage();
        steps.clickWishListIcon();
    }

    @Test
    //Потом разобраться что не так
    public void selectAnyPhotoSwitch() {
        steps.openPage();
        steps.selectAnyPhotoSwitch(true);
    }

    @Test
    public void selectAnyPhotoFromCarousel() {
        steps.openPage();
        steps.selectAnyPhotoFromCarousel(6);
        steps.selectPhotoCross();
    }

    @Test
    public void selectAnyElementFromOptionBar() {
        steps.openPage();
        steps.selectAnyElementFromOptionBar(3);
    }

    @Test
    public void selectAnyDataFromDateList() {
        steps.openPage();
        steps.selectAnyDataFromDateList(7);
    }

    @Test
    public void clickAllToursButton() {
        steps.openPage();
        steps.clickAllToursButton();
    }

    @Test
    public void clickMomentConfirmationCb() {
        steps.openPage();
        steps.clickMomentConfirmationCb(true);
    }

    @Test
    public void selectAnyTourOperatorFromList() {
        steps.openPage();
        steps.clickTourOperatorDd();
        steps.selectAnyTourOperatorFromList(2);
    }

    @Test
    public void clickDoneButton() {
        steps.openPage();
        steps.clickTourOperatorDd();
        steps.clickDoneButton();
    }

    @Test
    public void selectAnyOfferButton(){
        steps.openPage();
        steps.selectAnyOfferButton(3);
    }

    @Test
    //Разобраться почему не работает
    public void selectAnyOfferFromOfferDdList(){
        steps.openPage();
        steps.selectAnyOfferDdFromList(2);
        steps.selectAnyOfferFromOfferDdList(1);
    }
}
