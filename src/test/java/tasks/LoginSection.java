package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSection {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.name("uid")).sendKeys("mngr554581");
        driver.findElement(By.name("password")).sendKeys("aqejysU");
        driver.findElement(By.name("btnLogin")).click();
        Assertions.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
    }

    private String getMessage(){
        String alertMessage = driver.switchTo().alert().getText();
        return alertMessage;
    }

    @Test
    public void testInvalidUseridAndValidPassword() {
        driver.findElement(By.name("uid")).sendKeys("mngr554d581");
        driver.findElement(By.name("password")).sendKeys("aqejysU");
        driver.findElement(By.name("btnLogin")).click();
        Assertions.assertEquals("User or Password is not valid", getMessage());
    }

    @Test
    public void testValidUseridAndInvalidPassword() {
        driver.findElement(By.name("uid")).sendKeys("mngr554581");
        driver.findElement(By.name("password")).sendKeys("aqedjysU");
        driver.findElement(By.name("btnLogin")).click();
        Assertions.assertEquals("User or Password is not valid", getMessage());
    }

    @Test
    public void testInvalidUseridAndInvalidPassword() {
        driver.findElement(By.name("uid")).sendKeys("mngrfd554581");
        driver.findElement(By.name("password")).sendKeys("aqedsdjysU");
        driver.findElement(By.name("btnLogin")).click();
        Assertions.assertEquals("User or Password is not valid", getMessage());
    }


    @AfterEach
    public void close() {
        driver.quit();
    }
}
