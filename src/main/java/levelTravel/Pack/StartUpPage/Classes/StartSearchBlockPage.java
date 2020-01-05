package levelTravel.Pack.StartUpPage.Classes;

import levelTravel.Pack.AbstractPage.AbstractBasePage;
import levelTravel.Pack.HelperClass.TableForStartSearchBlockPage;
import levelTravel.Pack.HelperClass.CountryFactory;
import levelTravel.Pack.StartUpPage.Interfaces.Searchable;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class StartSearchBlockPage extends AbstractBasePage implements Searchable {

    public StartSearchBlockPage(WebDriver driver) {
        super(driver);
    }

    ////////////////////////////
    //Работа со списками стран и с самим полем выбора страны:

    public StartSearchBlockPage writeAnyCountryName(String anyPlace) {
        driver.findElement(searchCountryInput).sendKeys(anyPlace);
        driver.findElement(searchCountryInput).sendKeys(Keys.chord(Keys.ENTER));
        return this;
    }

    public StartSearchBlockPage clickCountryInput(){
        driver.findElement(searchCountryInput).click();
        return this;
    }

    public WebElement getPopularCountry(int elementNumber){
        List<WebElement> webElements = driver.findElements(popularCountriesList);
        return webElements.get(elementNumber - 1);
    }

    public StartSearchBlockPage clickGettingPopularCountry(@NotNull WebElement webElement){
        webElement.click();
        return this;
    }

    public WebElement getWholeCountry(int elementNumber){
        List<WebElement> webElements = driver.findElements(wholeCountriesList);
        return webElements.get(elementNumber - 1);
    }

    public StartSearchBlockPage clickGettingWholeCountry(@NotNull WebElement webElement){
        webElement.click();
        return this;
    }

    /////////////////////////////
    //Работаем со списком ошибок на странице:

    //Получаем лист объектов класса Error:
    public List<WebElement> getErrors () {
        return driver.findElements(errorListByClass);
    }

    //Получает текст ошибки по номеру объекта ошибки из колекции:
    public String getErrorByText (int number) {
        return getErrors().get(number).getText();
    }

    //Возвращает true, если:
    //Массив содержит ошибку с нашим message и соотв-нно > 0
    //первая ошибка в массиве отображается.
    public boolean isErrorVisible(String message) {
        return driver.findElements(By.xpath(String.format(errorListByText, message))).size() > 0
                && driver.findElements(By.xpath(String.format(errorListByText, message))).get(0).isDisplayed();
    }

    /////////////////////////////
    //Работа с календарем и выбором даты:

    public StartSearchBlockPage clickCalendarInput(){
        driver.findElement(calendarInput).click();
        return this;
    }

    //Метод для  пролистывания месяцев календаря:
    private void clickSwitchToNextMonth(int countMonth){
        for (int i = 0; i < countMonth; i++) {
            driver.findElement(switchToNextMonth).click();
        }
    }

    //Метод, в котором на входе задаем номер строки/столбца и номер месяца
    //Далее мы помещаем в вэбэлемент найденный элемент таблицы и подаем его на вход в конструктор класса TableForStartSearchBlockPage.
    //В итоге возвращаем объект ввиде ячейки календаря.
    private WebElement getCalendarDate(int row, int column, int setMonthNumber){

        WebElement element = driver.findElement(By.xpath(String.format(calendarTBody, setMonthNumber)));
        TableForStartSearchBlockPage tableForStartSearchBlockPage = new TableForStartSearchBlockPage(element, driver);
        return tableForStartSearchBlockPage.getValueFromCell(row, column);
    }

    //Метод получает текущее значение месяца, парсит его и возвращает инт.
    private int getCurrentParseMonth(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("MM");
         return Integer.parseInt(simpleDateFormat.format(date));
    }

    //Параметризованный метод со входом countSwitch =< 3 для каждого месяца.
    public WebElement getCalendarDateForWholeYear(int row, int column, int countSwitch){

        int month = getCurrentParseMonth();
        clickSwitchToNextMonth(countSwitch);

        if(month == 12){
            return getCalendarDate(row, column, countSwitch);
        } else if (month == 11) {
            if (countSwitch == 1) return getCalendarDate(row, column, countSwitch + 11);
            else if (countSwitch == 2) return getCalendarDate(row, column, countSwitch - 1);
            else if (countSwitch == 3) return getCalendarDate(row, column, countSwitch - 1);
        } else if (month == 10) {
            if (countSwitch == 1) return getCalendarDate(row, column, countSwitch + 10);
            else if (countSwitch == 2) return getCalendarDate(row, column, countSwitch + 10);
            else if (countSwitch == 3) return getCalendarDate(row, column, countSwitch - 2);
        } else if (month == 9) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3) return getCalendarDate(row, column, countSwitch + 9);
        } else if (month == 8) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3) return getCalendarDate(row, column, countSwitch + 8);
        } else if (month == 7) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3) return getCalendarDate(row, column, countSwitch + 7);
        } else if (month == 6) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3) return getCalendarDate(row, column, countSwitch + 6);
        } else if (month == 5) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3) return getCalendarDate(row, column, countSwitch + 5);
        } else if (month == 4) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3) return getCalendarDate(row, column, countSwitch + 4);
        } else if (month == 3) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3) return getCalendarDate(row, column, countSwitch + 3);
        } else if (month == 2) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3) return getCalendarDate(row, column, countSwitch + 2);
        }
            return getCalendarDate(row, column, countSwitch + 1);
    }


    public StartSearchBlockPage clickAdd2Days(){
        driver.findElement(add2days).click();
        return this;
    }

    public StartSearchBlockPage selectCalendarDate(@NotNull WebElement webElement){
        webElement.click();
        return this;
    }

    ////////////////////////////////////////////////////////////////////////////////
    //Работа с полем выбора периода кол-ва ночей:

    public StartSearchBlockPage clickCountOfNights(){
        driver.findElement(dayIntervalDD).click();
        return this;
    }

    public StartSearchBlockPage minusNight(){
        driver.findElement(minusDay).click();
        return this;
    }

    public StartSearchBlockPage plusNight(){
        driver.findElement(plusDay).click();
        return this;
    }

    public StartSearchBlockPage add2Nights(boolean b){
        WebElement element = driver.findElement(plusOrMinus2Days);
        if (!element.isSelected() == b){
            element.click();
        }
        return this;
    }

    /////////////////////////////
    //Выбираем кол-во пассажиров:

    public StartSearchBlockPage clickCountOfPassengers(){
        driver.findElement(countOfPassengersDD).click();
        return this;
    }

    public void addChildren(){
        driver.findElement(addChildrenDD).click();
    }

    public WebElement getVariableAddChildren(int variationChild){
        addChildren();
        List<WebElement> webElements = driver.findElements(childVaryingList);
        return webElements.get(variationChild);
    }

    public StartSearchBlockPage selectVariationAddChild(@NotNull WebElement webElement){
        webElement.click();
        return this;
    }

    public StartSearchBlockPage minusPassenger(){
        driver.findElement(minusPassenger).click();
        return this;
    }

    public StartSearchBlockPage plusPassenger(){
        driver.findElement(plusPassenger).click();
        return this;
    }

    /////////////////////////////////
    //Выбираем стартовую точку вылета:

    public StartSearchBlockPage clickStartPlaceInput(){
        driver.findElement(startPlaceInput).click();
        return this;
    }

    //Метод для очищения дефолтного значения "Москва":
    public StartSearchBlockPage clearStartPlaceInput(){
        driver.findElement(startPlaceInput).sendKeys(Keys.chord(Keys.CONTROL) + "a");
        driver.findElement(startPlaceInput).sendKeys(Keys.BACK_SPACE);
        return this;
    }


    public StartSearchBlockPage writeStartPlaceInput(String anyString){
        driver.findElement(startPlaceInput).sendKeys(anyString);
        return this;
    }

    //Метод для выбора любого значения из списка дропдауна городов для вылета, с заданием ожидания до отображения элемента на странице:
    public StartSearchBlockPage clickSelectingStartPlace(String startPlace){
        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(By.xpath(String.format(startPlaceList, startPlace)))).click();
        return this;
    }

    ////////////////////////////////////////
    //Методы перехода на след. страницу.
    //В возвращаемое значение передаем новый экземпляр класса-хелпера с паттерном Factory,
    // который нам создает уже нужный объект страницы нашей страны:

    public AbstractBasePage clickSearchButton(String countryName){
        driver.findElement(searchButton).click();
        return new CountryFactory(driver).createCountry(countryName);
    }

    public void clickConfirmButtonWithAnyEmptyFields(){
        driver.findElement(searchButton).click();
    }

}

