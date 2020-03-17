package levelTravel.Pack.Pages.HotelDescPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.HotelDescPage.Descriptable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

//Прописать через регулярное выражение!
@DefaultUrl("https://level.travel/hotels/9017874-Kleopatra_Aytur_Apart_Hotel?adults=2&from=Moscow-RU&kids=0&nights=7&offer_date=2020-03-27&offer_instant_confirm=false&offer_operators=&start_date=27.03.2020")
public class HotelFirstDescPage extends AbstractBasePage implements Descriptable {

    BaseMethods methods = new BaseMethods();

    //Работа с соцсетями:

    public void clickShareDd(){
        methods.selectAnyElement(shareButtonDd);
    }

    private List<WebElementFacade> getShareList(){
       return methods.getAnyList(shareButtonList);
    }

    public void selectAnyMessenger(boolean b){
        if(b){
            getShareList().get(1).click();
        } else{
            getShareList().get(2).click();
        }
    }

    //////////////////////////////////////////////////////

    public void getMainHeadingText(){
        methods.getTextFromAnyElement(mainHeader);
    }

    public void getDescHotelText(){
        methods.getTextFromAnyElement(mainDescHotel);
    }

    /////////////////////////////////////////////////////

    public void clickPriceButton(){
        methods.selectAnyElement(priceButton);
    }

    public void clickAskPriceButton(){
        methods.selectAnyElement(priceAskButton);
    }

    /////////////////////////////////////////////////////

    public void clickWishListIcon(){
        methods.selectAnyElement(wishListIcon);
    }

    /////////////////////////////////////////////////////

    private List<WebElementFacade> getPhotoCarouselButtonList(){
        return methods.getAnyList(photoCarouselButtonList);
    }

    public void selectAnyPhotoSwitch(boolean b){
        if(b){
            getPhotoCarouselButtonList().get(1).click();
        } else{
            getPhotoCarouselButtonList().get(2).click();
        }
    }

    public void selectPhotoCross(){
        methods.selectAnyElement(photoCarouselCrossButton);
    }

    //дописать умный метод на пролистывание баттонов карусели до конца, с учетом того,
    //что они должны нажиматься только с проверкой, а есть ли вообще этот элемент на странице.

    private List<WebElementFacade> getPhotoCarouselList(){
        return methods.getAnyList(photoCarouselList);
    }

    public void selectAnyPhotoFromCarousel(int number){
        //Тут возможно нужно будет дописать проверку на пролистывание карусели фото исходя из введенного номера.
        methods.selectAnyElementFromList(number, getPhotoCarouselList());
    }

    /////////////////////////////////////////////////////

    private List<WebElementFacade> getBarList(){
        return methods.getAnyList(optionBarList);
    }

    public void selectAnyElementFromOptionBar(int number){
        methods.selectAnyElementFromList(number, getBarList());
    }

    //////////////////////////////////////////////////////

    private List<WebElementFacade> getDateSlideList(){
        return methods.getAnyList(dateSlideList);
    }

    public void selectAnyDataFromDateList(int number){
        methods.selectAnyElementFromList(number, getDateSlideList());
    }

    //////////////////////////////////////////////////////

    public void clickAllToursButton(){
        methods.selectAnyElement(allToursButton);
    }

    public void clickMomentConfirmationCb(boolean b){
        methods.selectOrDeselectAnyElement(momentConfirmationCb, b);
    }

    //////////////////////////////////////////////////////////

    public void clickTourOperatorDd(){
        waitForRenderedElementsToBePresent(tourOperatorDd);
        methods.selectAnyElement(tourOperatorDd);
    }

    private List<WebElementFacade> getTourList(){
        return methods.getAnyList(tourOperatorLabelList);
    }

    public void selectAnyTourOperatorFromList(int number){
        methods.selectAnyElementFromList(number, getTourList());
    }

    public void clickDoneButton(){
        methods.selectAnyElement(doneButton);
    }

    //////////////////////////////////////////////////////

    private List<WebElementFacade> getOfferButtonList(){
        return methods.getAnyList(offerButtonList);
    }

    public void selectAnyOfferButton(int number){
        waitForRenderedElements(offerButtonList);
        methods.selectAnyElementFromList(number, getOfferButtonList());
    }

    private List<WebElementFacade> getOfferDdList(){
        return methods.getAnyList(offerDdList);
    }

    public void selectAnyOfferDdFromList(int number){
        methods.selectAnyElementFromList(number, getOfferDdList());
    }

    private List<WebElementFacade> getResultOfferDdList(){
        return methods.getAnyList(resultOfferDdList);
    }

    public void selectAnyOfferFromOfferDdList(int number){
        methods.selectAnyElementFromList(number, getResultOfferDdList());
    }

    ///////////////////////////////////////////////////////





}
