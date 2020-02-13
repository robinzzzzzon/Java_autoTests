package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryPage;
import levelTravel.Pack.Pages.HelperClass.CountryFactory;
import levelTravel.Pack.Pages.HelperClass.TableForStartSearchBlockPage;
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

    ////////////////////////////
    //Работа со списками стран и с самим полем выбора страны:

    public void writeAnyCountryName(String anyPlace) {
        find(searchCountryInput).sendKeys(anyPlace);
        find(searchCountryInput).sendKeys(Keys.chord(Keys.ENTER));
    }

    public void clickCountryInput() {
        find(searchCountryInput).click();
    }

    private List<WebElementFacade> getPopularCountryList() {
        return findAll(popularCountriesList);
    }

    public void clickGettingPopularCountry(int number) {
       WebElement element = getPopularCountryList().get(number - 1);
       element.click();
    }

    private List<WebElementFacade> getWholeCountryList() {
        return findAll(wholeCountriesList);
    }

    public void clickGettingWholeCountry(int number) {
        WebElement element = getWholeCountryList().get(number - 1);
        element.click();
    }

    /////////////////////////////
    //Работаем со списком ошибок на странице:

    //Получаем лист объектов класса Error:
    private List<WebElementFacade> getErrors() {
        return findAll(errorListByClass);
    }

    //Получает текст ошибки по номеру объекта ошибки из колекции:
    public String getErrorByText(int number) {
        return getErrors().get(number - 1).getText();
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
        find(calendarInput).click();
    }

    //Метод для пролистывания месяцев календаря:
    private void clickSwitchToNextMonth(int countMonth) {
        for (int i = 0; i < countMonth; i++) {
            find(switchToNextMonth).click();
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
        TableForStartSearchBlockPage tableForStartSearchBlockPage = new TableForStartSearchBlockPage(element);
        return tableForStartSearchBlockPage.getValueFromCell(row, column);
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
        find(add2days).click();
    }

    ////////////////////////////////////////////////////////////////////////////////
    //Работа с полем выбора периода кол-ва ночей:

    public void clickCountOfNights() {
        find(dayIntervalDD).click();
    }

    public void minusNight() {
        find(minusDay).click();
    }

    public void plusNight() {
        find(plusDay).click();
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
        WebElement element = find(plusOrMinus2Days);
        if (!element.isSelected() == b) {
            element.click();
        }
    }

    /////////////////////////////
    //Выбираем кол-во пассажиров:

    public void clickCountOfPassengers() {
        find(countOfPassengersDD).click();
    }

    private void addChildren() {
        find(addChildrenDD).click();
    }

    private WebElement getVariableAddChildren(int variationChild) {
        addChildren();
        List<WebElementFacade> webElements = findAll(childVaryingList);
        return webElements.get(variationChild);
    }

    public void selectVariationAddChild(int childNumber) {
        WebElement element = getVariableAddChildren(childNumber);
        element.click();
    }

    public void minusPassenger() {
        find(minusPassenger).click();
    }

    public void plusPassenger() {
        find(plusPassenger).click();
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
        find(startPlaceInput).click();
    }

    //Метод для очищения дефолтного значения "Москва":
    public void clearStartPlaceInput() {
        find(startPlaceInput).sendKeys(Keys.chord(Keys.CONTROL) + "a");
        find(startPlaceInput).sendKeys(Keys.BACK_SPACE);
    }


    public void writeStartPlaceInput(String anyString) {
        find(startPlaceInput).sendKeys(anyString);
    }

    //Метод для выбора любого значения из списка дропдауна городов для вылета, с заданием ожидания до отображения элемента на странице:
    public void clickSelectingStartPlace(String startPlace) {
        new WebDriverWait(getDriver(), 5).until(visibilityOfElementLocated(By.xpath(String.format(startPlaceList, startPlace)))).click();
    }

    ////////////////////////////////////////
    //Методы перехода на след. страницу.
    //В возвращаемое значение передаем новый экземпляр класса-хелпера с паттерном Factory,
    // который нам создает уже нужный объект страницы нашей страны:

    public CountryPage clickSearchButton(String countryName) {
        find(searchButton).click();
        return new CountryFactory().createCountry(countryName);
    }

    public void clickConfirmButtonWithAnyEmptyFields() {
        find(searchButton).click();
    }

}

