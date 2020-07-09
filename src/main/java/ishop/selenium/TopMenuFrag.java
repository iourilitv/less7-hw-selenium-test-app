package ishop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TopMenuFrag extends BaseActions {
    private static final By LOGIN_LINK = By.cssSelector("a.login-link");
    private static final By LOGOUT_LINK = By.cssSelector("button.login-link");
    private static final By MAIN_NAV_BAR = By.cssSelector("div.nav-menu");
    private static final By MAIN_NAV_ITEM = By.cssSelector("li.mega-menu");

    public TopMenuFrag(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToAuthPageByLogin() {
        if (isElementPresent(LOGOUT_LINK)) {
            driver.findElement(LOGOUT_LINK).click();
        }
        driver.findElement(LOGIN_LINK).click();
    }

    public void callSingInFormByCartMenuItemClicking() {
        WebElement cartMenuItem = findMenuItemByName("cart");
        cartMenuItem.click();
    }

    public int getCartItemCountInMenu() {
        WebElement element = findMenuItemByName("cart");
        String text = element.getText().toLowerCase();
        if(text.contains("(") && text.contains(")")) {
            int leftBracketIndex = text.indexOf("(") + 1;
            int rightBracketIndex = text.indexOf(")");
            return Integer.parseInt(text.substring(leftBracketIndex, rightBracketIndex));
        }
        return 0;
    }

    public WebElement findMenuItemByName(String name) {
        List<WebElement> elements = driver.findElements(MAIN_NAV_ITEM);
        for (WebElement e : elements) {
            String text = e.getText().toLowerCase();
            if(text.contains(name.toLowerCase())) {
                return e;
            }
        }
        return null;
    }

}

