package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.WholeSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WholeTests {

    @Steps
    private WholeSteps steps;

    @Managed
    private WebDriver driver;

    @Test
    public void selectAnyGraph(){
        steps.openPage();
        steps.clickAnyLabelOfLiner(4);
        steps.clickMonthNextFew(2);
        steps.getWindowHandle();
        steps.selectAnyPriceFromGraph(5);
        steps.switchToNextWindow();
        steps.selectAnyPriceTowerr(2);
    }

}
