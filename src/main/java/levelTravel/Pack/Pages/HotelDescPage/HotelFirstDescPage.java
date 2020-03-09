package levelTravel.Pack.Pages.HotelDescPage;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class HotelFirstDescPage extends AbstractBasePage {

    private By circleHeader = By.xpath("//div[@class='pie-wrapper progress-79']");
    private By favoriteButton = By.xpath("//span[@class='hotel-wishlist__text']");
    private By seePriceButton = By.xpath("//button[text()='Посмотреть цены']");
    private By photoList = By.xpath("//div[@id='lt-hotel-gallery']//img");
    private By priceByDateList = By.xpath("//ul[@data-reactid='.2.0.1.0.0.0']//li");
    private By foodChoiceDD = By.xpath("//td[text()='Тип проживания']/parent::tr/td[2]");
    private By foodChoiceList = By.xpath("//td[text()='Тип проживания']/parent::tr/td[2]//label");
    private By bestPriceDD = By.xpath("//td[text()='Тип проживания']/parent::tr/td[3]");
    private By bestPriceList = By.xpath("//td[text()='Тип проживания']/parent::tr/td[3]//label");
    private By resultOffersList = By.xpath("//div[@class='result-offers']//li");
    private By moreInfoAboutOffersList = By.xpath("//div[@class='result-offers']//div[@class='more-info']");
    private By crossByMoreInfoMenu = By.xpath("//i[@class='md-cross']");

    public HotelFirstDescPage clickCircleHeader() {
        find(circleHeader).click();
        return this;
    }

    public HotelFirstDescPage clickFavoriteButton() {
        find(favoriteButton).click();
        return this;
    }

    public HotelFirstDescPage clickSeePriceButton() {
        find(seePriceButton).click();
        return this;
    }

    //////////////////////////////////////////////////////////////

    private List<WebElementFacade> getPhotoList() {
        waitForRenderedElements(photoList);
        return findAll(photoList);
    }

    public HotelFirstDescPage selectAnyPhoto(int number) {
        List<WebElementFacade> webElements = getPhotoList();
        webElements.get(number - 1).click();
        return this;
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getPriceByDateList() {
        return findAll(priceByDateList);
    }

    public HotelFirstDescPage selectAnyPriceByDate(int number) {
        List<WebElementFacade> webElements = getPriceByDateList();
        webElements.get(number - 1).click();
        return this;
    }

    /////////////////////////////////////////////////////////////

    public HotelFirstDescPage clickFoodChoiceDD() {
        find(foodChoiceDD).click();
        return this;
    }

    private List<WebElementFacade> getFoodChoiceList() {
        return findAll(foodChoiceList);
    }

    public HotelFirstDescPage selectAnyFoodVariation(int number) {
        List<WebElementFacade> webElements = getFoodChoiceList();
        if (number <= webElements.size()) webElements.get(number - 1).click();
        return new HotelFirstDescPage();
    }

    ///////////////////////////////////////////////////////////

    public HotelFirstDescPage clickBestPriceDD() {
        find(bestPriceDD).click();
        return this;
    }

    private List<WebElementFacade> getBestPriceList() {
        return findAll(bestPriceList);
    }

    public HotelFirstDescPage selectAnyPriceVariation(int number) {
        List<WebElementFacade> webElements = getBestPriceList();
        if (number <= webElements.size()) webElements.get(number - 1).click();
        return this;
    }

    /////////////////////////////////////////////////////////////

    private List<WebElementFacade> getResultOffersList() {
        return findAll(resultOffersList);
    }

    public HotelSecondDescPage selectAnyResultOfferList(int number) {
        List<WebElementFacade> webElements = getResultOffersList();
        if (number <= webElements.size()) webElements.get(number - 1).click();
        return new HotelSecondDescPage();
    }

    ///////////////////////////////////////////////////////////////

    private List<WebElementFacade> getMoreInfoAboutOffersList() {
        return findAll(moreInfoAboutOffersList);
    }

    public HotelFirstDescPage selectMoreInfoAboutOffersVariation(int number) {
        List<WebElementFacade> webElements = getMoreInfoAboutOffersList();
        if (number <= webElements.size()) webElements.get(number - 1).click();
        return this;
    }

    ///////////////////////////////////////////////////////////////

    public HotelFirstDescPage clickCrossByMoreInfoMenu() {
        find(crossByMoreInfoMenu).click();
        return this;
    }

}
