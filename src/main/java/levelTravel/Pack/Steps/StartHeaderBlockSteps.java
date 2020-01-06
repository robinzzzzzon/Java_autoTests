package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.StartUpPage.Classes.StartHeaderBlockPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class StartHeaderBlockSteps {

    StartHeaderBlockPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void refreshStartPage(){
        page.refreshStartPage();
    }

    @Step
    public void clickNumberField(){
        page.clickNumberField();
    }

    @Step
    public void clickRecallMeButton(){
        page.clickRecallMeButton();
    }

    @Step
    public void clickRecallMeRightNow(){
        page.clickRecallMeRightNow();
    }

    @Step
    public void clickMessageIcon() {
        page.clickMessageIcon();
    }

    @Step
    public void readRecallMeHeading(){
        page.readRecallMeHeading();
    }

    @Step
    public void clickHeaderServices(){
        page.clickHeaderServices();
    }

    @Step
    public void selectHeaderServicesDD(int serviceNumber){
        page.selectHeaderServicesDD(serviceNumber);
    }

    @Step
    public void clickSelectingServices(WebElement webElement){
        page.clickSelectingServices(webElement);
    }

    @Step
    public void clickHeaderMyWishList(){
        page.clickHeaderMyWishList();
    }

    @Step
    public void selectingPartOfHeaderMyWishList(int number){
        page.selectingPartOfHeaderMyWishList(number);
    }

    @Step
    public void readSelectingWishList(WebElement webElement){
        page.readSelectingWishList(webElement);
    }

    @Step
    public void clickHeaderHelper(){
        page.clickHeaderHelper();
    }

    @Step
    public WebElement readHeaderHelper(int number){
        return page.readHeaderHelper(number);
    }

    @Step
    public void clickSelectingHelper(WebElement webElement){
        page.clickSelectingHelper(webElement);
    }

    @Step
    public void clickHeaderExit(){
        page.clickHeaderExit();
    }

    @Step
    public void getMailHeadingExitText(){
        page.getMailHeadingExitText();
    }

    @Step
    public void writeMailInputExit(String email){
        page.writeMailInputExit(email);
    }

    @Step
    public void clickGoOnButton(){
        page.clickGoOnButton();
    }

    @Step
    public void clickRegisterButton(){
        page.clickRegisterButton();
    }

    @Step
    public void clickToCross(){
        page.clickToCross();
    }

    @Step
    public void getTextEmptyFieldError(){
        page.getTextEmptyFieldError();
    }

    @Step
    public void clickFaceBookLink(){
        page.clickFaceBookLink();
    }

    @Step
    public void clickVKLink(){
        page.clickVKLink();
    }

    @Step
    public void writePassInput(String pass){
        page.writePassInput(pass);
    }

    @Step
    public void clickSignUpButton(){
        page.clickSignUpButton();
    }
}
