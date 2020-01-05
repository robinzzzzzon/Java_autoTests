package BasePack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Lesson8_checkboxes {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\IdeaProjects\\mavenTest\\drivers\\GKDR\\geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(900, 500));

        driver.get("https://market.yandex.ru/");

        WebElement linkBytovTech = driver.findElement(By.xpath("//span[text()='Бытовая техника']"));
        linkBytovTech.click();
        WebElement linkFreeze = driver.findElement(By.xpath("//div[2]/ul[1]/li[1]/div[1]/a[1]"));
        linkFreeze.click();

        selectCheckBox("1", "ATLANT");
        System.out.println();
        deSelectCheckBox("1", "ATLANT");
        /*
        if(!(driver.findElement(By.xpath("//fieldset[1]/ul[1]/li[1]/div[1]/a[1]/label[1]/input[1]")).isSelected()));
        driver.findElement(By.xpath("//span[contains(text(),'ATLANT')]")).click();
        System.out.println(driver.findElement(By.xpath("//fieldset[1]/ul[1]/li[1]/div[1]/a[1]/label[1]/input[1]")).isSelected());

        if(!(driver.findElement(By.xpath("//fieldset[1]/ul[1]/li[2]/div[1]/a[1]/label[1]/input[1]")).isSelected()));
        driver.findElement(By.xpath("//span[contains(text(),'Beko')]")).click();
        System.out.println(driver.findElement(By.xpath("//fieldset[1]/ul[1]/li[2]/div[1]/a[1]/label[1]/input[1]")).isSelected());

        if(!(driver.findElement(By.xpath("//fieldset[1]/ul[1]/li[3]/div[1]/a[1]/label[1]/input[1]")).isSelected()));
        driver.findElement(By.xpath("//span[contains(text(),'Bosch')]")).click();
        System.out.println(driver.findElement(By.xpath("//fieldset[1]/ul[1]/li[3]/div[1]/a[1]/label[1]/input[1]")).isSelected());
        */

        }
    private static void selectCheckBox(String  rbXPathName, String rbName){
        String localRbXPath = "//fieldset[1]/ul[1]/li[%s]/div[1]/a[1]/label[1]/input[1]";
        String localRbNameXPath = "//span[contains(text(),'%s')]";
        System.out.println(driver.findElement(By.xpath(String.format(localRbXPath, rbXPathName))).isSelected());
        if(!driver.findElement(By.xpath(String.format(localRbXPath, rbXPathName))).isSelected()) {
            driver.findElement(By.xpath(String.format(localRbNameXPath, rbName))).click();
            System.out.println(driver.findElement(By.xpath(String.format(localRbXPath, rbXPathName))).isSelected());
        }
    }
    private static void deSelectCheckBox(String  rbXPathName, String rbName){
        String localRbXPath = "//fieldset[1]/ul[1]/li[%s]/div[1]/a[1]/label[1]/input[1]";
        String localRbNameXPath = "//span[contains(text(),'%s')]";
        System.out.println(driver.findElement(By.xpath(String.format(localRbXPath, rbXPathName))).isSelected());
        if(driver.findElement(By.xpath(String.format(localRbXPath, rbXPathName))).isSelected()) {
            driver.findElement(By.xpath(String.format(localRbNameXPath, rbName))).click();
            System.out.println(driver.findElement(By.xpath(String.format(localRbXPath, rbXPathName))).isSelected());
        }
    }
}
