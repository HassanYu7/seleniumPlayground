package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TestCheckboxDropdownRadioButton extends TestBase {

    /**
     * initialize the browser in maximized mode (using options)
     * navigate to <a href="https://www.selenium.dev/selenium/web/web-form.html">web form test page</a>
     * check the box and validate that it is checked
     * select the radio and validate that it is selected
     * choose an item (by value) from the select dropdown menu and validate that it is selected (by text)
     */

    @Test
    public void testCheckBoxAndValidateIsChecked(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        By checkBoxLocator = By.id("my-check-2");
        driver.findElement(checkBoxLocator).click();
        boolean isChecked =  driver.findElement(checkBoxLocator).isSelected();
        Assertions.assertTrue(isChecked);
    }

    @Test
    public void testRadioButtonAndValidateIsSelected(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        By radioButtonLocator = By.id("my-radio-2");
        driver.findElement(radioButtonLocator).click();
        boolean isSelected =  driver.findElement(radioButtonLocator).isSelected();
        Assertions.assertTrue(isSelected);
    }

    @Test
    public void testSelectItemFromDropdown(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        By dropdownLocator = By.name("my-select");
        Select dropdown = new Select(driver.findElement(dropdownLocator));
        dropdown.selectByValue("3");
        String selectedText = dropdown.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("Three", selectedText);
    }

}
