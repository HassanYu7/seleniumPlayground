package testPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {


    @Test
    public void testMethod() {
        WebDriver driver = new ChromeDriver();

        //
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        //
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");


//        driver.getTitle();

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));


        System.out.println(driver.getTitle());

        driver.quit();

    }

}
