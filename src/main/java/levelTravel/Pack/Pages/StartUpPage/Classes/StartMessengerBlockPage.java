package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.Messengerable;
import levelTravel.Pack.Pages.StartUpPage.SubPages.AppStorePage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.GooglePlayPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://level.travel/")
public class StartMessengerBlockPage extends AbstractBasePage implements Messengerable {

    public StartMessengerBlockPage getBigHeadingText(){
        find(bigHeading).getText();
        return this;
    }

    public GooglePlayPage moveToGooglePlayPage(){
        find(googlePlayLink).click();
        return new GooglePlayPage();
    }

    public AppStorePage moveToAppStorePage(){
        find(appStoreLink).click();
        return new AppStorePage();
    }

    public StartMessengerBlockPage getHowItWorksBanner(){
        find(howItWorksLink).click();
        return this;
    }

    public StartMessengerBlockPage closeHowItWorksBanner(){
        find(closeHowItWorksLink).click();
        return this;
    }

    public void switchBack(){
        getDriver().navigate().back();
    }

    public WebElement getHeading(){
        return find(bigHeading);
    }

}
