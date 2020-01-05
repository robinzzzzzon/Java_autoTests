package levelTravel.Pack.StartUpPage.SubPages;

import levelTravel.Pack.AbstractPage.AbstractBasePage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaceBookPage extends AbstractBasePage {

    public FaceBookPage(WebDriver driver) {
        super(driver);
    }

    private By emailInput = By.xpath("//input[@name='email']");
    private By passInput = By.xpath("//input[@name='pass']");
    private By buttonLogIn = By.xpath("//input[@name='login']");
    private By linkCreateNewAcc = By.xpath("//a[@role='button']");
    private By linkForgottenAcc = By.xpath("//a[text()='Forgotten account?']");

    @Contract("_ -> this")
    private FaceBookPage writeEmailInput(String EmailExample){
        driver.findElement(emailInput).sendKeys(EmailExample);
        return this;
    }

    @Contract("_ -> this")
    private FaceBookPage writePassInput(String PassExample){
        driver.findElement(passInput).sendKeys(PassExample);
        return this;
    }

    @NotNull
    @Contract(" -> new")
    private FaceBookPage clickSignInButton(){
        driver.findElement(buttonLogIn).click();
        return new FaceBookPage(driver);
    }

    public FaceBookPage tryIncorrectLogIn(String EmailExample, String PassExample){
        writeEmailInput(EmailExample);
        writePassInput(PassExample);
        clickSignInButton();
        return this;
    }
}
