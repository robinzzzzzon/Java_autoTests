package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Filterable;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-15.04.2020-for-7-nights-2-adults-0-kids-1..5-stars")
public class CountryFiltersFragmentPage extends AbstractBasePage implements Filterable {

    BaseMethods methods = new BaseMethods();

    //свитчер моментального подтверждения:
    public CountryFiltersFragmentPage switchMomentConfirmTumbler(boolean b) {
        methods.selectOrDeselectAnyElement(speedAcceptTumbler, b);
        return this;
    }

    ///////////////////////////////////////////////////////////////////////
    //Работа с ценовыми столбцами и интервалом цен в инпутах:

    private List<WebElementFacade> getListOfPriceTowers() {
        return methods.getAnyList(priceTowers);
    }

    public void selectAnyPriceTower(int number) {
        methods.selectAnyElementFromList(number, getListOfPriceTowers());
    }

    private List<WebElementFacade> getPriceInputs() {
        return methods.getAnyList(priceInputs);
    }

    public CountryFiltersFragmentPage writeMinIntervalPrice(String anyPrice) {
        methods.writeTextToAnyElementOfList(getPriceInputs(), 1, anyPrice);
        return this;
    }

    public CountryFiltersFragmentPage writeMaxIntervalPrice(String anyPrice) {
        methods.writeTextToAnyElementOfList(getPriceInputs(), 2, anyPrice);
        return this;
    }

