package levelTravel.Pack.Pages.CountryPage.Classes.CountryList;


import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryFiltersBlockPage;
import levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage.CountryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EgyptPage extends CountryPage {

    private By heading = By.xpath("//h1[@class='search-page-title']/span");

    public String getTextLoadingHeading(){
        WebElement element = find(heading);
        return element.getText();
    }

}
