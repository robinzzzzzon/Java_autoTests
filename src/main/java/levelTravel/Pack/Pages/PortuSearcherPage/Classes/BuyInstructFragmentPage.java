package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.BuyInstructable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class BuyInstructFragmentPage extends AbstractBasePage implements BuyInstructable {

    private List<WebElementFacade> getStepList(){
        return findAll(stepsList);
    }

    public void selectAnyStep(int anyNumber){
        selectAnyElementFromAnyList(getStepList(), anyNumber);
    }

    public void selectFirstAndLastSteps(){
        selectFirstAndLastElementsFromAnyList(getStepList());
    }

    public void selectAllSteps(){
        selectAllElementsFromAnyList(getStepList());
    }

    ///////////////////////////////////////////////

    public void selectPrevStep(){
        selectAnyElement(prevStep);
    }

    public void selectNextStep(){
        selectAnyElement(nextStep);
    }

    //////////////////////////////////////////////

    private void selectAnyElement(By by){
        find(by).click();
    }

    private void selectAnyElementFromAnyList(List<WebElementFacade> list, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        element.click();
    }

    private void selectFirstAndLastElementsFromAnyList(List<WebElementFacade> list){
        LinkedList<WebElementFacade> linkedList = new LinkedList<>(list);
        linkedList.getFirst().click();
        linkedList.getLast().click();
    }

    private void selectAllElementsFromAnyList(List<WebElementFacade> list){
        for (WebElementFacade e: list) {
            e.click();
        }
    }
}
