package testPackage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass1 {

    private static WebDriver driver;

    @BeforeAll
     static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void testSubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        String buttonText = submitButton.getText();
        Assertions.assertEquals("Submit", buttonText, "Button text is not 'submit'");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
