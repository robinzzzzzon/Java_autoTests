package levelTravel.Pack.Pages.CountryPage.Interfaces;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import org.openqa.selenium.By;

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

    void selectAnyPriceTower(int number);

    CountryFiltersBlockPage writeMinIntervalPrice(String anyPrice);

    CountryFiltersBlockPage writeMaxIntervalPrice(String anyPrice);

    void putAnyPriceInPriceInput(boolean b);

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем отели по кол-ву звезд:

    void selectAnyStarsHotel(boolean b, int numberOfSpan, int numberOfInput);

    void selectFirstAndLastStars();

    void selectAllStars();

    /////////////////////////////////////////////////////////////////////////////////
    //Ищем отель по наименованию:

    CountryFiltersBlockPage writeHotelName(String hotelName);

    CountryFiltersBlockPage writeHotelNameFromBuffer(String anyHotelName);

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация отелей по рейтингу:

    CountryFiltersBlockPage selectRatingHotel(int number);

    /////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по удаленности от моря:

    CountryFiltersBlockPage selectDistanceToSea(int number);

    ///////////////////////////////////////////////////////////////////////////////
    //Фильтрация частных пляжей:

    CountryFiltersBlockPage selectPrivateBeachInput(boolean b);

    //////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по типам поверхности пляжа:

    CountryFiltersBlockPage selectTypeOfBeach(int typeNumber, boolean b);

    void selectFirstAndLastBeachType();

    CountryFiltersBlockPage selectAllTypeOfBeach();

    ///////////////////////////////////////////////////////////////////////////////////
    //Фильтруем по видам питания:

    void selectTypeFood(int number);

    void selectAllFoodType();

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем по виду местности:

    void selectRegionType(int regionNumber);

    /////////////////////////////////////////////////////////////////////////////////////
    //Фильтруем список регионов:

    void selectAnyRegion(int number);

    void selectFirstAndLastRegion();

    void selectAllRegions();

    //////////////////////////////////////////////////////////////////////////////////////
    //Выбираем тип отеля:
    void selectHotelType(int number);

    void selectFirstAndLastHotelTypes();

    void selectAllHotelTypes();

    //////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по наличию wi-fi:

    void selectWiFiInput(int elementNumber, boolean b);

    //////////////////////////////////////////////////////////////////////////////////////////
    //Наличие вида игр на воде:

    void selectWaterGame(int number);

    void selectFirstAndLastWaterGames();

    void selectAllWaterGames();

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Удобства в номере отеля:

    void selectHotelFacility(int number);

    void selectFirstAndLastFacilities();

    void selectAllFacilities();

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Работа со списком услуг для семей с детьми:

    void selectAnyVariationFamilyWithChildren(int number);

    void selectFirstAndLastFamilyWithChildren();

    void selectAllFamilyWithChildren();

    /////////////////////////////////////////////////////////////////////////////////////////////
    //Фильтрация по списку операторов:

    void selectAnyTourOperator(int number);

    void selectFirstAndLastTourOperators();

    void selectAllTourOperators();

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Сброс одной и более настроек фильтра:

    CountryFiltersBlockPage clickLocalClearFilter();

    void clickFewLocalClearFilter();

    //Сбросить все фильтры:
    void clickAllClearFilter();

}