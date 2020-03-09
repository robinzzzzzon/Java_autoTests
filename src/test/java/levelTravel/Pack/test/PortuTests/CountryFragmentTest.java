package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.CountrySteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CountryFragmentTest {

    @Steps
    private CountrySteps steps;

    @Managed
    private WebDriver driver;

    @Test
    public void selectAnyCountry(){
        steps.openPage();
        steps.selectAnyNumberOfLiner(7);
        steps.selectAnyCountryFromList(8);
    }
}
