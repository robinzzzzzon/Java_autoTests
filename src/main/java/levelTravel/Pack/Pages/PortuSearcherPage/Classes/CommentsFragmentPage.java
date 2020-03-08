package levelTravel.Pack.Pages.PortuSearcherPage.Classes;

import levelTravel.Pack.Pages.AbstractPage.AbstractBasePage;
import levelTravel.Pack.Pages.HelperClasses.BaseMethods;
import levelTravel.Pack.Pages.PortuSearcherPage.Interfaces.Commentable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://level.travel/countries/portugal")
public class CommentsFragmentPage extends AbstractBasePage implements Commentable {

    BaseMethods methods = new BaseMethods();

    public void readAllComments(){
        methods.selectAnyElement(readComment);
    }

    private List<WebElementFacade> getCardActionsList(){
        return methods.getAnyList(cardActionsList);
    }

    public void selectActionPrev(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getCardActionsList());
    }

    public void selectActionPrevWhileGetDisabled(int anyNumber){
        WebElement element = getCardActionsList().get(anyNumber - 1);
        do {
            element.click();
        } while(!element.getAttribute("class").equals("testimonial_scroll_next ib disabled"));
    }

    ////////////////////////////////////////////////////

    private List<WebElementFacade> getAllCommentsText(){
        return methods.getAnyList(commentsTextList);
    }

    public String getAnyCommentText(int anyNumber){
        return methods.getTextFromAnyElementOfList(getAllCommentsText(), anyNumber);
    }

    private List<WebElementFacade> getReadWholeTextLinksList(){
        return methods.getAnyList(linkReadWholeText);
    }

    public String getAnyCommentTextWhole(int anyNumber){
        return getAnyTextFromAnyElementOfList(getAllCommentsText(), getReadWholeTextLinksList(), anyNumber);
    }

    private List<WebElementFacade> getNamesOfClientsList(){
        return methods.getAnyList(namesOfClientsList);
    }

    public String getAnyNameFromClientNameList(int anyNumber){
        return methods.getTextFromAnyElementOfList(getNamesOfClientsList(), anyNumber);
    }

    private List<WebElementFacade> getTourLinksFromCommentsList(){
        return methods.getAnyList(tourLinksFromCommentsList);
    }

    public void selectAnyTourLinkFromCommentsList(int anyNumber){
        methods.selectAnyElementFromList(anyNumber, getTourLinksFromCommentsList());
    }

    //////////////////////////////////////////////
    //Подумать, как можно объединить этот метод с базовым получением куска текста из списка элементов.
    //Пока оставлю метод тут

    private String getAnyTextFromAnyElementOfList(List<WebElementFacade> list, List<WebElementFacade> readWholeList, int anyNumber){
        WebElement element = list.get(anyNumber - 1);
        WebElement linkElement = readWholeList.get(anyNumber - 1);
        //linkElement.click();
        return element.getText();
    }
}
