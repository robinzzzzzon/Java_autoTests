package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryWholePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.HelperClasses.CountryFactory;
import levelTravel.Pack.Pages.HelperClasses.TableClass;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.Searchable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@DefaultUrl("https://level.travel/")
public class StartSearchBlockPage extends AbstractBasePage implements Searchable {

    BaseMethods methods = new BaseMethods();

    ////////////////////////////
    //Работа со списками стран и с самим полем выбора страны:

    public void writeAnyCountryName(String anyPlace) {
        find(searchCountryInput).sendKeys(anyPlace);
        find(searchCountryInput).sendKeys(Keys.chord(Keys.ENTER));
    }

    public void clickCountryInput() {
        methods.selectAnyElement(searchCountryInput);
    }

    private List<WebElementFacade> getPopularCountryList() {
        return methods.getAnyList(popularCountriesList);
    }

    public void clickGettingPopularCountry(int number) {
       methods.selectAnyElementFromList(number, getPopularCountryList());
    }

    private List<WebElementFacade> getWholeCountryList() {
        return methods.getAnyList(wholeCountriesList);
    }

    public void clickGettingWholeCountry(int number) {
        methods.selectAnyElementFromList(number, getWholeCountryList());
    }

    /////////////////////////////
    //Работаем со списком ошибок на странице:

    //Получаем лист объектов класса Error:
    private List<WebElementFacade> getErrors() {
        return methods.getAnyList(errorListByClass);
    }

    //Получает текст ошибки по номеру объекта ошибки из колекции:
    public String getErrorByText(int number) {
        return methods.getTextFromAnyElementOfList(getErrors(), number);
    }

    //Возвращает true, если:
    //Массив содержит ошибку с нашим message и соотв-нно > 0
    //первая ошибка в массиве отображается.
    public boolean isErrorVisible(String message) {
        return findAll(By.xpath(String.format(errorListByText, message))).size() > 0
                && findAll(By.xpath(String.format(errorListByText, message))).get(0).isDisplayed();
    }

    /////////////////////////////
    //Работа с календарем и выбором даты:
    public void clickCalendarInput() {
        methods.selectAnyElement(calendarInput);
    }

    //Метод для пролистывания месяцев календаря:
    private void clickSwitchToNextMonth(int countMonth) {
        for (int i = 0; i < countMonth; i++) {
            methods.selectAnyElement(switchToNextMonth);
        }
    }

