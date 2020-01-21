package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.StartUpPage.Classes.StartMessengerBlockPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

public class StartMessengerBlockSteps {

    StartMessengerBlockPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void getBigHeadingText(){
        page.getBigHeadingText();
    }

    @Step
    public void moveToGooglePlayPage(){
        page.moveToGooglePlayPage();
    }

    @Step
    public void moveToAppStorePage(){
        page.moveToAppStorePage();
    }

    @Step
    public void getHowItWorksBanner(){
        page.getHowItWorksBanner();
    }

    @Step
    public void closeHowItWorksBanner(){
        page.closeHowItWorksBanner();
    }

    ///////////////////////////////////////////////

    @Step
    public void containsText(){
        Assertions.assertThat(page.getBigHeadingText().containsText("Разумный способ путешествовать")).isTrue();
    }

    @Step
    public void switchBack(){
            page.getDriver().navigate().back();
    }

    @Step
    public void checkOfHeadingVisible(){
        Assertions.assertThat(page.getHeading().isDisplayed()).isTrue();
    }
}
