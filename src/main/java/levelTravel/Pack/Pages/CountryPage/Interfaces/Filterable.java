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

    public CountryFiltersBlockPage selectAnyPriceTower(int number);

    public CountryFiltersBlockPage writeMinIntervalPrice(String anyPrice);

    public CountryFiltersBlockPage writeMaxIntervalPrice(String anyPrice);

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем отели по кол-ву звезд:

    public void clickAnyStars(int number);

    public CountryFiltersBlockPage selectAnyStarsHotel(int numberOfSpan, int numberOfInput);

    /////////////////////////////////////////////////////////////////////////////////
    //Ищем отель по наименованию:

    public CountryFiltersBlockPage writeHotelName(String hotelName);

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация отелей по рейтингу:

    public CountryFiltersBlockPage selectRatingHotel(int number);

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    public CountryFiltersBlockPage selectDistanceToSea(int number);

    ///////////////////////////////////////////////////////////////////////////////
    //Фильтрация частных пляжей:

    public CountryFiltersBlockPage selectPrivateBeachInput(boolean b);

    //////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по типам поверхности пляжа:

    public CountryFiltersBlockPage selectTypeOfBeach(int typeNumber, boolean b);

    public CountryFiltersBlockPage selectAllTypeOfBeach();

    ///////////////////////////////////////////////////////////////////////////////////
    //Фильтруем по видам питания:

    public CountryFiltersBlockPage selectTypeFood(int number);

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    public CountryFiltersBlockPage selectRegionType(int regionNumber);

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    public CountryFiltersBlockPage selectAnyRegion(int number);

    public CountryFiltersBlockPage selectAllRegions();

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:
    public CountryFiltersBlockPage selectHotelType(int number);

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по наличию wi-fi:

    public CountryFiltersBlockPage selectWiFiInput(int elementNumber, boolean b);

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    public CountryFiltersBlockPage selectWaterGame(int number);

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    public CountryFiltersBlockPage selectHotelFacility(int number);

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    public CountryFiltersBlockPage selectFamilyWithChildren(int number);

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    public CountryFiltersBlockPage selectAnyTourOperator(int number);

    public CountryFiltersBlockPage selectAllTourOperators();

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    public CountryFiltersBlockPage clickLocalClearFilter();

    public CountryFiltersBlockPage clickFewLocalClearFilter();

    //Сбросить все фильтры:
    public CountryFiltersBlockPage clickAllClearFilter();

}