package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.BuyInstructSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BuyInstructTests {

    @Steps
    private BuyInstructSteps steps;

    @Managed
    private WebDriver driver;

    @Test
    public void selectAnyStep(){
        steps.openPage();
        steps.clickAnyLinerNumber(5);
        steps.selectAnyStep(2);
    }

    @Test
    public void selectFirstAndLastSteps(){
        steps.openPage();
        steps.clickAnyLinerNumber(5);
        steps.selectFirstAndLastSteps();
    }

    @Test
    public void selectAllSteps(){
        steps.openPage();
        steps.clickAnyLinerNumber(5);
        steps.selectAllSteps();
    }

    @Test
    public void selectNextStep(){
        steps.openPage();
        steps.clickAnyLinerNumber(5);
        steps.selectNextStep();
    }

    @Test
    public void selectPrevStep(){
        steps.openPage();
        steps.clickAnyLinerNumber(5);
        steps.selectNextStep();
        steps.selectPrevStep();
    }
}
