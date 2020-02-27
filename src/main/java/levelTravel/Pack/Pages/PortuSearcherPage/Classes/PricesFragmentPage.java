package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.TableClass;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Priceable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class PricesFragmentPage extends AbstractBasePage implements Priceable {

    private String getPriceHeading(){
        return find(priceHeading).getText();
    }

    //Работаем с номерным лайнером:
    private List<WebElementFacade> getLinerLabelList(){
        return findAll(linerLabelList);
    }

    public void clickAnyLabelOfLiner(int anyNumber){
        selectAnyElementFromList(getLinerLabelList(), anyNumber);
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
       find(guaranteeDescLink).click();
    }

    public void clickToGuaranteeCross(){
        find(guaranteeDescPageCross).click();
    }

    /////////////////////////////////////////////

    public void clickExchangeLeftDD(){
        find(exchangeLeftDD).click();
    }

    private List<WebElementFacade> getLeftCurrencyExchangeList(){
        return findAll(exchangeLeftOptions);
    }

    public void selectAnyLeftExOption(int anyNumber){
        selectAnyElementFromList(getLeftCurrencyExchangeList(), anyNumber);
    }

    public void clickExchangeRightDD(){
        find(exchangeRightDD).click();
    }

    private List<WebElementFacade> getRightCurrencyExchangeList(){
        return findAll(exchangeRightOptions);
    }

    public void selectAnyRightExOption(int anyNumber){
        selectAnyElementFromList(getRightCurrencyExchangeList(), anyNumber);
    }

    public void writeToLeftCurInput(String anySum){
        find(exchangeLeftInput).sendKeys(anySum);
    }

    public void writeToRightCurInput(String anySum){
        find(exchangeRightInput).sendKeys(anySum);
    }

    /////////////////////////////////////////////////////

    public void clickPortugalWidget(){
        find(widgetPortugalPhoto).click();
    }

    public void closeWidget(){
        find(photoCross).click();
    }

    public void clickToPrevPhoto(){
        find(photoPrev).click();
    }

    public void clickToNextPhoto(){
        find(photoNext).click();
    }

    //////////////////////////////////////////////////

    private void selectAnyElementFromList(List<WebElementFacade> list, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        element.click();
    }

}
