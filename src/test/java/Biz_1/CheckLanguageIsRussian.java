package Biz_1;

import org.junit.Assert;
import java.util.concurrent.TimeUnit;

public class CheckLanguageIsRussian extends AbstractTest{

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        globalSettings.openGlobalSettings();
        Thread.sleep(2000);
        globalSettings.pressLanguageDropDown();
        globalSettings.selectRussianLanguage();
        globalSettings.pressSaveButton();
        globalSettings.refreshGlobalSettings();
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        String actualTextFromGlobalSettingsPageTitle = globalSettings.getTextFromGlobalSettingsPageTitle();
        String expectedTextFromGlobalSettingsPageTitle = "ГЛОБАЛЬНЫЕ НАСТРОЙКИ";
        Assert.assertEquals(actualTextFromGlobalSettingsPageTitle, expectedTextFromGlobalSettingsPageTitle);

    }

}