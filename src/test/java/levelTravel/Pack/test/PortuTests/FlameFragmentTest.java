package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.FlameSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class FlameFragmentTest {

    @Steps
    private FlameSteps steps;

    @Managed
    private WebDriver driver;

    @Test
    public void clickAnyFlameTourCity(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.selectAnyCity(2);
    }

    @Test
    public void clickFirstAndLastFlameTourCities(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.selectFirstAndLastCity();
    }

    @Test
    public void clickAllFlameTourCities(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.selectAllCities();
    }

    @Test
    public void getAnyTourName(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.getAnyToursName(2);
    }

    @Test
    public void getAnyTourRate(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.getAnyToursRate(2);
    }

    @Test
    public void getAnyPrice(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.getAnyPrice(2);
    }

    @Test
    public void getAnyCurrency(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.getAnyCurrency(2);
    }

    @Test
    public void getAnyPriceForCountOfPeoples(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.getAnyPriceForCountOfPeoples(2);
    }

    @Test
    public void getAnyDate(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.getAnyDate(2);
    }

    @Test
    public void getAnyCountOfNights(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.getAnyCountOfNights(2);
    }

    @Test
    public void selectAnyTourFromFlameList(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.selectAnyTourFromFlameList(2);
    }

    @Test
    public void clickShowMoreButton(){
        steps.openPage();
        steps.clickAnyLinerNumber(7);
        steps.clickShowMoreButton();
    }




}
