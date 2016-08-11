package Biz_1;

public class CheckBuilderElementsArePresentAfterReloading extends AbstractTest{

    @org.junit.Test
    public void checkBuilderElementsArePresentAfterReloading() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        mobileBuilder.clickMobileBuilder();
        mobileBuilder.imageIsDisplayed(mobileBuilder.MOBILE_BUILDER_IMAGE);
        // Thread.sleep(4000);
        mobileBuilder.refreshMobileBuilder();
        mobileBuilder.imageIsDisplayed(mobileBuilder.MOBILE_BUILDER_IMAGE);
    }



}
