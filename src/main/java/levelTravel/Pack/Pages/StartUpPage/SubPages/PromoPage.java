package levelTravel.Pack.Pages.StartUpPage.SubPages;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;

public class PromoPage extends AbstractBasePage {

    private By centerHeading = By.xpath("(//div[text()='Покупайте туры выгодно'])[1]");

    public String getHeading(){
        return find(centerHeading).getText();
    }
}
