package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassStrcutred {

    static WebDriver driver;


    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void webForm(){

        By textAreaInput = By.name("my-textarea");
        var textAreaValue = driver.findElement(textAreaInput).getText().toString();

        By pageHeader = By.tagName("h1");
        var textValue = driver.findElement(pageHeader).getText();

        Assertions.assertEquals("Web form",textValue);
        Assertions.assertEquals("", textAreaValue);
    }

    @Test
    public void webFormSubmit(){
        By submitButton = By.className("btn-outline-primary");
        driver.findElement(submitButton).click();
        By pageHeader = By.tagName("h1");
        var textValue = driver.findElement(pageHeader).getText();

        Assertions.assertEquals("Form submitted",textValue);
    }

    @Test
    public void checkForGoogleTitleAndURL()  {
        var title =  driver.getTitle();
        var currentURL =  driver.getCurrentUrl();
        Assertions.assertEquals("Google",title);
        Assertions.assertEquals("https://www.google.com/",currentURL);
    }


    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
