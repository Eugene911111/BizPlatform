package Biz_1;


import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.firefox.FirefoxDriver;



public class LogInTest {
    private FirefoxDriver driver;
    private LandingPage landingPage;
    private LogInPage logInPage;


    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        landingPage = new LandingPage(driver);
        logInPage = new LogInPage(driver);
        }

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        landingPage.checkBookingButtonIsDisplayed();
    }





   @After
    public void testShutDown() {
        driver.close();
    }

}



