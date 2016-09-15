package Biz_1;

import org.junit.Assert;

public class CheckLanguageIsEnglish extends AbstractTest {

    @org.junit.Test
    public void checkLanguageIsEnglish() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.logIn();
        globalSettings.openGlobalSettings();

//
        globalSettings.pressLanguageDropDown();
//
        globalSettings.selectEnglishLanguage();
        globalSettings.pressSaveButton();
        globalSettings.refreshPage();
        String actualTextFromGlobalSettingsPageTitle = globalSettings.getTextFromGlobalSettingsPageTitle();
        String expectedTextFromGlobalSettingsPageTitle = "GLOBAL SETTINGS";
        Assert.assertEquals(actualTextFromGlobalSettingsPageTitle, expectedTextFromGlobalSettingsPageTitle);

    }

}