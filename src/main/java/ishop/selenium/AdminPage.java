package ishop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BaseActions {
    private static final By MENU_ITEM_HEADER = By.cssSelector("h4");

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public int getMenuItemsCount() {
        return driver.findElements(MENU_ITEM_HEADER).size();
    }
}
