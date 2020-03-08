package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Footerable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class FooterFragmentPage extends AbstractBasePage implements Footerable {

    BaseMethods methods = new BaseMethods();

    private List<WebElementFacade> getNavCompanyList(){
        return methods.getAnyList(navCompanyList);
    }

    public void selectAnyElementFromCompanyList(int anyNumber){
        //Здесь решил не переопределять метод в BaseMethods ради редкого случая, когда заголовок списка входит в сам список как строка.
        methods.selectAnyElementFromList(anyNumber + 1, getNavCompanyList());
    }

    private List<WebElementFacade> getInstrumentsList(){
        return methods.getAnyList(navInstrumentsList);
    }

    public void selectAnyElementFromInstrumentsList(int anyNumber){
        //Same
        methods.selectAnyElementFromList(anyNumber + 1, getInstrumentsList());
    }

    private List<WebElementFacade> getHelperList(){
        return methods.getAnyList(navHelperList);
    }

    public void selectAnyElementFromHelperList(int anyNumber){
        //Same
        methods.selectAnyElementFromList(anyNumber + 1, getHelperList());
    }

    ///////////////////////////////////////////////////////////////////

    public void selectGuaranteeLink(){
        methods.selectAnyElement(priceGuaranteeLink);
    }

    ///////////////////////////////////////////////////////////////

    private List<WebElementFacade> getSocialLinksList(){
        return methods.getAnyList(socialLinksList);
    }

    public void selectAnySocial(int number){
        methods.selectAnyElementFromList(number, getSocialLinksList());
    }

    /////////////////////////////////////////

    private List<WebElementFacade> getStoreList(){
        return methods.getAnyList(appStoreAndGooglePlayList);
    }

    public void selectGooglePlayLink(){
        methods.selectAnyElementFromList(1, getStoreList());
    }

    public void selectAppStoreLink(){
        methods.selectAnyElementFromList(2, getStoreList());
    }

    //////////////////////////////////////////////

    public void getTextInfo(){
        methods.getTextFromAnyElement(footerInfo);
    }

    public void selectLawLink(){
        methods.selectAnyElement(lawInformationLink);
    }

    public void selectSkLink(){
        methods.selectAnyElement(skLink);
    }

}
