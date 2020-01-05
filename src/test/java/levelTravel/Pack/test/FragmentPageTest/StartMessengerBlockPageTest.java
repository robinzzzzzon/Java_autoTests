package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.Steps.StartMessengerBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class StartMessengerBlockPageTest {

    @Steps
    StartMessengerBlockSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void getBigHeadingText(){
        steps.openPage();
        steps.getBigHeadingText();
        steps.containsText();
    }

    @Test
    public void moveToGooglePlayPage(){
        steps.openPage();
        steps.moveToGooglePlayPage();
        steps.switchBack();
        steps.containsText();
    }

    @Test
    public void moveToAppStorePage(){
        steps.openPage();
        steps.moveToAppStorePage();
        steps.switchBack();
        steps.containsText();
    }

    @Test
    public void checkHowItWorksBanner(){
        steps.openPage();
        steps.getHowItWorksBanner();
        steps.closeHowItWorksBanner();
        steps.checkOfHeadingVisible();
    }


}
