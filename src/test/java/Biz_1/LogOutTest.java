package Biz_1;

public class LogOutTest extends AbstractTest implements Constants {
    @org.junit.Test
    public void logOutTest() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.checkElementIsDisplayed(landingPage.userButton);
        landingPage.waitForElementIsClickableAndClick(landingPage.userButton);
        landingPage.waitForElementIsClickableAndClick(landingPage.logOutButton);
        try {
            landingPage.checkElementIsDisplayed(landingPage.logInButton);
        } catch (Exception e) {
            log.error("User was not logged out ");
            throw new Exception(e);
        }
    }
}