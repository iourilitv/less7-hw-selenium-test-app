package ishop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

public class TopMenuFrag extends BaseActions {
    private static final By LOGIN_LINK = By.cssSelector("a.login-link");
    private static final By LOGOUT_LINK = By.cssSelector("button.login-link");

    private static final By ADMIN_MODE = By.cssSelector("a.fa.login-link");

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
//        WebElement cartMenuItem = getMenuItemByName("cart");
        WebElement cartMenuItem = getWebElementByText(MAIN_NAV_ITEM, "cart");
        assert cartMenuItem != null;
        cartMenuItem.click();
    }

    public int getCartItemCountInMenu() {
//        WebElement element = getMenuItemByName("cart");
        WebElement element = getWebElementByText(MAIN_NAV_ITEM, "cart");
        assert element != null;
        String text = element.getText().toLowerCase();
        if(text.contains("(") && text.contains(")")) {
            int leftBracketIndex = text.indexOf("(") + 1;
            int rightBracketIndex = text.indexOf(")");
            return Integer.parseInt(text.substring(leftBracketIndex, rightBracketIndex));
        }
        return 0;
    }

//    public WebElement findMenuItemByName(String name) {
//        List<WebElement> elements = driver.findElements(MAIN_NAV_ITEM);
//        for (WebElement e : elements) {
//            String text = e.getText().toLowerCase();
//            if(text.contains(name.toLowerCase())) {
//                return e;
//            }
//        }
//        return null;
//    }
//    public WebElement getMenuItemByName(String name) {
//        return getWebElementByText(MAIN_NAV_ITEM, name);
//    }

//    public boolean isUserAuthorizedToAdminMode() {
//        List<WebElement> elements = driver.findElements(ADMIN_MODE);
//        for (WebElement e: elements) {
//            System.out.println(e.getText());
//            if (e.getText().equalsIgnoreCase("Admin Mode")) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean isUserAuthorizedToAdminMode() {
        return getWebElementByText(ADMIN_MODE, "Admin Mode") != null;
    }

//    public boolean isTextPresentedInAdminModeElements(String text) {
//        List<WebElement> elements = driver.findElements(ADMIN_MODE);
//        for (WebElement e: elements) {
//            System.out.println(e.getText());
//            if (e.getText().equalsIgnoreCase(text)) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean isTextPresentedInAdminModeElements(String text) {
        return getWebElementByText(ADMIN_MODE, text) != null;
    }

    public void pressAdminModeLink() {
        Objects.requireNonNull(getWebElementByText(ADMIN_MODE, "Admin Mode")).click();
    }

    private WebElement getWebElementByText(By by, String text) {
        List<WebElement> elements = driver.findElements(by);
        for (WebElement e : elements) {
            if(e.getText().toLowerCase().contains(text.toLowerCase())) {
                return e;
            }
        }
        return null;
    }

}

