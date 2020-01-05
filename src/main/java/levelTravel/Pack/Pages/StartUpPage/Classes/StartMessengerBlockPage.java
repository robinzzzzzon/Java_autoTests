package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.Messengerable;
import levelTravel.Pack.Pages.StartUpPage.SubPages.AppStorePage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.GooglePlayPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://level.travel/")
public class StartMessengerBlockPage extends PageObject implements Messengerable {

    public StartMessengerBlockPage getBigHeadingText(){
        find(bigHeading).getText();
        return this;
    }

    public GooglePlayPage moveToGooglePlayPage(){
        find(googlePlayLink).click();
        return new GooglePlayPage(getDriver());
    }

    public AppStorePage moveToAppStorePage(){
        find(appStoreLink).click();
        return new AppStorePage(getDriver());
    }

    public StartMessengerBlockPage getHowItWorksBanner(){
        find(howItWorksLink).click();
        return this;
    }

    public StartMessengerBlockPage closeHowItWorksBanner(){
        find(closeHowItWorksLink).click();
        return this;
    }

}
