package levelTravel.Pack.Pages.LifehackPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CalendarPage.CalendarHeaderPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchBlockPage;
import levelTravel.Pack.Pages.TVPage.TVHeaderPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://hot.level.travel/tours_lifehacks/")
public class LifeHacksHeaderPage extends AbstractBasePage implements Headerable{

    public LifeHacksHeaderPage refreshPage(){
        find(mainHeading).click();
        return new LifeHacksHeaderPage();
    }

    public LifeHacksHeaderPage clickCatchTourLink(){
        find(catchTourLink).click();
        return new LifeHacksHeaderPage();
    }

    public TVHeaderPage clickTvTestLink(){
        find(tvTestsLink).click();
        return new TVHeaderPage();
    }

    public CalendarHeaderPage clickPriceCalendarLink(){
        find(priceCalendarLink).click();
        return new CalendarHeaderPage();
    }

    public StartSearchBlockPage clickFindTourLink(){
        find(findTourLink).click();
        return new StartSearchBlockPage();
    }

    public void selectPartOfPage(int i){
        List<WebElementFacade> list = findAll(anchorLinksList);
        list.get(i - 1).click();
    }
}
