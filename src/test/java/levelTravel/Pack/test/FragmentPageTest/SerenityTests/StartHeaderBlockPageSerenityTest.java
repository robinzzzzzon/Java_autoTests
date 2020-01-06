package levelTravel.Pack.test.FragmentPageTest.SerenityTests;


import levelTravel.Pack.Steps.StartHeaderBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class StartHeaderBlockPageSerenityTest {

    @Steps
    StartHeaderBlockSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void clickHeaderServices(){
        steps.openPage();
        steps.clickHeaderServices();
    }

    @Test
    public void selectHelper(){
        steps.openPage();
        steps.clickHeaderHelper();
        steps.clickSelectingHelper(steps.readHeaderHelper(2));
    }
}
