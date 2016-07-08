package Biz_1;

import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;

public class CheckBuilderElementsArePresentAfterReloading {
    private FirefoxDriver driver;
    private Booking booking;
    private MobileBuilder mobileBuilder;
    private LandingPage landingPage;
    private LogInPage logInPage;

    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        booking = new Booking(driver);
        mobileBuilder = new MobileBuilder(driver);
        landingPage = new LandingPage(driver);
        logInPage = new LogInPage(driver);

    }

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

    @After
    public void testShutDown() {
        driver.close();
    }

}
