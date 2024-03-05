package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class BreakoutRoom extends TestBase {

    /**
     * Use Google Chrome
     * Navigate to <a href="https://www.google.com/">Google.com</a>
     * Search for "Selenium"
     * Check that results stats is not empty
     * Change to using Firefox
     */


    @Test
    public void checkResultsIsNotEmptyUsingImplicitWait() {
        driver.navigate().to("https://www.google.com/");

        By searchBox = By.id("APjFqb");
        driver.findElement(searchBox).sendKeys("Selenium", Keys.RETURN);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        By resultsStats = By.id("result-stats");
        String actualText = driver.findElement(resultsStats).getText();
        Assertions.assertNotEquals("", actualText);
    }

    @Test
    public void checkResultsIsNotEmptyUsingExplicitWait() {

        driver.navigate().to("https://www.google.com/");

        By SDD = By.xpath("APjFqb");
        driver.findElement(SDD).sendKeys("Selenium");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        wait.until(d -> driver.manage() )

        By resultsStats = By.id("result-stats");
        String actualText = driver.findElement(resultsStats).getText();
        Assertions.assertNotEquals("", actualText);
    }


}
