package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.PortuSearcherPage.Classes.LinerFragmentPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class LinerPageSteps {

    LinerFragmentPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void getHeadingText(){
        page.getHeadingText();
    }

    @Step
    public void clickAnyLabelOfLiner(int anyNumber){
        page.clickAnyLabelOfLiner(anyNumber);
    }

    @Step
    public void getAnyTextOfFacts(int number){
        page.getAnyTextOfFacts(number);
    }

    @Step
    public void selectAnyCityFromList(int number){
        page.selectAnyCityFromList(number);
    }

    @Step
    public List<WebElementFacade> getMonthLabelList(){
        return page.getMonthLabelList();
    }

    @Step
    public List<WebElementFacade> getMonthIconList(){
        return page.getMonthIconList();
    }
}
