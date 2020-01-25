package levelTravel.Pack.test;

import levelTravel.Pack.Steps.StartPageSteps.StartBestPriceBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class StartBestPriceSerenityTest {

    @Steps
    private StartBestPriceBlockSteps steps;

    @Managed
    WebDriver driver;


    @Test
    public void selectAnyStartCity() {
        steps.openPage();
        steps.clickCityStartDD();
        steps.selectAnyStartCity(3);
        steps.checkVisibleElementOfStartCity(3);
    }

    @Test
    public void selectLastStartCity() {
        steps.openPage();
        steps.clickCityStartDD();
        steps.selectLastCity();
        steps.checkGraphIsNotEmpty();
    }

    @Test
    public void selectMinCountOfNights() {
        steps.openPage();
        steps.selectAnyCountOfNights(1);
        steps.checkGraphIsNotEmpty();
    }

    @Test
    public void selectMaxCountOfNights() {
        steps.openPage();
        steps.selectAnyCountOfNights(4);
        steps.checkGraphIsNotEmpty();
    }

    @Test
    public void selectAnyCountryFromStartList() {
        steps.openPage();
        steps.selectAnyCountry(3);
        steps.checkGraphSize(0);
    }

    @Test
    public void selectAnyCountryFromInvisibleList() {
        steps.openPage();
        steps.selectAnyCountry(20);
        steps.checkGraphSize(0);
    }

    @Test
    public void selectAnyPriceOfGraph() {
        steps.openPage();
        steps.getThisWindowHandle();
        steps.selectAnyPriceOfGraph(7, "Turk");
        steps.switchToNextWindow();
        steps.containTextOfHeading();
    }
}
