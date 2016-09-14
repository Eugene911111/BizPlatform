package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by egolub on 8/8/2016.
 */
public class WorkingTime extends AbstractPageObject {

    private final By workingTime = By.xpath("//div[@class=\"k-scheduler-content iScroll listen-scroll\"]//table[@class=\"k-scheduler-table\"]//following-sibling::div[@role=\"gridcell\"][1]");
    protected static final String WORKINGTIME_PAGE = "http://bizplatform.co/Venue/CommandCenter#/bookings/workingTime";
    private final By deleteWorkingTimeButton = By.xpath("//button[@class=\"btn btn-default delete text-uppercase ng-binding ng-scope\"]");
    private final By fieldForSettingWorkingTime = By.xpath("//tr[@class=\"k-middle-row\"][23]/td[1]");
    protected final By saveButtonn = By.xpath("//div[@class=\"panel-wrp\"]//button[@class=\"btn btn-success text-uppercase ng-binding\"]");
    private final By saveChangingButton = By.xpath("//div[@class=\"k-widget k-window wt-app-editor\"]//div[@class=\"action-panel\"]//button[@class=\"btn btn-default save text-uppercase ng-binding\"]");
    private final By fieldForOpeningTimeHour = By.xpath("//table[@class=\"editor-timepicker ng-isolate-scope ng-valid ng-valid-time\"][1]//td[@class=\"form-group\"]/input[@ng-model=\"hours\"]");
    private final By fieldForOpeningTimeHour1 = By.xpath("//div[@class=\"k-widget k-window wt-app-editor\"]//div[@class=\"time-wrp col-xs-12\"]//table[@class=\"editor-timepicker ng-isolate-scope ng-dirty ng-valid-parse ng-invalid ng-invalid-time\"]//input[@class=\"form-control text-center ng-valid ng-valid-maxlength ng-dirty ng-touched ng-valid-parse\"]");
    private static final String valueOfSettingTimeHour = "10";
    private static final String VALUE_OF_SETTING_MINUTE = "3";
    private final By fieldForOpeningTimeMinute = By.xpath("//table[@class=\"editor-timepicker ng-isolate-scope ng-dirty ng-valid-parse ng-valid ng-valid-time\"]//input[@class=\"form-control text-center ng-pristine ng-valid ng-valid-maxlength ng-touched\"]");


    public void pressWorkingTime() throws InterruptedException {
        waiter(workingTime, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void deleteWorkingTime() throws InterruptedException {
        waiter(deleteWorkingTimeButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void pressSaveChanges() throws InterruptedException {
        waiter(saveChangingButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void pressOnFieldForSettingTime() throws InterruptedException {
        waiter(fieldForSettingWorkingTime, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void saveChanges() throws InterruptedException {
        Thread.sleep(2000);
        waiter(saveButtonn, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void checkElementIsDisplayed(By element) throws InterruptedException {
        waiter(element, WebElement::isDisplayed, ExpectedConditions::elementToBeClickable, 10);
    }

    protected void sendKeysToOpeningTimeHours() throws InterruptedException {
        waiter(fieldForOpeningTimeHour, WebElement::clear, ExpectedConditions::elementToBeClickable, 10);
        findElementsAndSendKeys(fieldForOpeningTimeHour1, valueOfSettingTimeHour);
        // waiterElementtoBeClickable(fieldForOpeningTimeHour1, c -> c.sendKeys(valueOfSettingTimeHour));
        //findElementsAndSendKeys(fieldForOpeningTimeHour, valueOfSettingTimeHour);
    }

    protected void sendKeysToOpeningTimeMinuts() throws InterruptedException {
        waiter(fieldForOpeningTimeMinute, WebElement::clear, ExpectedConditions::elementToBeClickable, 10);
        findElementsAndSendKeys(fieldForOpeningTimeMinute, VALUE_OF_SETTING_MINUTE);
    }

    protected void sendKeysToCloseTimeHours(By element) throws InterruptedException {
        waiter(element, WebElement::isDisplayed, ExpectedConditions::elementToBeClickable, 10);
    }

    protected void sendKeysToCloseTimeMinuts(By element) throws InterruptedException {
        waiter(element, WebElement::isDisplayed, ExpectedConditions::elementToBeClickable, 10);
    }
}
