package levelTravel.Pack.Pages.StartUpPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClass.CountryFactory;
import levelTravel.Pack.Pages.StartUpPage.Interfaces.BestPricable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StartBestPriceBlockPage extends AbstractBasePage implements BestPricable {

    public StartBestPriceBlockPage(WebDriver driver) {
        super(driver);
    }


    public StartBestPriceBlockPage clickCityStartDD(){
        driver.findElement(cityStartDD).click();
        return this;
    }

    private List<WebElement> getStartCityList(){
        return driver.findElements(cityStartList);
    }

    public StartBestPriceBlockPage selectAnyStartCity(int number){
        List <WebElement> webElements = getStartCityList();
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage(driver);
    }

    //////////////////////////////////////////////////////////////

    private List<WebElement> getCountOfNightsList(){
        return driver.findElements(countPfNightsList);
    }

    public StartBestPriceBlockPage selectAnyCountOfNights(int number){
        List <WebElement> webElements = getCountOfNightsList();
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage(driver);
    }

    //////////////////////////////////////////////////////////////

    private List<WebElement> getCountryGraphList(){
        return driver.findElements(countryGraphList);
    }

    public StartBestPriceBlockPage selectAnyCountry(int number){
        if (number > 5) {
            driver.findElement(invisibleCountryDD).click();
            List <WebElement> webElements = getCountryGraphList();
            webElements.get(number - 1).click();
        }
        List <WebElement> webElements = getCountryGraphList();
        webElements.get(number - 1).click();
        return new StartBestPriceBlockPage(driver);
    }

    //////////////////////////////////////////////////////////////

    private void clickRightButtonOfGraphList(){
        driver.findElement(priceListRightButton).click();
    }

    private List<WebElement> getPriceGraphList(){
        return driver.findElements(priceColumnList);
    }

    public AbstractBasePage selectAnyPriceOfGraph(int number, String countryName){
        List<WebElement> webElements = getPriceGraphList();
        webElements.get(number - 1).click();
        return new CountryFactory(driver).createCountry(countryName);
    }

}
