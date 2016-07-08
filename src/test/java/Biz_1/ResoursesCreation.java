package Biz_1;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ResoursesCreation {
    private FirefoxDriver driver;
    private LandingPage landingPage;
    private LogInPage logInPage;
    private Resources resourses;

    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        landingPage = new LandingPage(driver);
        logInPage = new LogInPage(driver);
        resourses = new Resources(driver);
    }

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openBizplatform();
        landingPage.pressLogInButton();
        logInPage.enterEmailField();
        logInPage.enterPassword();
        logInPage.pressAuthoriseButton();
        resourses.openResources();
        resourses.addNewCategory();
        String actualCategoryName = resourses.getTextFromCreatedcategory();
        String expectedCategoryName = "NEW TEST CATEGORY";
        Assert.assertEquals(actualCategoryName, expectedCategoryName);
        System.out.println("---------New CATEGORY is created and it exist in list of Categories-------------- ");
        resourses.pressAddButton();
        resourses.selectToCreateNewResource();
        resourses.enterNewResourceName("NEW TEST RESOURCE");
        resourses.pressDropDownButtonToSelectCategory();
        resourses.pressSaveButton();
        Thread.sleep(4000);
        resourses.refreshResources();
        resourses.deleteCreatedResource();
        resourses.deleteCreatedCategory();
        System.out.println("---------Created CATEGORY is Deleted-------------- ");
    }

   // @After
  //  public void testShutDown() {
   //     driver.close();
   // }

}
