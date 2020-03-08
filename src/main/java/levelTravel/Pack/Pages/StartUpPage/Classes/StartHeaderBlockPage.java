package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
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

    BaseMethods methods = new BaseMethods();

    /////////////////////////////////
    //Методы по работе с полем номера телефона:

    @Override
    public void refreshStartPage() {
        methods.selectAnyElement(levelTravelLink);
    }

    public void clickNumberField() {
        methods.selectAnyElement(numberField);
    }

    public void clickRecallMeButton() {
        methods.selectAnyElement(recallMeButton);
    }

    public void clickRecallMeRightNow() {
        methods.selectAnyElement(recallMeRightNow);
    }

    public WhatsUpPage clickMessageIcon() {
        methods.selectAnyElement(linkWhatsUp);
        return new WhatsUpPage();
    }

    public String readRecallMeHeading() {
        return methods.getTextFromAnyElement(recallMeHeading);
    }

    //////////////////////////////////
    //Работаем с дропдауном "Сервисы":

    public void clickHeaderServices() {
        methods.selectAnyElement(headerServices);
    }

    private List<WebElementFacade> getServicesList() {
       return methods.getAnyList(headerServicesDD);
    }

    public PromoPage selectAnyService(int serviceNumber) {
        methods.selectAnyElementFromList(serviceNumber, getServicesList());
        return new PromoPage();
    }

    /////////////////////////////////////
    //Работаем с дропдауном "Мой список":

    public void clickHeaderMyWishList() {
        methods.selectAnyElement(headerMyWishList);
    }

    public String getTextPartOfWishList(int wishListNumber) {
        List<WebElementFacade> webElements = findAll(headerMyWishListDescription);
        return webElements.get(wishListNumber - 1).getText();
    }

    /////////////////////////////////
    //Работаем с дропдауном "Помощь":

    public void clickHeaderHelper() {
        methods.selectAnyElement(headerHelper);
    }

    private List<WebElementFacade> getHelperList() {
        return methods.getAnyList(headerHelperDD);
    }

    public PressPage selectAnyHelper(int helperNumber) {
        methods.selectAnyElementFromList(helperNumber, getHelperList());
        return new PressPage();
    }

    //////////////////////////////
    //Раздел "Вход":

    public void clickHeaderExit() {
        methods.selectAnyElement(headerExit);
    }

    public String getMailHeadingExitText() {
        return methods.getTextFromAnyElement(mailHeadingExit);
    }

    public void writeMailInputExit(String string) {
        methods.writeTextToAnyElement(mailInputExit, string);
    }

    /////////////////////////////
    //Работа с элементами при регистрации/входе уже зарегистрированного пользователя:

    public void clickGoOnButton() {
        methods.selectAnyElement(goOnButton);
    }

    public void clickRegisterButton() {
        methods.selectAnyElement(registryButton);
    }

    public void clickToCross() {
        methods.selectAnyElement(cross);
    }

    public String getTextEmptyFieldError() {
        return methods.getTextFromAnyElement(emptyFieldError);
    }

//    public void verifySignUpButtonVisibility(){
//        WebElement element = find(signUpButton);
//        if (element.isEnabled()){
//            clickToCross();
//        }
//    }

    public FaceBookPage clickFaceBookLink() {
        methods.selectAnyElement(fbButton);
        return new FaceBookPage();
    }

    public VKPage clickVKLink() {
        methods.selectAnyElement(vkButton);
        return new VKPage();
    }


    public void writePassInput(String pass) {
        methods.writeTextToAnyElement(signUpInputPass, pass);
    }

    public void clickSignUpButton() {
        methods.selectAnyElement(signUpButton);
    }

}
