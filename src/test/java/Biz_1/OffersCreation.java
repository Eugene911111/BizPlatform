package Biz_1;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

/**
 * Created by egolub on 9/13/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OffersCreation extends AbstractTest {

    @org.junit.Test
    public void a_addOffer() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        offers.openOffers();
        offers.pressAddNewOffer();
        offers.sendKeysToFieldForOffersDescription();
        offers.pressSave();
        offers.checkElementIsDisplayed(offers.addedOffer);
        String actualOfferDescription = offers.getTextFromListOfOffers();
        String expectedOfferDescription = "Test Offer";
        Assert.assertEquals(expectedOfferDescription, actualOfferDescription);
        log.info("Offer is added");
    }

    @org.junit.Test
    public void b_checkNumberOfOffersInList() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        offers.openOffers();
        offers.checkElementIs(offers.offersOnPreview);
        int numberOfOffersInList = driver.findElement(By.xpath("//div[@class=\"list item-list draggable-list\"]")).findElements(By.xpath("//div[@class=\"list item-list draggable-list\"]//div[@class=\"card options draggable-item ng-scope\"]")).size();
//        int numberOfOffersInPreview = driver.findElement(By.xpath("//ion-nav-bar[@class=\"nav-bar-container\"]")).findElements(By.xpath("//div[@class=\"list card offer\"]")).size();
//        System.out.println(numberOfOffersInPreview);

        if (numberOfOffersInList == offers.DEFAULT_NUMBER_OF_OFFERS) {
            log.info("Number of Offers in preview and in list is the same and equals " + numberOfOffersInList);
        } else {
            log.error("Number of Offers in preview and in list is different " + numberOfOffersInList);
            throw new InterruptedException();
        }
    }

    @org.junit.Test
    public void c_deleteOffer() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        offers.openOffers();
        offers.pressDeleteOffer();
        catalogue.pressContinue();
        offers.checkElementIsNotDisplayed(offers.addedOffer);
    }
}
