package levelTravel.Pack.test.FragmentPageTest.SerenityTests;

import levelTravel.Pack.Steps.StartBestPriceBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class StartBestPriceSerenityTest {

    @Steps
    StartBestPriceBlockSteps steps;

    @Managed
    WebDriver driver;


    @Test
    public void selectAnyStartCity(){
        steps.openPage();
        steps.clickCityStartDD();
        steps.selectAnyStartCity(3);
        steps.checkVisibleElementOfStartCity(3);
    }

    @Test
    public void selectAnyCountOfNights(){
        steps.openPage();
        steps.selectAnyCountOfNights(4);
        steps.checkGraphIsEmpty();
    }

    @Test
    public void selectAnyCountry(){
        steps.openPage();
        steps.selectAnyCountry(2);
        steps.checkGraphSize(10);
    }

    @Test
    public void selectAnyPriceOfGraph(){
        steps.openPage();
        steps.getThisWindowHandle();
        steps.selectAnyPriceOfGraph(7, "Turk");
        steps.switchToNextWindow();
        steps.containTextOfHeading();
    }
}
