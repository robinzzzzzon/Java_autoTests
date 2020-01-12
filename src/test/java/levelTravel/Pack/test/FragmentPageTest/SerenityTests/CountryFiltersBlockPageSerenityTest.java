package levelTravel.Pack.test.FragmentPageTest.SerenityTests;

import levelTravel.Pack.Steps.CountryFiltersBlockPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CountryFiltersBlockPageSerenityTest {

    @Steps
    CountryFiltersBlockPageSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void selectMomentConfirmationTours(){
        steps.openPage();
        steps.writeMinIntervalPrice("30000");
        steps.writeMaxIntervalPrice("60000");
        steps.checkToursResultGreaterNull(0);
    }

    @Test
    public void selectStarsOfHotel() {
        steps.openPage();
        steps.selectAnyStarsHotel(3, 3);
        steps.selectAnyStarsHotel(3, 3);
        steps.checkIsNotSelectedCheckBox(3);
    }

    @Test
    public void writeHotelNameTest() {
        steps.openPage();
        steps.writeHotelName("Green Nature Diamond Hotel");
        steps.checkToursResultEqually(1);
    }

    @Test
    public void getAnyRatingTest(){
        steps.openPage();
        steps.selectRatingHotel(1);
        steps.selectDistanceToSea(1);
        steps.isEnabledAnyElementOfRateList(1);
        steps.isEnabledAnyElementOfDistanceList(1);
    }

    @Test
    public void privateBeachTest(){
        steps.openPage();
        steps.selectPrivateBeachInput(false);
        steps.checkSelectedPBCheckBox(false);
    }

    @Test
    public void typeBeachTest(){
        steps.openPage();
        steps.selectAllTypeOfBeach();
        steps.checkSizeOfToursList();
    }

    @Test
    public void typeOfFoodTest(){
        steps.openPage();
        steps.selectTypeFood(2);
        steps.isDisplayedAnyCbOfFoodList(2);
    }

    @Test
    public void selectAnyRegion(){
        steps.openPage();
        steps.selectAnyRegion(2);
        steps.isEnabledAnyElementOfRegionList(2);
    }

    @Test
    public void selectAllRegion(){
        steps.openPage();
        steps.selectAllRegions();
        steps.isEnabledAnyElementOfRegionList(5);
    }

    @Test
    public void typeHotelTests(){
        steps.openPage();
        steps.selectHotelType(3);
        steps.checkEqualString("Активный");
    }

    @Test
    public void WiFiTests(){
        steps.openPage();
        steps.selectWiFiInput(2, true);
        steps.isSelectedRbWifi(2);
    }

    @Test
    public void waterGameTest(){
        steps.openPage();
        steps.selectWaterGame(2);

    }

    @Test
    public void hoTelFacilitiesTest(){
        steps.openPage();
        steps.selectHotelFacility(3);
        steps.checkToursResultGreaterNull(0);
    }

    @Test
    public void familyWithChild(){
        steps.openPage();
        steps.selectFamilyWithChildren(2);
        steps.checkToursResultGreaterNull(0);
    }

    @Test
    public void tourOperatorsTest(){
        steps.openPage();
        steps.selectAllTourOperators();
        //countryFiltersPage.selectAnyTourOperator(6);
        steps.isSelectedAnyTourOperator(2);
    }

    @Test
    public void clearFilterTest(){
        //countryFiltersPage.clickAllClearFilter();
//        countryFiltersPage.selectTypeFood(6);
//        countryFiltersPage.clickLocalClearFilter();
        steps.openPage();
        steps.selectRatingHotel(3);
        steps.selectDistanceToSea(2);
        steps.clickFewLocalClearFilter();
        steps.isSelectedAnyFilter(2);
    }

}
