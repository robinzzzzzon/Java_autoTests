package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.BuyInstructable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class BuyInstructFragmentPage extends AbstractBasePage implements BuyInstructable {

    BaseMethods methods = new BaseMethods();

    private List<WebElementFacade> getStepList(){
        return methods.getAnyList(stepsList);
    }

    public void selectAnyStep(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getStepList());
    }

    public void selectFirstAndLastSteps(){
        methods.selectFirstAndLastElements(getStepList());
    }

    public void selectAllSteps(){
        methods.selectAllElements(getStepList());
    }

    ///////////////////////////////////////////////

    public void selectPrevStep(){
        methods.selectAnyElement(prevStep);
    }

    public void selectNextStep(){
        methods.selectAnyElement(nextStep);
    }
}
