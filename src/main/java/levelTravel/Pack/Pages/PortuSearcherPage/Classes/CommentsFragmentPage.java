package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Commentable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class CommentsFragmentPage extends AbstractBasePage implements Commentable {

    public void readAllComments(){
        selectAnyElement(readComment);
    }

    private List<WebElementFacade> getCardActionsList(){
        return findAll(cardActionsList);
    }

    public void selectActionPrev(int anyNumber){
        selectAnyElementFromAnyList(getCardActionsList(), anyNumber);
    }

    public void selectActionPrevWhileGetDisabled(int anyNumber){
        WebElement element = getCardActionsList().get(anyNumber - 1);
        do {
            element.click();
        } while(!element.getAttribute("class").equals("testimonial_scroll_next ib disabled"));
    }

    ////////////////////////////////////////////////////

    private List<WebElementFacade> getAllCommentsText(){
        return findAll(commentsTextList);
    }

    public String getAnyCommentText(int anyNumber){
        return getAnyTextFromAnyElementOfList(getAllCommentsText(), anyNumber);
    }

    private List<WebElementFacade> getReadWholeTextLinksList(){
        return findAll(linkReadWholeText);
    }

    public String getAnyCommentTextWhole(int anyNumber){
        return getAnyTextFromAnyElementOfList(getAllCommentsText(), getReadWholeTextLinksList(), anyNumber);
    }

    private List<WebElementFacade> getNamesOfClientsList(){
        return findAll(namesOfClientsList);
    }

    public String getAnyNameFromClientNameList(int anyNumber){
        return getAnyTextFromAnyElementOfList(getNamesOfClientsList(), anyNumber);
    }

    private List<WebElementFacade> getTourLinksFromCommentsList(){
        return findAll(tourLinksFromCommentsList);
    }

    public void selectAnyTourLinkFromCommentsList(int anyNumber){
        selectAnyElementFromAnyList(getTourLinksFromCommentsList(), anyNumber);
    }

    //////////////////////////////////////////////

    private void selectAnyElement(By by){
        find(by).click();
    }

    private void selectAnyElementFromAnyList(List<WebElementFacade> list, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        element.click();
    }

    private String getAnyTextFromAnyElementOfList(List<WebElementFacade> list, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        return element.getText();
    }

    private String getAnyTextFromAnyElementOfList(List<WebElementFacade> list, List<WebElementFacade> readWholeList, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        WebElement linkElement = readWholeList.get(anyNumber - 1);
        //linkElement.click();
        return element.getText();
    }
}
