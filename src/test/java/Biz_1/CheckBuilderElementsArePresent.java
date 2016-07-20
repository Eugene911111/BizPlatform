package Biz_1;

public class CheckBuilderElementsArePresent extends AbstractTest {

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openBizplatform();
        landingPage.pressLogInButton();
        logInPage.enterEmailField();
        logInPage.enterPassword();
        logInPage.pressAuthoriseButton();
        mobileBuilder.clickMobileBuilder();
        mobileBuilder.imageIsDisplayed();
    }

}