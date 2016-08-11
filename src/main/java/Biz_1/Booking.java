package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private final By saveButton = By.xpath("//button[@class=\"btn btn-default save text-uppercase ng-scope\"]");
    protected final By booking1 = By.xpath("//div[@class=\"content-wrp ng-scope\"]//div[@class=\"client-icon-wrp\"]//label[@class=\"client ng-binding\"]\n");

    protected final By bookingWithMadeButton = By.xpath("//label[@class=\"client ng-binding\"]");
    private final By delete1Button = By.xpath("//button[@class=\"btn btn-default delete text-uppercase ng-binding ng-scope\"]");
    private final By delete2Button = By.xpath("//div[@class=\"k-widget k-window\"]//button[@class=\"ok btn btn-default text-uppercase ng-binding\"]");

    //не проверенно
    private final By date = By.xpath("//div[@class=\"main-menu-datepicker\"]//tr[@class=\"ng-scope\"][5]//span[contains(., '26')]");
    private final By weekButton = By.xpath(".//*[@id='managerApp']/div/ul[2]/li[3]/a");


    public Booking pressOnBookingField() throws InterruptedException {
        waiter(bookingField, WebElement::click);
        return this;
    }

    public Booking clickOnClientField() throws InterruptedException {
        waiter(clientNameField, c -> c.sendKeys(CLIENT_NAME));
        return this;
    }

    public Booking clickOnTelephoneNumberField() throws InterruptedException {
        waiter(phoneNumberField, c -> c.sendKeys(PHONE_NUMBER));
        return this;
    }

    public Booking clickOnEmailField() throws InterruptedException {
        waiter(emailField, c -> c.sendKeys(EMAIL));
        return this;
    }

    public Booking pressSaveButton() throws InterruptedException {
        waiter(saveButton, WebElement::click);
        return this;
    }

    // sdfksfjlkj
    public String getText() {
        // WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(BOOKING)));
        return driver.findElement(booking1).getText();

    }

    public Booking deleteBooking() throws InterruptedException {
        waiter(bookingWithMadeButton, WebElement::click);
        waiter(delete1Button, WebElement::click);
        waiter(delete2Button, WebElement::click);
        return this;
    }

    public void pressWeekButton() throws InterruptedException {
        waiter(weekButton,WebElement::click);
    }
}

