package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.PortuSearcherPage.Classes.BuyInstructFragmentPage;
import levelTravel.Pack.Pages.PortuSearcherPage.Classes.LinerFragmentPage;
import net.thucydides.core.annotations.Step;

public class BuyInstructSteps {

    private BuyInstructFragmentPage page;
    private LinerFragmentPage lPage;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickAnyLinerNumber(int anyNumber){
        lPage.clickAnyLabelOfLiner(anyNumber);
    }

    @Step
    public void selectAnyStep(int anyNumber){
        page.selectAnyStep(anyNumber);
    }

    @Step
    public void selectFirstAndLastSteps(){
        page.selectFirstAndLastSteps();
    }

    @Step
    public void selectAllSteps(){
        page.selectAllSteps();
    }

    ///////////////////////////////////////////////

    @Step
    public void selectPrevStep(){
        page.selectPrevStep();
    }

    @Step
    public void selectNextStep(){
        page.selectNextStep();
    }
}
