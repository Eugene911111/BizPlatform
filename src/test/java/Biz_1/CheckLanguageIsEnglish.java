package Biz_1;

import org.junit.Assert;

public class CheckLanguageIsEnglish extends AbstractTest {

    @org.junit.Test
    public void checkLanguageIsEnglish() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        globalSettings.openUrl(GLOBAL_SETTINGS);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_LANGUAGE_BUTTON);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_ENGLISH_LANGUAGE);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_SAVE_BUTTON);
        globalSettings.refreshPage();
        String actualTextFromGlobalSettingsPageTitle = globalSettings.getTextFromElement(globalSettings.GLOBAL_PAGE_TITLE);
        String expectedTextFromGlobalSettingsPageTitle = "GLOBAL SETTINGS";
        Assert.assertEquals(actualTextFromGlobalSettingsPageTitle, expectedTextFromGlobalSettingsPageTitle);
    }

}