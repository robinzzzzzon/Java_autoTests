package levelTravel.Pack.test.FragmentPageTest.SerenityTests;

import levelTravel.Pack.Steps.StartSearchBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class StartSearchBlockPageSerenityTest {

    @Steps
    StartSearchBlockSteps steps;

    @Managed
    WebDriver driver;


    @Test
    public void correctFindTurkeyToursForFamilyWithoutChildren(){
        steps.openPage();
        steps.clickCountryInput();
        steps.clickGettingPopularCountry(steps.getPopularCountry(1));
        steps.clickCalendarInput();
        steps.selectCalendarDate(steps.getCalendarDateForWholeYear(4, 3, 2));
        steps.clickSearchButton("Turk");
        //waiter.waitWhileElementWillBeClickable(By.xpath("//div[@class='filter-budget__cols']//button"), 10);
        //Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='search-page-title']")).getText().contains("ц"));
    }
}
