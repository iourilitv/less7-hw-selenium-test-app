package ishop.selenium.tests;

import ishop.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * The parent class for other test classes.
 */
public class BaseUITest {
    WebDriver driver;
    WebDriverWait wait;

    HomePage homePage;
    CatalogPage catalogPage;
    AuthPage authPage;
    TopMenuFrag topMenuFrag;
    AdminPage adminPage;

    @BeforeMethod
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 5);
        this.homePage = new HomePage(driver, wait);
        this.catalogPage = new CatalogPage(driver, wait);
        this.authPage = new AuthPage(driver, wait);
        this.topMenuFrag = new TopMenuFrag(driver, wait);
        this.adminPage = new AdminPage(driver, wait);
    }

    @AfterMethod
    public void shutdown() {
        driver.quit();
    }
}
