package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersFragmentPage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.PortuSearcherPage.Classes.BestGraphFragmentPage;
import levelTravel.Pack.Pages.PortuSearcherPage.Classes.LinerFragmentPage;
import levelTravel.Pack.Pages.PortuSearcherPage.Classes.PricesFragmentPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class WholeSteps {

    BaseMethods methods = new BaseMethods();

    private LinerFragmentPage linerPage;
    private PricesFragmentPage pricePage;
    private BestGraphFragmentPage bestGraphPage;
    private CountryFiltersFragmentPage filtersPage;
    private CountryFiltersFragmentPage countryFiltersFragmentPage;

    @Step
    public void openPage(){
        linerPage.open();
    }

    @Step
    public void clickAnyLabelOfLiner(int anyNumber){
        linerPage.clickAnyLabelOfLiner(anyNumber);
    }

    @Step
    public void clickExchangeLeftDD(){
        pricePage.clickExchangeLeftDD();
    }

    @Step
    public void selectAnyLeftExOption(int anyNumber){
        pricePage.selectAnyLeftExOption(anyNumber);
    }

    @Step
    public void clickExchangeRightDD(){
        pricePage.clickExchangeRightDD();
    }

    @Step
    public void selectAnyRightExOption(int anyNumber){
        pricePage.selectAnyRightExOption(anyNumber);
    }

    @Step
    public void clickMonthNextFew(int anyNumber){
        bestGraphPage.clickMonthNextFew(anyNumber);
    }

    @Step
    public void selectAnyPriceFromGraph(int anyNumber){
        bestGraphPage.selectAnyPriceFromGraph(anyNumber);
    }

    @Step
    public void selectAnyPriceTower(int anyNumber){
        filtersPage.selectAnyPriceTower(anyNumber);
    }

    @Step
    public void selectAnyPriceTowerr(int number) {
        countryFiltersFragmentPage.waitForRenderedElements(By.xpath("//div[@class='filter-budget__cols']//button"));
        countryFiltersFragmentPage.selectAnyPriceTower(number);
    }

    //////////////////////////////////////////////////////

    //Стэпы-хэлперы:
    //Вынести так же в класс BaseMethods
    @Step
    public String getWindowHandle() {
        return bestGraphPage.getDriver().getWindowHandle();
    }

    @Step
    public void switchToNextWindow() {
        for (String windowHandle : bestGraphPage.getDriver().getWindowHandles()) {
            bestGraphPage.getDriver().switchTo().window(windowHandle);
        }
    }

    @Step
    public void switchBack(String backHandle) {
        countryFiltersFragmentPage.getDriver().switchTo().window(backHandle);
    }

    @Step
    void navigateBack() {
        countryFiltersFragmentPage.getDriver().navigate().back();
    }

}
