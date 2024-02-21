package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassStrcutred {

    static WebDriver driver;


    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().to("https://www.google.com");
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
