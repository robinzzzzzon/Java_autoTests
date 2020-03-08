package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.PortuSearcherPage.Classes.CountriesListFragmentPage;
import levelTravel.Pack.Pages.PortuSearcherPage.Classes.LinerFragmentPage;
import net.thucydides.core.annotations.Step;

public class CountrySteps {

    private CountriesListFragmentPage page;
    private LinerFragmentPage lPage;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void selectAnyNumberOfLiner(int number){
        lPage.clickAnyLabelOfLiner(number);
    }

    @Step
    public void selectAnyCountryFromList(int anyNumber){
        page.selectAnyCountry(anyNumber);
    }
}
