package Biz_1;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
public class LogInTest extends AbstractTest implements Constants {
    @org.junit.Test
    public void logInTest() throws InterruptedException, IOException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(BOOKING_BUTTON, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
    }
}



