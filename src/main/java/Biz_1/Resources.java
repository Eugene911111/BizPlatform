package Biz_1;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Resources extends AbstractPageObject {
    protected final By categoryButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@class=\"ng-binding ng-scope\"][@href=\"#/bookings/resources/newGroup\"]");
    protected final By resourceButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@class=\"ng-binding ng-scope\"][@href=\"#/bookings/resources/new\"]");
    protected final By fieldForResourceName = By.xpath("//div[@class=\"input-row\"]//input[@type=\"text\"]");
    protected final By fieldForCategoryName = By.xpath("//input[@name=\"name\"]");
    protected final By dropDownButtonToSelectCategory = By.xpath("//div[@class=\"input-row\"]//span[@class=\"custom-select-wrapper\"]/select//option[@label=\"New Test Category\"]");
    protected String CREATED_CATEGORY_IN_LIST = "//span[@class=\"group-name ng-binding ng-scope\"][contains(., 'New Test Category')]";
    protected final By editButtonForCategory = By.xpath("//span[@class=\"group-name ng-binding ng-scope\"][contains(., 'r')]//following-sibling::*//i[@class=\"fa fa-pencil edit-group-icon\"]");
    protected final By saveButton = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    protected final By deleteCategoryButton = By.xpath("//div[@class=\"panel panel-default panel-open\"][contains(., 'New Test Category')]//ul[@class=\"edit-dropdown dropdown-menu\"]//li[3]");
    protected final By createdResource = By.xpath(" //div[@class=\"list-content\"]/div[@class=\"type-small-info selected\"]//span[@class=\"specialist-name ng-binding\"][contains(., 'NEW TEST RESOURCE')]");
    protected final By delete = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    protected final By editButtonForCreatedResource = By.xpath("//div[@class=\"reser-type ng-scope\"]//div[@class=\"edit-pencil edit-display\"]");
    protected final By deleteButtonForCreatedResource = By.xpath("//div[@class=\"buttons-block\"]//button[@class=\"btn ng-binding\"]");
    protected final By deleteButton2ForCreatedResource = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-green ng-binding\"]");
    protected @Getter final By addResourceButton = By.xpath("//i[@class=\"ion-plus\"]");

    public void deleteCreatedCategory() throws InterruptedException {
        waitForElementIsClickableAndClick(editButtonForCategory);
        waitForElementIsClickableAndClick(deleteCategoryButton);
        waitForElementIsClickableAndClick(delete);
    }

    public void deleteCreatedResource() throws InterruptedException {
        waiter(createdResource, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
        waitForElementIsClickableAndClick(editButtonForCreatedResource);
        waitForElementIsClickableAndClick(deleteButtonForCreatedResource);
        waitForElementIsClickableAndClick(deleteButton2ForCreatedResource);
    }

    public void addNewCategory() throws InterruptedException {
        waitForElementIsClickableAndClick(getAddResourceButton());
        waitForElementIsClickableAndClick(categoryButton);
        sendKeysToElementWhenElementIsClickable(fieldForCategoryName, "New Test Category");
        waitForElementIsClickableAndClick(saveButton);
    }
}