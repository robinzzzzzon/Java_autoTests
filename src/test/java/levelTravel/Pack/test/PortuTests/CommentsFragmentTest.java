package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.CommentsSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CommentsFragmentTest {

    @Steps
    private CommentsSteps steps;

    @Managed
    private WebDriver driver;

    @Test
    public void clickNextPartOfComments(){
        steps.openPage();
        steps.clickAnyLinerNumber(6);
        steps.selectActionPrev(2);
    }

    @Test
    public void clickNextAndBackPartOfComments(){
        steps.openPage();
        steps.clickAnyLinerNumber(6);
        steps.selectActionPrev(2);
        steps.selectActionPrev(1);
    }

    @Test
    public void readAllCommentsLink(){
        steps.openPage();
        steps.clickAnyLinerNumber(6);
        steps.readAllComments();
    }

    @Test
    public void selectActionPrevWhileGetDisabled(){
        steps.openPage();
        steps.clickAnyLinerNumber(6);
        steps.selectActionPrevWhileGetDisabled(2);
    }

    @Test
    public void getAnyCommentText(){
        steps.openPage();
        steps.clickAnyLinerNumber(6);
        steps.getAnyCommentText(3);
    }

    @Test
    //Доделать нормально. Если коммент после 3го, то надо еще вызывать метод перелистывания кусков комментов
    public void getAnyCommentTextWhole(){
        steps.openPage();
        steps.clickAnyLinerNumber(6);
        steps.getAnyCommentTextWhole(3);
    }

    @Test
    public void  getAnyNameFromClientNameList(){
        steps.openPage();
        steps.clickAnyLinerNumber(6);
        steps. getAnyNameFromClientNameList(10);
    }

    @Test
    public void selectAnyTourLinkFromCommentsList(){
        steps.openPage();
        steps.clickAnyLinerNumber(6);
        steps.selectAnyTourLinkFromCommentsList(6);
    }


}