    //Метод получает текущее значение месяца, парсит его и возвращает инт.
    private int getCurrentParseMonth() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
        return Integer.parseInt(simpleDateFormat.format(date));
    }

    //Метод, в котором на входе задаем номер строки/столбца и номер месяца
    //Далее мы помещаем в вэбэлемент найденный элемент таблицы и подаем его на вход в конструктор класса TableForStartSearchBlockPage.
    //В итоге возвращаем объект ввиде ячейки календаря.
    private WebElement getCalendarDate(int row, int column, int setMonthNumber) {
        WebElement element = find(By.xpath(String.format(calendarTBody, setMonthNumber)));
        TableClass table = new TableClass(element);
        return table.getValueFromCell(row, column);
    }

    //Параметризованный метод со входом countSwitch =< 3 для каждого месяца.
    private WebElement getCalendarDateForWholeYear(int row, int column, int countSwitch) {

        int month = getCurrentParseMonth();
        clickSwitchToNextMonth(countSwitch);

        if (month == 12) {
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
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3)
                return getCalendarDate(row, column, countSwitch + 9);
        } else if (month == 8) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3)
                return getCalendarDate(row, column, countSwitch + 8);
        } else if (month == 7) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3)
                return getCalendarDate(row, column, countSwitch + 7);
        } else if (month == 6) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3)
                return getCalendarDate(row, column, countSwitch + 6);
        } else if (month == 5) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3)
                return getCalendarDate(row, column, countSwitch + 5);
        } else if (month == 4) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3)
                return getCalendarDate(row, column, countSwitch + 4);
        } else if (month == 3) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3)
                return getCalendarDate(row, column, countSwitch + 3);
        } else if (month == 2) {
            if (countSwitch == 1 || countSwitch == 2 || countSwitch == 3)
                return getCalendarDate(row, column, countSwitch + 2);
        }
        return getCalendarDate(row, column, countSwitch + 1);
    }

    public void selectCalendarDate(int row, int column, int countSwitch) {
        WebElement calendarElement = getCalendarDateForWholeYear(row, column, countSwitch);
        calendarElement.click();
    }

    public void clickAdd2Days() {
        methods.selectAnyElement(add2days);
    }

    ////////////////////////////////////////////////////////////////////////////////
    //Работа с полем выбора периода кол-ва ночей:

    public void clickCountOfNights() {
        methods.selectAnyElement(dayIntervalDD);
    }

    public void minusNight() {
        methods.selectAnyElement(minusDay);
    }

    public void plusNight() {
        methods.selectAnyElement(plusDay);
    }

    public void addMaxCountNights(boolean b) {
        WebElement element = find(plusDay);
        do {
            element.click();
        } while (!element.getAttribute("class").equals("add disabled") == b);
    }

    public void addMinCountNights(boolean b) {
        WebElement element = find(minusDay);
        do {
            element.click();
        } while (!element.getAttribute("class").equals("subtract disabled") == b);
    }

    public void add2Nights(boolean b) {
        methods.selectOrDeselectAnyElement(plusOrMinus2Days, b);
    }

    /////////////////////////////
    //Выбираем кол-во пассажиров:

    public void clickCountOfPassengers() {
        methods.selectAnyElement(countOfPassengersDD);
    }

    private void addChildren() {
        methods.selectAnyElement(addChildrenDD);
    }

    public void selectVariationAddChild(int childNumber) {
        addChildren();
        methods.selectAnyElementFromList(childNumber, methods.getAnyList(childVaryingList));
    }

    public void minusPassenger() {
        methods.selectAnyElement(minusPassenger);
    }

    public void plusPassenger() {
        methods.selectAnyElement(plusPassenger);
    }

    public void addMaxPassenger(boolean b) {
        WebElement element = find(plusPassenger);
        do {
            element.click();
        } while (!element.getAttribute("class").equals("add disabled") == b);
    }

    /////////////////////////////////
    //Выбираем стартовую точку вылета:

    public void clickStartPlaceInput() {
        methods.selectAnyElement(startPlaceInput);
    }

    //Метод для очищения дефолтного значения "Москва":
    public void clearStartPlaceInput() {
        find(startPlaceInput).sendKeys(Keys.chord(Keys.CONTROL) + "a");
        find(startPlaceInput).sendKeys(Keys.BACK_SPACE);
    }

    //Пробую серенити метод typeInto():
    public void typeIntoString(String anyString){
        WebElement element = find(startPlaceInput);
        typeInto(element, anyString);
    }


    public void writeStartPlaceInput(String anyString) {
        methods.writeTextToAnyElement(startPlaceInput, anyString);
    }

    //Метод для выбора любого значения из списка дропдауна городов для вылета, с заданием ожидания до отображения элемента на странице:
    public void clickSelectingStartPlace(String startPlace) {
        //new WebDriverWait(getDriver(), 5).until(visibilityOfElementLocated(By.xpath(String.format(startPlaceList, startPlace)))).click();
        WebElement element = find(By.xpath(String.format(startPlaceList, startPlace)));
        element.click();
    }

    ////////////////////////////////////////
    //Методы перехода на след. страницу.
    //В возвращаемое значение передаем новый экземпляр класса-хелпера с паттерном Factory,
    // который нам создает уже нужный объект страницы нашей страны:

    public CountryWholePage clickSearchButton(String countryName) {
        methods.selectAnyElement(searchButton);
        return new CountryFactory().createCountry(countryName);
    }

    public void clickConfirmButtonWithAnyEmptyFields() {
        methods.selectAnyElement(searchButton);
    }

}

