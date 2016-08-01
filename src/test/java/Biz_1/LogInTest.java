package Biz_1;

import org.openqa.selenium.By;

public class LogInTest extends AbstractTest implements Constants {

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        landingPage.checkElementIsDisplayed(By.xpath(BOOKING_BUTTON));
    }
}



