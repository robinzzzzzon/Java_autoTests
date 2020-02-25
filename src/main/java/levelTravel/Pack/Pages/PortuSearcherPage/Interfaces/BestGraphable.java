package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public interface BestGraphable {

    By monthPrev = By.xpath("//span[@class='ps_changemonth-prev']");
    By monthNext = By.xpath("//span[@class='ps_changemonth-next']");
    By monthCurrent = By.xpath("//span[@class='ps_changemonth-current']");
    By priceMonthLinkList = By.xpath("//div[@class='col_month_inside']/a");
    By priceLinkPrev = By.xpath("//div[@class='ps_arrows-left']");
    By priceLinkNext = By.xpath("//div[@class='ps_arrows-right']");

    void clickMonthPrev();

    void clickMonthNext();

    void clickMonthPrevFew(int anyCount);

    void clickMonthNextFew(int anyCount);

    String getCurrentMonthText();

    void selectAnyPriceFromGraph(int anyNumber);

    void selectPriceGraphPrev();

    void selectPriceGraphNext();

    void clickPriceGraphPrevFew(int anyNumber);

    void clickPriceGraphNextFew(int anyNumber);
}
