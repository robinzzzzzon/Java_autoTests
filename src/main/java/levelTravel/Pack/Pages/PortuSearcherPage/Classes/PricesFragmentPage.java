package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.HelperClasses.TableClass;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Priceable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class PricesFragmentPage extends AbstractBasePage implements Priceable {

    BaseMethods methods = new BaseMethods();

    private String getPriceHeading(){
        return methods.getTextFromAnyElement(priceHeading);
    }

    ////////////////////////////////////////////

    public void selectAnyTableValueByNumber(int rowNumber, int columnNumber){
        WebElement element = find(priceTable).waitUntilVisible();
        TableClass table = new TableClass(element);
        WebElement cell = table.getValueFromCell(rowNumber - 1, columnNumber - 1);
        cell.click();
    }

    public void selectAnyTableValueByHeading(int rowNumber, String columnName){
        WebElement element = find(priceTable);
        TableClass table = new TableClass(element);
        WebElement cell = table.getValueFromCell(rowNumber - 1, columnName);
        cell.click();
    }

    ////////////////////////////////////////////

    public void clickGuaranteeLink(){
       methods.selectAnyElement(guaranteeDescLink);
    }

    public void clickToGuaranteeCross(){
        methods.selectAnyElement(guaranteeDescPageCross);
    }

    /////////////////////////////////////////////

    public void clickExchangeLeftDD(){
        methods.selectAnyElement(exchangeLeftDD);
    }

    private List<WebElementFacade> getLeftCurrencyExchangeList(){
        return methods.getAnyList(exchangeLeftOptions);
    }

    public void selectAnyLeftExOption(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getLeftCurrencyExchangeList());
    }

    public void clickExchangeRightDD(){
        methods.selectAnyElement(exchangeRightDD);
    }

    private List<WebElementFacade> getRightCurrencyExchangeList(){
        return methods.getAnyList(exchangeRightOptions);
    }

    public void selectAnyRightExOption(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getRightCurrencyExchangeList());
    }

    public void writeToLeftCurInput(String anySum){
        methods.writeTextToAnyElement(exchangeLeftInput, anySum);
    }

    public void writeToRightCurInput(String anySum){
        methods.writeTextToAnyElement(exchangeRightInput, anySum);
    }

    /////////////////////////////////////////////////////

    public void clickPortugalWidget(){
        methods.selectAnyElement(widgetPortugalPhoto);
    }

    public void closeWidget(){
        methods.selectAnyElement(photoCross);
    }

    public void clickToPrevPhoto(){
        methods.selectAnyElement(photoPrev);
    }

    public void clickToNextPhoto(){
        methods.selectAnyElement(photoNext);
    }
}
