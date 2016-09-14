package Biz_1;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class LogOutTest extends AbstractTest implements Constants {
    @org.junit.Test
    public void logOutTest() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        landingPage.pressUserButton();
        landingPage.pressLogOutButton();
        try {
            landingPage.checkElementIsNotDisplayed(landingPage.userButton);
        } catch (Exception e) {
            log.error("User was not logged out ");
            throw new Exception(e);
        }

    }
}