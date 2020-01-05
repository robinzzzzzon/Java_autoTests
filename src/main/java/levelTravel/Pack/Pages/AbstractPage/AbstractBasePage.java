package levelTravel.Pack.Pages.AbstractPage;

import org.openqa.selenium.WebDriver;

public abstract class AbstractBasePage {

    public WebDriver driver;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
    }
}
