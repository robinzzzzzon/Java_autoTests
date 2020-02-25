package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;

import org.openqa.selenium.By;

public interface Commentable {

    By readComment = By.xpath("//a[text()='Читать все отзывы']");
    By cardActionsList = By.xpath("(//div[@class='card_actions'])[2]//li");
    By commentsTextList = By.xpath("//ul[@class='rmf testimonials_list']/li/div[1]/div[1]");
    By linkReadWholeText = By.xpath("//ul[@class='rmf testimonials_list']/li/div[1]/div[2]");
    By namesOfClientsList = By.xpath("//ul[@class='rmf testimonials_list']/li/div[2]/div[2]");
    By tourLinksFromCommentsList = By.xpath("//ul[@class='rmf testimonials_list']/li/div[2]/div[3]");

    void readAllComments();

    void selectActionPrev(int anyNumber);

    void selectActionPrevWhileGetDisabled(int anyNumber);

    String getAnyCommentText(int anyNumber);

    String getAnyCommentTextWhole(int anyNumber);

    String getAnyNameFromClientNameList(int anyNumber);

    void selectAnyTourLinkFromCommentsList(int anyNumber);
}
