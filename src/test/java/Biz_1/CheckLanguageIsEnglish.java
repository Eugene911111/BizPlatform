package Biz_1;

import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class CheckLanguageIsEnglish extends AbstractTest {

    @org.junit.Test
    public void checkLanguageIsEnglish() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.logIn();
        globalSettings.openGlobalSettings();
      //  globalSettings.implicitlyWait(3, TimeUnit.SECONDS);
        globalSettings.pressLanguageDropDown();
        globalSettings.selectEnglishLanguage();
        globalSettings.pressSaveButton();
        globalSettings.refreshGlobalSettings();
        String actualTextFromGlobalSettingsPageTitle = globalSettings.getTextFromGlobalSettingsPageTitle();
        String expectedTextFromGlobalSettingsPageTitle = "GLOBAL SETTINGS";
        Assert.assertEquals(actualTextFromGlobalSettingsPageTitle, expectedTextFromGlobalSettingsPageTitle);

    }

}