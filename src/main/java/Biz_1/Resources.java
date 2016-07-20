package Biz_1;

import org.openqa.selenium.By;

public class Resources extends AbstractPageObject {
    private final By addResourceButton = By.xpath("//i[@class=\"ion-plus\"]");
    private final By categoryButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@class=\"ng-binding ng-scope\"][contains(., 'Category')]");
    private final By resourceButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@class=\"ng-binding ng-scope\"][contains(., 'Resource')]");
    private final By fieldForResourceName = By.xpath("//div[@class=\"input-row\"]//input[@type=\"text\"]");
    private final By fieldForCategoryName = By.xpath("//input[@name=\"name\"]");
    private final By dropDownButtonToSelectCategory = By.xpath("//div[@class=\"input-row\"]//span[@class=\"custom-select-wrapper\"]/select//option[@label=\"New Test Category\"]");
    private static final String CREATED_CATEGORY_IN_LIST = "//span[@class=\"group-name ng-binding ng-scope\"][contains(., 'New Test Category')]";
    private final By editButtonForCategory = By.xpath("//span[@class=\"group-name ng-binding ng-scope\"][contains(., 'r')]//following-sibling::*//i[@class=\"fa fa-pencil edit-group-icon\"]");
    private final By saveButton = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    private final By deleteCategoryButton = By.xpath("//div[@class=\"panel panel-default panel-open\"][contains(., 'New Test Category')]//ul[@class=\"edit-dropdown dropdown-menu\"]//li[3]");
    private final By createdResource = By.xpath(" //div[@class=\"list-content\"]/div[@class=\"type-small-info selected\"]//span[@class=\"specialist-name ng-binding\"][contains(., 'NEW TEST RESOURCE')]");
    private final By delete = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    private final By editButtonForCreatedResource = By.xpath("//div[@class=\"reser-type ng-scope\"]//div[@class=\"edit-pencil edit-display\"]");
    private final By deleteButtonForCreatedResource = By.xpath("//div[@class=\"buttons-block\"]//button[@class=\"btn ng-binding\"]");
    private final By deleteButton2ForCreatedResource = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-green ng-binding\"]");

    private static final String RESOURSES_PAGE = "http://bizplatform.co/Venue/CommandCenter#/bookings/resources";

    public Resources openResources() {
        driver.get(RESOURSES_PAGE);
        return this;
    }

    public void pressAddButton() throws InterruptedException {
        findElementsAndClick(addResourceButton);
    }

    public void selectToCreateNewCategory() throws InterruptedException {
        findElementsAndClick(categoryButton);
    }

    public Resources enterNewCategoryName(String categoryNameValue) throws InterruptedException {
        driver.findElement(fieldForCategoryName).sendKeys(categoryNameValue);
        return this;
    }

    public void pressSaveButton() throws InterruptedException {
        findElementsAndClick(saveButton);
    }

    public String getTextFromCreatedcategory() {
        return driver.findElement(By.xpath(CREATED_CATEGORY_IN_LIST)).getText();

    }

    public void pressEditButtonForCategory() throws InterruptedException {
        findElementsAndClick(editButtonForCategory);
    }

    public void pressDeleteCategoryButton() throws InterruptedException {
        driver.findElement(deleteCategoryButton).click();
    }

    public void pressDelete() throws InterruptedException {
        findElementsAndClick(delete);
    }

    public void deleteCreatedCategory() throws InterruptedException {
        pressEditButtonForCategory();
        pressDeleteCategoryButton();
        pressDelete();
    }

    public void deleteCreatedResource() throws InterruptedException {
        clickCreatedResource();
        clickEditButtonForCreatedResource();
        deleteButtonForCreatedResource();
        deleteButton2ForCreatedResource();
    }

    public void clickCreatedResource() throws InterruptedException {
        findElementsAndClick(createdResource);
    }

    public void clickEditButtonForCreatedResource() throws InterruptedException {
        findElementsAndClick(editButtonForCreatedResource);
    }

    public void deleteButtonForCreatedResource() throws InterruptedException {
        findElementsAndClick(deleteButtonForCreatedResource);
    }

    public void deleteButton2ForCreatedResource() throws InterruptedException {
        findElementsAndClick(deleteButton2ForCreatedResource);
    }

    public void addNewCategory() throws InterruptedException {
        pressAddButton();
        selectToCreateNewCategory();
        enterNewCategoryName("New Test Category");
        pressSaveButton();
    }

    public void selectToCreateNewResource() throws InterruptedException {
        findElementsAndClick(resourceButton);
    }

    public Resources enterNewResourceName(String categoryNameValue) throws InterruptedException {
        driver.findElement(fieldForResourceName).sendKeys(categoryNameValue);
        return this;
    }

    public void pressDropDownButtonToSelectCategory() throws InterruptedException {
        Thread.sleep(2000);
        findElementsAndClick(dropDownButtonToSelectCategory);
    }

    public Resources refreshResources() throws InterruptedException {
        driver.navigate().refresh();
        return this;
    }


}