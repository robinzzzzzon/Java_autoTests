package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Linerable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class LinerFragmentPage extends AbstractBasePage implements Linerable {

    BaseMethods methods = new BaseMethods();

    public String getHeadingText(){
        return methods.getTextFromAnyElement(headerHeading);
    }

    ////////////////////////////////////////////////////
    //Работаем с номерным лайнером:

    private List<WebElementFacade> getLinerLabelList(){
        return methods.getAnyList(linerLabelList);
    }

    public void clickAnyLabelOfLiner(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getLinerLabelList());
    }

    ///////////////////////////////////////////////////////////
    //Работаем с заголовками-фактами:

    private List<WebElementFacade> getFactsList(){
        return methods.getAnyList(factsList);
    }

    public void getAnyTextOfFacts(int number){
        methods.getTextFromAnyElementOfList(getFactsList(), number);
    }

    /////////////////////////////////////////////////
    //Получаем список ссылок городов:

    private List<WebElementFacade> getCityLinkList(){
        return methods.getAnyList(cityLinkList);
    }

    public void selectAnyCityFromList(int number){
        methods.selectAnyElementFromList(number, getCityLinkList());
    }

    //////////////////////////////////////////////////////
    //Получаем список месяцев и изображений погоды(Не факт что пригодится, но пока пусть будет):

    public List<WebElementFacade> getMonthLabelList(){
        return methods.getAnyList(monthLabelList);
    }

    public List<WebElementFacade> getMonthIconList(){
        return methods.getAnyList(monthIconList);
    }
}
