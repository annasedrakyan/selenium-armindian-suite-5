import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @Test
    public void successLogin() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/annasedrakyan/dev/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        assertTrue(driver.getCurrentUrl().contains("https://www.google.com"),
                "The page was not load correctly");

    }

    @Test
    public void failedLogin() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/annasedrakyan/dev/chromedriver");
        driver = new ChromeDriver();
//        driver.get("https://www.github.com/login");
//
//
//        WebElement loginField = driver.findElement(By.name("login"));
//        WebElement passwordField = driver.findElement(By.name("password"));
//        WebElement signInButton = driver.findElement(By.name("commit"));
//
//        loginField.sendKeys("mail.mail.com");
//        passwordField.sendKeys("Password");
//        signInButton.click();
//
//        WebElement errorMessage = driver.findElement((By.cssSelector("#js-flash-container .flash-error")));

//        assertTrue(errorMessage.isDisplayed(), "Error message was not displayed");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith("mail@mail.am", "Password");

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
