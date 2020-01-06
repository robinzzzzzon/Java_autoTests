package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.CountryPage.Interfaces.Filterable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountryFiltersBlockPage extends PageObject implements Filterable {

    private JavascriptExecutor JSE = (JavascriptExecutor) getDriver();

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

    public WebElement getAnyPriceTower(int towerNumber) {
        List<WebElementFacade> webElements = getListOfPriceTowers();
       return webElements.get(towerNumber - 1);
    }

    public CountryFiltersBlockPage selectAnyPriceTower(@NotNull WebElement element) {
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

    public WebElement getInputOfStarsHotel(int number) {
        List<WebElementFacade> webElements = getHotelStarsListInputs();
        return webElements.get(number - 1);
    }

    public WebElement getSpanOfStarsHotel(int number) {
        List<WebElementFacade> webElements = getHotelStarsListSpans();
        return webElements.get(number - 1);
    }

    public void clickAnyStars(@NotNull WebElement element){
        element.click();
    }

    public CountryFiltersBlockPage selectAnyStarsHotel(@NotNull WebElement span, WebElement input){
        if (!span.isSelected()){
            input.click();
        }
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Ищем отель по наименованию:

    public CountryFiltersBlockPage writeHotelName(String hotelName) {
        find(inputHotelName).sendKeys(hotelName);
        return new CountryFiltersBlockPage();
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация отелей по рейтингу:


    private List<WebElementFacade> getRatingHotelsList() {
        return findAll(hotelsRating);
    }

    public WebElement getAnyRating(int number){
        List<WebElementFacade> webElements = getRatingHotelsList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectRatingHotel(@NotNull WebElement webElement) {
        webElement.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    private List<WebElementFacade> getDistanceToSeaList() {
        return findAll(distanceToSea);
    }

    public WebElement getDistanceToSea(int number){
        List<WebElementFacade> webElements = getDistanceToSeaList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectDistanceToSea(@NotNull WebElement webElement) {
        webElement.click();
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //Фильтрация частных пляжей:

    public WebElement getPrivateBeachInput (){
        return find(inputPrivateBeach);
    }

    public WebElement getPrivateBeachSpan (){
        return find(spanPrivateBeach);
    }

    public CountryFiltersBlockPage selectPrivateBeachInput(@NotNull WebElement span, WebElement input, boolean b){
        if (!span.isSelected() == b){
            input.click();
        }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по типам поверхности пляжа:

    public List<WebElementFacade> getTypesOfBeachList(){
        return findAll(typesOfBeach);
    }

    public WebElement getTypeOfBeach (int number){
        List<WebElementFacade> webElements = getTypesOfBeachList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectTypeOfBeach(@NotNull WebElement webElement, boolean b){
        if (!webElement.isSelected() == b) webElement.click();
        return this;
    }

    public CountryFiltersBlockPage selectAllTypeOfBeach(@NotNull List<WebElement> webElements){
        for (WebElement element: webElements) {
            element.click();
        }
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //Фильтруем по видам питания:

    private List<WebElementFacade>getFoodTypeList() {
        return findAll(foodTypes);
    }

    private void showAllTypesFood(){
        find(showAllFoodTypes).click();
    }

    public CountryFiltersBlockPage selectTypeFood(int number){
        List<WebElementFacade> webElements = getFoodTypeList();
        if (!webElements.get(number - 1).isDisplayed()){
            showAllTypesFood();
            webElements.get(number - 1).click();
        }
            webElements.get(number - 1).click();
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    private List<WebElementFacade> getRegionTypesList(){
        return findAll(regionTypes);
    }

    public WebElement getRegionType(int number){
        List<WebElementFacade> webElements = getRegionTypesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectRegionType(@NotNull WebElement element){
        element.submit();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    private List<WebElementFacade>getRegionList() {
        return findAll(regionList);
    }

    private void showAllRegions(){
        JSE.executeScript("window.scrollBy(0, 300)", "");
        WebElement element = find(showAllRegions);
        waitMethod(1000);
        if (element.isDisplayed()) element.click();
    }


    public CountryFiltersBlockPage selectAnyRegion(int number){
        JSE.executeScript("window.scrollBy(0, 300)", "");
        waitMethod(1000);
        List<WebElementFacade> webElements = getRegionList();
        if (!webElements.get(number - 1).isDisplayed()){
            showAllRegions();
            webElements.get(number - 1).click();
        }
        webElements.get(number - 1).click();
        return this;
    }


    public CountryFiltersBlockPage selectAllRegions(){
        JSE.executeScript("window.scrollBy(0, 300)", "");
        waitMethod(1000);
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

    public WebElement getHotelType(int number){
        JSE.executeScript("window.scrollBy(0, 400)", "");
        waitMethod(1000);
        List<WebElementFacade> webElements = getHotelTypesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectHotelType(@NotNull WebElement element){
        JSE.executeScript("window.scrollBy(0, 400)", "");
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage();
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по наличию wi-fi:

    public List<WebElementFacade> getWiFiRb() {
        return findAll(wiFiRb);
    }

    private List<WebElementFacade> getWiFiLabel() {
        return findAll(wiFiTypeLabel);
    }

    public CountryFiltersBlockPage selectWiFiInput(@NotNull List<WebElement> Rb, int elementNumber){
        JSE.executeScript("window.scrollBy(0, 500)", "");
        waitMethod(1000);
        if (!Rb.get(elementNumber - 1).isSelected()){
            getWiFiLabel().get(elementNumber - 1).click();
        }
        return new CountryFiltersBlockPage();
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    private List<WebElementFacade> getWaterGamesList(){
        return findAll(waterGames);
    }

    public WebElement getWaterGame(int number){
        List<WebElementFacade> webElements = getWaterGamesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectWaterGame(@NotNull WebElement element){
        JSE.executeScript("window.scrollBy(0, 550)", "");
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    private List<WebElementFacade> getHotelFacilitiesList(){
        return findAll(hotelFacilities);
    }

    public WebElement getHotelFacility(int number){
        List<WebElementFacade> webElements = getHotelFacilitiesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectHotelFacility(@NotNull WebElement element){
        JSE.executeScript("window.scrollBy(0, 700)", "");
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    private List<WebElementFacade> getFamilyWithChildrenList(){
        return findAll(forFamilyWithChildren);
    }

    public WebElement getFamilyWithChildren(int number){
        List<WebElementFacade> webElements = getFamilyWithChildrenList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectFamilyWithChildren(@NotNull WebElement element){
        JSE.executeScript("window.scrollBy(0, 1000)", "");
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    private List<WebElementFacade>getTourOperatorsList() {
        return findAll(tourOperators);
    }

    public CountryFiltersBlockPage showAllTourOperators(){
        JSE.executeScript("window.scrollBy(0, 1200)", "");
        waitMethod(1000);
        find(showAllTourOperators).click();
        return new CountryFiltersBlockPage();
    }

    public CountryFiltersBlockPage selectAnyTourOperator(int number){
        List<WebElementFacade> webElements = getTourOperatorsList();
        if (!webElements.get(number - 1).isDisplayed()){
            showAllTourOperators();
            webElements.get(number - 1).click();
        }
            webElements.get(number - 1).click();
        return new CountryFiltersBlockPage();
    }

    public CountryFiltersBlockPage selectAllTourOperators(){
        List<WebElementFacade> webElements = getTourOperatorsList();
        showAllTourOperators();
        for (WebElement element: webElements) {
            element.click();
        }
        return new CountryFiltersBlockPage();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersBlockPage clickLocalClearFilter(){
        WebElement element = find(clearOneTypeFilter);
        waitMethod(1000);
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
        waitMethod(1200);
        JSE.executeScript("window.scrollBy(0, 1200)", "");
        waitMethod(1200);
        find(clearAllFiltersButton).click();
        return new CountryFiltersBlockPage();
    }


    /////////////////////////////////////////////////////////////////////////////////

    private void waitMethod(int countOfMs){
        try {
            Thread.sleep(countOfMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
