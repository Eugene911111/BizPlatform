package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by egolub on 8/8/2016.
 */
public class WorkingTime extends AbstractPageObject {

    protected final By workingTimeButton = By.xpath("//div[@class=\"k-scheduler-content iScroll listen-scroll\"]//table[@class=\"k-scheduler-table\"]//following-sibling::div[@role=\"gridcell\"][1]");
    protected final String WORKING_TIME_PAGE = "http://bizplatform.co/Venue/CommandCenter#/bookings/workingTime";
    protected final By deleteWorkingTimeButton = By.xpath("//button[@class=\"btn btn-default delete text-uppercase ng-binding ng-scope\"]");
    protected final By fieldForSettingWorkingTime = By.xpath("//tr[@class=\"k-middle-row\"][23]/td[1]");
    private final By saveButtonn = By.xpath("//div[@class=\"panel-wrp\"]//button[@class=\"btn btn-success text-uppercase ng-binding\"]");
    protected final By saveChangingButton = By.xpath("//div[@class=\"k-widget k-window wt-app-editor\"]//div[@class=\"action-panel\"]//button[@class=\"btn btn-default save text-uppercase ng-binding\"]");
    protected final By fieldForOpeningTimeHour1 = By.xpath("//div[@class=\"k-widget k-window wt-app-editor\"]//div[@class=\"time-wrp col-xs-12\"]//table[@class=\"editor-timepicker ng-isolate-scope ng-dirty ng-valid-parse ng-invalid ng-invalid-time\"]//input[@class=\"form-control text-center ng-valid ng-valid-maxlength ng-dirty ng-touched ng-valid-parse\"]");
    protected static final String valueOfSettingTimeHour = "10";
    protected final By firstDayOfTheWeek = By.xpath("//div[@class=\"k-scheduler-header-wrap iScroll\"]//th[@class=\"k-slot-cell\"][1]");
    protected final By week = By.xpath("//label[@class=\"working-time-month-label ng-binding\"]");
    protected final By lastDayOfTheWeek = By.xpath("//div[@class=\"k-scheduler-header-wrap iScroll\"]//th[@class=\"k-slot-cell\"][7]");
    protected final By arrowRight = By.xpath("//i[@class=\"fa fa-angle-right\"]//parent::button[@class=\"btn btn-default navigation-btn\"]");
    protected final By todayButton = By.xpath("//li[@class=\"k-state-default k-header k-nav-today\"]");
    protected final By todayButtonOnWorkingTime = By.xpath("//button[@ng-click=\"schedulerCtrl.today()\"]");
    protected final By firstDayInColumn = By.xpath("//div[@class=\"k-scheduler-header k-state-default\"]//th[@class=\"k-slot-cell\"][1]");


    public void saveChanges() throws InterruptedException  {
        Thread.sleep(2000);
        waitForElementIsClickableAndClick(saveButtonn);
    }
}
