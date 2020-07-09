package ishop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseActions {
    private static final String HOME_PAGE_URL = "http://localhost:8080/amin/";

    private static final By LOGIN_LINK = By.cssSelector("a.login-link");
    private static final By LOGOUT_LINK = By.cssSelector("button.login-link");
//    private static final By MAIN_NAV_BAR = By.cssSelector("div.nav-menu");
//    private static final By MAIN_NAV_ITEM = By.cssSelector("li.mega-menu");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void home() {
        driver.get(HOME_PAGE_URL);
    }

//    public void goToAuthPage() {
//        if (!isElementPresent(LOGIN_LINK)) {
//            driver.findElement(LOGOUT_LINK).click();
//        }
//        driver.findElement(LOGIN_LINK).click();
//    }

}

