package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * login as standard_user
 * assert that there are 6 items on the products list page
 * add the first and last items to the cart
 * navigate to the cart and check that both items are listed
 */
public class SauceDemoItemsListTests extends TestBase {


    @Test
    public void checkThatProductListHas6Items(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        login("standard_user", "secret_sauce");
        By productItemComponents = By.xpath("//div[@class='inventory_item']");
        var actualValue = driver.findElements(productItemComponents).size();
        Assertions.assertEquals(6,actualValue);
    }

    @Test
    public void checkFirstItem(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        login("standard_user", "secret_sauce");
        addItemNumber(1);
        addItemNumber(2);
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        var actucalResult = checkItemName(1);
        Assertions.assertEquals("Sauce Labs Backpack",actucalResult);
    }

    @Test
    public void checkSecondItem(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        login("standard_user", "secret_sauce");
        addItemNumber(1);
        addItemNumber(2);
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        var actucalResult = checkItemName(2);
        Assertions.assertEquals("Sauce Labs Bolt T-Shirt",actucalResult);
    }

    private void addItemNumber(int buttonNumber){
        By addFirstItemToCart  = By.xpath("(//*[@class='btn_primary btn_inventory'])["+buttonNumber+"]");
        driver.findElement(addFirstItemToCart).click();
    }

    private String checkItemName(int itemNumber){
        By item = By.xpath("(//div[@class='inventory_item_name'])["+itemNumber+"]");
        return driver.findElement(item).getText();
    }

    private void login(String username, String password) {
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }

}
