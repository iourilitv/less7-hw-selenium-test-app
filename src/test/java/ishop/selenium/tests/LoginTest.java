package ishop.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseUITest {
    @DataProvider(name = "usernamePasswordResult")
    public Object[][] clickDealsData() {

        return new Object[][]{
                {"", "", "Invalid username and password."},
                {"superadmin", "", "Invalid username and password."},
                {"", "superadmin", "Invalid username and password."}
        };
    }

    @Test(dataProvider = "usernamePasswordResult")
    public void tryToLoginWithError(String username, String password, String result) {
        homePage.home();
        topMenuFrag.goToAuthPageByLogin();
        Assert.assertTrue(authPage.checkFormHeader("Sign In"));
        authPage.fillSignInFormAndConfirm(username, password);
        Assert.assertTrue(authPage.isAlertPresent());
        Assert.assertEquals(result, authPage.getAlertContainerText());
    }

    @DataProvider(name = "usernamePassword")
    public Object[][] clickData() {

        return new Object[][]{
                {"superadmin", "superadmin"},
                {"admin", "admin"}
        };
    }

    @Test(dataProvider = "usernamePassword")
    public void isUsernamePresentedAfterLogin(String username, String password) {
        catalogPage.index();
        Assert.assertTrue(topMenuFrag.isTextPresentedInAdminModeElements("Register"));
        topMenuFrag.goToAuthPageByLogin();
        authPage.fillSignInFormAndConfirm(username, password);
        Assert.assertTrue(topMenuFrag.isTextPresentedInAdminModeElements(username));
    }
}
