package levelTravel.Pack.Pages.StartUpPage.Interfaces;

import levelTravel.Pack.Pages.StartUpPage.Classes.StartMessengerFragmentPage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.AppStorePage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.GooglePlayPage;
import org.openqa.selenium.By;

public interface Messengerable {

    By bigHeading = By.xpath("//div[text()=' Разумный способ путешествовать ']");
    By googlePlayLink = By.xpath("//div[@id='google_play_link']");
    By appStoreLink = By.xpath("//div[@id='app_store_link']");
    By howItWorksLink = By.xpath("//button[text()='Как работает сервис']");
    By closeHowItWorksLink = By.xpath("//div[@class='hiw_close']");

    public StartMessengerFragmentPage getBigHeadingText();

    public GooglePlayPage moveToGooglePlayPage();

    public AppStorePage moveToAppStorePage();

    public StartMessengerFragmentPage getHowItWorksBanner();

    public StartMessengerFragmentPage closeHowItWorksBanner();
}
