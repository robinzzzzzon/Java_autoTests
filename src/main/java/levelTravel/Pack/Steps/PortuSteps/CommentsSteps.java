package levelTravel.Pack.Steps.PortuSteps;

import levelTravel.Pack.Pages.PortuSearcherPage.Classes.CommentsFragmentPage;
import levelTravel.Pack.Pages.PortuSearcherPage.Classes.LinerFragmentPage;
import net.thucydides.core.annotations.Step;

public class CommentsSteps {

    private CommentsFragmentPage page;
    private LinerFragmentPage lPage;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void clickAnyLinerNumber(int anyNumber){
        lPage.clickAnyLabelOfLiner(anyNumber);
    }

    @Step
    public void readAllComments(){
        page.readAllComments();
    }

    @Step
    public void selectActionPrev(int anyNumber){
        page.selectActionPrev(anyNumber);
    }

    @Step
    public void selectActionPrevWhileGetDisabled(int anyNumber){
        page.selectActionPrevWhileGetDisabled(anyNumber);
    }

    ////////////////////////////////////////////////////

    @Step
    public String getAnyCommentText(int anyNumber){
        return page.getAnyCommentText(anyNumber);
    }

    @Step
    public String getAnyCommentTextWhole(int anyNumber){
        return page.getAnyCommentTextWhole(anyNumber);
    }

    @Step
    public String getAnyNameFromClientNameList(int anyNumber){
        return page.getAnyNameFromClientNameList(anyNumber);
    }

    @Step
    public void selectAnyTourLinkFromCommentsList(int anyNumber){
        page.selectAnyTourLinkFromCommentsList(anyNumber);
    }
}
