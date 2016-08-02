package Biz_1;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class CheckBuilderElementsArePresent extends AbstractTest {

    @org.junit.Test
    public void checkBuilderElementsArePresent() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        mobileBuilder.implicitlyWait(3, TimeUnit.SECONDS);
        mobileBuilder.clickMobileBuilder();
        mobileBuilder.imageIsDisplayed();
    }
}