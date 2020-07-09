package ishop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BaseActions {
    private static final By FORM_HEADER = By.cssSelector("h3");
    private static final By USERNAME_FIELD = By.cssSelector("input[name='username']");
    private static final By PASSWORD_FIELD = By.cssSelector("input[name='password']");
    private static final By SUBMIT_LOGIN_BTN = By.cssSelector(".btn-success");

    private static final By ALERT_DANGER = By.cssSelector(".alert.alert-danger.col-xs-offset-1.col-xs-10");

    public AuthPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillSignInFormAndConfirm(String username, String password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeInField(USERNAME_FIELD, username);
        typeInField(PASSWORD_FIELD, password);
        driver.findElement(SUBMIT_LOGIN_BTN).click();
    }

    public boolean checkFormHeader(String text) {
        return driver.findElement(FORM_HEADER).getText().trim().equalsIgnoreCase(text);
    }

    public boolean isAlertPresent() {
        return isElementPresent(ALERT_DANGER);
    }

    public String getAlertContainerText() {
        return driver.findElement(ALERT_DANGER).getText();
    }

}
