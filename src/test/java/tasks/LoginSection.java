package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginSection {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    @DisplayName("TC1: Valid Login")
    public void testValidLogin() {
        login("mngr554581", "aqejysU");
        Assertions.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
    }

    @Test
    @Order(2)
    @DisplayName("TC2: Invalid UserID and Valid Password")
    public void testInvalidUseridAndValidPassword() {
        login("mngr554d581", "aqejysU");
        Assertions.assertEquals("User or Password is not valid", getAlertMessage());
    }

    @Test
    @Order(3)
    @DisplayName("TC3: Valid UserID and Invalid Password")
    public void testValidUseridAndInvalidPassword() {
        login("mngr554581", "aqedjysU");
        Assertions.assertEquals("User or Password is not valid", getAlertMessage());
    }

    @Test
    @Order(4)
    @DisplayName("TC4: Invalid UserID and Invalid Password")
    public void testInvalidUseridAndInvalidPassword() {
        login("mngrfd554581", "aqedsdjysU");
        Assertions.assertEquals("User or Password is not valid", getAlertMessage());
    }

    private void login(String userID, String password) {
        driver.findElement(By.name("uid")).sendKeys(userID);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
    }

    private String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }

}
