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
    public void refreshStartPage() {
        find(levelTravelLink).click();
    }

    public void clickNumberField() {
        find(numberField).click();
    }

    public void clickRecallMeButton() {
        find(recallMeButton).click();
    }

    public void clickRecallMeRightNow() {
        find(recallMeRightNow).click();
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

    public void clickHeaderServices() {
        find(headerServices).click();
    }

    private List<WebElementFacade> getServicesList() {
        return findAll(headerServicesDD);
    }

    public PromoPage selectAnyService(int serviceNumber) {
        selectAnyFromAnyList(getServicesList(), serviceNumber);
        return new PromoPage();
    }

    /////////////////////////////////////
    //Работаем с дропдауном "Мой список":

    public void clickHeaderMyWishList() {
        find(headerMyWishList).click();
    }

    public String getTextPartOfWishList(int wishListNumber) {
        List<WebElementFacade> webElements = findAll(headerMyWishListDescription);
        return webElements.get(wishListNumber - 1).getText();
    }

    /////////////////////////////////
    //Работаем с дропдауном "Помощь":

    public void clickHeaderHelper() {
        find(headerHelper).click();
    }

    private List<WebElementFacade> getHelperList() {
        return findAll(headerHelperDD);
    }

    public PressPage selectAnyHelper(int helperNumber) {
        selectAnyFromAnyList(getHelperList(), helperNumber);
        return new PressPage();
    }

    //////////////////////////////
    //Раздел "Вход":

    public void clickHeaderExit() {
        find(headerExit).click();
    }

    public String getMailHeadingExitText() {
        return find(mailHeadingExit).getText();
    }

    public void writeMailInputExit(String string) {
        find(mailInputExit).sendKeys(string);
    }

    /////////////////////////////
    //Работа с элементами при регистрации/входе уже зарегистрированного пользователя:

    public void clickGoOnButton() {
        WebElement element = find(goOnButton);
        if (element.isEnabled()) {
            element.click();
        }
    }

    public void clickRegisterButton() {
        find(registryButton).click();
    }

    public void clickToCross() {
        find(cross).click();
    }

    public String getTextEmptyFieldError() {
        return find(emptyFieldError).getText();
    }

//    public void verifySignUpButtonVisibility(){
//        WebElement element = find(signUpButton);
//        if (element.isEnabled()){
//            clickToCross();
//        }
//    }

    public FaceBookPage clickFaceBookLink() {
        find(fbButton).click();
        return new FaceBookPage();
    }

    public VKPage clickVKLink() {
        find(vkButton).click();
        return new VKPage();
    }


    public void writePassInput(String pass) {
        find(signUpInputPass).sendKeys(pass);
    }

    public void clickSignUpButton() {
        find(signUpButton).click();
    }

    ////////////////////////////////////////////////////////

    private void selectAnyFromAnyList(List<WebElementFacade> list, int number){
        WebElement element = list.get(number - 1);
        element.click();
    }

}
