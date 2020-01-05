package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Filterable;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountryFiltersBlockPage extends AbstractBasePage implements Filterable {

    //private WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
    private JavascriptExecutor JSE = (JavascriptExecutor) driver;

    public CountryFiltersBlockPage(WebDriver driver) {
        super(driver);
    }


    //свитчер моментального подтверждения:
    public CountryFiltersBlockPage switchMomentConfirmTumbler(boolean b) {
        WebElement element = driver.findElement(speedAcceptTumbler);
        if (!element.isSelected() == b){
            element.click();
        }
        return this;
    }

    ///////////////////////////////////////////////////////////////////////
    //Работа с ценовыми столбцами и интервалом цен в инпутах:

    private List<WebElement> getListOfPriceTowers() {
        return driver.findElements(priceTowers);
    }

    public WebElement getAnyPriceTower(int towerNumber) {
        List<WebElement> webElements = getListOfPriceTowers();
       return webElements.get(towerNumber - 1);
    }

    public CountryFiltersBlockPage selectAnyPriceTower(@NotNull WebElement element) {
        element.click();
        return new CountryFiltersBlockPage(driver);
    }

    private List<WebElement> getPriceInputs() {
        return driver.findElements(priceInputs);
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

    private List<WebElement> getHotelStarsListInputs() {
        return driver.findElements(inputStarsOfHotels);
    }

    private List<WebElement> getHotelStarsListSpans() {
        return driver.findElements(spanStarsOfHotels);
    }

    public WebElement getInputOfStarsHotel(int number) {
        List<WebElement> webElements = getHotelStarsListInputs();
        return webElements.get(number - 1);
    }

    public WebElement getSpanOfStarsHotel(int number) {
        List<WebElement> webElements = getHotelStarsListSpans();
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
        driver.findElement(inputHotelName).sendKeys(hotelName);
        return new CountryFiltersBlockPage(driver);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация отелей по рейтингу:


    private List<WebElement> getRatingHotelsList() {
        return driver.findElements(hotelsRating);
    }

    public WebElement getAnyRating(int number){
        List<WebElement> webElements = getRatingHotelsList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectRatingHotel(@NotNull WebElement webElement) {
        webElement.click();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    private List<WebElement> getDistanceToSeaList() {
        return driver.findElements(distanceToSea);
    }

    public WebElement getDistanceToSea(int number){
        List<WebElement> webElements = getDistanceToSeaList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectDistanceToSea(@NotNull WebElement webElement) {
        webElement.click();
        return this;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //Фильтрация частных пляжей:

    public WebElement getPrivateBeachInput (){
        return driver.findElement(inputPrivateBeach);
    }

    public WebElement getPrivateBeachSpan (){
        return driver.findElement(spanPrivateBeach);
    }

    public CountryFiltersBlockPage selectPrivateBeachInput(@NotNull WebElement span, WebElement input, boolean b){
        if (!span.isSelected() == b){
            input.click();
        }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по типам поверхности пляжа:

    public List<WebElement> getTypesOfBeachList(){
        return driver.findElements(typesOfBeach);
    }

    public WebElement getTypeOfBeach (int number){
        List<WebElement> webElements = getTypesOfBeachList();
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

    private List<WebElement>getFoodTypeList() {
        return driver.findElements(foodTypes);
    }

    private void showAllTypesFood(){
        driver.findElement(showAllFoodTypes).click();
    }

    public CountryFiltersBlockPage selectTypeFood(int number){
        List<WebElement> webElements = getFoodTypeList();
        if (!webElements.get(number - 1).isDisplayed()){
            showAllTypesFood();
            webElements.get(number - 1).click();
        }
            webElements.get(number - 1).click();
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    private List<WebElement> getRegionTypesList(){
        return driver.findElements(regionTypes);
    }

    public WebElement getRegionType(int number){
        List<WebElement> webElements = getRegionTypesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectRegionType(@NotNull WebElement element){
        element.submit();
        return this;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    private List<WebElement>getRegionList() {
        return driver.findElements(regionList);
    }

    private void showAllRegions(){
        JSE.executeScript("window.scrollBy(0, 300)", "");
        WebElement element = driver.findElement(showAllRegions);
        waitMethod(1000);
        if (element.isDisplayed()) element.click();
    }


    public CountryFiltersBlockPage selectAnyRegion(int number){
        JSE.executeScript("window.scrollBy(0, 300)", "");
        waitMethod(1000);
        List<WebElement> webElements = getRegionList();
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
        List<WebElement> webElements = getRegionList();
        showAllRegions();
        for (WebElement element: webElements) {
                element.click();
            }
        return this;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:

    private List<WebElement> getHotelTypesList(){
        return driver.findElements(hotelTypes);
    }

    public WebElement getHotelType(int number){
        JSE.executeScript("window.scrollBy(0, 400)", "");
        waitMethod(1000);
        List<WebElement> webElements = getHotelTypesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectHotelType(@NotNull WebElement element){
        JSE.executeScript("window.scrollBy(0, 400)", "");
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage(driver);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по наличию wi-fi:

    public List<WebElement> getWiFiRb() {
        return driver.findElements(wiFiRb);
    }

    private List<WebElement> getWiFiLabel() {
        return driver.findElements(wiFiTypeLabel);
    }

    public CountryFiltersBlockPage selectWiFiInput(@NotNull List<WebElement> Rb, int elementNumber){
        JSE.executeScript("window.scrollBy(0, 500)", "");
        waitMethod(1000);
        if (!Rb.get(elementNumber - 1).isSelected()){
            getWiFiLabel().get(elementNumber - 1).click();
        }
        return new CountryFiltersBlockPage(driver);
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    private List<WebElement> getWaterGamesList(){
        return driver.findElements(waterGames);
    }

    public WebElement getWaterGame(int number){
        List<WebElement> webElements = getWaterGamesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectWaterGame(@NotNull WebElement element){
        JSE.executeScript("window.scrollBy(0, 550)", "");
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage(driver);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    private List<WebElement> getHotelFacilitiesList(){
        return driver.findElements(hotelFacilities);
    }

    public WebElement getHotelFacility(int number){
        List<WebElement> webElements = getHotelFacilitiesList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectHotelFacility(@NotNull WebElement element){
        JSE.executeScript("window.scrollBy(0, 700)", "");
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage(driver);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    private List<WebElement> getFamilyWithChildrenList(){
        return driver.findElements(forFamilyWithChildren);
    }

    public WebElement getFamilyWithChildren(int number){
        List<WebElement> webElements = getFamilyWithChildrenList();
        return webElements.get(number - 1);
    }

    public CountryFiltersBlockPage selectFamilyWithChildren(@NotNull WebElement element){
        JSE.executeScript("window.scrollBy(0, 1000)", "");
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage(driver);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    private List<WebElement>getTourOperatorsList() {
        return driver.findElements(tourOperators);
    }

    public CountryFiltersBlockPage showAllTourOperators(){
        JSE.executeScript("window.scrollBy(0, 1200)", "");
        waitMethod(1000);
        driver.findElement(showAllTourOperators).click();
        return new CountryFiltersBlockPage(driver);
    }

    public CountryFiltersBlockPage selectAnyTourOperator(int number){
        List<WebElement> webElements = getTourOperatorsList();
        if (!webElements.get(number - 1).isDisplayed()){
            showAllTourOperators();
            webElements.get(number - 1).click();
        }
            webElements.get(number - 1).click();
        return new CountryFiltersBlockPage(driver);
    }

    public CountryFiltersBlockPage selectAllTourOperators(){
        List<WebElement> webElements = getTourOperatorsList();
        showAllTourOperators();
        for (WebElement element: webElements) {
            element.click();
        }
        return new CountryFiltersBlockPage(driver);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersBlockPage clickLocalClearFilter(){
        WebElement element = driver.findElement(clearOneTypeFilter);
        waitMethod(1000);
        element.click();
        return new CountryFiltersBlockPage(driver);
    }

    public CountryFiltersBlockPage clickFewLocalClearFilter(){
        List<WebElement> webElements = driver.findElements(clearOneTypeFilter);
        if(webElements.size() > 0){
            for (WebElement element: webElements) {
                element.click();
            }
        }
        return new CountryFiltersBlockPage(driver);
    }

    //Сбросить все фильтры:
    public CountryFiltersBlockPage clickAllClearFilter(){
        waitMethod(1200);
        JSE.executeScript("window.scrollBy(0, 1200)", "");
        waitMethod(1200);
        driver.findElement(clearAllFiltersButton).click();
        return new CountryFiltersBlockPage(driver);
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
