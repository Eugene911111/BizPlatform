package Biz_1;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkingTimeSetting extends AbstractTest implements Constants {
    @org.junit.Test
    public void a_workingTimeDelete() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(workingTime.WORKING_TIME_PAGE);
        workingTime.waitForElementIsClickableAndClick(workingTime.workingTimeButton);
        workingTime.waitForElementIsClickableAndClick(workingTime.deleteWorkingTimeButton);
        workingTime.saveChanges();
        // Thread.sleep(500);
        //workingTime.checkElementIsDisplayed(workingTime.saveButton);
    }

    @org.junit.Test
    public void b_workingTimeSetting() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(workingTime.WORKING_TIME_PAGE);
        workingTime.waitForElementIsClickableAndClick(workingTime.fieldForSettingWorkingTime);
        workingTime.sendKeysToElementWhenElementIsClickable(workingTime.fieldForOpeningTimeHour1, workingTime.valueOfSettingTimeHour);
        //  workingTime.sendKeysToOpeningTimeMinuts();
        Thread.sleep(3000);
        workingTime.waitForElementIsClickableAndClick(workingTime.saveChangingButton);
        Thread.sleep(3000);
        workingTime.saveChanges();
        Thread.sleep(5000);
    }

}