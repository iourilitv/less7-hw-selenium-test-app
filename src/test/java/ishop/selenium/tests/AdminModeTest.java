package ishop.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminModeTest extends BaseUITest {
    @Test
    public void isUserNotAuthorizedToAdminMode() {
        catalogPage.index();
        Assert.assertFalse(topMenuFrag.isUserAuthorizedToAdminMode());
        topMenuFrag.goToAuthPageByLogin();
        authPage.fillSignInFormAndConfirm("admin", "admin");
        Assert.assertFalse(topMenuFrag.isUserAuthorizedToAdminMode());
    }

    @Test
    public void isUserAuthorizedToAdminMode() {
        catalogPage.index();
        topMenuFrag.goToAuthPageByLogin();
        authPage.fillSignInFormAndConfirm("superadmin", "superadmin");
        Assert.assertTrue(topMenuFrag.isUserAuthorizedToAdminMode());
    }

    @Test
    public void isAdminModeIndexPagePresented() {
        catalogPage.index();
        topMenuFrag.goToAuthPageByLogin();
        authPage.fillSignInFormAndConfirm("superadmin", "superadmin");
        Assert.assertTrue(topMenuFrag.isUserAuthorizedToAdminMode());
        topMenuFrag.pressAdminModeLink();
        Assert.assertTrue(topMenuFrag.isTextPresentedInAdminModeElements("Leave Admin Mode"));
        Assert.assertEquals(adminPage.getMenuItemsCount(), 7);
    }
}
