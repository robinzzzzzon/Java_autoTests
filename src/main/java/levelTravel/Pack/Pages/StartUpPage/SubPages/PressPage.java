package levelTravel.Pack.Pages.StartUpPage.SubPages;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PressPage extends AbstractBasePage {

    public PressPage(WebDriver driver) {
        super(driver);
    }

    private By periodHeading = By.xpath("//span[text()='Декабрь 2019']");

    public String getHeading() {
        return driver.findElement(periodHeading).getText();
    }
}
