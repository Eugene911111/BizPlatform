package Biz_1;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBuilderElementsArePresent extends AbstractTest {

    @org.junit.Test
    public void checkBuilderElementsArePresent() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        mobileBuilder.openUrl(mobileBuilder.MOBILE_BUILDER);
        mobileBuilder.imageIsDisplayed(mobileBuilder.MOBILE_BUILDER_IMAGE);
        mobileBuilder.imageIsDisplayed(mobileBuilder.MOBILE_BUILDER_SAMPLE);
    }
}