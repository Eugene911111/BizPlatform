package Biz_1;

import org.openqa.selenium.By;

public class LogInTest extends AbstractTest implements Constants {

    @org.junit.Test
    public void logInTest() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.checkElementIsDisplayed(By.xpath(BOOKING_BUTTON));

    }
}



