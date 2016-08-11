package Biz_1;

import lombok.Getter;
import org.openqa.selenium.*;

public class Specialists extends AbstractPageObject {
    private final By xxxxx = By.xpath(" ");
    public static final String SPECIALISTS_PAGE = "http://bizplatform.co/Venue/CommandCenter#/bookings/specialists";
    private @Getter final By addSpecialistButton = By.xpath("//i[@class=\"ion-plus\"]");
    private @Getter final By addCategoryButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@href=\"#/bookings/specialists/group/new\"]");
    private @Getter final By fieldForCategoryName = By.xpath("//input[@name=\"name\"]");
    private final By saveButton = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    private @Getter final By specialistButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@href=\"#/bookings/specialists/new\"]");
    private @Getter final By specialistName = By.xpath("//div[@class=\"input-row\"]//input[@type=\"text\"]");
    private final By editButtonForCategory = By.xpath("//span[@class=\"group-name ng-binding ng-scope\"][contains(., 'Specialist')]//following-sibling::*//i[@class=\"fa fa-pencil edit-group-icon\"]");
    private final By deleteCategoryButton = By.xpath("//div[@class=\"panel panel-default panel-open\"][contains(., 'Specialis')]//ul[@class=\"edit-dropdown dropdown-menu\"]//li[3]");
    private final By delete = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    private @Getter final By createdSpecialist = By.xpath("//section[@class=\"state-menu service-container scroll-body resources-menu ng-scope\"]//div[@class=\"reser-type ng-scope\"][contains(., 'Max')]");
    private @Getter final By editButtonForCreatedSpecialist = By.xpath("//section[@class=\"state-menu service-container scroll-body resources-menu ng-scope\"]//div[@class=\"reser-type ng-scope\"][contains(., 'Max')]/div[@id=\"resource-edit-button\"]");
    private final By deleteButtonForCreatedResource = By.xpath("//div[@class=\"buttons-block\"]//button[@class=\"btn ng-binding\"]");
    private final By deleteButton2ForCreatedResource = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-green ng-binding\"]");

    protected void getSpecialistsPage() throws InterruptedException {

        driver.get(SPECIALISTS_PAGE);
    }

   protected void addNewSpecialist() throws InterruptedException {
        waiter(getAddSpecialistButton(), WebElement::click);
    }
    protected void addNewCategory() throws InterruptedException {
        waiter(getAddCategoryButton(), WebElement::click);
    }
    protected Specialists enterNewCategoryName(String categoryNameValue) throws InterruptedException {
        waiter(fieldForCategoryName, c -> c.sendKeys("Max"));
        waiter(getFieldForCategoryName(),WebElement::sendKeys);
        driver.findElement(fieldForCategoryName).sendKeys(categoryNameValue);
        return this;
    }

    public void pressSaveButton() throws InterruptedException {
            waiter(saveButton,WebElement::click);
    }
    public void addSpecislist() throws InterruptedException {
        waiter(specialistButton,WebElement::click);
    }

    public void enterSpecialistName() throws InterruptedException {
        waiter(specialistName, c -> c.sendKeys("Max"));
    }

    public void pressEditForCategory() throws InterruptedException {
        waiter(editButtonForCategory,WebElement::click);
    }
    public void deleteCreatedCategory() throws InterruptedException {
        waiter(deleteCategoryButton,WebElement::click);
    }
    public void pressDelete() throws InterruptedException {
        waiter(delete,WebElement::click);
    }
    public void pressCreatedSpecialist() throws InterruptedException {
        waiter(createdSpecialist, WebElement::click);
    }
    public void pressEditButtonForCategory() throws InterruptedException {
        waiter(editButtonForCreatedSpecialist, WebElement::click);
    }

    public void deleteCreatedSpecialist() throws InterruptedException {
        waiter(deleteButtonForCreatedResource,WebElement::click);
    }

    public void pressDeleteCpecialist() throws InterruptedException {
        waiter(deleteButton2ForCreatedResource,WebElement::click);
    }









}