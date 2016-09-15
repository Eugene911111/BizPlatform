package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by egolub on 9/13/2016.
 */
public class Offers extends AbstractPageObject {
    protected static final String OFFERS = "http://bizplatform.co/Venue/CommandCenter#/builder/offers";
    protected static final String KEYS_TO_OFFERS_DESCRIPTION = "Test Offer";
    protected final By addNewOffer = By.xpath("//div[@class=\"line\"]//button[@class=\"btn btn-green add-offer-btn ng-scope\"]");
    protected final By descriptionFieldForBooking = By.xpath("//div[@class=\"col-sm-12 col-md-12\"]//textarea[@type=\"text\"]");
    protected final By saveButton = By.xpath("//div[@class=\"line\"]//button[@class=\"btn btn-green form-save-btn ng-scope\"]");
    protected final By addedOffer = By.xpath("//div[@class=\"description ng-binding\"][contains(., 'Test Offer')]");
    protected final By deleteButtonForCatalogue = By.xpath("//i[@class=\"ion-close-round close\"]//parent::div[contains(., \"Test Offer\")]//i[@class=\"ion-close-round close\"]");
    protected final By offersOnPreview = By.xpath("//div[@class=\"phone-view\"][1]//iframe[@class=\"phone-content mobileapp loaded\"]");
    protected final static int DEFAULT_NUMBER_OF_OFFERS = 1;
    protected final By offersInList = By.xpath("//div[@class=\"list item-list draggable-list\"]//div[@class=\"card options draggable-item ng-scope\"]");

    protected String getTextFromListOfOffers() throws InterruptedException {
        waiter(addedOffer, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        return driver.findElement(addedOffer).getText();
    }

    public void checkElementIs(By element) throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.presenceOfElementLocated(element));
    }

}
