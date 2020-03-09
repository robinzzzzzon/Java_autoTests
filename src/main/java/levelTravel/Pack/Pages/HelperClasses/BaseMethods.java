package levelTravel.Pack.Pages.HelperClasses;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class BaseMethods extends PageObject {

    //Работа с одним элементом:
    /////////////////////////////////////////////////////////

    //Выбрать любой одиночный элемент:
    public void selectAnyElement(By by) {
        WebElement element = find(by);
        if (!element.isEnabled()) {
            find(by).waitUntilEnabled();
        }
        element.click();
    }

    //Выбрать любой элемент из списка:
    public void selectAnyElementFromList(int CbNumber, @NotNull List<WebElementFacade> list) {
        if (!list.get(CbNumber - 1).isClickable()){
            waitFor(list.get(CbNumber - 1)).waitUntilClickable().click();
        } else {
            list.get(CbNumber - 1).click();
        }
    }

    //Выбрать изначально скрытый элемент из списка:
    public void selectAnyElementFromList(int CbNumber, @NotNull List<WebElementFacade> list, By by) {
        WebElement element = list.get(CbNumber - 1);
        WebElement showElement = find(by);
        if (!element.isDisplayed() || !element.isEnabled()) {
            showElement.click();
            element.click();
        }
    }

    //Выбрать любой элемент с предварительной проверкой того, что он уже/еще (не)выбран:
    public void selectOrDeselectAnyElement(By by, boolean b) {
        WebElement element = find(by);
        if (!element.isSelected() == b) {
            element.click();
        }
    }

    //Выбрать любой элемент из списка, с предварительной проверкой того, что он уже/еще (не)выбран:
    public void selectOrDeselectAnyElementFromList(int CbNumber, @NotNull List<WebElementFacade> list, boolean b) {
        WebElement element = list.get(CbNumber - 1);
        if (!element.isSelected() == b) {
            element.click();
        }
    }

    //Выбрать любой элемент неск. раз:
    public void selectAnyElementFew(int anyCount, By by) {
        int i = 0;
        WebElement element = find(by);
        if (!element.isEnabled()){
            waitFor(element).waitUntilVisible();
        }
        while (i < anyCount) {
            element.click();
            i++;
        }
    }

    public void writeTextToAnyElement(By by, String anyString) {
        WebElement element = find(by);
        element.sendKeys(anyString);
    }

    public void writeTextToAnyElementOfList(@NotNull List<WebElementFacade> list, int anyNumber, String anyString) {
        WebElement element = list.get(anyNumber - 1);
        element.sendKeys(anyString);
    }

    //Получить текст любого элемента:
    public String getTextFromAnyElement(By by) {
        return find(by).getText();
    }

    //Получить текст любого элемента из списка:
    public String getTextFromAnyElementOfList(@NotNull List<WebElementFacade> list, int anyNumber) {
        WebElement element = list.get(anyNumber - 1);
        return element.getText();
    }

    //Работа с несколькими элементами:
    ///////////////////////////////////////////////////////

    //Выбрать первый и последний элемент из списка:
    public void selectFirstAndLastElements(List<WebElementFacade> facadeList) {
        LinkedList<WebElementFacade> list = new LinkedList<>(facadeList);
        list.getFirst().click();
        list.getLast().click();
    }

    //Выбрать первый и последний скрытый элемент из списка:
    public void selectFirstAndLastElements(List<WebElementFacade> facadeList, By by) {
        LinkedList<WebElementFacade> list = new LinkedList<>(facadeList);
        list.getFirst().click();
        find(by).waitUntilClickable().click();
        list.getLast().click();
    }


    //Работа со всем списком:
    ///////////////////////////////////////////////////////

    //Вернуть список элементов в виде листа:
    public List<WebElementFacade> getAnyList(By by) {
        return findAll(by);
    }

    //Выбрать все элементы:
    public void selectAllElements(@NotNull List<WebElementFacade> list) {
        for (WebElementFacade element : list) {
            if(!element.isEnabled()){
                element.waitUntilEnabled();
            }
            element.click();
        }
    }

    //Выбрать все элементы включая скрытые:
    public void selectAllElements(@NotNull List<WebElementFacade> facadeList, By by) {
        for (WebElementFacade element : facadeList) {
            if (!element.isDisplayed()) {
                find(by).click();
            }
            element.click();
        }
    }

    /////////////////////////////////////////////////////////

    //Получаем заголовок текущей вкладки:
    public String getCurrentHandle(){
        return getDriver().getWindowHandle();
    }

    //Переключение на последнюю вкладку:
    public void switchToNextHandle(){
        for (String tab : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(tab);
        }
    }

    //Переключение на первоначальную вкладку:
    public void switchToInitHandle(String initHandle){
        getDriver().switchTo().window(initHandle);
    }

    //Прочее:
    ////////////////////////////////////////////////

    //метод для проверки вставки:
    public void bufferInput(@NotNull WebElement element) {
        String SelectAll = Keys.chord(Keys.ENTER, "a");
        String CutAll = Keys.chord(Keys.ENTER, "x");
        String PasteAll = Keys.chord(Keys.ENTER, "v");
        element.sendKeys(SelectAll);
        element.sendKeys(CutAll);
        element.sendKeys(PasteAll);
    }

    //метод скроллинга с учетом внутреннего метода задержки треда:
    public void scrolling(int number) {
        JavascriptExecutor JSE = (JavascriptExecutor) getDriver();
        String s = "window.scrollBy(0, %s)";
        JSE.executeScript(String.format(s, number), "");
        //waitMethod(1000); // для нижних списков все таки ожидание пропажи оверлея недостаточно, нужно ждать еще и рендеринга.
    }

    //метод задержки треда(не лучшаяя практика. Попробовать переделать на ожидание рендеринга нужных элементов):
    private void waitMethod(int countOfMs) {
        try {
            Thread.sleep(countOfMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
