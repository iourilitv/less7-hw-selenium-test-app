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
    public void tryToLogin(String username, String password, String result) {
        homePage.home();
        topMenuFrag.goToAuthPageByLogin();
        Assert.assertTrue(authPage.checkFormHeader("Sign In"));
        authPage.fillSignInFormAndConfirm(username, password);
        Assert.assertTrue(authPage.isAlertPresent());
        Assert.assertEquals(result, authPage.getAlertContainerText());
    }

}
