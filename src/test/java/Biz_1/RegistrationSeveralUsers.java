package Biz_1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;

public class RegistrationSeveralUsers implements Constants {

    protected WebDriver driver;
    protected LandingPage landingPage;
    protected LogInPage logInPage;
    protected MobileBuilder mobileBuilder;
    protected Resources resources;
    protected Booking booking;
    protected GlobalSettings globalSettings;
    protected Specialists specialists;
    protected WorkingTime workingTime;
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before
    public void precondition() {
        this.driver = new FirefoxDriver();
        (logInPage = new LogInPage()).setDriver(driver);
        (landingPage = new LandingPage()).setDriver(driver);
        (booking = new Booking()).setDriver(driver);
        (mobileBuilder = new MobileBuilder()).setDriver(driver);
        (globalSettings = new GlobalSettings()).setDriver(driver);
        (resources = new Resources()).setDriver(driver);
        (specialists = new Specialists()).setDriver(driver);
        (workingTime = new WorkingTime()).setDriver(driver);
    }

    @After
    public void testShutDown() {
        driver.close();
    }

    @org.junit.Test
    public void newUserRegistration() throws Exception {
        for (int i = 1; i < 4; i++) {
            String randomUserEmail = ("test.ncube" + Math.random() + 0.1 + "@gmail.com");
            landingPage.openUrl(landingPage.BIZPLATFORM_MAIN);
            landingPage.waitForElementIsPresentAndClick(landingPage.registerButton);
            landingPage.waitForElementIsClickableAndClick(landingPage.registrationNameField);
            landingPage.waitForElementIsClickableAndClick(landingPage.registrationNameField);
            landingPage.sendKeysToElementWhenElementIsClickable(landingPage.registrationNameField, landingPage.SEND_KEYS_TO_REGISTRATION_NAME_FIELD);
            landingPage.waitForElementIsClickableAndClick(landingPage.registrationEmailField);
            landingPage.sendKeysToElementWhenElementIsClickable(landingPage.registrationEmailField, (randomUserEmail));
            landingPage.waitForElementIsClickableAndClick(landingPage.registrationPasswordField);
            landingPage.sendKeysToElementWhenElementIsClickable(landingPage.registrationPasswordField, landingPage.SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD);
            landingPage.waitForElementIsClickableAndClick(landingPage.registrationConfirmationPasswordField);
            landingPage.sendKeysToElementWhenElementIsClickable(landingPage.registrationConfirmationPasswordField, landingPage.SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD);
            landingPage.waitForElementIsClickableAndClick(landingPage.tryForFreeButton);
            landingPage.checkElementIsDisplayed(landingPage.bizplatformLogo);
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "http://bizplatform.co/Account/EmailVerification?email=" + randomUserEmail;
            Assert.assertEquals(expectedUrl, actualUrl);
            URL url = new URL(driver.getCurrentUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code1 = connection.getResponseCode();
            Assert.assertEquals(code1, 200);
            log.info("New user registration test # " + i + " passed successfully");
        }
    }
}
