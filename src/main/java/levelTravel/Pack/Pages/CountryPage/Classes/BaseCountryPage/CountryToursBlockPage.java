package levelTravel.Pack.Pages.CountryPage.Classes.BaseCountryPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.CountryPage.Interfaces.Toursable;
import levelTravel.Pack.Pages.HotelDescPage.HotelFirstDescPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountryToursBlockPage extends AbstractBasePage implements Toursable {

//    Actions action = new Actions(driver);

    public CountryToursBlockPage(WebDriver driver) {
        super(driver);
    }

    public CountryToursBlockPage clickRecommendFilter(){
        driver.findElement(recommendationFilter).click();
        return new CountryToursBlockPage(driver);
    }

    public CountryToursBlockPage clickPriceFilter(){
        driver.findElement(priceFilter).click();
        return new CountryToursBlockPage(driver);
    }

    public CountryToursBlockPage clickRateFilter(){
        driver.findElement(rateFilter).click();
        return new CountryToursBlockPage(driver);
    }

    /////////////////////////////////////////////////////////////

    private List<WebElement> getWishListHeartButtons(){
        return driver.findElements(wishListHeartButtons);
    }

    public CountryToursBlockPage clickFirstWishListButton(boolean b){
        WebElement element =getWishListHeartButtons().get(0);
        if (!element.isSelected() == b){
            element.click();
        }
        return this;
    }

    public CountryToursBlockPage clickAnyWishListButton(int number){
        List<WebElement> webElements = getWishListHeartButtons();
        webElements.get(number - 1).click();
        return this;
    }

    /////////////////////////////////////////////////////////////

    private List<WebElement> getExploreHotelButtons(){
        return driver.findElements(exploreHotelButtons);
    }

    public HotelFirstDescPage clickFirstExploreHotel(boolean b){
        WebElement element = getExploreHotelButtons().get(0);
        if (!element.isSelected() == b){
            element.click();
        }
        return new HotelFirstDescPage(driver);
    }

    public HotelFirstDescPage clickAnyExploreHotel(int number){
        List<WebElement> webElements = getExploreHotelButtons();
        webElements.get(number - 1).click();
        return new HotelFirstDescPage(driver);
    }

    /////////////////////////////////////////////////////////////

    private List<WebElement> getHotelPriceLinks(){
        return driver.findElements(hotelPriceLinks);
    }

    public HotelFirstDescPage clickFirstHotelPriceLink(boolean b){
        WebElement element = getHotelPriceLinks().get(0);
        if (!element.isSelected() == b){
            element.click();
        }
        return new HotelFirstDescPage(driver);
    }

    public HotelFirstDescPage clickAnyHotelPriceLink(int number){
        List<WebElement> webElements = getHotelPriceLinks();
        webElements.get(number - 1).click();
        return new HotelFirstDescPage(driver);
    }

    ////////////////////////////////////////////////////////////

    private List<WebElement> getNameHotelLinks(){
        return driver.findElements(nameHotelLinks);
    }

    public String getAnyNameHotelText(int number){
        List<WebElement> webElements = getNameHotelLinks();
        return webElements.get(number).getText();
    }

    public HotelFirstDescPage clickFirstNameHotelLink(boolean b){
        WebElement element = getNameHotelLinks().get(0);
        if (!element.isSelected() == b){
            element.click();
        }
        return new HotelFirstDescPage(driver);
    }

    public HotelFirstDescPage clickAnyNameHotelLink(int number){
        List<WebElement> webElements = getNameHotelLinks();
        webElements.get(number - 1).click();
        return new HotelFirstDescPage(driver);
    }
}
