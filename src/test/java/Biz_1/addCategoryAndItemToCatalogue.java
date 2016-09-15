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
        catalogue.openUrl(catalogue.CATALOGUE);
        catalogue.waitForElementIsClickableAndClick(catalogue.addNewCategory);
        catalogue.sendKeysToElementWhenElementIsPresent(catalogue.fieldForCatalogueTitle, catalogue.KEYS_TO_CATALOGUE_TITLE);
        catalogue.waitForElementIsClickableAndClick(catalogue.saveCategoryTitleButton);
        String actualEmailErrorMessage = catalogue.getTextFromListOfCatalogues();
        String expectedErrorMessage = "TEST CATALOGUE NAME";
        Assert.assertEquals(expectedErrorMessage, actualEmailErrorMessage);
    }

    @org.junit.Test
    public void b_addItemToCatalogue() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        catalogue.openUrl(catalogue.CATALOGUE);
        catalogue.waitForElementIsClickableAndClick(catalogue.addNewItem);
        catalogue.sendKeysToElementWhenElementIsPresent(catalogue.fieldForItemTitle, catalogue.KEYS_TO_ITEM_TITLE);
        catalogue.waitForElementIsClickableAndClick(catalogue.saveItemTitleButton);
        String actualEmailErrorMessage = catalogue.getItemNameOfCatalogues();
        String expectedErrorMessage = "Test Item Name";
        Assert.assertEquals(expectedErrorMessage, actualEmailErrorMessage);
    }

    @org.junit.Test
    public void c_deleteItem() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        catalogue.openUrl(catalogue.CATALOGUE);
        catalogue.waitForElementIsClickableAndClick(catalogue.deleteItemButton);
        catalogue.waitForElementIsClickableAndClick(catalogue.continueButton);
        catalogue.checkElementIsNotDisplayed(catalogue.deleteItemButton);
        //   Thread.sleep(5000);
    }

    @org.junit.Test
    public void d_deleteCategory() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        catalogue.openUrl(catalogue.CATALOGUE);;
        catalogue.waitForElementIsPressentAndClick(catalogue.editButtonForCatalogue);
        catalogue.waitForElementIsPressentAndClick(catalogue.removeCategoryButton);
        catalogue.waitForElementIsPressentAndClick(catalogue.continueButton);
        catalogue.checkElementIsNotDisplayed(catalogue.editButtonForCatalogue);
        //   Thread.sleep(3000);
    }

}
