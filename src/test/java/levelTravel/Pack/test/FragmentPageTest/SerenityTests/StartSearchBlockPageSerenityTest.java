package levelTravel.Pack.test.FragmentPageTest.SerenityTests;

import levelTravel.Pack.Steps.StartSearchBlockSteps;
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
    public void correctFindTurkeyToursForFamilyWithoutChildren(){
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(steps.getPopularCountry(1));
        steps.clickCalendarInput();
        steps.selectCalendarDate(steps.getCalendarDateForWholeYear(4, 3, 2));
        steps.clickSearchButton("Turk");
        steps.checkContainsPartOfHeading("ц");

    }

    @Test
    public void correctFindEgyptToursForFamilyWithChildren(){
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingWholeCountry(steps.getWholeCountry(14));
        steps.clickCalendarInput();
        steps.selectCalendarDate(steps.getCalendarDateForWholeYear(2, 4, 3));
        steps.clickCountOfPassengers();
        steps.selectVariationAddChild(steps.getVariableAddChildren(4));
        steps.clickSearchButton("Egy");
        steps.isDisplayedTransportVariation();
    }

    @Test
    public void correctFindTurkeyToursNotDefCountPassengers(){
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(steps.getPopularCountry(2));
        steps.clickCalendarInput();
        steps.selectCalendarDate(steps.getCalendarDateForWholeYear(2, 4, 1));
        steps.clickCountOfPassengers();
        steps.plusPassenger();
        steps.minusPassenger();
        steps.minusPassenger();
        steps.selectVariationAddChild(steps.getVariableAddChildren(4));
        steps.clickSearchButton("Thai");
        steps.isSelectMomentConfirmSwitcher();
    }

    @Test
    public void correctFindTurkeyToursOnNotDefaultNights(){
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(steps.getPopularCountry(4));
        steps.clickCalendarInput();
        steps.selectCalendarDate(steps.getCalendarDateForWholeYear(3, 2, 3));
        steps.clickCountOfNights();
        steps.minusNight();
        steps.add2Nights(true);
        steps.clickSearchButton("Viet");
        steps.isVisibleHotelStarsList();
    }

    @Test
    public void correctFindTurkeyToursOnNotDefaultStartPlace(){
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(steps.getPopularCountry(5));
        steps.clickCalendarInput();
        steps.selectCalendarDate(steps.getCalendarDateForWholeYear(4, 2, 2));
        steps.clickStartPlaceInput();
        steps.clearStartPlaceInput();
        steps.clickSelectingStartPlace("Самара");
        steps.clickSearchButton("Rus");
        steps.checkGetToursList();
    }

    @Test
    public void correctFindRussiaToursComplete(){
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(steps.getPopularCountry(5));
        steps.clickCalendarInput();
        steps.clickAdd2Days();
        steps.selectCalendarDate(steps.getCalendarDateForWholeYear(4, 2, 1));
        steps.clickCountOfNights();
        steps.plusNight();
        steps.minusNight();
        steps.add2Nights(true);
        steps.clickCountOfPassengers();
        steps.selectVariationAddChild(steps.getVariableAddChildren(9));
        steps.clickStartPlaceInput();
        steps.clearStartPlaceInput();
        steps.clickSelectingStartPlace("Самара");
        steps.clickSearchButton("Rus");
        steps.isEnabledSearchInput();
    }

    @Test
    public void correctFindToursWithWriteCountry() {
        steps.openPage();
        steps.writeAnyCountryName("Рим");
        steps.clickCalendarInput();
        steps.selectCalendarDate(steps.getCalendarDateForWholeYear(3, 2, 2));
        steps.clickCountOfNights();
        steps.add2Nights(true);
        steps.clickCountOfPassengers();
        steps.selectVariationAddChild(steps.getVariableAddChildren(3));
        steps.clickSearchButton("Ita");
        steps.checkEqualHeadingText("Загружаем туры в Рим, Италия");
    }

    @Test
    public void tryFindToursWithEmptyCountryField() {
        steps.openPage();
        steps.clickConfirmButtonWithAnyEmptyFields();
        steps.checkVisibleErrorByAnyEmptyRequiredField();
    }

    @Test
    public void tryFindToursWithNoCreateCountry() {
        steps.openPage();
        steps.writeAnyCountryName("SomePlace");
        steps.clickConfirmButtonWithAnyEmptyFields();
        steps.checkVisibleErrorByAnyEmptyRequiredField();
    }
}
