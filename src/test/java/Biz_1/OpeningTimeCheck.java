package Biz_1;

import org.junit.Assert;
import org.junit.Ignore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by egolub on 10/11/2016.
 */
public class OpeningTimeCheck extends AbstractTest implements Constants {
    @Ignore
    @org.junit.Test
    public void a_checkCurrentDate() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(workingTime.WORKING_TIME_PAGE);
        String firstDayOfTheWeekFromcalendar = workingTime.getTextFromElement(workingTime.firstDayOfTheWeek);
        String dateOfTheFirstDay = firstDayOfTheWeekFromcalendar.split(", ")[1];
        String durationOfTheWeek = workingTime.getTextFromElement(workingTime.week);
        String dateOfTheFirstDay1 = durationOfTheWeek.split(" ")[1];
        Assert.assertEquals(dateOfTheFirstDay, dateOfTheFirstDay1);
        String lastDayOfTheWeekFromcalendar = workingTime.getTextFromElement(workingTime.lastDayOfTheWeek);
        String lastDayOfTheWeek = lastDayOfTheWeekFromcalendar.split(", ")[1];
        String lastOfTheFirstDay1 = durationOfTheWeek.split(" ")[4];
        Assert.assertEquals(lastDayOfTheWeek, lastOfTheFirstDay1);


//        DateFormat dateFormat = new SimpleDateFormat("dd");
//        Date date = new Date();
//        String  n = (dateFormat.format(date));
//        System.out.println(n); //2014/08/06 15:59:48
//
//
//

    }
    @Ignore
    @org.junit.Test
    public void b_checkCurrentDateAfterSelectingNextWeek() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(workingTime.WORKING_TIME_PAGE);
        workingTime.waitForElementIsClickableAndClick(workingTime.arrowRight);
        String firstDayOfTheWeekFromCalendar = workingTime.getTextFromElement(workingTime.firstDayOfTheWeek);
        String dateOfTheFirstDay = firstDayOfTheWeekFromCalendar.split(", ")[1];
        String durationOfTheWeek = workingTime.getTextFromElement(workingTime.week);
        String dateOfTheFirstDay1 = durationOfTheWeek.split(" ")[1];
        Assert.assertEquals(dateOfTheFirstDay, dateOfTheFirstDay1);
        String lastDayOfTheWeekFromCalendar = workingTime.getTextFromElement(workingTime.lastDayOfTheWeek);
        String lastDayOfTheWeek = lastDayOfTheWeekFromCalendar.split(", ")[1];
        String lastOfTheFirstDay1 = durationOfTheWeek.split(" ")[4];
        Assert.assertEquals(lastDayOfTheWeek, lastOfTheFirstDay1);
        Thread.sleep(5000);
    }
}