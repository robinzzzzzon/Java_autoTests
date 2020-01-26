package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Filterable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-09.02.2020-for-7-nights-2-adults-0-kids-1..5-stars")
public class CountryFiltersBlockPage extends AbstractBasePage implements Filterable {

    //свитчер моментального подтверждения:
    public CountryFiltersBlockPage switchMomentConfirmTumbler(boolean b) {
        WebElement element = find(speedAcceptTumbler);
        if (!element.isSelected() == b) {
            element.click();
        }
        return this;
    }

    ///////////////////////////////////////////////////////////////////////
    //Работа с ценовыми столбцами и интервалом цен в инпутах:

    private List<WebElementFacade> getListOfPriceTowers() {
        return findAll(priceTowers);
    }

    public void selectAnyPriceTower(int number) {
        WebElement element = getListOfPriceTowers().get(number);
        element.click();
    }

    private List<WebElementFacade> getPriceInputs() {
        return findAll(priceInputs);
    }

    public CountryFiltersBlockPage writeMinIntervalPrice(String anyPrice) {
        WebElement element = getPriceInputs().get(0);
        element.sendKeys(anyPrice);
        return this;
    }

    public CountryFiltersBlockPage writeMaxIntervalPrice(String anyPrice) {
        WebElement element = getPriceInputs().get(1);
        element.sendKeys(anyPrice);
        return this;
    }

