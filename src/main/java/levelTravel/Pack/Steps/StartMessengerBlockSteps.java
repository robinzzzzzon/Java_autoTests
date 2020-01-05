package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.StartUpPage.Classes.StartMessengerBlockPage;
import net.thucydides.core.annotations.Step;

public class StartMessengerBlockSteps {

    StartMessengerBlockPage startMessengerBlockPage;

    @Step
    public void openStartMessengerPage(){
        startMessengerBlockPage.open();
    }

    @Step
    public void getBigHeadingText(){
        startMessengerBlockPage.getBigHeadingText();
    }

    @Step
    public void moveToGooglePlayPage(){
        startMessengerBlockPage.moveToGooglePlayPage();
    }

    @Step
    public void moveToAppStorePage(){
        startMessengerBlockPage.moveToAppStorePage();
    }

    @Step
    public void getHowItWorksBanner(){
        startMessengerBlockPage.getHowItWorksBanner();
    }

    @Step
    public void closeHowItWorksBanner(){
        startMessengerBlockPage.closeHowItWorksBanner();
    }
}
