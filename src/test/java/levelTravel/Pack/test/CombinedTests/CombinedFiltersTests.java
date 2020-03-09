package levelTravel.Pack.test.CombinedTests;

import levelTravel.Pack.Steps.CombinedSteps.CombinedSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CombinedFiltersTests {

    @Steps
    CombinedSteps steps;

    @Managed //(driver = "chrome")
    WebDriver driver;

    @Test
    public void checkTest(){
        steps.openPage();
        steps.clickCountryInput();
        steps.selectPopularCountry(1);
        steps.clickSearchButton("Турция");
        steps.selectAnyPriceTower(2);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void checkTest2(){
        steps.openPage();
        steps.clickCountryInput();
        steps.selectPopularCountry(1);
        steps.clickSearchButton("Турция");
        steps.checkToursResultGreaterNull();
        steps.clickAnyHotelPriceLink(3);
        steps.getCurrentHandle();
        steps.switchToNextHandle();
        steps.selectAnyPhoto(1);
        steps.switchToInitHandle();
    }
}
