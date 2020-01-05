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
        steps.openStartMessengerPage();
        steps.getBigHeadingText();
    }
}
