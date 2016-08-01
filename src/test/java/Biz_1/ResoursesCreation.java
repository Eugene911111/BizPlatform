package Biz_1;

import org.junit.Assert;

public class ResoursesCreation extends AbstractTest {

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        resources.openResources();
        resources.addNewCategory();
        String actualCategoryName = resources.getTextFromCreatedcategory();
        String expectedCategoryName = "NEW TEST CATEGORY";
        Assert.assertEquals(actualCategoryName, expectedCategoryName);
        System.out.println("---------New CATEGORY is created and it exist in list of Categories-------------- ");
        resources.pressAddButton();
        resources.selectToCreateNewResource();
        resources.enterNewResourceName("NEW TEST RESOURCE");
        resources.pressDropDownButtonToSelectCategory();
        resources.pressSaveButton();
        Thread.sleep(4000);
        resources.refreshResources();
        resources.deleteCreatedResource();
        resources.deleteCreatedCategory();
        System.out.println("---------Created CATEGORY is Deleted-------------- ");
    }

}
