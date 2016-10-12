package Biz_1;

import org.junit.Assert;

import java.net.HttpURLConnection;
import java.net.URL;

public class NewUserRegistration extends AbstractTest {

    @org.junit.Test
    public void newUserRegistration() throws Exception {
        landingPage.openUrl(landingPage.BIZPLATFORM_MAIN);
        landingPage.waitForElementIsPresentAndClick(landingPage.registerButton);
        landingPage.registerRandomUser();
        landingPage.checkElementIsDisplayed(landingPage.bizplatformLogo);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://bizplatform.co/Account/EmailVerification?email=" + landingPage.randomUserEmail;
        Assert.assertEquals(expectedUrl, actualUrl);
        log.info("---------current url is:   " + actualUrl);
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCodeesponseCode = connection.getResponseCode();
        Assert.assertEquals(responseCodeesponseCode, 200);
        log.info("Response Code: "+ responseCodeesponseCode);
        log.info("User is registered");
    }
}