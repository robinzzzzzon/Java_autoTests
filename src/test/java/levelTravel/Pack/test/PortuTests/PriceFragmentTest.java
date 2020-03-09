package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.PriceSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class PriceFragmentTest {

    @Steps
    private PriceSteps steps;


    @Managed
    private WebDriver driver;

    @Test
    public void clickNextPhoto(){
        steps.openPage();
        steps.clickLinerNumber(2);
        steps.clickToNextPhoto();
    }

    @Test
    public void clickPrevPhoto(){
        steps.openPage();
        steps.clickLinerNumber(2);
        steps.clickToPrevPhoto();
    }

    @Test
    public void selectAnyPriceFromCell(){
        steps.openPage();
        steps.clickLinerNumber(2);
        steps.selectAnyTableValueByNumber(2, 3);
    }

    @Test
    public void selectAnyPriceFromCellByHeading(){
        steps.openPage();
        steps.clickLinerNumber(2);
        steps.selectAnyTableValueByHeading(2, "Март");
    }

    @Test
    public void readGuarantee(){
        steps.openPage();
        steps.clickLinerNumber(2);
        steps.clickGuaranteeLink();
        steps.clickToGuaranteeCross();
    }

    @Test
    public void selectLeftAndRightCurrency(){
        steps.openPage();
        steps.clickLinerNumber(2);
        steps.clickExchangeLeftDD();
        steps.selectAnyLeftExOption(2);
        steps.clickExchangeRightDD();
        steps.selectAnyRightExOption(3);
    }

    @Test
    public void writeSumInSumFields(){
        steps.openPage();
        steps.clickLinerNumber(2);
        steps.writeToLeftCurInput("5000");
        steps.writeToRightCurInput("444");
    }

    @Test
    public void lookToPortugalWidget(){
        steps.openPage();
        steps.clickLinerNumber(3);
        steps.clickPortugalWidget();
        //steps.closeWidget();
    }
}
