package Biz_1;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResoursesCreation extends AbstractTest {
    public static final String RESOURSES_PAGE = "http://bizplatform.co/Venue/CommandCenter#/bookings/resources";

    @org.junit.Test
    public void a_addNewResourceCategory() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(RESOURSES_PAGE);
        resources.addNewCategory();
    }

    //  String actualCategoryName = resources.getTextFromCreatedcategory();
    // String expectedCategoryName = "NEW TEST CATEGORY";
    // Assert.assertEquals(actualCategoryName, expectedCategoryName);
    //  System.out.println("---------New CATEGORY is created and it exist in list of Categories-------------- ");
    @org.junit.Test
    public void b_addNewResource() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(RESOURSES_PAGE);
        resources.waitForElementIsClickableAndClick(resources.getAddResourceButton());
        resources.waitForElementIsClickableAndClick(resources.resourceButton);
        resources.sendKeysToElementWhenElementIsClickable(resources.fieldForResourceName,"NEW TEST RESOURCE");
        resources.waitForElementIsClickableAndClick(resources.dropDownButtonToSelectCategory);
        resources.waitForElementIsClickableAndClick(resources.saveButton);
    }

    @org.junit.Test
    public void c_deleteCreatedResource() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(RESOURSES_PAGE);
        resources.refreshPage();
        resources.deleteCreatedResource();
    }

    @org.junit.Test
    public void d_deleteCreatedCategory() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(RESOURSES_PAGE);
        resources.deleteCreatedCategory();
        log.debug("---------Created CATEGORY is Deleted-------------");
        System.out.println("---------Created CATEGORY is Deleted-------------- ");
    }
}


