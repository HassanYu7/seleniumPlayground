package structureDesign;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlertTests extends TestBase {

    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://the-internet.herokuapp.com/javascript_alerts">Alerts</a>
     * click on "Click for JS Confirm"
     * Press OK
     * Check that "You clicked: Ok" is displayed
     */

    @Test
    public void checkJsConfirmAlert() {
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        By button = By.xpath("//button[@onclick='jsConfirm()']");
        driver.findElement(button).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        String actualText = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals("You clicked: Ok", actualText);
    }

    @Test
    public void checkJsConfirmPrompt() {
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        By button = By.xpath("//button[@onclick='jsPrompt()']");
        driver.findElement(button).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Write something here .. ");
        alert.accept();
        String actualText = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals("You entered: Write something here ..", actualText);
    }


    @Test
    public void checkTheFrame() {
        driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");
        WebElement iframe = driver.findElement(By.xpath("//frame[@name='source']"));
        driver.switchTo().frame(iframe);
        var text = driver.findElement(By.xpath("//h1[text()='Testing Clicks']")).getText();
        driver.switchTo().defaultContent();
        Assertions.assertEquals("Testing Clicks", text);
    }

    //Go to URL: http://demo.guru99.com/test/guru99home/
    //Find the number of iframes on the page.
    //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
    //Exit the iframe and return to the main page.



}
