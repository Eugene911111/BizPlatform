package Biz_1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class CheckBuilderElementsArePresentAfterReloading extends AbstractTest {
    private final String screenshotName = "D:\\screenshot\\mobileBuilder\\" + ft.format(date) + getClass() + "Screenshot.jpg\\";

    @org.junit.Test
    public void checkBuilderElementsArePresentAfterReloading() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        mobileBuilder.clickMobileBuilder();
        mobileBuilder.imageIsDisplayed(mobileBuilder.MOBILE_BUILDER_IMAGE);
        for (int h = 1; h <= 5; h++) {
            mobileBuilder.refreshMobileBuilder();
            try {
                mobileBuilder.imageIsDisplayed(mobileBuilder.MOBILE_BUILDER_IMAGE);
            } catch (Exception e) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(screenshotName));
                log.error("Screenshot of the bug was saved to: " + screenshotName);
                throw new Exception(e);
            }
        }
    }
}
