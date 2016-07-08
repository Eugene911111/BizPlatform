package Biz_1;


import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBuilderElementsArePresent {

    private FirefoxDriver driver;
    private MobileBuilder mobileBuilder;
    private LandingPage landingPage;
    private LogInPage logInPage;

    @Before
    public void precondition() {
        driver = new FirefoxDriver();
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
        mobileBuilder.imageIsDisplayed();
    }

       @After
    public void testShutDown() {
    driver.close();
       }

}