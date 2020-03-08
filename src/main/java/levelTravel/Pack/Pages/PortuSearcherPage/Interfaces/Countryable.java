package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;

import org.openqa.selenium.By;


public interface Countryable {

    By countryLinksList = By.xpath("//div[@class='card_block card_block-gmap']//li/a");

    public void selectAnyCountry(int anyNumber);
}
