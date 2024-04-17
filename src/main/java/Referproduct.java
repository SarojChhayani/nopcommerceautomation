import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Referproduct { protected static WebDriver driver;

    //initialization expected msg
    static String expectedMsg = "Your registration completed";

    @BeforeMethod
    public static void openbBowser() {
        //open browser
        driver = new ChromeDriver();
        //Type URL
        driver.get("https://demo.nopcommerce.com/");
    }
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    public static String randomDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }
//    @AfterMethod
//    public static void closeBrowser() {
//        //close browser
//        driver.close();
//    }
    @Test
    public static void registerusershouldbeabletoreferaproducttofriend(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Click on register
        clickOnElement(By.className("ico-register"));
        //driver.findElement(By.className("ico-register")).click();

        //Type First name
        typeText(By.id("FirstName"), "Seema");
        //driver.findElement(By.id("FirstName")).sendKeys("Seema");

        //Type Lastname
        typeText(By.name("LastName"), "Parekh");
        //driver.findElement(By.name("LastName")).sendKeys("Parekh");

        //Type E-mail
        typeText(By.id("Email"), "seemaparekh"+randomDate()+"@gmail.com");
        //driver.findElement(By.id("Email")).sendKeys("sparekh02@gmail.com");

        //Type Password
        typeText(By.id("Password"), "Abcd@123");
        //driver.findElement(By.id("Password")).sendKeys("Abcd@123");

        //Type Confirmed password
        typeText(By.id("ConfirmPassword"), "Abcd@123");
        //driver.findElement(By.id("ConfirmPassword")).sendKeys("Abcd@123");

        //Click on register Submit Button
        clickOnElement(By.id("register-button"));
        //driver.findElement(By.id("register-button")).click();

        //Verify correct registration message displayed
        String actualMsg = getTextFromElement(By.className("result"));
        //String actualMsg = driver.findElement(By.className("result")).getText();

        Assert.assertEquals(actualMsg,expectedMsg);

        //click on continue button
        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));

        //click on electronics button on menu bar
        clickOnElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));

        //click on camera & photos
        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a"));

        //click on Leica T Mirrorless Digital Camera product
        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a"));

        //click on Email a friend
        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[4]/div[2]/button"));

        //Type friend's email
        typeText(By.className("friend-email"),"abcxyz@gmail.com");

        //type Your email
        typeText(By.id("YourEmailAddress"),"seemaparekh"+randomDate()+"@gmail.com");

        //Type Personal message
        typeText(By.id("PersonalMessage"),"Good camera at very cheaper rate");

        //click on send email
        clickOnElement(By.name("send-email"));



    }
}
