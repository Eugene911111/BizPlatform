package Biz_1;

public class CheckBuilderElementsArePresentAfterReloading extends AbstractTest{

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        mobileBuilder.clickMobileBuilder();
        // Thread.sleep(4000);
        mobileBuilder.refreshMobileBuilder();
        mobileBuilder.imageIsDisplayed();
    }



}
