package Biz_1;

public class CheckBuilderElementsArePresentAfterReloading extends AbstractTest{

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openBizplatform();
        landingPage.pressLogInButton();
        logInPage.enterEmailField();
        logInPage.enterPassword();
        logInPage.pressAuthoriseButton();
        mobileBuilder.clickMobileBuilder();
        // Thread.sleep(4000);
        mobileBuilder.refreshMobileBuilder();
        mobileBuilder.imageIsDisplayed();
    }



}
