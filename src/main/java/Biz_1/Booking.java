package Biz_1;

import org.apache.xml.utils.ThreadControllerWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Booking extends AbstractPageObject {
    //<<-----------------------------------BUTTONS---------------------------------------------->>
    protected final By bookingField = By.xpath("//tr[@class=\"k-middle-row\"][24]/td");
    protected final By clientNameField = By.name("client");
    protected final String CLIENT_NAME = "Eugene";
    protected final By phoneNumberField = By.name("phone");
    protected final String PHONE_NUMBER = "+380957211613";
    protected final By emailField = By.name("email");
    protected final String EMAIL = "golubeugene91155@gmail.com";
    protected final By saveButton = By.xpath("//button[@class=\"btn btn-default save text-uppercase ng-scope\"]//span[@class=\"ng-binding ng-scope\"]");
    protected final By booking1 = By.xpath("//div[@class=\"content-wrp ng-scope\"]//div[@class=\"client-icon-wrp\"]//label[@class=\"client ng-binding\"]\n");
    protected final By bookingWithMadeButton = By.xpath("//div[@class=\"content-wrp ng-scope\"]");
    protected final By delete1Button = By.xpath("//div[@class=\"control-panel-wrp col-xs-12 ng-scope\"]//button[@class=\"btn btn-default text-uppercase ng-binding ng-scope\"]");
    private final By delete2Button = By.xpath("//div[@class=\"k-widget k-window\"]//button[@class=\"ok btn btn-default text-uppercase ng-binding\"]");
    protected final By currentDate = By.xpath("//div[@class=\"k-floatwrap k-header k-scheduler-toolbar\"]//li[@class=\"k-state-default k-nav-current\"]");

    public void deleteBooking() throws InterruptedException {
        waitForElementIsPresentAndClick(bookingWithMadeButton);
        waitForElementIsPresentAndClick(delete1Button);
        waitForElementIsClickableAndClick(delete2Button);
    }
}

