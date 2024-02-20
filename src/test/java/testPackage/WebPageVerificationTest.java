package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPageVerificationTest {

    private static WebDriver driver;

    // 1- open google page and print title, print current URL, quit the broswer.
    @Test
    public void checkForGoogleTitleAndURL() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.quit();
    }

    // 3- open facebook URL and verify if expected URL equals to the actual URL, verify  pagesource of FaceBook contains "Facebook"
    @Test
    public void checkForFacebookURL() {
        driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/";

        String pageSource = driver.getPageSource();

        Assertions.assertEquals(expectedUrl, actualUrl);

        Assertions.assertTrue(pageSource.contains("Facebook"), "Page source does not contain 'Facebook'");

        driver.quit();
    }


}
