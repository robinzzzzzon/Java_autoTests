package levelTravel.Pack.Pages.StartUpPage.Interfaces;

import levelTravel.Pack.Pages.StartUpPage.SubPages.FaceBookPage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.PressPage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.PromoPage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.WhatsUpPage;
import org.openqa.selenium.By;

public interface Headerable {

    By levelTravelLink = By.xpath("//a[text()='Level Travel'][2]");
    By numberField = By.xpath("//div[@class='dropdown_switcher phone_dropdown-switcher']");
    By recallMeButton = By.xpath("//button[text()='Перезвоните мне']");
    By recallMeHeading = By.xpath("//div[@class='ppc_subtitle']");
    By recallMeRightNow = By.xpath("//button[text()='Перезвоните мне!']");
    By linkWhatsUp = By.xpath("//div[@class='ppc_messenger_icon ppc_messenger_icon-whatsapp']/parent::a");
    By headerServices = By.xpath("(//div[@class='dropdown_switcher'])[1]");
    By headerServicesDD = By.xpath("//div[@class='header_module header_module-search-tours']//a");
    By headerMyWishList = By.xpath("//div[@class='dropdown_switcher wishlist_dropdown-switcher']");
    By headerMyWishListDescription = By.xpath("//div[@class='intro']//p");
    By headerHelper = By.xpath("(//div[@class='dropdown_switcher'])[2]");
    By headerHelperDD = By.xpath("//div[@class='header_module header_module-help help']//a");
    By headerExit = By.xpath("//span[text()='Вход']/parent::div");
    By mailHeadingExit = By.xpath("(//div[@class='user_input_block']/label[text()='Электронная почта'])[1]");
    By mailInputExit = By.xpath("(//div[@class='user_input_block']/input)[1]");
    By signUpInputPass = By.xpath("//input[@name='client[password]']");
    By cross = By.xpath("(//a[@class='universal_popup_close'])[1]");
    By vkButton = By.xpath("//a[@data-provider='vk']");
    By fbButton = By.xpath("//a[@data-provider='fb']");
    By goOnButton = By.xpath("//button[text()='Продолжить']");
    By registryButton = By.xpath("//button[text()='Зарегистрироваться']");
    By signUpButton = By.xpath("//button[text()='Войти']");
    By emptyFieldError = By.xpath("//div[@class='simple_tooltip_body']");

    void refreshStartPage();

    void clickNumberField();

    void clickRecallMeButton();

    void clickRecallMeRightNow();

    WhatsUpPage clickMessageIcon();

    String readRecallMeHeading();

    void clickHeaderServices();

    PromoPage selectAnyService(int serviceNumber);

    void clickHeaderMyWishList();

    String getTextPartOfWishList(int wishListNumber);

    void clickHeaderHelper();

    PressPage selectAnyHelper(int helperNumber);

    void clickHeaderExit();

    String getMailHeadingExitText();

    void writeMailInputExit(String string);

    void clickGoOnButton();

    void clickToCross();

    void clickRegisterButton();

    String getTextEmptyFieldError();

    FaceBookPage clickFaceBookLink();

    void clickSignUpButton();

    void writePassInput(String pass);
}
