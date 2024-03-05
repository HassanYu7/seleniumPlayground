package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class S_testClass extends TestBase {


    @Test
    public void checkNameOfFirstElement() {
        // get the locator of the first element => get the text of the first element, it should be "Sauce Labs Backpack"
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");

        // common way
        var inventoryItemName = By.xpath("//div[@class='inventory_item_name']");
        var actualResult = driver.findElements(inventoryItemName).getFirst().getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualResult);

        // optimal way
        var firstInventoryItem = By.xpath("(//div[@class='inventory_item_name'])[1]");
        var actualResult2 = driver.findElement(firstInventoryItem).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualResult2);

        // very bad way
        var inventoryItem = By.xpath("//div[@class='inventory_item']");
        var actualResult3 = driver.findElements(inventoryItem).getFirst().findElement(inventoryItemName).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualResult3);
    }

}
