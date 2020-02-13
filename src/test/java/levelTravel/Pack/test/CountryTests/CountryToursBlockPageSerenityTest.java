package levelTravel.Pack.test.CountryTests;

import levelTravel.Pack.Steps.CountrySteps.CountryToursBlockSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CountryToursBlockPageSerenityTest {

    @Steps
    private CountryToursBlockSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void clickAnyFilters() {
        steps.openPage();
        steps.clickRecommendFilter();
        steps.isEqualAttributeButtonBeforeAndAfterClick();
    }

    @Test
    public void clickWishListVariation() {
        steps.openPage();
        steps.clickAnyWishListButton(3);
        steps.checkSizeWishList(4);
    }

    @Test
    public void selectAnyExploreHotel() {
        steps.openPage();
        steps.clickAnyExploreHotel(3);
        steps.switchToNextHandle();
        steps.isVisiblePriceButtonOnTheFirstDescPage();
    }

    @Test
    public void selectAnyPriceLinkHotel() {
        steps.openPage();
        steps.clickAnyHotelPriceLink(2);
        steps.switchToNextHandle();
        steps.isVisiblePriceButtonOnTheFirstDescPage();
    }

    @Test
    public void selectAnyNameLinkHotel() {
        steps.openPage();
        steps.clickAnyNameHotelLink(2);
        steps.switchToNextHandle();
        steps.isVisiblePriceButtonOnTheFirstDescPage();
    }

    @Test
    public void getAnyNameLinkHotel() {
        steps.openPage();
        steps.getAnyNameHotelText(3);
        steps.checkGetStringByAnyHotelName(1);
    }
}
