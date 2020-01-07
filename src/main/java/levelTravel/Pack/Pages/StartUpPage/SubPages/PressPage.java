package levelTravel.Pack.Pages.StartUpPage.SubPages;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;

public class PressPage extends AbstractBasePage {

    private By periodHeading = By.xpath("//span[text()='Декабрь 2019']");

    public String getHeading() {
        return find(periodHeading).getText();
    }
}
