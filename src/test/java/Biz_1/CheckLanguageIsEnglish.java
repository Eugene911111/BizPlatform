package Biz_1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class CheckLanguageIsEnglish extends AbstractTest {

    @org.junit.Test
    public void firstTest() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.fillLogInForm();
        globalSettings.openGlobalSettings();
        globalSettings.implicitlyWait(3, TimeUnit.SECONDS);
        globalSettings.pressLanguageDropDown();
        globalSettings.selectEnglishLanguage();
        globalSettings.pressSaveButton();
        globalSettings.refreshGlobalSettings();
        String actualTextFromGlobalSettingsPageTitle = globalSettings.getTextFromGlobalSettingsPageTitle();
        String expectedTextFromGlobalSettingsPageTitle = "GLOBAL SETTINGS";
        Assert.assertEquals(actualTextFromGlobalSettingsPageTitle, expectedTextFromGlobalSettingsPageTitle);

    }

}