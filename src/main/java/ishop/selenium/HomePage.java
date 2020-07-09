package ishop.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseActions {
    private static final String HOME_PAGE_URL = "http://localhost:8080/amin/";

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void home() {
        driver.get(HOME_PAGE_URL);
    }

}

