package levelTravel.Pack.Pages.LifehackPage;

import levelTravel.Pack.Pages.CalendarPage.CalendarHeaderPage;
import levelTravel.Pack.Pages.StartUpPage.Classes.StartSearchBlockPage;
import levelTravel.Pack.Pages.TVPage.TVHeaderPage;
import org.openqa.selenium.By;


public interface Headerable {

    //хедер-линки:
    By mainHeading = By.xpath("//a[@title='Лучшие туры на море']");
    By catchTourLink = By.xpath("//span[text()='Как поймать горящий тур?']/parent::a");
    By tvTestsLink = By.xpath("//span[text()='TV-тесты от Москвы24']/parent::a");
    By priceCalendarLink = By.xpath("//span[text()='Календарь цен']/parent::a");
    By findTourLink = By.xpath("//span[text()='Найти тур']/parent::a");
    //якорь-линки:
    By anchorLinksList = By.xpath("//div[@class='howfind-bg_title_links']//a");

    LifeHacksHeaderPage refreshPage();

    LifeHacksHeaderPage clickCatchTourLink();

    TVHeaderPage clickTvTestLink();

    CalendarHeaderPage clickPriceCalendarLink();

    StartSearchBlockPage clickFindTourLink();

    void selectPartOfPage(int i);

}
