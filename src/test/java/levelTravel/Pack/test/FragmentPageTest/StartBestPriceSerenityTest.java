package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.Steps.StartBestPriceBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class StartBestPriceSerenityTest {

    @Steps
    StartBestPriceBlockSteps steps;

    @Managed
    WebDriver driver;


    @Test
    public void selectAnyStartCity(){
        steps.openPage();
        steps.clickCityStartDD();
        steps.selectAnyStartCity(3);
    }
}
