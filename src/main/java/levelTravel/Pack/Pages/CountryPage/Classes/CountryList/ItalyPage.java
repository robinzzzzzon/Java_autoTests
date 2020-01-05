package levelTravel.Pack.Pages.CountryPage.Classes.CountryList;

import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItalyPage extends CountryFiltersBlockPage {
    public ItalyPage(WebDriver driver) {
        super(driver);
    }

    private By heading = By.xpath("//h1[@class='search-page-title']/span");

    public String getTextLoadingHeading(){
        WebElement element = driver.findElement(heading);
        return element.getText();
    }

}
