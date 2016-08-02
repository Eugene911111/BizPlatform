package Biz_1;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MakingBooking extends AbstractTest {
    private final String EXPECTED_CLIENT_NAME = "Eugene";

    @org.junit.Test
    public void bookingCreation() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        booking.pressOnBooking();
        booking.clickOnClientField().clickOnTelephoneNumberField();
        booking.clickOnEmailField();
        booking.pressSaveButton();
        Thread.sleep(2500);
        String actualClientName = booking.getText();
        Assert.assertEquals(EXPECTED_CLIENT_NAME, actualClientName);
        System.out.println("---------Booking is made-------------- ");

    }

    @org.junit.Test
    public void bookingDelete() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        Thread.sleep(2500);
        booking.deleteBooking();

    }
}



