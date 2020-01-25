package levelTravel.Pack.Pages.StartUpPage.SubPages;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

public class FaceBookPage extends AbstractBasePage {

    private By emailInput = By.xpath("//input[@name='email']");
    private By passInput = By.xpath("//input[@name='pass']");
    private By buttonLogIn = By.xpath("//input[@name='login']");
    private By linkCreateNewAcc = By.xpath("//a[@role='button']");
    private By linkForgottenAcc = By.xpath("//a[text()='Forgotten account?']");

    @Contract("_ -> this")
    private FaceBookPage writeEmailInput(String EmailExample) {
        find(emailInput).sendKeys(EmailExample);
        return this;
    }

    @Contract("_ -> this")
    private FaceBookPage writePassInput(String PassExample) {
        find(passInput).sendKeys(PassExample);
        return this;
    }

    @NotNull
    @Contract(" -> new")
    private FaceBookPage clickSignInButton() {
        find(buttonLogIn).click();
        return new FaceBookPage();
    }

    public FaceBookPage tryIncorrectLogIn(String EmailExample, String PassExample) {
        writeEmailInput(EmailExample);
        writePassInput(PassExample);
        clickSignInButton();
        return this;
    }
}
