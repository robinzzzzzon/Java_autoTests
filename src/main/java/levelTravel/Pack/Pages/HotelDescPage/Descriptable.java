package levelTravel.Pack.Pages.HotelDescPage;

import org.openqa.selenium.By;

public interface Descriptable {

     By shareButtonDd = By.xpath("//div[@class='lt-hotel-header__stars-location']/div[2]/button");
     By shareButtonList = By.xpath("//div[@class='lt-hotel-header__stars-location']/div[2]/div//button");
     By mainHeader = By.xpath("//span[@class='lt-hotel-header__title--bold']");
     By mainDescHotel = By.xpath("//div[@class='lt-hotel-header__subheader']/div");
     By priceButton = By.xpath("//span[@class='hotel-price-badge__inner']/button");
     By priceAskButton = By.xpath("//span[@class='lt-hotel-header__tooltip']/button");
     By wishListIcon = By.xpath("//div[@class='hotel-wishlist']/button");
     By photoCarouselButtonList = By.xpath("//div[@id='lt-hotel-gallery']//button");
     By photoCarouselCrossButton = By.xpath("//button[contains(@class, 'FullscreenGallery')][1]");
     By photoCarouselList = By.xpath("//div[@id='lt-hotel-gallery']//img");
     By optionBarList = By.xpath("//div[contains(@class, 'StyledWrapper')][1]/button");
     By allToursButton = By.xpath("//button[text()='Все туры в этот отель']/parent::div");
     By dateSlideList = By.xpath("//div[@class='slick-track']//button");
     By momentConfirmationCb = By.xpath("//div[contains(@class, 'SearcherFormFilters')][1]//input");
     By tourOperatorDd = By.xpath("//span[contains(text(), 'Показаны')]");
     By tourOperatorLabelList = By.xpath("//div[contains(@class, 'AbstractDropdown')]/div//label");
     By doneButton = By.xpath("//div[contains(@class, 'AbstractDropdown')]/div[2]/button");
     By offerButtonList = By.xpath("//button[contains(@class, 'HotelOfferButton')]");
     By offerDdList = By.xpath("//span[contains(@class, 'StyledDropdownLabel')]/parent::span/parent::button/parent::div");
     By resultOfferDdList = By.xpath("//div[contains(@class, 'OffersContainer')]/button");

     void clickShareDd();

     void selectAnyMessenger(boolean b);

     //////////////////////////////////////////////////////

     void getMainHeadingText();

     void getDescHotelText();

     /////////////////////////////////////////////////////

     void clickPriceButton();

     void clickAskPriceButton();

     /////////////////////////////////////////////////////

     void clickWishListIcon();

     /////////////////////////////////////////////////////

     void selectAnyPhotoSwitch(boolean b);

     void selectPhotoCross();
     //дописать умный метод на пролистывание баттонов карусели до конца, с учетом того,
     //что они должны нажиматься только с проверкой, а есть ли вообще этот элемент на странице.

     void selectAnyPhotoFromCarousel(int number);

     /////////////////////////////////////////////////////

     void selectAnyElementFromOptionBar(int number);

     //////////////////////////////////////////////////////

     void selectAnyDataFromDateList(int number);

     //////////////////////////////////////////////////////

     void clickAllToursButton();

     void clickMomentConfirmationCb(boolean b);

     //////////////////////////////////////////////////////////

     void clickTourOperatorDd();

     void selectAnyTourOperatorFromList(int number);

     void clickDoneButton();

     //////////////////////////////////////////////////////

     void selectAnyOfferButton(int number);

     void selectAnyOfferDdFromList(int number);

     void selectAnyOfferFromOfferDdList(int number);
}
