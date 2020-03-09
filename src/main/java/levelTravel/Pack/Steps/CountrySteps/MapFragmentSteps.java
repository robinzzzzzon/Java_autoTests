package levelTravel.Pack.Steps.CountrySteps;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryMapFragmentPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;


public class MapFragmentSteps {

    CountryMapFragmentPage page;

    @Step
    public void openPage() {
        page.open();
    }

    @Step
    public void clickMaximizeButton() {
        page.clickMaximizeButton();
    }

    @Step
    public void clickZoomIn() {
        page.clickZoomIn();
    }

    @Step
    public void clickZoomOut() {
        page.clickZoomOut();
    }

    @Step
    public void clickBarAndCafe() {
        page.clickBarAndCafe();
    }

    @Step
    public void clickTheaterButton() {
        page.clickTheaterButton();
    }

    @Step
    public void clickShoppingButton() {
        page.clickShoppingButton();
    }

    @Step
    public void selectAnyDynamicGraph(int elementNumber) {
        page.selectAnyDynamicGraph(elementNumber);
    }

    ////////////////////////////////////////////////////////

    @Step
    public void isCardEnable() {
        Assertions.assertThat(page.find("//button[text()='Свернуть карту']").isEnabled()).isTrue();
    }

    @Step
    public void isMainCanvasVisible() {
        Assertions.assertThat(page.find("//canvas[@class='mapboxgl-canvas']").isVisible()).isTrue();
    }

    @Step
    public void isCardMarkerPresent() {
        Assertions.assertThat(page.findAll("//div[@class='search-page__map']//div[@class='mapboxgl-marker ']").size()).isGreaterThan(0);
    }

    @Step
    public void isEnableOneOfContentList(int number) {
        Assertions.assertThat(page.findAll("//div[@class='hotels-list']//div").get(number).isEnabled()).isTrue();
    }

}
