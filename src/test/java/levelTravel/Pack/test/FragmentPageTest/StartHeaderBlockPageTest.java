package levelTravel.Pack.test.FragmentPageTest;

import levelTravel.Pack.StartUpPage.Classes.StartHeaderBlockPage;
import levelTravel.Pack.StartUpPage.SubPages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StartHeaderBlockPageTest {

    private WebDriver driver;
    private WebDriverWait waiter;
    private StartHeaderBlockPage startHeaderBlockPage;

   @Before
   public void setUp(){
       System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\CHDR\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       waiter = new WebDriverWait(driver, 5);
       driver.get("https://level.travel/");
       startHeaderBlockPage = new StartHeaderBlockPage(driver);
   }

   @Test
   public void selectServices(){
       startHeaderBlockPage.clickHeaderServices();
       PromoPage promoPage = startHeaderBlockPage.clickSelectingServices(startHeaderBlockPage.selectHeaderServicesDD(4));
       Assert.assertNotNull(promoPage.getHeading());
   }

   @Test
   public void selectHelpers(){
       startHeaderBlockPage.clickHeaderHelper();
       PressPage pressPage = startHeaderBlockPage.clickSelectingHelper(startHeaderBlockPage.readHeaderHelper(4));
       Assert.assertEquals("ДЕКАБРЬ 2019", pressPage.getHeading());
   }

   @Test
   public void selectPartOfTextWishList(){
       startHeaderBlockPage.clickHeaderMyWishList();
       String s = startHeaderBlockPage.readSelectingWishList((startHeaderBlockPage.selectingPartOfHeaderMyWishList(3)));
       Assert.assertEquals("Ищите иконку на странице чтобы пополнить свой список.", s);
   }

   @Test
   public void doIncorrectRegistry(){
       startHeaderBlockPage.clickHeaderExit()
                      .writeMailInputExit("Qwerty@gmail.com")
                      .clickGoOnButton()
                      .clickRegisterButton();
       Assert.assertEquals("Поле не может быть пустым", startHeaderBlockPage.getTextEmptyFieldError());
   }

   @Test
   public void doCorrectSignUp(){
       startHeaderBlockPage.clickHeaderExit()
                      .writeMailInputExit("patrick.kelskyh@gmail.com")
                      .clickGoOnButton()
                      .writePassInput("oidEYRzs")
                      .clickSignUpButton();
       String s = driver.findElement(By.xpath("//div[@class='auth_success']")).getText();
       Assert.assertEquals("С возвращением, Патрик!", s);
   }

   @Test
   public void doSwitchOnTheFBSource(){
       startHeaderBlockPage.clickHeaderExit();
       FaceBookPage faceBookPage = startHeaderBlockPage.clickFaceBookLink();
       for (String windowHandle : driver.getWindowHandles()) {
           driver.switchTo().window(windowHandle);
       }
       WebElement element = faceBookPage.driver.findElement(By.xpath("//a[text()='Forgotten account?']"));
       Assert.assertTrue(element.isEnabled());
   }

    @Test
    public void doSwitchOnTheVKSource(){
       String mainHandle = startHeaderBlockPage.driver.getWindowHandle();
        startHeaderBlockPage.clickHeaderExit();
        VKPage vkPage = startHeaderBlockPage.clickVKLink();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.switchTo().window(mainHandle);
        String backHandle = startHeaderBlockPage.driver.getWindowHandle();
        Assert.assertEquals(mainHandle, backHandle);
    }

    @Test
    public void checkEnableRecallMeButton(){
       startHeaderBlockPage.clickNumberField();
       WebElement element = driver.findElement(By.xpath("//button[text()='Перезвоните мне']"));
       Assert.assertTrue(element.isEnabled());
    }

    @Test
    public void checkRecallMeNow(){
       startHeaderBlockPage.clickNumberField()
                      .clickRecallMeButton()
                      .clickRecallMeRightNow();
       String s = startHeaderBlockPage.readRecallMeHeading();
       Assert.assertEquals("Или напишите нам в мессенджеры:", s);
    }

    @Test
    public void checkEnableRecallMeToMessenger(){
        String mainHandleWindow = driver.getWindowHandle();
       startHeaderBlockPage.clickNumberField()
                      .clickRecallMeButton();
       WhatsUpPage whatsUpPage = startHeaderBlockPage.clickMessageIcon();
        driver.switchTo().window(mainHandleWindow);
        String s = startHeaderBlockPage.readRecallMeHeading();
        Assert.assertEquals("Или напишите нам в мессенджеры:", s);
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
