package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver =driver;
    }

    public abstract String getUrl();

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void type(By location, String text) {
        type(find(location), text); //overloaded mehod , as we use type method and use in it find method
    }

    public void type(String cssSelector, String text) {
        type(By.cssSelector(cssSelector), text); //it is another overloaded method to find By webelement also with cssSeelector
    }

    public WebElement find(By location) {
        return driver.findElement(location);
    }
//if we want to find more than 1 elements
//    public List<WebElement> findElements(By location) {
//        return driver.findElements(location);
//    }

    public void click(WebElement element) {
        System.out.println("Clicking on element with location: " + element.toString());
        element.click();
    }

    public void click(By location) {
        click(find(location));
    }


}
