package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Filterable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-28.02.2020-for-7-nights-2-adults-0-kids-1..5-stars")
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
        selectAnyCB(number, getListOfPriceTowers());
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
        selectAnyCB(number, getRatingHotelsList());
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    private List<WebElementFacade> getDistanceToSeaList() {
        return findAll(distanceToSea);
    }

    public CountryFiltersBlockPage selectDistanceToSea(int number) {
        selectAnyCB(number, getDistanceToSeaList());
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
        scrolling(300);
        WebElement element = getTypesOfBeachList().get(typeNumber - 1);
        if (!element.isSelected() == b) element.click();
        return this;
    }

    public void selectFirstAndLastBeachType() {
        scrolling(300);
        selectFirstAndLastCB(getTypesOfBeachList());
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

    public void selectTypeFood(int number) {
        scrolling(400);
        selectAnyCB(number, getFoodTypeList(), showAllFoodTypes);
    }

    public void selectAllFoodType() {
        scrolling(400);
        selectAllCB(getFoodTypeList(), showAllFoodTypes);
    }


    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    private List<WebElementFacade> getRegionTypesList() {
        return findAll(regionTypes);
    }

    public void selectRegionType(int regionNumber) {
        scrolling(450);
        selectAnyCB(regionNumber, getRegionTypesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    private List<WebElementFacade> getRegionList() {
        return findAll(regionList);
    }

    public void selectAnyRegion(int number) {
        scrolling(500);
        selectAnyCB(number, getRegionList(), showAllRegions);
    }

    public void selectFirstAndLastRegion() {
        scrolling(500);
        selectFirstAndLastCB(getRegionList(), showAllRegions);
    }

    public void selectAllRegions() {
        scrolling(500);
        selectAllCB(getRegionList(), showAllRegions);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:

    private List<WebElementFacade> getHotelTypesList() {
        return findAll(hotelTypes);
    }

    public void selectHotelType(int number) {
        scrolling(700);
        selectAnyCB(number, getHotelTypesList());
    }

    public void selectFirstAndLastHotelTypes() {
        scrolling(700);
        selectFirstAndLastCB(getHotelTypesList());
    }

    public void selectAllHotelTypes() {
        scrolling(700);
        selectAllCB(getHotelTypesList());
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по наличию wi-fi:

    private List<WebElementFacade> getWiFiRb() {
        return findAll(wiFiRb);
    }

    private List<WebElementFacade> getWiFiLabel() {
        return findAll(wiFiTypeLabel);
    }

    public void selectWiFiInput(int elementNumber, boolean b) {
        scrolling(800);
        List<WebElementFacade> RbList = getWiFiRb();
        if (!RbList.get(elementNumber - 1).isSelected() == b) {
            getWiFiLabel().get(elementNumber - 1).click();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    private List<WebElementFacade> getWaterGamesList() {
        return findAll(waterGames);
    }

    public void selectWaterGame(int number) {
        scrolling(900);
        selectAnyCB(number, getWaterGamesList());
    }

    public void selectFirstAndLastWaterGames() {
        scrolling(900);
        selectFirstAndLastCB(getWaterGamesList());
    }

    public void selectAllWaterGames() {
        scrolling(900);
        selectAllCB(getWaterGamesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    private List<WebElementFacade> getHotelFacilitiesList() {
        return findAll(hotelFacilities);
    }

    public void selectHotelFacility(int number) {
        scrolling(1000);
        selectAnyCB(number, getHotelFacilitiesList());
    }

    public void selectFirstAndLastFacilities() {
        scrolling(1000);
        selectFirstAndLastCB(getHotelFacilitiesList());
    }

    public void selectAllFacilities() {
        scrolling(1000);
        selectAllCB(getHotelFacilitiesList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    private List<WebElementFacade> getFamilyWithChildrenList() {
        return findAll(forFamilyWithChildren);
    }

    public void selectAnyVariationFamilyWithChildren(int number) {
        scrolling(1200);
        selectAnyCB(number, getFamilyWithChildrenList());
    }

    public void selectFirstAndLastFamilyWithChildren() {
        scrolling(1200);
        selectFirstAndLastCB(getFamilyWithChildrenList());
    }

    public void selectAllFamilyWithChildren() {
        scrolling(1200);
        selectAllCB(getFamilyWithChildrenList());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    private List<WebElementFacade> getTourOperatorsList() {
        return findAll(tourOperators);
    }

    public void selectAnyTourOperator(int number) {
        scrolling(1500);
        selectAnyCB(number, getTourOperatorsList(), showAllTourOperators);
    }

    public void selectFirstAndLastTourOperators(){
        scrolling(1500);
        selectFirstAndLastCB(getTourOperatorsList(), showAllTourOperators);
    }

    public void selectAllTourOperators() {
        scrolling(1500);
        selectAllCB(getTourOperatorsList(), showAllTourOperators);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersBlockPage clickLocalClearFilter() {
        WebElement element = find(clearOneTypeFilter);
        element.click();
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
        scrolling(1600);
        find(clearAllFiltersButton).click();
    }


    /////////////////////////////////////////////////////////////////////////////////
    //Общие служебные методы:
    //Продолжить переносить сюда методы встречающиеся не единожды по классу!

    private void selectAnyCB(int CbNumber, List<WebElementFacade> list) {
        list.get(CbNumber - 1).click();
    }

    private void selectAnyCB(int CbNumber, List<WebElementFacade> list, By by) {
        WebElement element = list.get(CbNumber - 1);
        WebElement showElement = find(by);
        if (!element.isDisplayed() || !element.isEnabled()) {
            showElement.click();
            element.click();
        } else {
            element.click();
        }
    }

    private void selectFirstAndLastCB(List<WebElementFacade> facadeList) {
        LinkedList<WebElementFacade> list = new LinkedList<>(facadeList);
        list.getFirst().click();
        list.getLast().click();
    }

    private void selectFirstAndLastCB(List<WebElementFacade> facadeList, By by) {
        LinkedList<WebElementFacade> list = new LinkedList<>(facadeList);
        list.getFirst().click();
        find(by).waitUntilClickable().click();
        list.getLast().click();
    }

    private void selectAllCB(List<WebElementFacade> facadeList) {
        for (WebElementFacade element : facadeList) {
            element.click();
        }
    }

    private void selectAllCB(List<WebElementFacade> facadeList, By by) {
        for (WebElementFacade element : facadeList) {
            if (!element.isDisplayed()) {
                find(by).waitUntilClickable().click();
            } else {
                element.waitUntilClickable().click();
            }
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
