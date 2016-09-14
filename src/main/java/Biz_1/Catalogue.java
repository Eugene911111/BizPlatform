package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by egolub on 9/12/2016.
 */
public class Catalogue extends AbstractPageObject {
    private static final String CATALOGUI = "http://bizplatform.co/Venue/CommandCenter#/builder/catalogue";
    protected final By addNewCategory = By.xpath("//div[@class=\"full-height builder ng-scope\"]//a[@class=\"btn btn-dark add-category-btn ng-scope\"]");
    protected final By addNewItem = By.xpath("//div[@class=\"full-height builder ng-scope\"]//a[@class=\"btn btn-green add-item-btn ng-scope\"]");
    protected final By deleteItemButton = By.xpath("//i[@class=\"ion-close-round close\"]//parent::div[contains(., \"Test Item Name\")]//i[@class=\"ion-close-round close\"]");
    protected final By continueButton = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-green\"]");
    protected final By fieldForCatalogueTitle = By.xpath("//div[@class=\"col-sm-12 col-md-9\"]//input[@type=\"text\"]");
    protected final By editButtonForCatalogue = By.xpath("//i[@class=\"fa fa-pencil edit\"]//parent::div[contains(., \"Test Catalogue Name\")]//i[@class=\"fa fa-pencil edit\"]");
    protected final By removeCategoryButton = By.xpath("//div[@class=\"line category-btns\"]//button[@class=\"btn btn-dark remove-btn ng-scope\"]");

    protected final By fieldForItemTitle = By.xpath("//div[@class=\"col-sm-12 col-md-9\"]//input[@class=\"form-control ng-pristine ng-untouched ng-invalid ng-invalid-required\"]");
    private static final String KEYS_TO_CATALOGUE_TITLE = "Test Catalogue Name";
    private static final String KEYS_TO_ITEM_TITLE = "Test Item Name";

    protected final By addedTestCatalogue = By.xpath("//div[@class=\"category draggable-item ng-scope\"]//span[@class=\"ng-binding\"][contains(., 'Test Catalogue Name')]");
    protected final By saveCategortTitleButton = By.xpath("//div[@class=\"full-height builder ng-scope\"]//button[@class=\"btn btn-green ng-scope\"]");
    protected final By saveItemTitleButton = By.xpath("//div[@class=\"col-xs-12 col-sm-7 col-md-8 full-height side-panel-wrp eye\"]//button[@class=\"btn btn-green form-save-btn ng-scope\"]");
    protected final By addedTestItem = By.xpath("//div[@class=\"card options draggable-item ng-scope\"]//div[@class=\"name ng-binding\"][contains(., \"Test Item Name\")]");

    public void openCatalogue() {
        driver.get(CATALOGUI);
    }

    public void pressAddNewCategory() throws InterruptedException {
        waiter(addNewCategory, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void sendKeysToFieldForCatalogueTitle() throws InterruptedException {
        waiter(fieldForCatalogueTitle, c -> c.sendKeys(KEYS_TO_CATALOGUE_TITLE), ExpectedConditions::presenceOfElementLocated, 10);
    }

    public void clickSaveCategortTitle() throws InterruptedException {
        waiter(saveCategortTitleButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    protected String getTextFromListOfCatalogues() throws InterruptedException {
        waiter(addedTestCatalogue, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        return driver.findElement(addedTestCatalogue).getText();
    }

    public void pressAddNewItem() throws InterruptedException {
        waiter(addNewItem, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void sendKeysToFieldForItemTitle() throws InterruptedException {
        waiter(fieldForItemTitle, c -> c.sendKeys(KEYS_TO_ITEM_TITLE), ExpectedConditions::presenceOfElementLocated, 10);
    }

    public void clickSaveItemTitle() throws InterruptedException {
        waiter(saveItemTitleButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    protected String getItemNameOfCatalogues() throws InterruptedException {
        waiter(addedTestItem, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        return driver.findElement(addedTestItem).getText();
    }

    public void pressDeleteItem() throws InterruptedException {
        waiter(deleteItemButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void pressContinue() throws InterruptedException {
        waiter(continueButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void pressEditForCategory() throws InterruptedException {
        waiter(editButtonForCatalogue, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void pressRemoveCategoryButton() throws InterruptedException {
        waiter(removeCategoryButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }


}
