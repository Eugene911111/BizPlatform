package Biz_1;

import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class CheckLanguageIsRussian extends AbstractTest {

    @org.junit.Test
    public void checkLanguageIsRussian() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.logIn();
        globalSettings.openUrl(GLOBAL_SETTINGS);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_LANGUAGE_BUTTON);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_RUSSIAN_LANGUAGE);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_SAVE_BUTTON);
        globalSettings.refreshPage();
        String actualTextFromGlobalSettingsPageTitle = globalSettings.getTextFromGlobalSettingsPageTitle();
        String expectedTextFromGlobalSettingsPageTitle = "ГЛОБАЛЬНЫЕ НАСТРОЙКИ";
        Assert.assertEquals(actualTextFromGlobalSettingsPageTitle, expectedTextFromGlobalSettingsPageTitle);

    }

}