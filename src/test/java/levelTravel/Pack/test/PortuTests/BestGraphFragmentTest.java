package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.BestGraphSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BestGraphFragmentTest {

    @Steps
    private BestGraphSteps steps;

    @Managed
    private WebDriver driver;

    @Test
    public void clickPrevAndNextMonth(){
        steps.openPage();
        steps.clickAnyLinerNumber(4);
        //steps.clickMonthPrev();
        steps.clickMonthNext();
    }

    @Test
    public void getTextOfCurrentMonth(){
        steps.openPage();
        steps.clickAnyLinerNumber(4);
        steps.getCurrentMonthText();
    }

    @Test //Поработать над базовым методом неск. кликов!
    public void clickNextOrPrevElementFew(){
        steps.openPage();
        steps.clickAnyLinerNumber(4);
        steps.clickMonthNextFew(5);
        //steps.clickMonthPrevFew(4);
    }

    @Test
    public void selectAnyPriceOfGraph(){
        steps.openPage();
        steps.clickAnyLinerNumber(4);
        steps.selectAnyPriceFromGraph(9);
    }

    @Test
    public void clickPrevAndNextGraphMonthFew(){
        steps.openPage();
        steps.clickAnyLinerNumber(4);
        steps.clickPriceGraphNextFew(3);
        //steps.clickPriceGraphPrevFew(4);
    }

    @Test
    public void clickPrevAndNextGraphMonth(){
        steps.openPage();
        steps.clickAnyLinerNumber(4);
        steps.selectPriceGraphNext();
    }
}
