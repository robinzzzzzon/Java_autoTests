package levelTravel.Pack.Pages.HotelDescPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HotelFirstDescPage extends AbstractBasePage {

    private WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

    public HotelFirstDescPage(WebDriver driver) {
        super(driver);
    }

    private By circleHeader = By.xpath("//div[@class='pie-wrapper progress-79']");
    private By favoriteButton = By.xpath("//span[text()='В избранное']");
    private By seePriceButton = By.xpath("//button[text()='Посмотреть цены']");
    private By photoList = By.xpath("//div[@class='rtee-images-root'][1]//li//img");
    private By priceByDateList = By.xpath("//ul[@data-reactid='.2.0.1.0.0.0']//li");
    private By foodChoiceDD = By.xpath("//td[text()='Тип проживания']/parent::tr/td[2]");
    private By foodChoiceList = By.xpath("//td[text()='Тип проживания']/parent::tr/td[2]//label");
    private By bestPriceDD = By.xpath("//td[text()='Тип проживания']/parent::tr/td[3]");
    private By bestPriceList = By.xpath("//td[text()='Тип проживания']/parent::tr/td[3]//label");
    private By resultOffersList = By.xpath("//div[@class='result-offers']//li");
    private By moreInfoAboutOffersList = By.xpath("//div[@class='result-offers']//div[@class='more-info']");
    private By crossByMoreInfoMenu = By.xpath("//i[@class='md-cross']");

    public HotelFirstDescPage clickCircleHeader(){
        driver.findElement(circleHeader).click();
        return this;
    }

    public HotelFirstDescPage clickFavoriteButton(){
        driver.findElement(favoriteButton).click();
        return this;
    }

    public HotelFirstDescPage clickSeePriceButton(){
        driver.findElement(seePriceButton).click();
        return this;
    }

    //////////////////////////////////////////////////////////////

    private List<WebElement> getPhotoList(){
        return driver.findElements(photoList);
    }

    public HotelFirstDescPage selectAnyPhoto(int number){
        List<WebElement> webElements = getPhotoList();
        webElements.get(number - 1).click();
        return this;
    }

    /////////////////////////////////////////////////////////////

    private List <WebElement> getPriceByDateList(){
        return driver.findElements(priceByDateList);
    }

    public HotelFirstDescPage selectAnyPriceByDate(int number){
        List<WebElement> webElements = getPriceByDateList();
        webElements.get(number - 1).click();
        return this;
    }

    /////////////////////////////////////////////////////////////

    public HotelFirstDescPage clickFoodChoiceDD(){
        driver.findElement(foodChoiceDD).click();
        return this;
    }

    private List<WebElement> getFoodChoiceList(){
        return driver.findElements(foodChoiceList);
    }

    public HotelFirstDescPage selectAnyFoodVariation(int number){
        List<WebElement> webElements = getFoodChoiceList();
        if(number <= webElements.size()) webElements.get(number - 1).click();
        return new HotelFirstDescPage(driver);
    }

    ///////////////////////////////////////////////////////////

    public HotelFirstDescPage clickBestPriceDD(){
        driver.findElement(bestPriceDD).click();
        return this;
    }

    private List<WebElement> getBestPriceList(){
        return driver.findElements(bestPriceList);
    }

    public HotelFirstDescPage selectAnyPriceVariation(int number){
        List<WebElement> webElements = getBestPriceList();
        if(number <= webElements.size()) webElements.get(number - 1).click();
        return this;
    }

    /////////////////////////////////////////////////////////////

    private List<WebElement> getResultOffersList(){
        return driver.findElements(resultOffersList);
    }

    public HotelSecondDescPage selectAnyResultOfferList(int number){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(moreInfoAboutOffersList));
        List<WebElement> webElements = getResultOffersList();
        if(number <= webElements.size()) webElements.get(number - 1).click();
        return new HotelSecondDescPage(driver);
    }

    ///////////////////////////////////////////////////////////////

    private List<WebElement> getMoreInfoAboutOffersList(){
        return driver.findElements(moreInfoAboutOffersList);
    }

    public HotelFirstDescPage selectMoreInfoAboutOffersVariation(int number){
        List<WebElement> webElements = getMoreInfoAboutOffersList();
        if(number <= webElements.size()) webElements.get(number - 1).click();
        return this;
    }

    ///////////////////////////////////////////////////////////////

    public HotelFirstDescPage clickCrossByMoreInfoMenu(){
        driver.findElement(crossByMoreInfoMenu).click();
        return this;
    }

}
