package structureDesign;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropdownTask extends TestBase {

    /*
   Go to URL: https://the-internet.herokuapp.com/dropdown
   Create method selectByIndexTest and Select Option 1 using index .
   Create method selectByValueTest Select Option 2 by value.
   Create method selectByVisibleTextTest Select Option 1 value by visible text.
   Create method printAllTest Print all dropdown value.
   Verify the dropdown has Option 2 text.
   Create method printFirstSelectedOptionTest Print first selected option.
   Find the size of the dropdown,
   Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
    */


    @Test
    public void dropdown() {
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        By dropdownId = By.id("dropdown");
        Select dropdown = new Select(driver.findElement(dropdownId));

//     Create method selectByIndexTest and Select Option 1 using index .
        selectByIndexTest(dropdown, 2);
        selectByVisibleTextTest(dropdown, "val");
        selectByValueTest(dropdown,"Text");
    }

    public void selectByVisibleTextTest(Select dropdown, String value) {
        dropdown.selectByVisibleText(value);
    }

    public void selectByIndexTest(Select dropdown, int index) {
        dropdown.selectByIndex(index);
    }

    //       Create method selectByValueTest Select Option 2 by value.
    public void selectByValueTest(Select dropdown, String value) {
        dropdown.selectByValue(value);
    }


}
