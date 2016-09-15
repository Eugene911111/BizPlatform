package Biz_1;

import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class CheckLanguageIsRussian extends AbstractTest {

    @org.junit.Test
    public void checkLanguageIsRussian() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.logIn();
        globalSettings.openGlobalSettings();
        // globalSettings.implicitlyWait(3, TimeUnit.SECONDS);
        globalSettings.pressLanguageDropDown();
        globalSettings.selectRussianLanguage();
        globalSettings.pressSaveButton();
        globalSettings.refreshPage();
        String actualTextFromGlobalSettingsPageTitle = globalSettings.getTextFromGlobalSettingsPageTitle();
        String expectedTextFromGlobalSettingsPageTitle = "ГЛОБАЛЬНЫЕ НАСТРОЙКИ";
        Assert.assertEquals(actualTextFromGlobalSettingsPageTitle, expectedTextFromGlobalSettingsPageTitle);

    }

}