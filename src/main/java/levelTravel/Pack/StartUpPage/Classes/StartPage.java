package levelTravel.Pack.StartUpPage.Classes;

import levelTravel.Pack.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends AbstractBasePage {

    private StartHeaderBlockPage startHeaderBlockPage = new StartHeaderBlockPage(driver);
    private StartMessengerBlockPage startMessengerBlockPage = new StartMessengerBlockPage(driver);
    private StartSearchBlockPage startSearchBlockPage = new StartSearchBlockPage(driver);
    private StartBestPriceBlockPage startBestPriceBlockPage = new StartBestPriceBlockPage(driver);

    public StartPage(WebDriver driver) {
        super(driver);
        //initStartPage();
    }

//    private void initStartPage(){
//        StartHeaderBlockPage startHeaderBlockPage = new StartHeaderBlockPage(driver);
//        StartMessengerBlockPage startMessengerBlockPage = new StartMessengerBlockPage(driver);
//        StartSearchBlockPage startSearchBlockPage = new StartSearchBlockPage(driver);
//        StartBestPriceBlockPage startBestPriceBlockPage = new StartBestPriceBlockPage(driver);
//    }

    public StartPage doCorrectSignUp(){
        startHeaderBlockPage.clickHeaderExit()
                .writeMailInputExit("patrick.kelskyh@gmail.com")
                .clickGoOnButton()
                .writePassInput("oidEYRzs")
                .clickSignUpButton();
        String s = driver.findElement(By.xpath("//div[@class='auth_success']")).getText();
        return new StartPage(driver);
    }





    //Здесь буду уже писать общие методы по взаимодействию с программой.
    //Методы объектов дочерних классов доступны только при создании метода.
}
