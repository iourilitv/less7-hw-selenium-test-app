package ishop.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class CatalogTest extends BaseUITest {
    @Test
    @Ignore
    public void checkCatalogPage() {
        homePage.home();
        Assert.assertTrue(catalogPage.isProductPresented());
    }

    //unauthorized mode
    @Test
    @Ignore
    public void checkEmptyCartMenuItem() {
        catalogPage.index();
        int count = topMenuFrag.getCartItemCountInMenu();
        Assert.assertEquals(count, 0);
    }

    @Test
    public void checkCountedCartMenuItem() {
        catalogPage.index();
        topMenuFrag.callSingInFormByCartMenuItemClicking();
        authPage.fillSignInFormAndConfirm("superadmin", "superadmin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catalogPage.pressAddToCartBtn(0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count = topMenuFrag.getCartItemCountInMenu();

        System.out.println("count=" + count);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(count, 4);
    }

}