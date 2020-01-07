package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.CountryPage.Classes.CountryList.TurkeyPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartBestPriceBlockPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class StartBestPriceBlockSteps {

    StartBestPriceBlockPage page;
    TurkeyPage turkeyPage;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickCityStartDD(){
        page.clickCityStartDD();
    }

    @Step
    public void selectAnyStartCity(int number){
        page.selectAnyStartCity(number);
    }

    @Step
    public void selectAnyCountOfNights(int number){
        page.selectAnyCountOfNights(number);
    }

    @Step
    public void selectAnyCountry(int number){
        page.selectAnyCountry(number);
    }

    @Step
    public void selectAnyPriceOfGraph(int number, String countryName){
        page.selectAnyPriceOfGraph(number, countryName);
    }

    @Step
    public void checkVisibleElementOfStartCity(int number){
        Assertions.assertThat(page.findAll(By.xpath("//div[@class='ps-departures_input']//option")).get(number - 1).isVisible());
    }

    @Step
    public void checkGraphIsEmpty(){
        Assertions.assertThat(!page.findAll(By.xpath("//div[@class='price-stat-columns-wrap']//a")).isEmpty());
    }

    @Step
    public void checkGraphSize(int anyCount){
        Assertions.assertThat(page.findAll(By.xpath("//div[@class='price-stat-columns-wrap']//a")).size() > anyCount);
    }

    @Step
    public void getThisWindowHandle(){
       String s = page.getDriver().getWindowHandle();
    }

    @Step
    public void switchToNextWindow(){
        for (String windowHandle : page.getDriver().getWindowHandles()) {
            page.getDriver().switchTo().window(windowHandle);
        }
    }

    @Step
    public void switchBackToMainWindow(){
        String s = page.getDriver().getWindowHandle();
        page.getDriver().switchTo().window(s);
    }

    @Step
    public void containTextOfHeading(){
        Assertions.assertThat(turkeyPage.getMainHeadingText()).isNotEmpty();
    }
}
