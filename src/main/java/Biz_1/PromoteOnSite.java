package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by egolub on 9/7/2016.
 */
public class PromoteOnSite extends AbstractPageObject {
    protected static final String PROMOTE_ON_SITE_FLYER = "http://bizplatform.co/Venue/CommandCenter#/promote/on-site/flyer";
    protected final By resetToDefaultButton = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//a[@class=\"reset ng-binding\"]");
    protected final By fieldForListOfBenefits = By.xpath("//ul[@dnd-list=\"flyerCtrl.features\"]");
    protected final By addYourCustomFiel = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//input[@name=\"feature\"]");
    protected String newBenefit = "test custom field";
    protected final By addButton = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//div[@class=\"plus\"]//i[@class=\"ion-plus\"]");
    protected final By additionalInformationButton = By.xpath("//span[@class=\"green switch green ng-valid\"]//small");
    protected final By fieldForAdditionalInformationButton = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//input[@ng-model=\"flyerCtrl.prizeFieldName\"]");
    protected final String TEXT_OF_ADDITIONAL_INFO = "test additional info";
    protected final By additionalInformationInPreview = By.xpath("//div[@class=\"content col-xs-9 col-xs-offset-3 ng-scope\"]//span[@class=\"animate-show ng-binding\"]");
    protected final By customFieldInPreview = By.xpath("//span[@ng-bind=\"feature.name|translate\"][contains(., 'test custom field')]");
    protected final By downloadButton = By.xpath("//div[@class=\"custom_button_area\"]//button[@class=\"btn btn-green download ng-binding\"]");

}
