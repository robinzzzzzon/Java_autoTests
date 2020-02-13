package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public interface Linerable {

    By headerHeading = By.xpath("//h2[@class='page_content_head-title']");
    By linerLabelList = By.xpath("//div[@class='sidebar_content']//span[@class='nav_label']");
    By factsList = By.xpath("//ul[@class='facts']//div[@class='fact_content']/span[normalize-space(text())]");
    By cityLinkList = By.xpath("//ul[@class='regions links_list non_url']//li");
    By monthLabelList = By.xpath("//ul[@class='months rmf']//div[@class='month_label']");
    By monthIconList = By.xpath("//ul[@class='months rmf']//div[2]");

    void clickAnyLabelOfLiner(int anyNumber);

    void getAnyTextOfFacts(int number);

    void selectAnyCityFromList(int number);

    List<WebElementFacade> getMonthLabelList();

    List<WebElementFacade> getMonthIconList();
}
