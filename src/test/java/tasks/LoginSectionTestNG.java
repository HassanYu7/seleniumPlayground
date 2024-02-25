package tasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;

public class LoginSectionTestNG {

    static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String getAlertMessage() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.name("uid")).sendKeys("mngr554581");
        driver.findElement(By.name("password")).sendKeys("aqejysU");
        driver.findElement(By.name("btnLogin")).click();
        Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
    }

    @Test
    public void testInvalidUseridAndValidPassword() {
        driver.findElement(By.name("uid")).sendKeys("mngr554d581");
        driver.findElement(By.name("password")).sendKeys("aqejysU");
        driver.findElement(By.name("btnLogin")).click();
        Assert.assertEquals("User or Password is not valid", getAlertMessage());
    }

    @Test
    public void testValidUseridAndInvalidPassword() throws InterruptedException {
        driver.findElement(By.name("uid")).sendKeys("mngr554581");
        driver.findElement(By.name("password")).sendKeys("aqedasddjysU");
        driver.findElement(By.name("btnLogin")).click();
        Assert.assertEquals("User or Password is not valid", getAlertMessage());
    }

    @Test
    public void testInvalidUseridAndInvalidPassword() {
        driver.findElement(By.name("uid")).sendKeys("mngr554581");
        driver.findElement(By.name("password")).sendKeys("aqedsdjysU");
        driver.findElement(By.name("btnLogin")).click();
        Assert.assertEquals("User or Password is not valid", getAlertMessage());
    }
}
