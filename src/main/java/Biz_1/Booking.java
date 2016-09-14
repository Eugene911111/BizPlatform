package Biz_1;

import org.apache.xml.utils.ThreadControllerWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class Booking extends AbstractPageObject {
    //<<-----------------------------------BUTTONS---------------------------------------------->>
    private final By bookingField = By.xpath("//tr[@class=\"k-middle-row\"][24]/td");
    private final By clientNameField = By.name("client");
    private static final String CLIENT_NAME = "Eugene";
    private final By phoneNumberField = By.name("phone");
    private static final String PHONE_NUMBER = "+380957211613";
    private final By emailField = By.name("email");
    private static final String EMAIL = "golubeugene91155@gmail.com";
    protected final By saveButton = By.xpath("//button[@class=\"btn btn-default save text-uppercase ng-scope\"]//span[@class=\"ng-binding ng-scope\"]");
    protected final By booking1 = By.xpath("//div[@class=\"content-wrp ng-scope\"]//div[@class=\"client-icon-wrp\"]//label[@class=\"client ng-binding\"]\n");

    //    protected final By bookingWithMadeButton = By.xpath("//label[@class=\"client ng-binding\"]");
    protected final By bookingWithMadeButton = By.xpath("//div[@class=\"content-wrp ng-scope\"]");
    //div[@class="content-wrp ng-scope"]//i[@class="comment-flag fa fa-ellipsis-h ng-scope"]
    protected final By delete1Button = By.xpath("//button[@class=\"btn btn-default text-uppercase ng-binding ng-scope\"]");
    private final By delete2Button = By.xpath("//div[@class=\"k-widget k-window\"]//button[@class=\"ok btn btn-default text-uppercase ng-binding\"]");

    public Booking pressOnBookingField() throws InterruptedException {
        waiter(bookingField, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
        return this;
    }

    public Booking clickOnClientField() throws InterruptedException {
        waiter(clientNameField, c -> c.sendKeys(CLIENT_NAME), ExpectedConditions::presenceOfElementLocated, 10);
        return this;
    }

    public Booking clickOnTelephoneNumberField() throws InterruptedException {
        waiter(phoneNumberField, c -> c.sendKeys(PHONE_NUMBER), ExpectedConditions::presenceOfElementLocated, 10);
        return this;
    }

    public Booking clickOnEmailField() throws InterruptedException {
        waiter(emailField, c -> c.sendKeys(EMAIL), ExpectedConditions::presenceOfElementLocated, 10);
        return this;
    }

    public Booking pressSaveButton() throws InterruptedException {
        waiter(saveButton, WebElement::click, ExpectedConditions::elementToBeClickable, 15);
        return this;
    }

    public String getText() {
        return driver.findElement(booking1).getText();

    }

    public void deleteBooking() throws InterruptedException {
        // Thread.sleep(5000);
        // driver.findElement(bookingWithMadeButton).click();
        waiter(bookingWithMadeButton, WebElement::click, ExpectedConditions::presenceOfElementLocated, 15);
        waiter(delete1Button, WebElement::click, ExpectedConditions::elementToBeClickable, 15);
        waiter(delete2Button, WebElement::click, ExpectedConditions::presenceOfElementLocated, 15);
    }
}

