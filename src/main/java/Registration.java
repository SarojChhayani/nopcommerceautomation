import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Registration {
    protected static WebDriver driver;

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

    @AfterMethod
    public static void closeBrowser() {
        //close browser
        driver.close();
    }

    @Test
    public static void usershouldbeabletoregistersucessfully() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Click on register
        clickOnElement(By.className("ico-register"));
        //Type First name
        typeText(By.id("FirstName"), "Seema");
        //Type Lastname
        typeText(By.name("LastName"), "Parekh");
        //Type E-mail
        typeText(By.id("Email"), "sparekh" + randomDate() + "@gmail.com");
        //Type Password
        typeText(By.id("Password"), "Abcd@123");
        //Type Confirmed password
        typeText(By.id("ConfirmPassword"), "Abcd@123");
        //Click on register Submit Button
        clickOnElement(By.id("register-button"));
        //Verify correct registration message displayed
        String actualMsg = getTextFromElement(By.className("result"));
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
