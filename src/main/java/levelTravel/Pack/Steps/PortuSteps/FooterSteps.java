package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.PortuSearcherPage.Classes.FooterFragmentPage;
import levelTravel.Pack.Pages.PortuSearcherPage.Classes.LinerFragmentPage;
import net.thucydides.core.annotations.Step;

public class FooterSteps {

    private FooterFragmentPage page;
    private LinerFragmentPage lPage;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void selectAnyLinerNumber(int number){
        lPage.clickAnyLabelOfLiner(number);
    }

    @Step
    public void selectAnyElementFromCompanyList(int anyNumber){
        page.selectAnyElementFromCompanyList(anyNumber);
    }

    @Step
    public void selectAnyElementFromInstrumentsList(int anyNumber){
        page.selectAnyElementFromInstrumentsList(anyNumber);
    }

    @Step
    public void selectAnyElementFromHelperList(int anyNumber){
        page.selectAnyElementFromHelperList(anyNumber);
    }

    @Step
    public void selectGuaranteeLink(){
        page.selectGuaranteeLink();
    }

    @Step
    public void selectAnySocial(int number){
        page.selectAnySocial(number);
    }

    @Step
    public void selectGooglePlayLink(){
        page.selectGooglePlayLink();
    }

    @Step
    public void selectAppStoreLink(){
        page.selectAppStoreLink();
    }

    @Step
    public void getTextInfo(){
        page.getTextInfo();
    }

    @Step
    public void selectLawLink(){
        page.selectLawLink();
    }

    @Step
    public void selectSkLink(){
        page.selectSkLink();
    }
}
