package Biz_1;
//Opennig time should be specified from 00.00-23.59
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookingCreation extends AbstractTest {
    private final String EXPECTED_CLIENT_NAME = "Eugene";

    private static final Logger log = LoggerFactory.getLogger(BookingCreation.class);

    @org.junit.Test
    public void a_bookingCreation() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        booking.waitForElementIsClickableAndClick(booking.bookingField);
        booking.sendKeysToElementWhenElementIsClickable(booking.clientNameField, booking.CLIENT_NAME);
        booking.sendKeysToElementWhenElementIsClickable(booking.phoneNumberField, booking.PHONE_NUMBER);
        booking.sendKeysToElementWhenElementIsClickable(booking.emailField, booking.EMAIL);
        booking.waitForElementIsClickableAndClick(booking.saveButton);
        booking.checkElementIsDisplayed(booking.bookingWithMadeButton);

        //   String actualClientName = landingPage.getTextFromLocator(booking.booking1);
        //String actualClientName = landingPage.getTextFromLocator(booking.booking1);
        //log.info(actualClientName);
        // Assert.assertEquals(EXPECTED_CLIENT_NAME, actualClientName);
        log.debug("---------Booking is made-------------- ");
    }

    @org.junit.Test
    public void b_bookingDelete() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        booking.deleteBooking();
        booking.checkElementIsNotDisplayed(booking.delete1Button);
    }
}




