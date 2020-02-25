package levelTravel.Pack.Pages.PortuSearcherPage.Interfaces;

import org.openqa.selenium.By;

public interface BuyInstructable {

    By stepsList = By.xpath("//ul[@class='steps_line step-1']/li");
    By prevStep = By.xpath("//div[@class='book_guide_button book_guide_prev']");
    By nextStep = By.xpath("//div[@class='book_guide_button book_guide_next']");


    void selectAnyStep(int anyNumber);

    void selectFirstAndLastSteps();

    void selectAllSteps();

    void selectPrevStep();

    void selectNextStep();
}
