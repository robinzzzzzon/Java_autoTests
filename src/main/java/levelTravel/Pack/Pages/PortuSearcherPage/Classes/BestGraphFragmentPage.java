package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.BestGraphable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class BestGraphFragmentPage extends AbstractBasePage implements BestGraphable {

    BaseMethods methods = new BaseMethods();

    public void clickMonthPrev(){
        methods.selectAnyElement(monthPrev);
    }

    public void clickMonthNext(){
        methods.selectAnyElement(monthNext);
    }

    public void clickMonthPrevFew(int anyCount){
        methods.selectAnyElementFew(anyCount, monthPrev);
    }

    public void clickMonthNextFew(int anyCount){
        methods.selectAnyElementFew(anyCount, monthNext);
    }

    public String getCurrentMonthText(){
        return methods.getTextFromAnyElement(monthCurrent);
    }

    /////////////////////////////////////////////

    private List<WebElementFacade> getPriceGraphList(){
        return methods.getAnyList(priceMonthLinkList);
    }

    public void selectAnyPriceFromGraph(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getPriceGraphList());
    }

    public void selectPriceGraphPrev(){
        methods.selectAnyElement(priceLinkPrev);
    }

    public void selectPriceGraphNext(){
        methods.selectAnyElement(priceLinkNext);
    }

    public void clickPriceGraphPrevFew(int anyNumber){
        methods.selectAnyElementFew(anyNumber, priceLinkPrev);
    }

    public void clickPriceGraphNextFew(int anyNumber){
        methods.selectAnyElementFew(anyNumber, priceLinkNext);
    }
}
