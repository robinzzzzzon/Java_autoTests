package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Filterable;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-15.04.2020-for-7-nights-2-adults-0-kids-1..5-stars")
public class CountryFiltersBlockPage extends AbstractBasePage implements Filterable {

    BaseMethods methods = new BaseMethods();

    //свитчер моментального подтверждения:
    public CountryFiltersBlockPage switchMomentConfirmTumbler(boolean b) {
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

    public CountryFiltersBlockPage writeMinIntervalPrice(String anyPrice) {
        methods.writeTextToAnyElementOfList(getPriceInputs(), 1, anyPrice);
        return this;
    }

    public CountryFiltersBlockPage writeMaxIntervalPrice(String anyPrice) {
        methods.writeTextToAnyElementOfList(getPriceInputs(), 2, anyPrice);
        return this;
    }

    public void putAnyPriceInPriceInput(boolean b) {
        if (!b) {
            WebElement element = getPriceInputs().get(1);
            methods.bufferInput(element);
        }
        WebElement element = getPriceInputs().get(0);
        methods.bufferInput(element);
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

    public CountryFiltersBlockPage writeHotelName(String hotelName) {
        methods.writeTextToAnyElement(inputHotelName, hotelName);
        return new CountryFiltersBlockPage();
    }

    public CountryFiltersBlockPage writeHotelNameFromBuffer(String anyHotelName) {
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

    public CountryFiltersBlockPage selectRatingHotel(int number) {
        methods.selectAnyElementFromList(number, getRatingHotelsList());
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    private List<WebElementFacade> getDistanceToSeaList() {
        return methods.getAnyList(distanceToSea);
    }

    public CountryFiltersBlockPage selectDistanceToSea(int number) {
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

    public CountryFiltersBlockPage selectPrivateBeachInput(boolean b) {
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

    public CountryFiltersBlockPage selectTypeOfBeach(int typeNumber, boolean b) {
        methods.scrolling(300, 1000);
        methods.selectOrDeselectAnyElementFromList(typeNumber, getTypesOfBeachList(), b);
        return this;
    }

    public void selectFirstAndLastBeachType() {
        methods.scrolling(300, 1000);
        methods.selectFirstAndLastElements(getTypesOfBeachList());
    }

    public CountryFiltersBlockPage selectAllTypeOfBeach() {
        methods.scrolling(300, 1000);
        methods.selectAllElements(getTypesOfBeachList());
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //Фильтруем по видам питания:

    private List<WebElementFacade> getFoodTypeList() {
        return methods.getAnyList(foodTypes);
    }

    public void selectTypeFood(int number) {
        methods.scrolling(400, 1000);
        methods.selectAnyElementFromList(number, getFoodTypeList(), showAllFoodTypes);
    }

    public void selectAllFoodType() {
        methods.scrolling(400, 1000);
        methods.selectAllElements(getFoodTypeList(), showAllFoodTypes);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    private List<WebElementFacade> getRegionTypesList() {
        return methods.getAnyList(regionTypes);
    }

    public void selectRegionType(int regionNumber) {
        methods.scrolling(450, 1000);
        methods.selectAnyElementFromList(regionNumber, getRegionTypesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    private List<WebElementFacade> getRegionList() {
        return methods.getAnyList(regionList);
    }

    public void selectAnyRegion(int number) {
        methods.scrolling(600, 1000);
        methods.selectAnyElementFromList(number, getRegionList(), showAllRegions);
    }

    public void selectFirstAndLastRegion() {
        methods.scrolling(600, 1000);
        methods.selectFirstAndLastElements(getRegionList(), showAllRegions);
    }

    public void selectAllRegions() {
        methods.scrolling(600, 1000);
        methods.selectAllElements(getRegionList(), showAllRegions);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:

    private List<WebElementFacade> getHotelTypesList() {
        return methods.getAnyList(hotelTypes);
    }

    public void selectHotelType(int number) {
        methods.scrolling(700, 1000);
        methods.selectAnyElementFromList(number, getHotelTypesList());
    }

    public void selectFirstAndLastHotelTypes() {
        methods.scrolling(700, 1000);
        methods.selectFirstAndLastElements(getHotelTypesList());
    }

    public void selectAllHotelTypes() {
        methods.scrolling(700, 1000);
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
        methods.scrolling(800, 1000);
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
        methods.scrolling(1000, 1000);
        methods.selectAnyElementFromList(number, getWaterGamesList());
    }

    public void selectFirstAndLastWaterGames() {
        methods.scrolling(1000, 1000);
        methods.selectFirstAndLastElements(getWaterGamesList());
    }

    public void selectAllWaterGames() {
        methods.scrolling(1000, 1000);
        methods.selectAllElements(getWaterGamesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    private List<WebElementFacade> getHotelFacilitiesList() {
        return methods.getAnyList(hotelFacilities);
    }

    public void selectHotelFacility(int number) {
        methods.scrolling(1100, 1000);
        methods.selectAnyElementFromList(number, getHotelFacilitiesList());
    }

    public void selectFirstAndLastFacilities() {
        methods.scrolling(1100, 1000);
        methods.selectFirstAndLastElements(getHotelFacilitiesList());
    }

    public void selectAllFacilities() {
        methods.scrolling(1100, 1000);
        methods.selectAllElements(getHotelFacilitiesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    private List<WebElementFacade> getFamilyWithChildrenList() {
        return methods.getAnyList(forFamilyWithChildren);
    }

    public void selectAnyVariationFamilyWithChildren(int number) {
        methods.scrolling(1200, 1000);
        methods.selectAnyElementFromList(number, getFamilyWithChildrenList());
    }

    public void selectFirstAndLastFamilyWithChildren() {
        methods.scrolling(1200, 1000);
        methods.selectFirstAndLastElements(getFamilyWithChildrenList());
    }

    public void selectAllFamilyWithChildren() {
        methods.scrolling(1200, 1000);
        methods.selectAllElements(getFamilyWithChildrenList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    private List<WebElementFacade> getTourOperatorsList() {
        return methods.getAnyList(tourOperators);
    }

    public void selectAnyTourOperator(int number) {
        methods.scrolling(1500, 1000);
        methods.selectAnyElementFromList(number, getTourOperatorsList(), showAllTourOperators);
    }

    public void selectFirstAndLastTourOperators() {
        methods.scrolling(1500, 1000);
        methods.selectFirstAndLastElements(getTourOperatorsList(), showAllTourOperators);
    }

    public void selectAllTourOperators() {
        methods.scrolling(1500, 1000);
        methods.selectAllElements(getTourOperatorsList(), showAllTourOperators);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersBlockPage clickLocalClearFilter() {
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
        methods.scrolling(1600, 1000);
        methods.selectAnyElement(clearAllFiltersButton);
    }

}
