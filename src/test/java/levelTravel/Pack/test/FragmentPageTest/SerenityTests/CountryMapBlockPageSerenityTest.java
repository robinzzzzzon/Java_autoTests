package levelTravel.Pack.test.FragmentPageTest.SerenityTests;

import levelTravel.Pack.Steps.CountryMapBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CountryMapBlockPageSerenityTest {

    @Steps
    CountryMapBlockSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void clickMaxButton(){
        steps.openPage();
        steps.clickMaximizeButton();
        steps.isCardEnable();
    }

    @Test
    public void clickZoomInAndOut(){
        steps.openPage();
        steps.clickMaximizeButton();
        steps.clickZoomIn();
        steps.clickZoomOut();
        steps.isMainCanvasVisible();
    }

    @Test
    public void clickTheaterAndShops(){
        steps.openPage();
        steps.clickMaximizeButton();
        steps.clickShoppingButton();
        steps.clickTheaterButton();
        steps.isCardMarkerPresent();
    }

    @Test
    public void selectDynamicGraphs(){
        steps.openPage();
        steps.clickMaximizeButton();
        steps.selectAnyDynamicGraph(steps.getAnyDynamicGraph(3));
        steps.isEnableOneOfContentList(0);
    }
}