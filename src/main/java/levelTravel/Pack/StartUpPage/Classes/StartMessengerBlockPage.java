package levelTravel.Pack.StartUpPage.Classes;

import levelTravel.Pack.AbstractPage.AbstractBasePage;
import levelTravel.Pack.StartUpPage.Interfaces.Messengerable;
import levelTravel.Pack.StartUpPage.SubPages.AppStorePage;
import levelTravel.Pack.StartUpPage.SubPages.GooglePlayPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartMessengerBlockPage extends AbstractBasePage implements Messengerable {

    public StartMessengerBlockPage(WebDriver driver) {
        super(driver);
    }

    public StartMessengerBlockPage getBigHeadingText(){
        driver.findElement(bigHeading).getText();
        return this;
    }

    public GooglePlayPage moveToGooglePlayPage(){
        driver.findElement(googlePlayLink).click();
        return new GooglePlayPage(driver);
    }

    public AppStorePage moveToAppStorePage(){
        driver.findElement(appStoreLink).click();
        return new AppStorePage(driver);
    }

    public StartMessengerBlockPage getHowItWorksBanner(){
        driver.findElement(howItWorksLink).click();
        return this;
    }

    public StartMessengerBlockPage closeHowItWorksBanner(){
        driver.findElement(closeHowItWorksLink).click();
        return this;
    }

}
