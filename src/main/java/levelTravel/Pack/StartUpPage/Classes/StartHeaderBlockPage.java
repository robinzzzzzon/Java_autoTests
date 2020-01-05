package levelTravel.Pack.StartUpPage.Classes;

import levelTravel.Pack.AbstractPage.AbstractBasePage;
import levelTravel.Pack.StartUpPage.Interfaces.Headerable;
import levelTravel.Pack.StartUpPage.SubPages.*;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class StartHeaderBlockPage extends AbstractBasePage implements Headerable {

    public StartHeaderBlockPage(WebDriver driver) {
        super(driver);
    }

    /////////////////////////////////
    //Методы по работе с полем номера телефона:

    @Override
    public StartHeaderBlockPage refreshStartPage() {
        driver.findElement(levelTravelLink).click();
        return new StartHeaderBlockPage(driver);
    }

    public StartHeaderBlockPage clickNumberField() {
        driver.findElement(numberField).click();
        return this;
    }

    public StartHeaderBlockPage clickRecallMeButton(){
        driver.findElement(recallMeButton).click();
        return this;
    }

    public StartHeaderBlockPage clickRecallMeRightNow() {
        driver.findElement(recallMeRightNow).click();
        return this;
    }

    public WhatsUpPage clickMessageIcon() {
        driver.findElement(linkWhatsUp).click();
        return new WhatsUpPage(driver);
    }

    public String readRecallMeHeading() {
        return driver.findElement(recallMeHeading).getText();
    }

    //////////////////////////////////
    //Работаем с дропдауном "Сервисы":

    public StartHeaderBlockPage clickHeaderServices(){
        driver.findElement(headerServices).click();
        return this;
    }

    public WebElement selectHeaderServicesDD(int serviceNumber){
        List<WebElement> webElements = driver.findElements(headerServicesDD);
        return webElements.get(serviceNumber - 1);
    }

    public PromoPage clickSelectingServices(@NotNull WebElement webElement){
        webElement.click();
        return new PromoPage(driver);
    }

    /////////////////////////////////////
    //Работаем с дропдауном "Мой список":

    public StartHeaderBlockPage clickHeaderMyWishList(){
        driver.findElement(headerMyWishList).click();
        return this;
    }

    public WebElement selectingPartOfHeaderMyWishList(int wishListNumber){
        List<WebElement> webElements = driver.findElements(headerMyWishListDescription);
        return webElements.get(wishListNumber -1);
    }

    public String readSelectingWishList(@NotNull WebElement webElement){
        return webElement.getText();
    }

    /////////////////////////////////
    //Работаем с дропдауном "Помощь":

    public StartHeaderBlockPage clickHeaderHelper(){
        driver.findElement(headerHelper).click();
        return this;
    }

    public WebElement readHeaderHelper(int helperNumber){
        List<WebElement> webElements = driver.findElements(headerHelperDD);
        return webElements.get(helperNumber -1);
    }

    public PressPage clickSelectingHelper(@NotNull WebElement webElement){
        webElement.click();
        return new PressPage(driver);
    }

    //////////////////////////////
    //Раздел "Вход":

    public StartHeaderBlockPage clickHeaderExit(){
        driver.findElement(headerExit).click();
        return this;
    }

    public String getMailHeadingExitText(){
        return driver.findElement(mailHeadingExit).getText();
    }

    public StartHeaderBlockPage writeMailInputExit(String string){
        driver.findElement(mailInputExit).sendKeys(string);
        return this;
    }

    /////////////////////////////
    //Работа с элементами при регистрации/входе уже зарегистрированного пользователя:

    public StartHeaderBlockPage clickGoOnButton(){
        WebElement element = driver.findElement(goOnButton);
        if(element.isEnabled()){
            element.click();
        }
        return this;
    }

    public StartHeaderBlockPage clickRegisterButton(){
        driver.findElement(registryButton).click();
        return this;
    }

    public StartHeaderBlockPage clickToCross(){
        driver.findElement(cross).click();
        return this;
    }

    public String getTextEmptyFieldError(){
        return driver.findElement(By.xpath("//div[@class='simple_tooltip_body']")).getText();
    }

    public StartHeaderBlockPage verifySignUpButtonVisibility(){
        WebElement element = driver.findElement(signUpButton);
        if (element.isEnabled()){
            clickToCross();
        }
        return this;
    }

    public FaceBookPage clickFaceBookLink(){
        driver.findElement(fbButton).click();
        return new FaceBookPage(driver);
    }

    public VKPage clickVKLink(){
        driver.findElement(vkButton).click();
        return new VKPage(driver);
    }


    public StartHeaderBlockPage writePassInput(String pass) {
        driver.findElement(signUpInputPass).sendKeys(pass);
        return this;
    }

    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();
    }

}
