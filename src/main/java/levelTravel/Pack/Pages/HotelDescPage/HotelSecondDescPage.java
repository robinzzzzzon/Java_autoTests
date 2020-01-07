package levelTravel.Pack.Pages.HotelDescPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;

public class HotelSecondDescPage extends AbstractBasePage {

    private By heading = By.xpath("//div[@class='checkout-header__title']");

    public String getHeadingText(){
        return find(heading).getText();
    }

}
