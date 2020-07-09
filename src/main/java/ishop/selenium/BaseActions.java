package ishop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The class for basic testing operations.
 */
public class BaseActions {
    WebDriver driver;
    WebDriverWait wait;

    //initializing the webdriver
    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * The method for imitation of user action: type smth into the field.
     * @param by - where - the rule for element searching
     * @param msg - message
     */
    public void typeInField(By by, String msg) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        element.click();
        element.clear();
        element.sendKeys(msg);
    }

    /**
     * The method for checking is the element exist on the page.
     * @param by - the rule for element searching
     * @return - result of action
     */
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}