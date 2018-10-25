import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    //private WebDriver driver; because it extends from BasePage
    private By usernameField = By.name("login");
    private By passwordField = By.name("password");
    private By signInButton = By.name("commit");
    private By errorMessage = By.cssSelector("#js-flash-container .flash-error");


    public LoginPage (WebDriver driver) {
        super(driver);
        //this.driver = driver;
        driver.get(getUrl());
    }

    public String getUrl() {
        return "https://github.com/login";
    }

    public void loginWith(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(signInButton);



        //driver.findElement(usernameField).sendKeys(username);
        //driver.findElement(passwordField).sendKeys(password);
        //driver.findElement(signInButton).click();

    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }




}
