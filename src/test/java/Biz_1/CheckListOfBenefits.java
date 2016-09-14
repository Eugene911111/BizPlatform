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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckListOfBenefits extends AbstractTest implements Constants {
    private final static int DEFAULT_NUMBER_OF_BENEFITS_IN_LIST = 1;

    @Test
    public void a_checkListOfBenefits() throws InterruptedException, IOException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.getPromoteOnWebFlyer();
        promoteOnSite.waitForElementPresent();
        int BenefitsCount = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCount == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST) {
            log.info("Test passed!! The number of Benefits is " + DEFAULT_NUMBER_OF_BENEFITS_IN_LIST);
        } else {
            log.error("The number of Benefits in list is " + BenefitsCount + ". The number of Benefits should be " + DEFAULT_NUMBER_OF_BENEFITS_IN_LIST);
            throw new InterruptedException();
        }
    }

    @Test
    public void b_checkListOfBenefitsAfterResetToDefault() throws InterruptedException, IOException {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.getPromoteOnWebFlyer();
        promoteOnSite.waitForElementPresent();
        int BenefitsCount2 = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCount2 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST) {
            log.info("Test passed!!");
        } else {
            log.error("The number of Benefits in list is " + BenefitsCount2);
            throw new InterruptedException();
        }
        promoteOnSite.clickResetToDefault();
        promoteOnSite.waitForElementPresent();
        int BenefitsCountAfterResetToDefault = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCountAfterResetToDefault == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST) {
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
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.getPromoteOnWebFlyer();
        promoteOnSite.waitForAddYourCustomFieldIsPresent();
        promoteOnSite.findElementsAndSendKeys(promoteOnSite.addYourCustomFiel, promoteOnSite.newBenefit);
        promoteOnSite.clickAddButton();
        int BenefitsCount2 = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCount2 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST + 1) {
            log.info("Test passed!! One Benefit was added to the list.");
        } else {
            log.error("The number of Benefits in list is " + BenefitsCount2);
            throw new InterruptedException();
        }
        //------------check that custom field is added to preview
        String actualEmailErrorMessage = promoteOnSite.getTextFromPreviewPromoteOnSiteAdditionInformation();
        String expectedErrorMessage = "test custom field";
        Assert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
        log.info("It is displayed in preview");


    }

    @Test
    public void d_addCustomFieldsPressResetToDefault() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.getPromoteOnWebFlyer();
        promoteOnSite.waitForAddYourCustomFieldIsPresent();
        promoteOnSite.findElementsAndSendKeys(promoteOnSite.addYourCustomFiel, promoteOnSite.newBenefit);
        promoteOnSite.clickAddButton();
        int BenefitsCount3 = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (BenefitsCount3 == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST + 1) {
            log.info("Test passed!! One Benefit was added to the list.");
        } else {
            log.error("The number of Benefits in list is " + BenefitsCount3);
            throw new InterruptedException();
        }
        promoteOnSite.clickResetToDefault();
        promoteOnSite.waitForElementPresent();
        int recordsCountAfterResetToDefault = driver.findElement(By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]")).findElements(By.tagName("li")).size();
        if (recordsCountAfterResetToDefault == DEFAULT_NUMBER_OF_BENEFITS_IN_LIST) {
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
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.getPromoteOnWebFlyer();
        promoteOnSite.waitForAddYourCustomFieldIsPresent();
        promoteOnSite.clickProvideAdditionalInformation();
        promoteOnSite.additionalInformation();
        // check addition information is added to the preview
        String actualEmailErrorMessage = promoteOnSite.getTextFromPreviewPromoteOnSiteCustomField();
        String expectedErrorMessage = "test additional info";
        Assert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
    }

    @Test
    public void f_checkPdfIsDownloaded() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        landingPage.waiter(By.xpath(BOOKING_BUTTON), WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        promoteOnSite.getPromoteOnWebFlyer();
        promoteOnSite.clickDownloadButton();
        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int code = connection.getResponseCode();
        Assert.assertEquals(code, 200);
        log.info("PDF file was downloaded with Response Code " + code );

       Thread.sleep(2000);
    }

//private void sendLogIn() throws IOException{
//    GetMethod getMEthod = new GetMethod("http://bizplatform.co/Account/Login/");
//    getMEthod.addRequestHeader("Email", "golubeugene91155@gmail.com");
//    getMEthod.addRequestHeader("Password", "111111");
//    Http
//    HttpConnection connection = new HttpConnection("bizplatform.co", 80);
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