    public void putAnyPriceInPriceInput(boolean b) {

        if (!b) {
            WebElement element = getPriceInputs().get(1);
            bufferInput(element);
        }
        WebElement element = getPriceInputs().get(0);
        bufferInput(element);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем отели по кол-ву звезд:

    private List<WebElementFacade> getHotelStarsListInputs() {
        return findAll(inputStarsOfHotels);
    }

    private List<WebElementFacade> getHotelStarsListSpans() {
        return findAll(spanStarsOfHotels);
    }

    public void selectAnyStarsHotel(boolean b, int numberOfSpan, int numberOfInput) {
        WebElement span = getHotelStarsListSpans().get(numberOfSpan);
        WebElement input = getHotelStarsListInputs().get(numberOfInput);
        if (!span.isSelected() == b) {
            input.click();
        }
    }

    public void selectFirstAndLastStars() {
        selectFirstAndLastCB(getHotelStarsListInputs());
    }

    public void selectAllStars() {
        selectAllCB(getHotelStarsListInputs());
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Ищем отель по наименованию:

    public CountryFiltersBlockPage writeHotelName(String hotelName) {
        find(inputHotelName).waitUntilEnabled().sendKeys(hotelName);
        return new CountryFiltersBlockPage();
    }

    public CountryFiltersBlockPage writeHotelNameFromBuffer(String anyHotelName) {
        WebElement element = find(inputHotelName);
        element.sendKeys(anyHotelName);
        bufferInput(element);
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация отелей по рейтингу:

    private List<WebElementFacade> getRatingHotelsList() {
        return findAll(hotelsRating);
    }

    public CountryFiltersBlockPage selectRatingHotel(int number) {
        WebElement element = getRatingHotelsList().get(number - 1);
        element.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    private List<WebElementFacade> getDistanceToSeaList() {
        return findAll(distanceToSea);
    }

    public CountryFiltersBlockPage selectDistanceToSea(int number) {
        WebElement element = getDistanceToSeaList().get(number);
        element.click();
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
        return findAll(typesOfBeach);
    }

    public CountryFiltersBlockPage selectTypeOfBeach(int typeNumber, boolean b) {
        WebElement element = getTypesOfBeachList().get(typeNumber);
        if (!element.isSelected() == b) element.click();
        return this;
    }

    public CountryFiltersBlockPage selectAllTypeOfBeach() {
        scrolling(300);
        selectAllCB(getTypesOfBeachList());
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //Фильтруем по видам питания:

    private List<WebElementFacade> getFoodTypeList() {
        return findAll(foodTypes);
    }

    private void showAllTypesFood() {
        waitMethod(1000);
        find(showAllFoodTypes).click();
    }

    public CountryFiltersBlockPage selectTypeFood(int number) {
        scrolling(400);
        WebElement element = getFoodTypeList().get(number - 1);
        if (!element.isEnabled()) {
            showAllTypesFood();
            element.click();
        }
        element.click();
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    private List<WebElementFacade> getRegionTypesList() {
        return findAll(regionTypes);
    }

    public CountryFiltersBlockPage selectRegionType(int regionNumber) {
        WebElement element = getRegionTypesList().get(regionNumber);
        element.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    private List<WebElementFacade> getRegionList() {
        return findAll(regionList);
    }

    private void showAllRegions() {
        find(showAllRegions).waitUntilClickable().click();
    }


    public CountryFiltersBlockPage selectAnyRegion(int number) {
        scrolling(500);
        WebElement element = getRegionList().get(number - 1);
        if (!element.isEnabled()) {
            showAllRegions();
            element.click();
        }
        element.click();
        return new CountryFiltersBlockPage();
    }


    public CountryFiltersBlockPage selectAllRegions() {
        scrolling(500);
        List<WebElementFacade> webElements = getRegionList();
        showAllRegions();
        for (WebElement element : webElements) {
            element.click();
        }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:

    private List<WebElementFacade> getHotelTypesList() {
        return findAll(hotelTypes);
    }

    public CountryFiltersBlockPage selectHotelType(int number) {
        scrolling(600);
        WebElement element = getHotelTypesList().get(number);
        element.click();
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по наличию wi-fi:

    private List<WebElementFacade> getWiFiRb() {
        return findAll(wiFiRb);
    }

    private List<WebElementFacade> getWiFiLabel() {
        return findAll(wiFiTypeLabel);
    }

    public CountryFiltersBlockPage selectWiFiInput(int elementNumber, boolean b) {
        scrolling(500);
        List<WebElementFacade> RbList = getWiFiRb();
        if (!RbList.get(elementNumber - 1).isSelected() == b) {
            getWiFiLabel().get(elementNumber - 1).click();
        }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    private List<WebElementFacade> getWaterGamesList() {
        return findAll(waterGames);
    }

    public CountryFiltersBlockPage selectWaterGame(int number) {
        scrolling(600);
        WebElement element = getWaterGamesList().get(number);
        element.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    private List<WebElementFacade> getHotelFacilitiesList() {
        return findAll(hotelFacilities);
    }

    public CountryFiltersBlockPage selectHotelFacility(int number) {
        scrolling(700);
        WebElement element = getHotelFacilitiesList().get(number);
        element.click();
        return new CountryFiltersBlockPage();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    private List<WebElementFacade> getFamilyWithChildrenList() {
        return findAll(forFamilyWithChildren);
    }

    public CountryFiltersBlockPage selectFamilyWithChildren(int number) {
        scrolling(1000);
        WebElement element = getFamilyWithChildrenList().get(number);
        element.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    private List<WebElementFacade> getTourOperatorsList() {
        return findAll(tourOperators);
    }

    private CountryFiltersBlockPage showAllTourOperators() {
        find(showAllTourOperators).click();
        return this;
    }

    public CountryFiltersBlockPage selectAnyTourOperator(int number) {
        scrolling(1100);
        List<WebElementFacade> webElements = getTourOperatorsList();
        if (!webElements.get(number - 1).isDisplayed()) {
            showAllTourOperators();
            webElements.get(number - 1).click();
        }
        webElements.get(number - 1).click();
        return this;
    }

    public CountryFiltersBlockPage selectAllTourOperators() {
        scrolling(1100);
        List<WebElementFacade> webElements = getTourOperatorsList();
        showAllTourOperators();
        for (WebElement element : webElements) {
            element.click();
        }
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersBlockPage clickLocalClearFilter() {
        WebElement element = find(clearOneTypeFilter);
        element.click();
        return new CountryFiltersBlockPage();
    }

    public CountryFiltersBlockPage clickFewLocalClearFilter() {
        List<WebElementFacade> webElements = findAll(clearOneTypeFilter);
        if (webElements.size() > 0) {
            for (WebElement element : webElements) {
                element.click();
            }
        }
        return new CountryFiltersBlockPage();
    }

    //Сбросить все фильтры:
    public CountryFiltersBlockPage clickAllClearFilter() {
        scrolling(1200);
        find(clearAllFiltersButton).click();
        return new CountryFiltersBlockPage();
    }


    /////////////////////////////////////////////////////////////////////////////////
    //Общие служебные методы:

    private void selectFirstAndLastCB(List<WebElementFacade> facadeList) {
        LinkedList<WebElementFacade> list = new LinkedList<>(getHotelStarsListInputs());
        list.getFirst().click();
        list.getLast().click();
    }

    private void selectAllCB(List<WebElementFacade> facadeList) {
        for (WebElementFacade element : facadeList) {
            element.click();
        }
    }

    private void bufferInput(WebElement element) {
        String SelectAll = Keys.chord(Keys.ENTER, "a");
        String CutAll = Keys.chord(Keys.ENTER, "x");
        String PasteAll = Keys.chord(Keys.ENTER, "v");
        element.sendKeys(SelectAll);
        element.sendKeys(CutAll);
        element.sendKeys(PasteAll);
    }


    private void scrolling(int number) {
        JavascriptExecutor JSE = (JavascriptExecutor) getDriver();
        String s = "window.scrollBy(0, %s)";
        JSE.executeScript(String.format(s, number), "");
        waitMethod(1000);
    }

    private void waitMethod(int countOfMs) {
        try {
            Thread.sleep(countOfMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
