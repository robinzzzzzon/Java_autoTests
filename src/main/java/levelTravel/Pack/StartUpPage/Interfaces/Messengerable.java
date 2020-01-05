package levelTravel.Pack.StartUpPage.Interfaces;

import levelTravel.Pack.StartUpPage.Classes.StartMessengerBlockPage;
import levelTravel.Pack.StartUpPage.SubPages.AppStorePage;
import levelTravel.Pack.StartUpPage.SubPages.GooglePlayPage;
import org.openqa.selenium.By;

public interface Messengerable {

    By bigHeading = By.xpath("//div[text()=' Разумный способ путешествовать ']");
    By googlePlayLink = By.xpath("//div[@id='google_play_link']");
    By appStoreLink = By.xpath("//div[@id='app_store_link']");
    By howItWorksLink = By.xpath("//button[text()='Как работает сервис']");
    By closeHowItWorksLink = By.xpath("//div[@class='hiw_close']");

    public StartMessengerBlockPage getBigHeadingText();

    public GooglePlayPage moveToGooglePlayPage();

    public AppStorePage moveToAppStorePage();

    public StartMessengerBlockPage getHowItWorksBanner();

    public StartMessengerBlockPage closeHowItWorksBanner();
}
