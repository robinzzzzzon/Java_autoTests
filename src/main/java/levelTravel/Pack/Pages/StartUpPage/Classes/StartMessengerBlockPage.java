package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.Messengerable;
import levelTravel.Pack.Pages.StartUpPage.SubPages.AppStorePage;
import levelTravel.Pack.Pages.StartUpPage.SubPages.GooglePlayPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://level.travel/")
public class StartMessengerBlockPage extends AbstractBasePage implements Messengerable {

    BaseMethods methods = new BaseMethods();

    public WebElement getHeading() {
        return find(bigHeading);
    }

    public StartMessengerBlockPage getBigHeadingText() {
        methods.getTextFromAnyElement(bigHeading);
        return this;
    }

    public GooglePlayPage moveToGooglePlayPage() {
        methods.selectAnyElement(googlePlayLink);
        return new GooglePlayPage();
    }

    public AppStorePage moveToAppStorePage() {
        methods.selectAnyElement(appStoreLink);
        return new AppStorePage();
    }

    public StartMessengerBlockPage getHowItWorksBanner() {
        methods.selectAnyElement(howItWorksLink);
        return this;
    }

    public StartMessengerBlockPage closeHowItWorksBanner() {
        methods.selectAnyElement(closeHowItWorksLink);
        return this;
    }

}
