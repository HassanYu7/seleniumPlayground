package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators extends TestBase {

    /**
     * Navigate to <a href="https://www.w3schools.com/html/html_tables.asp">w3schools tables</a>
     * check that the Contact for "Alfreds Futterkiste" company is "Maria Anders"
     * check that the Contact for "Island Trading" company is "Helen Bennett"
     */


    @Test
    public void checkContact() {
//        By alredsTest = By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td[1]");
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

        By contactName = RelativeLocator.with(
                By.tagName("td"))
                .toRightOf(By.xpath("//td[text)='lfreds Futterkiste']"))
                .below(By.xpath("//th[text='Contact']")
                );

//        By mariaAnders = RelativeLocator.with(By.tagName("td")).toRightOf(alredsTest).below(alredsTest);
        var actucalValue = driver.findElement(contactName).getText();
        Assertions.assertEquals("Maria Anders", actucalValue);
    }

}
