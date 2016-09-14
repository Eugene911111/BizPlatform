package Biz_1;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MakingBooking extends AbstractTest {
    private final String EXPECTED_CLIENT_NAME = "Eugene";

    private static final Logger log = LoggerFactory.getLogger(MakingBooking.class);

    @org.junit.Test
    public void bookingCreation() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        booking.pressOnBookingField();
        booking.clickOnClientField().clickOnTelephoneNumberField().clickOnEmailField();
        booking.pressSaveButton();
        booking.checkElementIsDisplayed(booking.bookingWithMadeButton);


        //   String actualClientName = landingPage.getTextFromLocator(booking.booking1);
        //String actualClientName = landingPage.getTextFromLocator(booking.booking1);
        //log.info(actualClientName);
        // Assert.assertEquals(EXPECTED_CLIENT_NAME, actualClientName);
        log.debug("---------Booking is made-------------- ");
    }

    @org.junit.Test
    public void bookingDelete() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        booking.deleteBooking();
        booking.checkElementIsNotDisplayed(booking.delete1Button);
    }
}




