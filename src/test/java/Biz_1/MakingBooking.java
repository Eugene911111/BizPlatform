package Biz_1;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertFalse;


public class MakingBooking {
    private FirefoxDriver driver;
    private LandingPage landingPage;
    private LogInPage logInPage;
    private Booking booking;

    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        landingPage = new LandingPage(driver);
        logInPage = new LogInPage(driver);
        booking = new Booking(driver);
    }

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openBizplatform();
        landingPage.pressLogInButton();
        logInPage.enterEmailField();
        logInPage.enterPassword();
        logInPage.pressAuthoriseButton();
        booking.pressOnBooking();
        booking.clickOnClientField();
        booking.clickOnTelephoneNumberField();
        booking.clickOnEmailField();
        booking.pressSaveButton();
        Thread.sleep(3000);
        String actualEmailErrorMessage = booking.getTextt();
        String expectedErrorMessage = "Eugene";
        Assert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
        System.out.println("---------Booking is made-------------- ");
        booking.deleteBooking();
        System.out.println("---------Booking is deleted-------------- ");
    }

    @After
    public void testShutDown() {
        driver.close();
    }

}


