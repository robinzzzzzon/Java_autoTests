package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchBlockPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StartSearchBlockSteps {

    StartSearchBlockPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void writeAnyCountryName(String anyCountryName){
        page.writeAnyCountryName(anyCountryName);
    }

    @Step
    public void clickCountryInput(){
        page.clickCountryInput();
    }

    @Step
    public WebElement getPopularCountry(int elementNumber){
        return page.getPopularCountry(elementNumber);
    }

    @Step
    public void clickGettingPopularCountry(WebElement webElement){
        page.clickGettingPopularCountry(webElement);
    }

    @Step
    public WebElement getWholeCountry(int elementNumber){
        return page.getWholeCountry(elementNumber);
    }

    @Step
    public void clickGettingWholeCountry(WebElement webElement){
        page.clickGettingWholeCountry(webElement);
    }

    @Step
    public List<WebElementFacade> getErrorList(){
        return page.getErrors();
    }

    @Step
    public String getErrorByText(int errorNumber){
        return page.getErrorByText(errorNumber);
    }

    @Step
    public boolean checkIsErrorVisible(String message){
        return page.isErrorVisible(message);
    }

    @Step
    public void clickCalendarInput(){
        page.clickCalendarInput();
    }

    @Step
    public WebElement getCalendarDateForWholeYear(int row, int column, int countSwitch){
        return page.getCalendarDateForWholeYear(row, column, countSwitch);
    }

    @Step
    public void clickAdd2Days(){
        page.clickAdd2Days();
    }

    @Step
    public void selectCalendarDate(WebElement webElement){
        page.selectCalendarDate(webElement);
    }

    @Step
    public void clickCountOfNights(){
        page.clickCountOfNights();
    }

    @Step
    public void minusNight(){
        page.minusNight();
    }

    @Step
    public void plusNight(){
        page.plusNight();
    }

    @Step
    public void add2Nights(boolean b){
        page.add2Nights(b);
    }

    @Step
    public void clickCountOfPassengers(){
        page.clickCountOfPassengers();
    }

    @Step
    public void addChildren(){
        page.addChildren();
    }

    @Step
    public WebElement getVariableAddChildren(int variationChild){
        return page.getVariableAddChildren(variationChild);
    }

    @Step
    public void selectVariationAddChild(WebElement webElement){
        page.selectVariationAddChild(webElement);
    }

    @Step
    public void minusPassenger(){
        page.minusPassenger();
    }

    @Step
    public void plusPassenger(){
        page.plusPassenger();
    }

    @Step
    public void clickStartPlaceInput(){
        page.clickStartPlaceInput();
    }

    @Step
    public void clearStartPlaceInput(){
        page.clearStartPlaceInput();
    }

    @Step
    public void writeStartPlaceInput(String anyPlace){
        page.writeStartPlaceInput(anyPlace);
    }

    @Step
    public void clickSelectingStartPlace(String startPlace){
        page.clickSelectingStartPlace(startPlace);
    }

    @Step
    public void clickSearchButton(String countryName){
        page.clickSearchButton(countryName);
    }

    @Step
    public void clickConfirmButtonWithAnyEmptyFields(){
        page.clickConfirmButtonWithAnyEmptyFields();
    }



}
