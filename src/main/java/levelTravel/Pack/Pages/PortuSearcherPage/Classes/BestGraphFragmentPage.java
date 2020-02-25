package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.BestGraphable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class BestGraphFragmentPage extends AbstractBasePage implements BestGraphable {

    public void clickMonthPrev(){
        find(monthPrev).click();
    }

    public void clickMonthNext(){
        find(monthNext).click();
    }

    public void clickMonthPrevFew(int anyCount){
        clickAnyElementFew(anyCount, monthPrev);
    }

    public void clickMonthNextFew(int anyCount){
        clickAnyElementFew(anyCount, monthNext);
    }

    public String getCurrentMonthText(){
        return find(monthCurrent).getText();
    }

    /////////////////////////////////////////////

    private List<WebElementFacade> getPriceGraphList(){
        return findAll(priceMonthLinkList);
    }

    public void selectAnyPriceFromGraph(int anyNumber){
        selectAnyElementFromList(getPriceGraphList(), anyNumber);
    }

    public void selectPriceGraphPrev(){
        find(priceLinkPrev).waitUntilClickable().click();
    }

    public void selectPriceGraphNext(){
        find(priceLinkNext).waitUntilClickable().click();
    }

    public void clickPriceGraphPrevFew(int anyNumber){
        clickAnyElementFew(anyNumber, priceLinkPrev);
    }

    public void clickPriceGraphNextFew(int anyNumber){
        clickAnyElementFew(anyNumber, priceLinkNext);
    }

    /////////////////////////////////////////////

    private void selectAnyElementFromList(@NotNull List<WebElementFacade> list, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        element.click();
    }

    private void clickAnyElementFew(int anyCount, By by){
        int i = 0;
        WebElement element = find(by);
        while(i < anyCount){
            element.click();
            i++;
        }
    }
}
