package levelTravel.Pack.test.StartTests;

import levelTravel.Pack.Steps.StartPageSteps.HeaderSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class HeaderFragmentTest {

    @Steps
    private HeaderSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void navigateToPressPage() {
        steps.openPage();
        steps.clickHeaderHelper();
        steps.selectAnyHelper(4);
        steps.checkEqualStringsByPressPage("ДЕКАБРЬ 2019");
    }

    @Test
    public void navigateToPromoPage() {
        steps.openPage();
        steps.clickHeaderServices();
        steps.selectHeaderServicesDD(4);
        steps.checkContainsHeadingTextByPromoPage(" туры ");
    }

    @Test
    public void selectPartOfTextWishList() {
        steps.openPage();
        steps.clickHeaderMyWishList();
        steps.getTextPartOfWishList(3);
        steps.compareStringWithPartOfWishList("Ищите иконку на странице чтобы пополнить свой список.");
    }

    @Test
    public void doIncorrectRegistry() {
        steps.openPage();
        steps.clickHeaderExit();
        steps.writeMailInputExit("Qwerty@gmail.com");
        steps.clickGoOnButton();
        steps.clickRegisterButton();
        steps.checkEnableErrorText("Поле не может быть пустым");
    }

    @Test
    public void doSignUp() {
        steps.openPage();
        steps.clickHeaderExit();
        steps.writeMailInputExit("patrick.kelskyh@gmail.com");
        steps.clickGoOnButton();
        steps.writePassInput("oidEYRzs");
        steps.clickSignUpButton();
        steps.checkSuccessWelcomeHeading("С возвращением, Патрик!");
    }

    @Test
    public void doSwitchOnTheFBSource() {
        steps.openPage();
        steps.clickHeaderExit();
        steps.clickFaceBookLink();
        steps.switchToNextWindow();
        steps.checkEnabledFbLink();
    }

    @Test
    public void doSwitchOnTheVKSource() {
        steps.openPage();
        String mainHandle = steps.getWindowHandle();
        steps.clickHeaderExit();
        steps.clickVKLink();
        steps.switchToNextWindow();
        steps.switchBack(mainHandle);
        steps.compareVkAndCurrentHandles(mainHandle);
    }

    @Test
    public void checkEnableRecallMeButton() {
        steps.openPage();
        steps.clickNumberField();
        steps.checkIsDisplayedRecallButton();
    }

    @Test
    public void checkRecallMeNow() {
        steps.openPage();
        steps.clickNumberField();
        steps.clickRecallMeButton();
        steps.clickRecallMeRightNow();
        steps.compareRecallHeading("Или напишите нам в мессенджеры:");
    }

    @Test
    public void checkEnableRecallMeToMessenger() {
        steps.openPage();
        String mainHandleWindow = steps.getWindowHandle();
        steps.clickNumberField();
        steps.clickRecallMeButton();
        steps.clickMessageIcon();
        steps.switchBack(mainHandleWindow);
        steps.compareRecallHeading("Или напишите нам в мессенджеры:");
    }

}
