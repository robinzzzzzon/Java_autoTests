package levelTravel.Pack.Steps;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryMapBlockPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;


public class CountryMapBlockSteps {

    CountryMapBlockPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickMaximizeButton(){
        page.clickMaximizeButton();
    }

    @Step
    public void clickZoomIn(){
        page.clickZoomIn();
    }

    @Step
    public void clickZoomOut(){
        page.clickZoomOut();
    }

    @Step
    public void clickBarAndCafe(){
        page.clickBarAndCafe();
    }

    @Step
    public void clickTheaterButton(){
        page.clickTheaterButton();
    }

    @Step
    public void clickShoppingButton(){
        page.clickShoppingButton();
    }

    @Step
    public WebElement getAnyDynamicGraph(int number){
        return page.getAnyDynamicGraph(number);
    }

    @Step
    public void selectAnyDynamicGraph(WebElement webElement){
        page.selectAnyDynamicGraph(webElement);
    }

    ////////////////////////////////////////////////////////

    @Step
    public void isCardEnable(){
        Assertions.assertThat(page.find("//button[text()='Свернуть карту']").isEnabled()).isTrue();
    }

    @Step
    public void isMainCanvasVisible(){
        Assertions.assertThat(page.find("//canvas[@class='mapboxgl-canvas']").isVisible()).isTrue();
    }

    @Step
    public void isCardMarkerPresent(){
        Assertions.assertThat(page.findAll("//div[@class='search-page__map']//div[@class='mapboxgl-marker ']").size()).isGreaterThan(0);
    }

    @Step
    public void isEnableOneOfContentList(int number){
        Assertions.assertThat(page.findAll("//div[@class='hotels-list']//div").get(number).isEnabled()).isTrue();
    }

}
