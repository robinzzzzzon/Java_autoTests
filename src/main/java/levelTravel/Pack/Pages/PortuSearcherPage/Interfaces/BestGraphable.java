package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;

import org.openqa.selenium.By;

public interface BestGraphable {

    By monthPrev = By.xpath("//span[@class='ps_changemonth-prev']");
    By monthNext = By.xpath("//span[@class='ps_changemonth-next']");
    By monthCurrent = By.xpath("//span[@class='ps_changemonth-current']");
    By priceMonthLinkList = By.xpath("//div[@class='col_month_inside']/a");
    By priceLinkPrev = By.xpath("//div[@class='ps_arrows-left']");
    By priceLinkNext = By.xpath("//div[@class='ps_arrows-right']");


}
