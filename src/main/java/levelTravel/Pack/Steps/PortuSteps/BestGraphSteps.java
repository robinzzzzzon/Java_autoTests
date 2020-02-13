package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.PortuSearcherPage.Classes.BestGraphFragmentPage;
import net.thucydides.core.annotations.Step;

public class BestGraphSteps {

    private BestGraphFragmentPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickMonthPrev(){
        page.clickMonthPrev();
    }

    @Step
    public void clickMonthNext(){
        page.clickMonthNext();
    }

    @Step
    public void clickMonthPrevFew(int anyCount){
        page.clickMonthPrevFew(anyCount);
    }

    @Step
    public void clickMonthNextFew(int anyCount){
        page.clickMonthNextFew(anyCount);
    }

    @Step
    public String getCurrentMonthText(){
        return page.getCurrentMonthText();
    }

    @Step
    public void selectAnyPriceFromGraph(int anyNumber){
        page.selectAnyPriceFromGraph(anyNumber);
    }

    @Step
    public void selectPriceGraphPrev(){
        page.selectPriceGraphPrev();
    }

    @Step
    public void selectPriceGraphNext(){
        page.selectPriceGraphNext();
    }

    @Step
    public void clickPriceGraphPrevFew(int anyNumber){
        page.clickPriceGraphPrevFew(anyNumber);
    }

    @Step
    public void clickPriceGraphNextFew(int anyNumber){
        page.clickPriceGraphNextFew(anyNumber);
    }
}
