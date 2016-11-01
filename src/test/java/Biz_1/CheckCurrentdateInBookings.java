package Biz_1;

import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by egolub on 10/11/2016.
 */
public class CheckCurrentDateInBookings extends AbstractTest {

@org.junit.Test
public void a_checkCurrentDate()throws InterruptedException{
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(booking.BOOKING_PAGE);
        String currentDay=booking.getTextFromElement(booking.currentDate);
        String currentDate=currentDay.split(" ")[1];
        DateFormat dateFormat=new SimpleDateFormat("dd");
        Date date=new Date();
        String realDate=(dateFormat.format(date));
        Assert.assertEquals(currentDate,realDate);
        log.info("Today is "+currentDay);
        }
        }