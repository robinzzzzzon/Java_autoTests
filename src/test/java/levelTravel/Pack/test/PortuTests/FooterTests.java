package levelTravel.Pack.test.PortuTests;

import levelTravel.Pack.Steps.PortuSteps.FooterSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class FooterTests {

    @Steps
    private FooterSteps steps;

    @Managed
    private WebDriver driver;

    @Test
    public void selectAnyCompanyLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectAnyElementFromCompanyList(3);
    }

    @Test
    public void selectAnyInstrumentsLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectAnyElementFromInstrumentsList(2);
    }

    @Test
    public void selectAnyHelperLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectAnyElementFromHelperList(1);
    }

    @Test
    public void selectGuaranteeLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectGuaranteeLink();
    }

    @Test
    public void selectAnySocialLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectAnySocial(3);
    }

    @Test
    public void selectGooglePlayLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectGooglePlayLink();
    }

    @Test
    public void selectAppStoreLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectAppStoreLink();
    }

    @Test
    public void getTextInfo() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.getTextInfo();
    }

    @Test
    public void selectLawLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectLawLink();
    }

    @Test
    public void selectSkLink() {
        steps.openPage();
        steps.selectAnyLinerNumber(7);
        steps.selectSkLink();
    }

}
