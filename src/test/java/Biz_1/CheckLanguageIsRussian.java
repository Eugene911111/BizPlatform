package Biz_1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CheckLanguageIsRussian {

    private FirefoxDriver driver;
    private LandingPage landingPage;
    private LogInPage logInPage;
    private GlobalSettings globalSettings;


    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        landingPage = new LandingPage(driver);
        logInPage = new LogInPage(driver);
        globalSettings = new GlobalSettings(driver);


    }

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

    @After
    public void testShutDown() {
        driver.close();
    }

}