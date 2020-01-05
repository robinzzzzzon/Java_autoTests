package levelTravel.Pack.Pages.HelperClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethodClass {

    private WebDriver driver;

    public WaitMethodClass(WebDriver driver) {
        this.driver = driver;
    }

    public void waitWhileElementWillBePresent(By locator, int timeout){
        try {
            System.out.println("Waiting for max: " + timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element was appeared on the web page");
        } catch (Exception e){
            System.out.println("Element was not appeared on the web page");
        }
    }

    public WebElement waitWhileElementWillBeClickable(By locator, int timeout){
        WebElement element = null;
        try {
            System.out.println("Waiting for max: " + timeout + " seconds for element to be clickable");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element was clicked on the web page");
        } catch (Exception e){
            System.out.println("Element was not appeared on the web page");
        }
        return element;
    }


}
