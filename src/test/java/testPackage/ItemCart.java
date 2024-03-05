package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class ItemCart {

    /*
    *
*   breakout task: (in a separate class)
    navigate to this url https://www.saucedemo.com/v1/inventory.html
    add the first item you find to your cart
    open your cart*
    assert that the item name is correct inside the cart
    * */

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();

    }

    @Test
    public void testAddToCartAndVerifyItem() {
        // Navigate to the URL
        driver.get("https://www.saucedemo.com/v1/inventory.html");

        var inventoryName = By.xpath("//div[@class='inventory_item_name']");
        var actualResult = driver.findElements(inventoryName).getFirst().getText();

        var addToCartButton = By.className("btn_primary");
        driver.findElement(addToCartButton).click();

        var cartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartButton.click();

        WebElement itemNameElement = driver.findElement(By.cssSelector(".inventory_item_name"));
        String itemNameInCart = itemNameElement.getText();
        String expectedItemName = "Sauce Labs Backpack";
        Assertions.assertEquals(expectedItemName, itemNameInCart, "Item name in the cart is incorrect");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}


