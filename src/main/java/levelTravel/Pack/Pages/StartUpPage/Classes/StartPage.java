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

//    private void initStartPage(){
//        StartHeaderBlockPage startHeaderBlockPage = new StartHeaderBlockPage(driver);
//        StartMessengerBlockPage startMessengerBlockPage = new StartMessengerBlockPage(driver);
//        StartSearchBlockPage startSearchBlockPage = new StartSearchBlockPage(driver);
//        StartBestPriceBlockPage startBestPriceBlockPage = new StartBestPriceBlockPage(driver);
//    }

    public StartPage doCorrectSignUp() {
        startHeaderBlockPage.clickHeaderExit()
                .writeMailInputExit("patrick.kelskyh@gmail.com")
                .clickGoOnButton()
                .writePassInput("oidEYRzs")
                .clickSignUpButton();
        String s = find(By.xpath("//div[@class='auth_success']")).getText();
        return new StartPage();
    }


    //Здесь буду уже писать общие методы по взаимодействию с программой.
    //Методы объектов дочерних классов доступны только при создании метода.
}
