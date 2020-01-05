package levelTravel.Pack.StartUpPage.SubPages;

import levelTravel.Pack.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PromoPage extends AbstractBasePage {

    public PromoPage(WebDriver driver) {
        super(driver);
    }

    private By centerHeading = By.xpath("(//div[text()='Покупайте туры выгодно'])[1]");

    public String getHeading(){
        return driver.findElement(centerHeading).getText();
    }
}
