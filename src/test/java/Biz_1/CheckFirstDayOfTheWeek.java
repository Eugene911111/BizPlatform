package Biz_1;

import org.junit.Assert;

import java.util.Objects;

public class CheckFirstDayOfTheWeek extends AbstractTest {

    @org.junit.Test
    public void a_firstDayOfTheWeekDependingOnLanguage() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        workingTime.openUrl(workingTime.WORKING_TIME_PAGE);
        String checkLAnguage = workingTime.getTextFromElement(workingTime.todayButton);
        if (Objects.equals(checkLAnguage, "TODAY")) {
            String sunday = workingTime.getTextFromElement(workingTime.firstDayInColumn);
            String dateOfTheFirstDay1 = sunday.split(",")[0];
            Assert.assertEquals(dateOfTheFirstDay1, "SUN");
        } else if (Objects.equals(checkLAnguage, "СЕГОДНЯ")) {
            String sunday = workingTime.getTextFromElement(workingTime.firstDayInColumn);
            String dateOfTheFirstDay1 = sunday.split(",")[0];
            Assert.assertEquals("ПН", dateOfTheFirstDay1);
        }
    }

    @org.junit.Test
    public void b_checkDayOfTheWeekAfterSpecifyingLanguage() throws InterruptedException {
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
        workingTime.openUrl(workingTime.WORKING_TIME_PAGE);
        workingTime.checkElementIsDisplayed(workingTime.todayButton);
        String sunday = workingTime.getTextFromElement(workingTime.firstDayInColumn);
        String dateOfTheFirstDay1 = sunday.split(",")[0];
        Assert.assertEquals(dateOfTheFirstDay1, "SUN");
    }

    @org.junit.Test
    public void c_checkLanguageIsRussian() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.logIn();
        globalSettings.openUrl(GLOBAL_SETTINGS);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_LANGUAGE_BUTTON);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_RUSSIAN_LANGUAGE);
        globalSettings.waitForElementIsClickableAndClick(GLOBAL_SAVE_BUTTON);
        globalSettings.refreshPage();
        String actualTextFromGlobalSettingsPageTitle = globalSettings.getTextFromElement(globalSettings.GLOBAL_PAGE_TITLE);
        String expectedTextFromGlobalSettingsPageTitle = "ГЛОБАЛЬНЫЕ НАСТРОЙКИ";
        Assert.assertEquals(actualTextFromGlobalSettingsPageTitle, expectedTextFromGlobalSettingsPageTitle);
        workingTime.openUrl(workingTime.WORKING_TIME_PAGE);
        workingTime.checkElementIsDisplayed(workingTime.todayButton);
        String sunday = workingTime.getTextFromElement(workingTime.firstDayInColumn);
        String dateOfTheFirstDay1 = sunday.split(",")[0];
        Assert.assertEquals(dateOfTheFirstDay1, "ПН");
    }
}