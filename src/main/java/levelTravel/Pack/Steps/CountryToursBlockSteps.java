package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryToursBlockPage;
import levelTravel.Pack.Pages.HotelDescPage.HotelFirstDescPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

public class CountryToursBlockSteps {

    CountryToursBlockPage page;
    HotelFirstDescPage firstDescPage;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickRecommendFilter(){
        page.clickRecommendFilter();
    }

    @Step
    public void clickPriceFilter(){
        page.clickPriceFilter();
    }

    @Step
    public void clickRateFilter(){
        page.clickRateFilter();
    }

    @Step
    public void clickFirstWishListButton(boolean b){
        page.clickFirstWishListButton(b);
    }

    @Step
    public void clickAnyWishListButton(int number){
        page.clickAnyWishListButton(number);
    }

    @Step
    public HotelFirstDescPage clickFirstExploreHotel(boolean b){
        return page.clickFirstExploreHotel(b);
    }

    @Step
    public HotelFirstDescPage clickAnyExploreHotel(int number){
       return page.clickAnyExploreHotel(number);
    }

    @Step
    public HotelFirstDescPage clickFirstHotelPriceLink(boolean b){
        return page.clickFirstHotelPriceLink(b);
    }

    @Step
    public HotelFirstDescPage clickAnyHotelPriceLink(int number){
        return page.clickAnyHotelPriceLink(number);
    }

    @Step
    public String getAnyNameHotelText(int number){
        return page.getAnyNameHotelText(number);
    }

    @Step
    public HotelFirstDescPage clickFirstNameHotelLink(boolean b){
        return page.clickFirstNameHotelLink(b);
    }

    @Step
    public HotelFirstDescPage clickAnyNameHotelLink(int number){
        return page.clickAnyNameHotelLink(number);
    }

    //////////////////////////////////////////////////////////////////

    @Step
    public void isEqualAttributeButtonBeforeAndAfterClick(){
        String s = "sorting__link sorting__link--active";
        Assertions.assertThat(page.find("//button[text()='по рекомендации']").getAttribute("class")).isEqualTo(s);
    }

    @Step
    public void checkSizeWishList(int number){
        Assertions.assertThat(page.findAll("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[3]//a").size()).isEqualTo(number);
    }

    @Step
    public void switchToNextHandle(){
        for (String windowHandle : page.getDriver().getWindowHandles()) {
            page.getDriver().switchTo().window(windowHandle);
        }
    }

    @Step
    public void isVisiblePriceButtonOnTheFirstDescPage(){
        Assertions.assertThat(firstDescPage.find("//button[text()='Посмотреть цены']").isVisible());
    }

    @Step
    public void checkGetStringByAnyHotelName(int number){
        Assertions.assertThat(page.findAll("//a[@class='hotel-explore-link']").get(number).getText()).isNotNull();
    }

}
