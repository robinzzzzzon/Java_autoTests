package levelTravel.Pack.test.StartTests;

import levelTravel.Pack.Steps.StartPageSteps.StartSearchBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class StartSearchBlockPageSerenityTest {

    @Steps
    private StartSearchBlockSteps steps;

    @Managed
    WebDriver driver;


    @Test
    public void searchTurkeyTours() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(1);
        steps.clickSearchButton("Turk");
        steps.checkContainsPartOfHeading("ц");
    }

    @Test
    public void searchRussiaTours_Write() {
        steps.openPage();
        steps.writeAnyCountryName("Россия");
        steps.clickSearchButton("Rus");
        steps.checkContainsPartOfHeading("сс");
    }

    @Test
    public void searchAbkhaziaTours_Write() {
        steps.openPage();
        steps.writeAnyCountryName("Абхазия");
        steps.clickSearchButton("Abk");
        steps.isDisplayedTransportVariation();
    }

    @Test
    public void searchSouthKoreaTours() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingWholeCountry(47);
        steps.clickSearchButton("Jap");
        steps.checkContainsPartOfHeading("ию");
    }

    @Test
    public void searchToursWithWriteAnyPlace() {
        steps.openPage();
        steps.writeAnyCountryName("Порту");
        steps.clickSearchButton("Por");
        steps.checkEqualHeadingText("Выберите тур в Порту, Португалия");
    }

    @Test
    public void searchToursWithEmptyCountryField() {
        steps.openPage();
        steps.clickConfirmButtonWithAnyEmptyFields();
        steps.checkVisibleErrorByAnyEmptyRequiredField();
    }

    @Test
    public void searchToursWithIncorrectPlace() {
        steps.openPage();
        steps.writeAnyCountryName("SomePlace");
        steps.clickConfirmButtonWithAnyEmptyFields();
        steps.checkVisibleErrorByAnyEmptyRequiredField();
    }

    @Test
    public void searchToursWithNoDefaultDate() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingWholeCountry(19);
        steps.clickCalendarInput();
        steps.selectCalendarDate(2, 4, 3);
        steps.clickSearchButton("Spa");
        steps.isSelectMomentConfirmSwitcher();
    }

    @Test
    public void searchToursWithDateInterval() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(2);
        steps.clickCalendarInput();
        steps.clickAdd2Days();
        steps.clickSearchButton("Thai");
        steps.isSelectMomentConfirmSwitcher();
    }

    @Test
    public void searchToursWithMinCountOfPassengers() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(2);
        steps.clickCountOfPassengers();
        steps.minusPassenger();
        steps.clickSearchButton("Thai");
        steps.selectSwitcher();
        steps.isSelectMomentConfirmSwitcher();
    }

    @Test
    public void searchToursWithMaxCountOfPassengers() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(2);
        steps.clickCountOfPassengers();
        steps.plusPassenger();
        steps.plusPassenger(); // переписать как параметризованный метод.
        steps.clickSearchButton("Thai");
        steps.isSelectMomentConfirmSwitcher();
    }

    @Test
    public void searchToursWithMinPassAddChild() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(5);
        steps.clickCountOfPassengers();
        steps.minusPassenger();
        steps.selectVariationAddChild(4);
        steps.clickSearchButton("Rus");
        steps.checkGetToursList();
    }

    @Test
    public void searchToursWithDefCountPassAddFewChild() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(5);
        steps.clickCountOfPassengers();
        steps.selectVariationAddChild(8);
        steps.selectVariationAddChild(16);
        steps.clickSearchButton("Rus");
        steps.checkGetToursList();
    }

    @Test
    public void searchToursWithMaxCountPassAddMaxCountChild() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(5);
        steps.clickCountOfPassengers();
        steps.addMaxPassenger(true);
        steps.selectVariationAddChild(2);
        steps.selectVariationAddChild(8);
        steps.selectVariationAddChild(17);
        steps.clickSearchButton("Rus");
        steps.checkGetToursList();
    }

    @Test
    public void searchToursWithMaxCountNights() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(4);
        steps.clickCountOfNights();
        steps.addMaxCountNights(true);
        steps.add2Nights(true);
        steps.clickSearchButton("Viet");
        steps.isVisibleHotelStarsList();
    }

    @Test
    public void searchToursWithMinCountNights() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(4);
        steps.clickCountOfNights();
        steps.addMinCountNights(true);
        steps.add2Nights(true);
        steps.clickSearchButton("Viet");
        steps.checkVisibleHeadingOfEmptyToursList("Именно таких туров не нашлось");
        //steps.isVisibleHotelStarsList();
    }

    @Test
    public void searchToursWithNotDefaultStartPlace() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(5);
        steps.clickStartPlaceInput();
        steps.clearStartPlaceInput();
        steps.clickSelectingStartPlace("Самара");
        steps.clickSearchButton("Rus");
        steps.checkGetToursList();
    }

    @Test
    public void searchToursWithLastDDVarStartPlace() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(5);
        steps.clickStartPlaceInput();
        steps.clearStartPlaceInput();
        steps.clickSelectingStartPlace("Тюмень");
        steps.clickSearchButton("Rus");
        steps.checkGetToursList();
    }

    @Test
    public void correctFindRussiaToursComplete() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(5);
        steps.clickCalendarInput();
        steps.clickAdd2Days();
        steps.selectCalendarDate(4, 2, 1);
        steps.clickCountOfNights();
        steps.plusNight();
        steps.minusNight();
        steps.add2Nights(true);
        steps.clickCountOfPassengers();
        steps.selectVariationAddChild(9);
        steps.clickStartPlaceInput();
        steps.clearStartPlaceInput();
        steps.clickSelectingStartPlace("Самара");
        steps.clickSearchButton("Rus");
        steps.isEnabledSearchInput();
    }

    @Test
    public void checkTypeInto() {
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(5);
        steps.typeIntoString("Самара"); //Метод typeInto() прекрасно работает из коробки!!!
        steps.clickSearchButton("Rus");
        steps.isEnabledSearchInput();
    }
}
