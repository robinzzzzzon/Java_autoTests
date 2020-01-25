package levelTravel.Pack.Steps.StartPageSteps;

import levelTravel.Pack.Pages.StartUpPage.Classes.StartHeaderBlockPage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.FaceBookPage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.PressPage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.PromoPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class StartHeaderBlockSteps {

    StartHeaderBlockPage page;
    PromoPage promoPage;
    PressPage pressPage;
    FaceBookPage faceBookPage;

    @Step
    public void openPage() {
        page.open();
    }

    @Step
    public void refreshStartPage() {
        page.refreshStartPage();
    }

    @Step
    public void clickNumberField() {
        page.clickNumberField();
    }

    @Step
    public void clickRecallMeButton() {
        page.clickRecallMeButton();
    }

    @Step
    public void clickRecallMeRightNow() {
        page.clickRecallMeRightNow();
    }

    @Step
    public void clickMessageIcon() {
        page.clickMessageIcon();
    }

    @Step
    public void readRecallMeHeading() {
        page.readRecallMeHeading();
    }

    @Step
    public void clickHeaderServices() {
        page.clickHeaderServices();
    }

    @Step
    public PromoPage selectHeaderServicesDD(int serviceNumber) {
        return page.selectAnyService(serviceNumber);
    }

    @Step
    public void clickHeaderMyWishList() {
        page.clickHeaderMyWishList();
    }

    @Step
    public String getTextPartOfWishList(int number) {
        return page.getTextPartOfWishList(number);
    }

    @Step
    public void clickHeaderHelper() {
        page.clickHeaderHelper();
    }

    @Step
    public PressPage selectAnyHelper(int number) {
        return page.selectAnyHelper(number);
    }

    @Step
    public void clickHeaderExit() {
        page.clickHeaderExit();
    }

    @Step
    public void getMailHeadingExitText() {
        page.getMailHeadingExitText();
    }

    @Step
    public void writeMailInputExit(String email) {
        page.writeMailInputExit(email);
    }

    @Step
    public void clickGoOnButton() {
        page.clickGoOnButton();
    }

    @Step
    public void clickRegisterButton() {
        page.clickRegisterButton();
    }

    @Step
    public void clickToCross() {
        page.clickToCross();
    }

    @Step
    public void getTextEmptyFieldError() {
        page.getTextEmptyFieldError();
    }

    @Step
    public void clickFaceBookLink() {
        page.clickFaceBookLink();
    }

    @Step
    public void clickVKLink() {
        page.clickVKLink();
    }

    @Step
    public void writePassInput(String pass) {
        page.writePassInput(pass);
    }

    @Step
    public void clickSignUpButton() {
        page.clickSignUpButton();
    }

    ///////////////////////////////////////////////////////////
    //Стэпы-хэлперы:
    @Step
    public String getWindowHandle() {
        return page.getDriver().getWindowHandle();
    }

    @Step
    public void switchBack(String backHandle) {
        page.getDriver().switchTo().window(backHandle);
    }

    @Step
    void navigateBack() {
        page.getDriver().navigate().back();
    }

    @Step
    public void switchToNextWindow() {
        for (String windowHandle : page.getDriver().getWindowHandles()) {
            page.getDriver().switchTo().window(windowHandle);
        }
    }

    //////////////////////////////////////////////////////////////
    //Проверочные стэпы:
    @Step
    public void checkEqualStringsByPressPage(String anyString) {
        Assertions.assertThat(pressPage.getHeading()).isEqualTo(anyString);
    }

    @Step
    public void checkContainsHeadingTextByPromoPage(String anyString) {
        Assertions.assertThat(promoPage.getHeading()).contains(anyString);
    }

    @Step
    public void compareStringWithPartOfWishList(String anyString) {
        Assertions.assertThat(page.getTextPartOfWishList(3).compareTo(anyString));
    }

    @Step
    public void checkEnableErrorText(String anyString) {
        Assertions.assertThat(page.getTextEmptyFieldError()).isEqualTo(anyString);
    }

    @Step
    public void checkSuccessWelcomeHeading(String anyString) {
        String s = page.getDriver().findElement(By.xpath("//div[@class='auth_success']")).getText();
        Assertions.assertThat("С возвращением, Патрик!").isEqualTo(anyString);
    }

    @Step
    public void checkEnabledFbLink() {
        Assertions.assertThat(faceBookPage.find(By.xpath("//a[text()='Forgotten account?']")).isEnabled()).isTrue();
    }

    @Step
    public void compareVkAndCurrentHandles(String anyHandle) {
        Assertions.assertThat(anyHandle).isEqualTo(page.getDriver().getWindowHandle());
    }

    @Step
    public void checkIsDisplayedRecallButton() {
        Assertions.assertThat(page.find(By.xpath("//button[text()='Перезвоните мне']")).isDisabled());
    }

    @Step
    public void compareRecallHeading(String anyString) {
        String s = page.readRecallMeHeading();
        Assertions.assertThat(s).isEqualTo(anyString);
    }


}