    public void putAnyPriceInPriceInput(boolean b, String anyPrice) {
        if (!b) {
            typeInto(getPriceInputs().get(1), anyPrice);
        } else{
            typeInto(getPriceInputs().get(0), anyPrice);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем отели по кол-ву звезд:

    private List<WebElementFacade> getHotelStarsListInputs() {
        return methods.getAnyList(inputStarsOfHotels);
    }

    private List<WebElementFacade> getHotelStarsListSpans() {
        return methods.getAnyList(spanStarsOfHotels);
    }

    public void selectAnyStarsHotel(boolean b, int numberOfSpan, int numberOfInput) {
        WebElement span = getHotelStarsListSpans().get(numberOfSpan);
        WebElement input = getHotelStarsListInputs().get(numberOfInput);
        if (!span.isSelected() == b) {
            input.click();
        }
    }

    public void selectFirstAndLastStars() {
        methods.selectFirstAndLastElements(getHotelStarsListInputs());
    }

    public void selectAllStars() {
        methods.selectAllElements(getHotelStarsListInputs());
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Ищем отель по наименованию:

    public CountryFiltersFragmentPage writeHotelName(String hotelName) {
        methods.writeTextToAnyElement(inputHotelName, hotelName);
        return new CountryFiltersFragmentPage();
    }

    public CountryFiltersFragmentPage writeHotelNameFromBuffer(String anyHotelName) {
        WebElement element = find(inputHotelName);
        element.sendKeys(anyHotelName);
        methods.bufferInput(element);
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация отелей по рейтингу:

    private List<WebElementFacade> getRatingHotelsList() {
        return methods.getAnyList(hotelsRating);
    }

    public CountryFiltersFragmentPage selectRatingHotel(int number) {
        methods.selectAnyElementFromList(number, getRatingHotelsList());
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    private List<WebElementFacade> getDistanceToSeaList() {
        return methods.getAnyList(distanceToSea);
    }

    public CountryFiltersFragmentPage selectDistanceToSea(int number) {
        methods.selectAnyElementFromList(number, getDistanceToSeaList());
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //Фильтрация частных пляжей:

    private WebElement getPrivateBeachInput() {
        return find(inputPrivateBeach);
    }

    private WebElement getPrivateBeachSpan() {
        return find(spanPrivateBeach);
    }

    public CountryFiltersFragmentPage selectPrivateBeachInput(boolean b) {
        WebElement span = getPrivateBeachSpan();
        WebElement input = getPrivateBeachInput();
        if (!span.isSelected() == b) {
            input.click();
        }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по типам поверхности пляжа:

    private List<WebElementFacade> getTypesOfBeachList() {
        return methods.getAnyList(typesOfBeach);
    }

    public CountryFiltersFragmentPage selectTypeOfBeach(int typeNumber, boolean b) {
        methods.scrolling(400);
        waitOverlayDisappear();
        methods.selectOrDeselectAnyElementFromList(typeNumber, getTypesOfBeachList(), b);
        return this;
    }

    public void selectFirstAndLastBeachType() {
        methods.scrolling(400);
        waitOverlayDisappear();
        methods.selectFirstAndLastElements(getTypesOfBeachList());
    }

    public CountryFiltersFragmentPage selectAllTypeOfBeach() {
        methods.scrolling(400);
        waitOverlayDisappear();
        methods.selectAllElements(getTypesOfBeachList());
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //Фильтруем по видам питания:

    private List<WebElementFacade> getFoodTypeList() {
        return methods.getAnyList(foodTypes);
    }

    public void selectTypeFood(int number) {
        methods.scrolling(500);
        waitOverlayDisappear();
        methods.selectAnyElementFromList(number, getFoodTypeList(), showAllFoodTypes);
    }

    public void selectAllFoodType() {
        methods.scrolling(500);
        waitOverlayDisappear();
        methods.selectAllElements(getFoodTypeList(), showAllFoodTypes);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    private List<WebElementFacade> getRegionTypesList() {
        return methods.getAnyList(regionTypes);
    }

    public void selectRegionType(int regionNumber) {
        methods.scrolling(600);
        waitOverlayDisappear();
        methods.selectAnyElementFromList(regionNumber, getRegionTypesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    private List<WebElementFacade> getRegionList() {
        return methods.getAnyList(regionList);
    }

    public void selectAnyRegion(int number) {
        methods.scrolling(700);
        waitOverlayDisappear();
        methods.selectAnyElementFromList(number, getRegionList(), showAllRegions);
    }

    public void selectFirstAndLastRegion() {
        methods.scrolling(700);
        waitOverlayDisappear();
        methods.selectFirstAndLastElements(getRegionList(), showAllRegions);
    }

    public void selectAllRegions() {
        methods.scrolling(700);
        waitOverlayDisappear();
        methods.selectAllElements(getRegionList(), showAllRegions);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:

    private List<WebElementFacade> getHotelTypesList() {
        return methods.getAnyList(hotelTypes);
    }

    public void selectHotelType(int number) {
        methods.scrolling(800);
        waitOverlayDisappear();
        methods.selectAnyElementFromList(number, getHotelTypesList());
    }

    public void selectFirstAndLastHotelTypes() {
        methods.scrolling(800);
        waitOverlayDisappear();
        methods.selectFirstAndLastElements(getHotelTypesList());
    }

    public void selectAllHotelTypes() {
        methods.scrolling(800);
        waitOverlayDisappear();
        methods.selectAllElements(getHotelTypesList());
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по наличию wi-fi:

    private List<WebElementFacade> getWiFiRb() {
        return methods.getAnyList(wiFiRb);
    }

    private List<WebElementFacade> getWiFiLabel() {
        return methods.getAnyList(wiFiTypeLabel);
    }

    public void selectWiFiInput(int elementNumber, boolean b) {
        methods.scrolling(900);
        waitOverlayDisappear();
        waitForRenderedElements(wiFiTypeLabel);
        List<WebElementFacade> RbList = getWiFiRb();
        if (!RbList.get(elementNumber - 1).isSelected() == b) {
            getWiFiLabel().get(elementNumber - 1).click();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    private List<WebElementFacade> getWaterGamesList() {
        return methods.getAnyList(waterGames);
    }

    public void selectWaterGame(int number) {
        methods.scrolling(1000);
        waitOverlayDisappear();
        waitForRenderedElements(waterGames);
        methods.selectAnyElementFromList(number, getWaterGamesList());
    }

    public void selectFirstAndLastWaterGames() {
        methods.scrolling(1000);
        waitOverlayDisappear();
        waitForRenderedElements(waterGames);
        methods.selectFirstAndLastElements(getWaterGamesList());
    }

    public void selectAllWaterGames() {
        methods.scrolling(1000);
        waitOverlayDisappear();
        waitForRenderedElements(waterGames);
        methods.selectAllElements(getWaterGamesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    private List<WebElementFacade> getHotelFacilitiesList() {
        return methods.getAnyList(hotelFacilities);
    }

    public void selectHotelFacility(int number) {
        methods.scrolling(1100);
        waitOverlayDisappear();
        waitForRenderedElements(hotelFacilities);
        methods.selectAnyElementFromList(number, getHotelFacilitiesList());
    }

    public void selectFirstAndLastFacilities() {
        methods.scrolling(1100);
        waitOverlayDisappear();
        waitForRenderedElements(hotelFacilities);
        methods.selectFirstAndLastElements(getHotelFacilitiesList());
    }

    public void selectAllFacilities() {
        methods.scrolling(1100);
        waitOverlayDisappear();
        waitForRenderedElements(hotelFacilities);
        methods.selectAllElements(getHotelFacilitiesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    private List<WebElementFacade> getFamilyWithChildrenList() {
        return methods.getAnyList(forFamilyWithChildren);
    }

    public void selectAnyVariationFamilyWithChildren(int number) {
        methods.scrolling(1400);
        waitOverlayDisappear();
        waitForRenderedElements(forFamilyWithChildren);
        methods.selectAnyElementFromList(number, getFamilyWithChildrenList());
    }

    public void selectFirstAndLastFamilyWithChildren() {
        methods.scrolling(1400);
        waitOverlayDisappear();
        waitForRenderedElements(forFamilyWithChildren);
        methods.selectFirstAndLastElements(getFamilyWithChildrenList());
    }

    public void selectAllFamilyWithChildren() {
        methods.scrolling(1400);
        waitOverlayDisappear();
        waitForRenderedElements(forFamilyWithChildren);
        methods.selectAllElements(getFamilyWithChildrenList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    private List<WebElementFacade> getTourOperatorsList() {
        return methods.getAnyList(tourOperators);
    }

    public void selectAnyTourOperator(int number) {
        methods.scrolling(1700);
        waitOverlayDisappear();
        waitForRenderedElements(tourOperators);
        methods.selectAnyElementFromList(number, getTourOperatorsList(), showAllTourOperators);
    }

    public void selectFirstAndLastTourOperators() {
        methods.scrolling(1700);
        waitOverlayDisappear();
        waitForRenderedElements(tourOperators);
        methods.selectFirstAndLastElements(getTourOperatorsList(), showAllTourOperators);
    }

    public void selectAllTourOperators() {
        methods.scrolling(1700);
        waitOverlayDisappear();
        waitForRenderedElements(tourOperators);
        methods.selectAllElements(getTourOperatorsList(), showAllTourOperators);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersFragmentPage clickLocalClearFilter() {
        methods.selectAnyElement(clearOneTypeFilter);
        return this;
    }

    public void clickFewLocalClearFilter() {
        List<WebElementFacade> webElements = findAll(clearOneTypeFilter);
        if (webElements.size() > 0) {
            for (WebElement element : webElements) {
                element.click();
            }
        }
    }

    //Сбросить все фильтры:
    public void clickAllClearFilter() {
        methods.scrolling(1800);
        waitOverlayDisappear();
        methods.selectAnyElement(clearAllFiltersButton);
    }

    /////////////////////////////////////////
    //служебный метод с ожиданием конца отбражения оверлея:
    public void waitOverlayDisappear(){
        find(overlay).waitUntilNotVisible();
    }

}
