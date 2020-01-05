package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.StartUpPage.Classes.StartBestPriceBlockPage;
import net.thucydides.core.annotations.Step;

public class StartBestPriceBlockSteps {

    StartBestPriceBlockPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickCityStartDD(){
        page.clickCityStartDD();
    }

    @Step
    public void selectAnyStartCity(int number){
        page.selectAnyStartCity(number);
    }

    @Step
    public void selectAnyCountOfNights(int number){
        page.selectAnyCountOfNights(number);
    }

    @Step
    public void selectAnyCountry(int number){
        page.selectAnyCountry(number);
    }

    @Step
    public void selectAnyPriceOfGraph(int number, String countryName){
        page.selectAnyPriceOfGraph(number, countryName);
    }
}
