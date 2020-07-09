package ishop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogPage extends BaseActions {
    private static final String CATALOG_PAGE_URL = "http://localhost:8080/amin/catalog/all";

    private static final By PRODUCT_ITEM = By.cssSelector("div.catalog__product-card__price");
    private static final By ADD_TO_CART_BTN = By.cssSelector("a.catalog__product-card__price.btn-to-cart.color-white");

    public CatalogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void index() {
        driver.get(CATALOG_PAGE_URL);
    }

    public boolean isProductPresented() {
        return isElementPresent(PRODUCT_ITEM);
    }

    public void pressAddToCartButtons() {
        List<WebElement> elements = driver.findElements(ADD_TO_CART_BTN);
        for (WebElement e : elements) {
            e.click();
        }
    }

    public void pressAddToCartBtn(int index) {
        List<WebElement> elements = driver.findElements(ADD_TO_CART_BTN);
        elements.get(index).click();
    }

}

