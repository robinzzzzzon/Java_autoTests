package levelTravel.Pack.test.CombinedTests;

import levelTravel.Pack.Steps.CombinedSteps.CombinedSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@Concurrent(threads="4")
public class CombinedFiltersTests {

    @Steps
    CombinedSteps steps;

    @Managed //(uniqueSession=true) //(driver = "chrome") //(clearCookies=BeforeEachTest)
    WebDriver driver;

    @Test
    public void checkTest(){
        steps.openPage();
        steps.clickCountryInput();
        steps.selectPopularCountry(1);
        steps.clickSearchButton("Турция");
        steps.selectAnyPriceTower(2);
        steps.checkToursResultGreaterNull();
    }

    @Test
    public void checkTest2(){
        steps.openPage();
        // метод onSamePage здесь просто для наглядности. По идее он нужен тогда, когда планируется много вычисл. операций с элементами на странице. Типа если мы уверены что это та же страница, то можно применять этот метод, тогда происходит оптимизация мощностей.
        steps.onSamePage(CombinedSteps.class).clickCountryInput();
        steps.onSamePage(CombinedSteps.class).selectPopularCountry(1);
        steps.clickSearchButton("Турция");
        steps.checkToursResultGreaterNull();
        steps.clickAnyHotelPriceLink(3);
        steps.getCurrentHandle();
        steps.switchToNextHandle();
        steps.selectAnyOfferButton(2);
    }
}
