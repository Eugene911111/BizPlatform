package Biz_1;

import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpConnection;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckListOfBenefits extends AbstractTest implements Constants {
    private final static int DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_RUSSIAN = 6;
    private final static int DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_ENGLISH = 9;

    @Test
    public void a_checkListOfBenefits() throws InterruptedException, IOException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(BOOKING_BUTTON, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.openUrl(promoteOnSite.PROMOTE_ON_SITE_FLYER);
        promoteOnSite.waitForElementIsPresentAndClick(promoteOnSite.fieldForListOfBenefits);
        int BenefitsCount = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCount == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_ENGLISH || BenefitsCount == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_RUSSIAN) {
            log.info("Test passed!! The number of Benefits is " + BenefitsCount);
        } else {
            log.error("The number of Benefits in list is " + BenefitsCount + ". The number of Benefits should be " + BenefitsCount);
            throw new InterruptedException();
        }
    }

    @Test
    public void b_checkListOfBenefitsAfterResetToDefault() throws InterruptedException, IOException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(BOOKING_BUTTON, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.openUrl(promoteOnSite.PROMOTE_ON_SITE_FLYER);
        promoteOnSite.waitForElementIsPresentAndClick(promoteOnSite.fieldForListOfBenefits);
        int BenefitsCount2 = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCount2 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_ENGLISH || BenefitsCount2 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_RUSSIAN) {
            log.info("Test passed!!");
        } else {
            log.error("The number of Benefits in list is " + BenefitsCount2);
            throw new InterruptedException();
        }
        promoteOnSite.waitForElementIsClickableAndClick(promoteOnSite.resetToDefaultButton);
        promoteOnSite.waitForElementIsPresentAndClick(promoteOnSite.fieldForListOfBenefits);
        int BenefitsCountAfterResetToDefault = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCountAfterResetToDefault == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_ENGLISH || BenefitsCountAfterResetToDefault == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_RUSSIAN) {
            log.info("After pressing ResetToDefault the numder od Benefits is correct " + BenefitsCountAfterResetToDefault);
        } else {
            log.error("The number of Benefits in list is " + BenefitsCountAfterResetToDefault);
            throw new InterruptedException();
        }
    }

    @Test
    public void c_addCustomFields() throws InterruptedException, IOException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(BOOKING_BUTTON, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.openUrl(promoteOnSite.PROMOTE_ON_SITE_FLYER);
        promoteOnSite.waitForElementIsPresentAndClick(promoteOnSite.addYourCustomFiel);
        promoteOnSite.findElementsAndSendKeys(promoteOnSite.addYourCustomFiel, promoteOnSite.newBenefit);
        promoteOnSite.waitForElementIsClickableAndClick(promoteOnSite.addButton);
        int BenefitsCount4 = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCount4 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_ENGLISH + 1 || BenefitsCount4 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_RUSSIAN + 1) {
            log.info("Test passed!! One Benefit was added to the list.");
        } else {
            log.error("The number of Benefits in list is " + BenefitsCount4);
            throw new InterruptedException();
        }
        //-- ----------check that custom field is added to preview
        String actualEmailErrorMessage = promoteOnSite.getTextFromElement(promoteOnSite.customFieldInPreview);
        String expectedErrorMessage = "test custom field";
        Assert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
        log.info("It is displayed in preview");


    }

    @Test
    public void d_addCustomFieldsPressResetToDefault() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(BOOKING_BUTTON, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.openUrl(promoteOnSite.PROMOTE_ON_SITE_FLYER);
        promoteOnSite.waitForElementIsPresentAndClick(promoteOnSite.addYourCustomFiel);
        promoteOnSite.findElementsAndSendKeys(promoteOnSite.addYourCustomFiel, promoteOnSite.newBenefit);
        promoteOnSite.waitForElementIsClickableAndClick(promoteOnSite.addButton);
        int BenefitsCount3 = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCount3 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_ENGLISH + 1 || BenefitsCount3 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_RUSSIAN + 1) {
            log.info("Test passed!! One Benefit was added to the list.");
        } else {
            log.error("The number of Benefits in list is " + BenefitsCount3);
            throw new InterruptedException();
        }
        promoteOnSite.waitForElementIsClickableAndClick(promoteOnSite.resetToDefaultButton);
        promoteOnSite.waitForElementIsPresentAndClick(promoteOnSite.fieldForListOfBenefits);
        int recordsCountAfterResetToDefault = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (recordsCountAfterResetToDefault == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_ENGLISH  || recordsCountAfterResetToDefault == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST_FOR_RUSSIAN) {
            log.info("After pressing ResetToDefault the numder of Benefits is correct " + recordsCountAfterResetToDefault);
        } else {
            log.error("The number of Benefits in list is " + recordsCountAfterResetToDefault);
            throw new InterruptedException();
        }
    }

    @Test
    public void e_checkProvideAdditionalMotivationIsDisplayedOnPreview() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(BOOKING_BUTTON, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.openUrl(promoteOnSite.PROMOTE_ON_SITE_FLYER);
        promoteOnSite.waitForElementIsPresentAndClick(promoteOnSite.addYourCustomFiel);
        promoteOnSite.waitForElementIsClickableAndClick(promoteOnSite.additionalInformationButton);
        promoteOnSite.sendKeysToElementWhenElementIsPresent(promoteOnSite.fieldForAdditionalInformationButton, promoteOnSite.TEXT_OF_ADDITIONAL_INFO);
        // check addition information is added to the preview
        String actualEmailErrorMessage = promoteOnSite.getTextFromElement(promoteOnSite.additionalInformationInPreview);
        String expectedErrorMessage = "test additional info";
        Assert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
    }

    @Test
    public void f_checkPdfIsDownloaded() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(BOOKING_BUTTON, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.openUrl(promoteOnSite.PROMOTE_ON_SITE_FLYER);
        promoteOnSite.waitForElementIsClickableAndClick(promoteOnSite.downloadButton);
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int code = connection.getResponseCode();
        Assert.assertEquals(code, 200);
        log.info("PDF file was downloaded with Response Code " + code);
        Thread.sleep(3000);
    }


//private void sendLogIn() throws IOException{
//    GetMethod getMEthod = new GetMethod("http://bizplatform.co/Account/Login/");
//    getMEthod.addRequestHeader("Email", "golubeugene91155@gmail.com");
//    getMEthod.addRequestHeader("Password", "111111");
//    Http
//    HttpConnection connection = new HttpConnection("bizplatform.co", 80);SessionId=efxqma50uvl3tbsxqzos4nxk
//    getMEthod.execute(new HttpState(), connection);
//
//}
//
//    @org.junit.Test
//    public void logInTest() throws InterruptedException, IOException {
////        sendLogIn();
////        driver.manage().window().maximize();
//        driver.get("http://bizplatform.co/Venue/CommandCenter#/bookings/scheduler/full");
//        Thread.sleep(9000);
//        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
//        landingPage.checkElementIsDisplayed(By.xpath(BOOKING_BUTTON));
//
//    }

}



