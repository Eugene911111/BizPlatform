package Biz_1;

public class CheckBuilderElementsArePresent extends AbstractTest {

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        Thread.sleep(3000);
        mobileBuilder.clickMobileBuilder();
        mobileBuilder.imageIsDisplayed();
    }

}