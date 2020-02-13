package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Linerable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class LinerFragmentPage extends AbstractBasePage implements Linerable {

    public String getHeadingText(){
        return find(headerHeading).getText();
    }

    ////////////////////////////////////////////////////
    //Работаем с номерным лайнером:

    private List<WebElementFacade> getLinerLabelList(){
        return findAll(linerLabelList);
    }

    public void clickAnyLabelOfLiner(int anyNumber){
        selectAnyElementFromAnyList(getLinerLabelList(), anyNumber);
    }

    ///////////////////////////////////////////////////////////
    //Работаем с заголовками-фактами:

    private List<WebElementFacade> getFactsList(){
        return findAll(factsList);
    }

    public void getAnyTextOfFacts(int number){
        getTextOfAnyElementFromAnyList(getFactsList(), number);
    }

    /////////////////////////////////////////////////
    //Получаем список ссылок городов:

    private List<WebElementFacade> getCityLinkList(){
        return findAll(cityLinkList);
    }

    public void selectAnyCityFromList(int number){
        selectAnyElementFromAnyList(getCityLinkList(), number);
    }

    //////////////////////////////////////////////////////
    //Получаем список месяцев и изображений погоды(Не факт что пригодится, но пока пусть будет):

    public List<WebElementFacade> getMonthLabelList(){
        return findAll(monthLabelList);
    }

    public List<WebElementFacade> getMonthIconList(){
        return findAll(monthIconList);
    }

    ////////////////////////////////////////////////

    private void selectAnyElementFromAnyList(List<WebElementFacade> list, int number){
        WebElement element = list.get(number - 1);
        element.click();
    }

    private void getTextOfAnyElementFromAnyList(List<WebElementFacade> list, int number){
        WebElement element = list.get(number - 1);
        element.getText();
    }
}
