package Biz_1;

import org.junit.Assert;

public class MakingBooking extends AbstractTest {
private final String EXPECTED_ERROR_MESSAGE = "Eugene";

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
        String actualEmailErrorMessage = booking.getText();
        Assert.assertEquals(actualEmailErrorMessage, EXPECTED_ERROR_MESSAGE);
        System.out.println("---------Booking is made-------------- ");
        booking.deleteBooking();
        System.out.println("---------Booking is deleted-------------- ");
    }
}



