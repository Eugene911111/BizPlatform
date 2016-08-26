package Biz_1;

import org.openqa.selenium.*;
import java.io.IOException;

public class LogInTest extends AbstractTest implements Constants {
    @org.junit.Test
    public void logInTest() throws InterruptedException, IOException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed);
        landingPage.checkElementIsDisplayed(By.xpath(BOOKING_BUTTON));
    }
}



