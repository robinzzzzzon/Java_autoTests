package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.PortuSearcherPage.Classes.FlameToursFragmentPage;
import levelTravel.Pack.Pages.PortuSearcherPage.Classes.LinerFragmentPage;
import net.thucydides.core.annotations.Step;

public class FlameSteps {

    private FlameToursFragmentPage page;
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
    public void selectAnyCity(int anyNumber){
        page.selectAnyCity(anyNumber);
    }

    @Step
    public void selectFirstAndLastCity(){
        page.selectFirstAndLastCity();
    }

    @Step
    public void selectAllCities(){
        page.selectAllCities();
    }

    //////////////////////////////////////

    @Step
    public String getAnyToursName(int anyNumber){
        return page.getAnyToursName(anyNumber);
    }

    //////////////////////////////////////

    @Step
    public String getAnyToursRate(int anyNumber){
        return page.getAnyToursRate(anyNumber);
    }

    //////////////////////////////////////

    @Step
    public String getAnyPrice(int anyNumber){
        return page.getAnyPrice(anyNumber);
    }

    //////////////////////////////////////

    @Step
    public String getAnyCurrency(int anyNumber){
        return page.getAnyCurrency(anyNumber);
    }

    /////////////////////////////////////

    @Step
    public String getAnyPriceForCountOfPeoples(int anyNumber){
       return page.getAnyPriceForCountOfPeoples(anyNumber);
    }

    ////////////////////////////////////////

    @Step
    public String getAnyDate(int anyNumber) {
        return page.getAnyDate(anyNumber);
    }

    ///////////////////////////////////////

    @Step
    public String getAnyCountOfNights(int anyNumber) {
       return page.getAnyCountOfNights(anyNumber);
    }

    ///////////////////////////////////////

    @Step
    public void selectAnyTourFromFlameList(int anyNumber){
        page.selectAnyTourFromFlameList(anyNumber);
    }

    //////////////////////////////////////

    @Step
    public void clickShowMoreButton(){
        page.clickShowMoreButton();
    }
}
