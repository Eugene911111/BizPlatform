package Biz_1;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

public class Resources extends AbstractPageObject {
 //   public final By addResourceButton = By.xpath("//i[@class=\"ion-plus\"]");
    private final By categoryButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@class=\"ng-binding ng-scope\"][@href=\"#/bookings/resources/newGroup\"]");
    private final By resourceButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@class=\"ng-binding ng-scope\"][@href=\"#/bookings/resources/new\"]");
    private final By fieldForResourceName = By.xpath("//div[@class=\"input-row\"]//input[@type=\"text\"]");
    private final By fieldForCategoryName = By.xpath("//input[@name=\"name\"]");
    private final By dropDownButtonToSelectCategory = By.xpath("//div[@class=\"input-row\"]//span[@class=\"custom-select-wrapper\"]/select//option[@label=\"New Test Category\"]");
    private String CREATED_CATEGORY_IN_LIST = "//span[@class=\"group-name ng-binding ng-scope\"][contains(., 'New Test Category')]";
    private final By editButtonForCategory = By.xpath("//span[@class=\"group-name ng-binding ng-scope\"][contains(., 'r')]//following-sibling::*//i[@class=\"fa fa-pencil edit-group-icon\"]");
    private final By saveButton = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    private final By deleteCategoryButton = By.xpath("//div[@class=\"panel panel-default panel-open\"][contains(., 'New Test Category')]//ul[@class=\"edit-dropdown dropdown-menu\"]//li[3]");
    private final By createdResource = By.xpath(" //div[@class=\"list-content\"]/div[@class=\"type-small-info selected\"]//span[@class=\"specialist-name ng-binding\"][contains(., 'NEW TEST RESOURCE')]");
    private final By delete = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    private final By editButtonForCreatedResource = By.xpath("//div[@class=\"reser-type ng-scope\"]//div[@class=\"edit-pencil edit-display\"]");
    private final By deleteButtonForCreatedResource = By.xpath("//div[@class=\"buttons-block\"]//button[@class=\"btn ng-binding\"]");
    private final By deleteButton2ForCreatedResource = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-green ng-binding\"]");
    private @Getter final By addResourceButton = By.xpath("//i[@class=\"ion-plus\"]");
    public static final String RESOURSES_PAGE = "http://bizplatform.co/Venue/CommandCenter#/bookings/resources";





    public void pressAddButton(By er) throws InterruptedException {
        waiter(er,WebElement::click);
    }

    public void selectToCreateNewCategory() throws InterruptedException {
        waiter(categoryButton, WebElement::click);
    }

    public Resources enterNewCategoryName(String categoryNameValue) throws InterruptedException {
        waiter(fieldForCategoryName,c-> c.sendKeys(categoryNameValue));
        return this;
    }

    public void pressSaveButton() throws InterruptedException {
        waiter(saveButton,WebElement::click);
    }

    public String getTextFromCreatedcategory() {

        return driver.findElement(By.xpath(CREATED_CATEGORY_IN_LIST)).getText();

    }

    public void pressEditButtonForCategory() throws InterruptedException {
       waiter(editButtonForCategory,WebElement::click);
    }

    public void pressDeleteCategoryButton() throws InterruptedException {
        waiter(deleteCategoryButton,WebElement::click);
    }

    public void pressDelete() throws InterruptedException {
        waiter(delete,WebElement::click);
    }

    public void deleteCreatedCategory() throws InterruptedException {

        pressEditButtonForCategory();
        pressDeleteCategoryButton();
        pressDelete();
    }

    public void deleteCreatedResource() throws InterruptedException {
        waiter(createdResource,WebElement::click);
        clickEditButtonForCreatedResource();
        deleteButtonForCreatedResource();
        deleteButton2ForCreatedResource();
    }

    public void clickCreatedResource() throws InterruptedException {
        waiter(createdResource, WebElement::click);
    }

    public void clickEditButtonForCreatedResource() throws InterruptedException {
        waiter(editButtonForCreatedResource,WebElement::click);
    }

    public void deleteButtonForCreatedResource() throws InterruptedException {
        waiter(deleteButtonForCreatedResource, WebElement::click);
    }

    public void deleteButton2ForCreatedResource() throws InterruptedException {
        waiter(deleteButton2ForCreatedResource, WebElement::click);
    }

    public void addNewCategory() throws InterruptedException {
        pressAddButton(getAddResourceButton());
        selectToCreateNewCategory();
        enterNewCategoryName("New Test Category");
        pressSaveButton();
    }

    public void selectToCreateNewResource() throws InterruptedException {
        waiter(resourceButton,WebElement::click);
    }

    public Resources enterNewResourceName(String categoryNameValue) throws InterruptedException {
        waiter(fieldForResourceName,c-> c.sendKeys(categoryNameValue));
        return this;
    }

    public void pressDropDownButtonToSelectCategory() throws InterruptedException {
        waiter(dropDownButtonToSelectCategory,WebElement::click);
           }

    public Resources openResources() throws InterruptedException {
        driver.navigate().refresh();
        return this;
    }
    public Resources refreshResource () throws InterruptedException {
        driver.navigate().refresh();
        return this;
    }


}