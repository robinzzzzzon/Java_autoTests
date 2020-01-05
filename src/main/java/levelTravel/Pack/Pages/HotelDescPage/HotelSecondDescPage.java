package levelTravel.Pack.Pages.HotelDescPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelSecondDescPage extends AbstractBasePage {


    public HotelSecondDescPage(WebDriver driver) {
        super(driver);
    }

    private By heading = By.xpath("//div[@class='checkout-header__title']");

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

}
