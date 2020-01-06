package levelTravel.Pack.Pages.CountryPage.Interfaces;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface Filterable {

    By speedAcceptTumbler = By.xpath("//span[@class='toggle-switch__button-pin']");
    By priceTowers = By.xpath("//div[@class='filter-budget__cols']//button");
    By priceInputs = By.xpath("//div[@class='filter-budget__fields']//input");
    By inputStarsOfHotels = By.xpath("//ul[@class='checkbox-group__list filter-stars__list']//input");
    By spanStarsOfHotels = By.xpath("//ul[@class='checkbox-group__list filter-stars__list']//span[@class='checkbox__custom']");
    By inputHotelName = By.xpath("//input[@placeholder='Введите название отеля']");
    By hotelsRating = By.xpath("//div[@class='filter-rating']//li");
    By distanceToSea = By.xpath("//div[@class='distance']//li");
    By inputPrivateBeach = By.xpath("//div[@class='checkbox-group__item-container filter-beach__item-container']/input");
    By spanPrivateBeach = By.xpath("//div[@class='checkbox-group__item-container filter-beach__item-container']/span");
    By typesOfBeach = By.xpath("//ul[@class='checkbox-group__list block__list']//li");
    By foodTypes = By.xpath("//div[@class='checkbox-group filter-pansion__checkbox-group']//li");
    By showAllFoodTypes = By.xpath("//button[text()='Показать все типы питания']");
    By regionTypes = By.xpath("//div[@class='checkbox-group__presets-container']//button");
    By regionList = By.xpath("//ul[@class='checkbox-group__list filter-region__list']//li//input");
    By showAllRegions = By.xpath("//button[normalize-space()='Показать все регионы']");
    By hotelTypes = By.xpath("//ul[@class='checkbox-group__list filter-category__list']//li");
    By wiFiRb = By.xpath("//ul[@class='radio-group']//div");
    By wiFiTypeLabel = By.xpath("//ul[@class='radio-group']//label");
    By waterGames = By.xpath("//ul[@class='checkbox-group__list filter-spa__list']//li");
    By hotelFacilities = By.xpath("//ul[@class='checkbox-group__list filter-facilities__list']//li");
    By forFamilyWithChildren = By.xpath("//ul[@class='checkbox-group__list filter-family_with_kids__list']//li");
    By tourOperators = By.xpath("//ul[@class='checkbox-group__list filter-operator__list']//li");
    By showAllTourOperators = By.xpath("//button[text()='Показать всех туроператоров']");
    By clearOneTypeFilter = By.xpath("//button[@class='filters__filter-clear']");
    By clearAllFiltersButton = By.xpath("//button[text()='Сбросить все фильтры']");

    //свитчер моментального подтверждения:
    public CountryFiltersBlockPage switchMomentConfirmTumbler(boolean b);

    ///////////////////////////////////////////////////////////////////////
    //Работа с ценовыми столбцами и интервалом цен в инпутах:

    public WebElement getAnyPriceTower(int towerNumber);

    public CountryFiltersBlockPage selectAnyPriceTower(WebElement element);

    public CountryFiltersBlockPage writeMinIntervalPrice(String anyPrice);

    public CountryFiltersBlockPage writeMaxIntervalPrice(String anyPrice);

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем отели по кол-ву звезд:

    public WebElement getInputOfStarsHotel(int number);

    public WebElement getSpanOfStarsHotel(int number);

    public void clickAnyStars(WebElement element);

    public CountryFiltersBlockPage selectAnyStarsHotel(WebElement span, WebElement input);

    /////////////////////////////////////////////////////////////////////////////////
    //Ищем отель по наименованию:

    public CountryFiltersBlockPage writeHotelName(String hotelName);

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация отелей по рейтингу:

    public WebElement getAnyRating(int number);

    public CountryFiltersBlockPage selectRatingHotel(WebElement webElement);

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    public WebElement getDistanceToSea(int number);

    public CountryFiltersBlockPage selectDistanceToSea(WebElement webElement);

    ///////////////////////////////////////////////////////////////////////////////
    //Фильтрация частных пляжей:

    public WebElement getPrivateBeachInput();

    public WebElement getPrivateBeachSpan();

    public CountryFiltersBlockPage selectPrivateBeachInput(WebElement span, WebElement input, boolean b);

    //////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по типам поверхности пляжа:

    public List<WebElementFacade> getTypesOfBeachList();

    public WebElement getTypeOfBeach(int number);

    public CountryFiltersBlockPage selectTypeOfBeach(WebElement webElement, boolean b);

    public CountryFiltersBlockPage selectAllTypeOfBeach(List<WebElement> webElements);

    ///////////////////////////////////////////////////////////////////////////////////
    //Фильтруем по видам питания:

    public CountryFiltersBlockPage selectTypeFood(int number);

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    public WebElement getRegionType(int number);

    public CountryFiltersBlockPage selectRegionType(WebElement element);

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    public CountryFiltersBlockPage selectAnyRegion(int number);

    public CountryFiltersBlockPage selectAllRegions();

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:

    public WebElement getHotelType(int number);

    public CountryFiltersBlockPage selectHotelType(WebElement element);

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по наличию wi-fi:

    public List<WebElementFacade> getWiFiRb();

    public CountryFiltersBlockPage selectWiFiInput(List<WebElement> Rb, int elementNumber);

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    public CountryFiltersBlockPage selectWaterGame(WebElement element);

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    public WebElement getHotelFacility(int number);

    public CountryFiltersBlockPage selectHotelFacility(WebElement element);

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    public WebElement getFamilyWithChildren(int number);

    public CountryFiltersBlockPage selectFamilyWithChildren(WebElement element);

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    CountryFiltersBlockPage showAllTourOperators();

    public CountryFiltersBlockPage selectAnyTourOperator(int number);

    public CountryFiltersBlockPage selectAllTourOperators();

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersBlockPage clickLocalClearFilter();

    public CountryFiltersBlockPage clickFewLocalClearFilter();

    //Сбросить все фильтры:
    public CountryFiltersBlockPage clickAllClearFilter();

}