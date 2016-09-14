package Biz_1;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Created by egolub on 9/12/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class addCategoryAndItemToCatalogue extends AbstractTest {

    @org.junit.Test
    public void a_addCategoryToCatalogue() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        catalogue.openCatalogue();
        catalogue.pressAddNewCategory();
        catalogue.sendKeysToFieldForCatalogueTitle();
        catalogue.clickSaveCategortTitle();
        String actualEmailErrorMessage = catalogue.getTextFromListOfCatalogues();
        String expectedErrorMessage = "TEST CATALOGUE NAME";
        Assert.assertEquals(expectedErrorMessage, actualEmailErrorMessage );
    }
    @org.junit.Test
    public void b_addItemToCatalogue() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        catalogue.openCatalogue();
        catalogue.pressAddNewItem();
        catalogue.sendKeysToFieldForItemTitle();
        catalogue.clickSaveItemTitle();
        String actualEmailErrorMessage = catalogue.getItemNameOfCatalogues();
        String expectedErrorMessage = "Test Item Name";
        Assert.assertEquals(expectedErrorMessage, actualEmailErrorMessage );
    }
    @org.junit.Test
    public void c_deleteItem() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        catalogue.openCatalogue();
        catalogue.pressDeleteItem();
        catalogue.pressContinue();
        catalogue.checkElementIsNotDisplayed(catalogue.deleteItemButton);
     //   Thread.sleep(5000);
    }
    @org.junit.Test
    public void d_deleteCategory() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        catalogue.openCatalogue();
        catalogue.pressEditForCategory();
        catalogue.pressRemoveCategoryButton();
        catalogue.pressContinue();
        catalogue.checkElementIsNotDisplayed(catalogue.editButtonForCatalogue);
     //   Thread.sleep(3000);
    }

}
