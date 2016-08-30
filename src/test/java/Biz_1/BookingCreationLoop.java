package Biz_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingCreationLoop {

    protected WebDriver driver;
    protected LandingPage landingPage;
    protected LogInPage logInPage;
    protected MobileBuilder mobileBuilder;
    protected Resources resources;
    protected Booking booking;
    protected GlobalSettings globalSettings;
    protected Specialists specialists;
    protected WorkingTime workingTime;
    protected static final Logger log = LoggerFactory.getLogger(MakingBooking.class);

    @Before
    public void precondition() {

        driver = new FirefoxDriver();
        (logInPage = new LogInPage()).setDriver(driver);
        (landingPage = new LandingPage()).setDriver(driver);
        (booking = new Booking()).setDriver(driver);
        (mobileBuilder = new MobileBuilder()).setDriver(driver);
        (globalSettings = new GlobalSettings()).setDriver(driver);
        (resources = new Resources()).setDriver(driver);
        (specialists = new Specialists()).setDriver(driver);
        (workingTime = new WorkingTime()).setDriver(driver);

    }


    @Test
    public void bookingcreation() throws InterruptedException {
        for (int u = 23; u >= 20; u--) {
            landingPage.openLogInPage();
            logInPage.logIn();
            Thread.sleep(2000);
            By a = By.xpath("//tr[@class=\"k-middle-row\"][" + Integer.toString(u) + "]/td");
            driver.findElement(a).click();
            System.out.println(a);

       //     booking.pressOnBookingField();
            booking.clickOnClientField().clickOnTelephoneNumberField().clickOnEmailField();
            booking.pressSaveButton();

            //   String actualClientName = landingPage.getTextFromLocator(booking.booking1);
            //String actualClientName = landingPage.getTextFromLocator(booking.booking1);
            //log.info(actualClientName);
            // Assert.assertEquals(EXPECTED_CLIENT_NAME, actualClientName);
            log.debug("---------Booking is made-------------- ");
        }


    }

    @After
    public void testShutDown() {
        driver.close();
    }

}



