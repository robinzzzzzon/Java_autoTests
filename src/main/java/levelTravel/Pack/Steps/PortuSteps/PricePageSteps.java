package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.PortuSearcherPage.Classes.PricesFragmentPage;
import net.thucydides.core.annotations.Step;

public class PricePageSteps {

    PricesFragmentPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickLinerNumber(int anyNumber){
        page.clickAnyLabelOfLiner(anyNumber);
    }

    @Step
    public void selectAnyTableValueByNumber(int rowNumber, int columnNumber){
       page.selectAnyTableValueByNumber(rowNumber, columnNumber);
    }

    @Step
    public void selectAnyTableValueByHeading(int rowNumber, String columnName){
        page.selectAnyTableValueByHeading(rowNumber, columnName);
    }

    ////////////////////////////////////////////

    @Step
    public void clickGuaranteeLink(){
        page.clickGuaranteeLink();
    }

    @Step
    public void clickToGuaranteeCross(){
        page.clickToGuaranteeCross();
    }

    /////////////////////////////////////////////

    @Step
    public void clickExchangeLeftDD(){
        page.clickExchangeLeftDD();
    }

    @Step
    public void selectAnyLeftExOption(int anyNumber){
        page.selectAnyLeftExOption(anyNumber);
    }

    @Step
    public void clickExchangeRightDD(){
        page.clickExchangeRightDD();
    }

    @Step
    public void selectAnyRightExOption(int anyNumber){
        page.selectAnyRightExOption(anyNumber);
    }

    @Step
    public void writeToLeftCurInput(String anySum){
        page.writeToLeftCurInput(anySum);
    }

    @Step
    public void writeToRightCurInput(String anySum){
        page.writeToRightCurInput(anySum);
    }

    /////////////////////////////////////////////////////

    @Step
    public void clickPortugalWidget(){
        page.clickPortugalWidget();
    }

    @Step
    public void closeWidget(){
        page.closeWidget();
    }

    @Step
    public void clickToPrevPhoto(){
        page.clickToPrevPhoto();
    }

    @Step
    public void clickToNextPhoto(){
        page.clickToNextPhoto();
    }
}
