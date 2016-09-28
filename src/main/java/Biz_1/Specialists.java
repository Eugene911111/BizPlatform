package Biz_1;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Specialists extends AbstractPageObject {
    public static final String SPECIALISTS_PAGE = "http://bizplatform.co/Venue/CommandCenter#/bookings/specialists";
    protected
    @Getter
    final By addSpecialistButton = By.xpath("//i[@class=\"ion-plus\"]");
    protected
    @Getter
    final By addCategoryButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@href=\"#/bookings/specialists/group/new\"]");
    protected
    @Getter
    final By fieldForCategoryName = By.xpath("//input[@name=\"name\"]");
    protected final By saveButton = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    protected
    @Getter
    final By specialistButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@href=\"#/bookings/specialists/new\"]");
    @Getter
    protected final By specialistName = By.xpath("//div[@class=\"input-row\"]//input[@type=\"text\"]");
    protected final By editButtonForCategory = By.xpath("//span[@class=\"group-name ng-binding ng-scope\"][contains(., 'Specialist')]//following-sibling::*//i[@class=\"fa fa-pencil edit-group-icon\"]");
    protected final By deleteCategoryButton = By.xpath("//div[@class=\"panel panel-default panel-open\"][contains(., 'Specialis')]//ul[@class=\"edit-dropdown dropdown-menu\"]//li[3]");
    protected final By delete = By.xpath("//button[@class=\"btn btn-green ng-binding\"]");
    protected
    @Getter
    final By createdSpecialist = By.xpath("//section[@class=\"state-menu service-container scroll-body resources-menu ng-scope\"]//div[@class=\"reser-type ng-scope\"][contains(., 'Max')]");
    protected
    @Getter
    final By editButtonForCreatedSpecialist = By.xpath("//section[@class=\"state-menu service-container scroll-body resources-menu ng-scope\"]//div[@class=\"reser-type ng-scope\"][contains(., 'Max')]/div[@id=\"resource-edit-button\"]");
    protected final By deleteButtonForCreatedResource = By.xpath("//div[@class=\"buttons-block\"]//button[@class=\"btn ng-binding\"]");
    protected final By deleteButton2ForCreatedResource = By.xpath("//div[@class=\"modal-footer\"]//button[@class=\"btn btn-green ng-binding\"]");

    protected Specialists enterNewCategoryName(String categoryNameValue) throws InterruptedException {
        waiter(fieldForCategoryName, c -> c.sendKeys("Max"), ExpectedConditions::elementToBeClickable, 10);
        waiter(getFieldForCategoryName(), WebElement::sendKeys, ExpectedConditions::elementToBeClickable, 10);
        driver.findElement(fieldForCategoryName).sendKeys(categoryNameValue);
        return this;
    }
}