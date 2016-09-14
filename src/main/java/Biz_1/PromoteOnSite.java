package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.By.xpath;

/**
 * Created by egolub on 9/7/2016.
 */
public class PromoteOnSite extends AbstractPageObject {
    private static final String MROMOTE_ON_SITE_FLYER = "http://bizplatform.co/Venue/CommandCenter#/promote/on-site/flyer";
    private final By resetToDefaultButton = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//a[@class=\"reset ng-binding\"]");

    private final By fieldForListOfBenefits = By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]");

    protected final By addYourCustomFiel = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//input[@name=\"feature\"]");
    protected String newBenefit = "test custom field";
    private final By addButton = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//div[@class=\"plus\"]//i[@class=\"ion-plus\"]");
    private final By additionalInformationButton = By.xpath("//span[@class=\"green switch green ng-valid\"]//small");
    private final By fieldForAdditionalInformationButton = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//input[@ng-model=\"flyerCtrl.prizeFieldName\"]");
    protected final String TEXT_OF_ADDITIONAL_INFO = "test additional info";
    private final By additionalInformationInPreview = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//span[@class=\"animate-show ng-binding\"]");
    private final By customFieldInPreview = By.xpath("//span[@ng-bind=\"feature.name|translate\"][contains(., 'test custom field')]");
    private final By downloadButton = By.xpath("//div[@class=\"custom_button_area\"]//button[@class=\"btn btn-green download ng-binding\"]");


    public void getPromoteOnWebFlyer() throws InterruptedException {
        driver.get(MROMOTE_ON_SITE_FLYER);
    }

    public void clickResetToDefault() throws InterruptedException {
        waiter(resetToDefaultButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void waitForElementPresent() throws InterruptedException {
        waiter(fieldForListOfBenefits, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
    }

    public void waitForAddYourCustomFieldIsPresent() throws InterruptedException {
        waiter(addYourCustomFiel, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
    }

    public void clickAddButton() throws InterruptedException {
        waiter(addButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void clickProvideAdditionalInformation() throws InterruptedException {
        waiter(additionalInformationButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void additionalInformation() throws InterruptedException {
        findElementsAndSendKeys(fieldForAdditionalInformationButton, TEXT_OF_ADDITIONAL_INFO);
    }

    protected String getTextFromPreviewPromoteOnSiteCustomField() throws InterruptedException {
        waiter(additionalInformationInPreview, WebElement::isEnabled, ExpectedConditions::presenceOfElementLocated, 10);
        return driver.findElement(additionalInformationInPreview).getText();


    }

    protected String getTextFromPreviewPromoteOnSiteAdditionInformation() throws InterruptedException {
        waiter(customFieldInPreview, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        return driver.findElement(customFieldInPreview).getText();
    }

    public void clickDownloadButton() throws InterruptedException {
        waiter(downloadButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }
}
