package Biz_1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class CheckBuilderElementsArePresentAfterReloading extends AbstractTest {
    public CheckBuilderElementsArePresentAfterReloading() {
        super("mobileBuilder\\");
    }

    @org.junit.Test
    public void checkBuilderElementsArePresentAfterReloading() throws Exception {

        landingPage.openLogInPage();
        logInPage.logIn();
        mobileBuilder.openUrl(mobileBuilder.MOBILE_BUILDER);
        mobileBuilder.imageIsDisplayed(mobileBuilder.MOBILE_BUILDER_IMAGE);
        for (int h = 1; h <= 5; h++) {
            mobileBuilder.refreshPage();
            try {
                mobileBuilder.imageIsDisplayed(mobileBuilder.MOBILE_BUILDER_IMAGE);
                log.info("After " + h + " reloading builder elements are displayed correct");
            } catch (Exception e) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(randScreenshotName));
                log.error("Screenshot of the bug was saved to: " + randScreenshotName);
                throw new Exception(e);
            }
        }
    }
}
