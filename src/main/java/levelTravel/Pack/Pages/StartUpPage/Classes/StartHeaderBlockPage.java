package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.Headerable;
import levelTravel.Pack.Pages.StartUpPage.SubPages.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

@DefaultUrl("https://level.travel/")
public class StartHeaderBlockPage extends AbstractBasePage implements Headerable {

    /////////////////////////////////
    //Методы по работе с полем номера телефона:

    @Override
    public StartHeaderBlockPage refreshStartPage() {
        find(levelTravelLink).click();
        return new StartHeaderBlockPage();
    }

    public StartHeaderBlockPage clickNumberField() {
        find(numberField).click();
        return this;
    }

    public StartHeaderBlockPage clickRecallMeButton(){
        find(recallMeButton).click();
        return this;
    }

    public StartHeaderBlockPage clickRecallMeRightNow() {
        find(recallMeRightNow).click();
        return this;
    }

    public WhatsUpPage clickMessageIcon() {
        find(linkWhatsUp).click();
        return new WhatsUpPage();
    }

    public String readRecallMeHeading() {
        return find(recallMeHeading).getText();
    }

    //////////////////////////////////
    //Работаем с дропдауном "Сервисы":

    public StartHeaderBlockPage clickHeaderServices(){
        find(headerServices).click();
        return this;
    }

    public WebElement selectHeaderServicesDD(int serviceNumber){
        List<WebElementFacade> webElements = findAll(headerServicesDD);
        return webElements.get(serviceNumber - 1);
    }

    public PromoPage clickSelectingServices(@NotNull WebElement webElement){
        webElement.click();
        return new PromoPage();
    }

    /////////////////////////////////////
    //Работаем с дропдауном "Мой список":

    public StartHeaderBlockPage clickHeaderMyWishList(){
        find(headerMyWishList).click();
        return this;
    }

    public WebElement selectingPartOfHeaderMyWishList(int wishListNumber){
        List<WebElementFacade> webElements = findAll(headerMyWishListDescription);
        return webElements.get(wishListNumber -1);
    }

    public String readSelectingWishList(@NotNull WebElement webElement){
        return webElement.getText();
    }

    /////////////////////////////////
    //Работаем с дропдауном "Помощь":

    public StartHeaderBlockPage clickHeaderHelper(){
        find(headerHelper).click();
        return this;
    }

    public WebElement readHeaderHelper(int helperNumber){
        List<WebElementFacade> webElements = findAll(headerHelperDD);
        return webElements.get(helperNumber -1);
    }

    public PressPage clickSelectingHelper(@NotNull WebElement webElement){
        webElement.click();
        return new PressPage();
    }

    //////////////////////////////
    //Раздел "Вход":

    public StartHeaderBlockPage clickHeaderExit(){
        find(headerExit).click();
        return this;
    }

    public String getMailHeadingExitText(){
        return find(mailHeadingExit).getText();
    }

    public StartHeaderBlockPage writeMailInputExit(String string){
        find(mailInputExit).sendKeys(string);
        return this;
    }

    /////////////////////////////
    //Работа с элементами при регистрации/входе уже зарегистрированного пользователя:

    public StartHeaderBlockPage clickGoOnButton(){
        WebElement element = find(goOnButton);
        if(element.isEnabled()){
            element.click();
        }
        return this;
    }

    public StartHeaderBlockPage clickRegisterButton(){
        find(registryButton).click();
        return this;
    }

    public StartHeaderBlockPage clickToCross(){
        find(cross).click();
        return this;
    }

    public String getTextEmptyFieldError(){
        return find(By.xpath("//div[@class='simple_tooltip_body']")).getText();
    }

    public StartHeaderBlockPage verifySignUpButtonVisibility(){
        WebElement element = find(signUpButton);
        if (element.isEnabled()){
            clickToCross();
        }
        return this;
    }

    public FaceBookPage clickFaceBookLink(){
        find(fbButton).click();
        return new FaceBookPage();
    }

    public VKPage clickVKLink(){
        find(vkButton).click();
        return new VKPage();
    }


    public StartHeaderBlockPage writePassInput(String pass) {
        find(signUpInputPass).sendKeys(pass);
        return this;
    }

    public void clickSignUpButton(){
        find(signUpButton).click();
    }

}
