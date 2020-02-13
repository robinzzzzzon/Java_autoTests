package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.LinerPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LinerTests {

    @Steps
    private LinerPageSteps steps;

    @Managed
    private WebDriver driver;

    @Test
    public void selectAnyLinerLabel(){
        steps.openPage();
        steps.clickAnyLabelOfLiner(4);
    }

    @Test
    public void getHeadingText(){
        steps.openPage();
        steps.getHeadingText();
    }

    @Test
    public void getAnyFactText(){
        steps.openPage();
        steps.getAnyTextOfFacts(2);
    }

    @Test
    public void selectAnyCity(){
        steps.openPage();
        steps.selectAnyCityFromList(5);
    }

    @Test
    public void getMonthList(){
        steps.openPage();
        steps.getMonthLabelList();
    }

    @Test
    public void getMonthIconList(){
        steps.openPage();
        steps.getMonthIconList();
    }
}
