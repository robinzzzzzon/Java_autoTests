package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;
import org.openqa.selenium.By;


public interface Priceable {

    By priceHeading = By.xpath("//div[@class='card_title']//p");
    By priceTable = By.xpath("//table[@class='montly_stats']");
    By guaranteeDescLink = By.xpath("//a[text()='Подробнее о гарантии']");
    By guaranteePageMailLink = By.xpath("//a[text()='manager@level.travel']");
    By guaranteeDescPageCross = By.xpath("(//i[@class='lt-icon-cross-2'])[3]");
    By exchangeLeftDD = By.xpath("//div[@class='currency_exchanger_item inlineb'][1]//select");
    By exchangeLeftOptions = By.xpath("//div[@class='currency_exchanger_item inlineb'][1]//option");
    By exchangeLeftInput  =By.xpath("(//input[@class='currency_exchanger_input inlineb'])[1]");
    By exchangeRightDD = By.xpath("//div[@class='currency_exchanger_item inlineb'][2]//select");
    By exchangeRightOptions = By.xpath("//div[@class='currency_exchanger_item inlineb'][2]//option");
    By exchangeRightInput = By.xpath("(//input[@class='currency_exchanger_input inlineb'])[2]");
    By widgetPortugalPhoto = By.xpath("//div[@class='photo_widget_bg']");
    By photoCross = By.xpath("//div[@class='fullscreen_controls-close']");
    By photoPrev = By.xpath("//div[@class='ltaslider-prev']");
    By photoNext = By.xpath("//div[@class='ltaslider-next']");

    ////////////////////////////////////////////

    void selectAnyTableValueByNumber(int rowNumber, int columnNumber);

    void selectAnyTableValueByHeading(int rowNumber, String columnName);

    ////////////////////////////////////////////

    void clickGuaranteeLink();

    void clickToGuaranteeCross();

    /////////////////////////////////////////////

    void clickExchangeLeftDD();

    void selectAnyLeftExOption(int anyNumber);

    void clickExchangeRightDD();

    void selectAnyRightExOption(int anyNumber);

    void writeToLeftCurInput(String anySum);

    void writeToRightCurInput(String anySum);

    /////////////////////////////////////////////////////

    void clickPortugalWidget();

    void closeWidget();

    void clickToPrevPhoto();

    void clickToNextPhoto();
}
