package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;

import org.openqa.selenium.By;

public interface Footerable {

    By navCompanyList = By.xpath("//div[@class='footer__top__menu']/ul[1]/li");
    By navInstrumentsList = By.xpath("//div[@class='footer__top__menu']/ul[2]/li");
    By navHelperList = By.xpath("//div[@class='footer__top__menu']/ul[3]/li");
    By priceGuaranteeLink = By.xpath("//a[@class='footer__best-price-guarantee']");
    By socialLinksList = By.xpath("//div[@class='footer-social-links__container']/a");
    By appStoreAndGooglePlayList = By.xpath("//div[@class='footer__bottom__mobile-apps__links']/div");
    By lawInformationLink = By.xpath("//a[text()='Правовая информация']");
    By skLink = By.xpath("//a[@class='footer__skolkovo']");
    By footerInfo = By.xpath("//div[@class='footer__info']");

    void selectAnyElementFromCompanyList(int anyNumber);

    void selectAnyElementFromInstrumentsList(int anyNumber);

    void selectAnyElementFromHelperList(int anyNumber);

    ///////////////////////////////////////////////////////////////////

    void selectGuaranteeLink();

    ///////////////////////////////////////////////////////////////

    void selectAnySocial(int number);

    /////////////////////////////////////////

    void selectGooglePlayLink();

    void selectAppStoreLink();

    //////////////////////////////////////////////

    void getTextInfo();

    void selectLawLink();

    void selectSkLink();
}