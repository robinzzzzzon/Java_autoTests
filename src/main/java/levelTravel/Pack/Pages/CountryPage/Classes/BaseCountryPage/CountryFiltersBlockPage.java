package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Filterable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/search/Moscow-RU-to-Any-TR-departure-20.01.2020-for-5..9-nights-2-adults-0-kids-1..5-stars")
public class CountryFiltersBlockPage extends AbstractBasePage implements Filterable {

    //свитчер моментального подтверждения:
    public CountryFiltersBlockPage switchMomentConfirmTumbler(boolean b) {
        WebElement element = find(speedAcceptTumbler);
        if (!element.isSelected() == b){
            element.click();
        }
        return this;
    }

    ///////////////////////////////////////////////////////////////////////
    //Работа с ценовыми столбцами и интервалом цен в инпутах:

    private List<WebElementFacade> getListOfPriceTowers() {
        return findAll(priceTowers);
    }

    private WebElement getAnyPriceTower(int towerNumber) {
        List<WebElementFacade> webElements = getListOfPriceTowers();
       return webElements.get(towerNumber - 1);
    }

    public CountryFiltersBlockPage selectAnyPriceTower(int number) {
        WebElement element = getAnyPriceTower(number);
        element.click();
        return new CountryFiltersBlockPage();
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

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем отели по кол-ву звезд:

    private List<WebElementFacade> getHotelStarsListInputs() {
        return findAll(inputStarsOfHotels);
    }

    private List<WebElementFacade> getHotelStarsListSpans() {
        return findAll(spanStarsOfHotels);
    }

    private WebElement getInputOfStarsHotel(int number) {
        List<WebElementFacade> webElements = getHotelStarsListInputs();
        return webElements.get(number - 1);
    }

    private WebElement getSpanOfStarsHotel(int number) {
        List<WebElementFacade> webElements = getHotelStarsListSpans();
        return webElements.get(number - 1);
    }

    public void clickAnyStars(int number){
        WebElement element = getInputOfStarsHotel(number);
        element.click();
    }

    public CountryFiltersBlockPage selectAnyStarsHotel(int numberOfSpan, int numberOfInput){
        WebElement span = getSpanOfStarsHotel(numberOfSpan);
        WebElement input = getInputOfStarsHotel(numberOfInput);
        if (!span.isSelected()){
            input.click();
        }
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Ищем отель по наименованию:

    public CountryFiltersBlockPage writeHotelName(String hotelName) {
        find(inputHotelName).waitUntilEnabled().sendKeys(hotelName);
        return new CountryFiltersBlockPage();
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация отелей по рейтингу:

    private List<WebElementFacade> getRatingHotelsList() {
        return findAll(hotelsRating);
    }

    private WebElement getAnyRating(int number){
        List<WebElementFacade> webElements = getRatingHotelsList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectRatingHotel(int number) {
        WebElement webElement = getAnyRating(number);
        webElement.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    private List<WebElementFacade> getDistanceToSeaList() {
        return findAll(distanceToSea);
    }

    private WebElement getDistanceToSea(int number){
        List<WebElementFacade> webElements = getDistanceToSeaList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectDistanceToSea(int number) {
        WebElement element = getDistanceToSea(number);
        element.click();
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //Фильтрация частных пляжей:

    private WebElement getPrivateBeachInput (){
        return find(inputPrivateBeach);
    }

    private WebElement getPrivateBeachSpan (){
        return find(spanPrivateBeach);
    }

    public CountryFiltersBlockPage selectPrivateBeachInput(boolean b){
        WebElement span = getPrivateBeachSpan();
        WebElement input = getPrivateBeachInput();
        if (!span.isSelected() == b){
            input.click();
        }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по типам поверхности пляжа:

    private List<WebElementFacade> getTypesOfBeachList(){
        return findAll(typesOfBeach);
    }

    public CountryFiltersBlockPage selectTypeOfBeach(int typeNumber, boolean b){
        WebElement element = getTypesOfBeachList().get(typeNumber);
        if (!element.isSelected() == b) element.click();
        return this;
    }

    public CountryFiltersBlockPage selectAllTypeOfBeach(){
        scrolling(300);
        for (int i = 0; i < getTypesOfBeachList().size(); i++) {
            getTypesOfBeachList().get(i).click();
        }
//        List<WebElementFacade> list = getTypesOfBeachList();
//        for (WebElement element: list) {
//            element.click();
//        }
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //Фильтруем по видам питания:

    private List<WebElementFacade>getFoodTypeList() {
        return findAll(foodTypes);
    }

    private void showAllTypesFood(){
        waitMethod(1000);
        find(showAllFoodTypes).click();
    }

    public CountryFiltersBlockPage selectTypeFood(int number){
        scrolling(400);
        WebElement element = getFoodTypeList().get(number - 1);
        if (!element.isEnabled()){
            showAllTypesFood();
            element.click();
        }
            element.click();
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    private List<WebElementFacade> getRegionTypesList(){
        return findAll(regionTypes);
    }

    private WebElement getRegionType(int number){
        List<WebElementFacade> webElements = getRegionTypesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectRegionType(int regionNumber){
        WebElement element = getRegionType(regionNumber);
        element.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    private List<WebElementFacade> getRegionList() {
        return findAll(regionList);
    }

    private void showAllRegions(){
        find(showAllRegions).waitUntilClickable().click();
    }


    public CountryFiltersBlockPage selectAnyRegion(int number){
        scrolling(500);
        WebElement element = getRegionList().get(number - 1);
        if (!element.isEnabled()){
            showAllRegions();
            element.click();
        }
        element.click();
        return new CountryFiltersBlockPage();
    }


    public CountryFiltersBlockPage selectAllRegions(){
        scrolling(500);
        List<WebElementFacade> webElements = getRegionList();
        showAllRegions();
        for (WebElement element: webElements) {
                element.click();
            }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:

    private List<WebElementFacade> getHotelTypesList(){
        return findAll(hotelTypes);
    }

    private WebElement getHotelType(int number){
        List<WebElementFacade> webElements = getHotelTypesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectHotelType(int number){
        scrolling(600);
        WebElement element = getHotelType(number);
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

    public CountryFiltersBlockPage selectWiFiInput(int elementNumber, boolean b){
        scrolling(500);
        List<WebElementFacade> RbList = getWiFiRb();
        if (!RbList.get(elementNumber - 1).isSelected() == b){
            getWiFiLabel().get(elementNumber - 1).click();
        }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    private List<WebElementFacade> getWaterGamesList(){
        return findAll(waterGames);
    }

    private WebElement getWaterGame(int number){
        List<WebElementFacade> webElements = getWaterGamesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectWaterGame(int number){
        scrolling(600);
        WebElement element = getWaterGame(number);
        element.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    private List<WebElementFacade> getHotelFacilitiesList(){
        return findAll(hotelFacilities);
    }

    private WebElement getHotelFacility(int number){
        List<WebElementFacade> webElements = getHotelFacilitiesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectHotelFacility(int number){
        scrolling(700);
        WebElement element = getHotelFacility(number);
        element.click();
        return new CountryFiltersBlockPage();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    private List<WebElementFacade> getFamilyWithChildrenList(){
        return findAll(forFamilyWithChildren);
    }

    private WebElement getFamilyWithChildren(int number){
        List<WebElementFacade> webElements = getFamilyWithChildrenList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectFamilyWithChildren(int number){
        scrolling(1000);
        WebElement element = getFamilyWithChildren(number);
        element.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    private List<WebElementFacade>getTourOperatorsList() {
        return findAll(tourOperators);
    }

    private CountryFiltersBlockPage showAllTourOperators(){
        find(showAllTourOperators).click();
        return this;
    }

    public CountryFiltersBlockPage selectAnyTourOperator(int number){
        scrolling(1100);
        List<WebElementFacade> webElements = getTourOperatorsList();
        if (!webElements.get(number - 1).isDisplayed()){
            showAllTourOperators();
            webElements.get(number - 1).click();
        }
            webElements.get(number - 1).click();
        return this;
    }

    public CountryFiltersBlockPage selectAllTourOperators(){
        scrolling(1100);
        List<WebElementFacade> webElements = getTourOperatorsList();
        showAllTourOperators();
        for (WebElement element: webElements) {
            element.click();
        }
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersBlockPage clickLocalClearFilter(){
        WebElement element = find(clearOneTypeFilter);
        element.click();
        return new CountryFiltersBlockPage();
    }

    public CountryFiltersBlockPage clickFewLocalClearFilter(){
        List<WebElementFacade> webElements = findAll(clearOneTypeFilter);
        if(webElements.size() > 0){
            for (WebElement element: webElements) {
                element.click();
            }
        }
        return new CountryFiltersBlockPage();
    }

    //Сбросить все фильтры:
    public CountryFiltersBlockPage clickAllClearFilter(){
        scrolling(1200);
        find(clearAllFiltersButton).click();
        return new CountryFiltersBlockPage();
    }


    /////////////////////////////////////////////////////////////////////////////////


    private void scrolling(int number){
        JavascriptExecutor JSE = (JavascriptExecutor) getDriver();
        String s = "window.scrollBy(0, %s)";
        JSE.executeScript(String.format(s, number), "");
        waitMethod(1000);
    }

    private void waitMethod(int countOfMs){
        try {
            Thread.sleep(countOfMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
