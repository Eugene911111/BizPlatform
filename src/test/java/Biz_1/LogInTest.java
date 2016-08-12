package Biz_1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogInTest extends AbstractTest implements Constants {


    @org.junit.Test
    public void logInTest() throws InterruptedException, IOException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed);
        landingPage.checkElementIsDisplayed(By.xpath(BOOKING_BUTTON));

    }
}



