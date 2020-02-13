package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://level.travel/")
public class StartPage extends AbstractBasePage {

    private StartHeaderBlockPage startHeaderBlockPage = new StartHeaderBlockPage();
    private StartMessengerBlockPage startMessengerBlockPage = new StartMessengerBlockPage();
    private StartSearchBlockPage startSearchBlockPage = new StartSearchBlockPage();
    private StartBestPriceBlockPage startBestPriceBlockPage = new StartBestPriceBlockPage();

    public StartPage doCorrectSignUp() {
        startHeaderBlockPage.clickHeaderExit();
        startHeaderBlockPage.writeMailInputExit("patrick.kelskyh@gmail.com");
        startHeaderBlockPage.clickGoOnButton();
        startHeaderBlockPage.writePassInput("123456");
        startHeaderBlockPage.clickSignUpButton();
        String s = find(By.xpath("//div[@class='auth_success']")).getText();
        return new StartPage();
    }


    //Здесь буду уже писать общие методы по взаимодействию с программой.
}
