package Biz_1;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkingTimeSetting extends AbstractTest implements Constants {

    @org.junit.Test
    public void a_workingTimeDelete() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(workingTime.WORKINGTIME_PAGE);
        workingTime.pressWorkingTime();
        workingTime.deleteWorkingTime();
        workingTime.saveChanges();
       // Thread.sleep(500);
        //workingTime.checkElementIsDisplayed(workingTime.saveButton);
    }

    @org.junit.Test
    public void b_workingTimeSetting() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(workingTime.WORKINGTIME_PAGE);
        workingTime.pressOnFieldForSettingTime();

        workingTime.sendKeysToOpeningTimeHours();

      //  workingTime.sendKeysToOpeningTimeMinuts();
        Thread.sleep(3000);

        workingTime.pressSaveChanges();
        Thread.sleep(3000);
        workingTime.saveChanges();
        Thread.sleep(5000);
    }

}