package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Booking {
    private WebDriver driver;
    //<<-----------------------------------BUTTONS---------------------------------------------->>
    private final By bookingButton = By.xpath("//span[contains(., 'Bookings')]//following-sibling::span[@class=\"tab-name ng-binding\"]");
    private final By mobileAppButton = By.xpath("//span[contains(., 'Mobile app')]//following-sibling::span[@class=\"tab-name ng-binding\"]");
    private final By toolsForBusinessButton = By.xpath("//span[contains(., 'Tools for business')]//following-sibling::span[@class=\"tab-name ng-binding\"]");
    private final By promoteButton = By.xpath("//span[contains(., 'Promote')]//following-sibling::span[@class=\"tab-name ng-binding\"]");
    private final By clientsButton = By.xpath("//span[contains(., 'Clients')]//following-sibling::span[@class=\"tab-name ng-binding\"]");
    private final By errorMessage = By.xpath("//span[contains (., 'Chosen cell is not available')]");
    private final By bookingField = By.xpath("//tr[@class=\"k-middle-row\"][10]/td");
    private final By clientNameField = By.name("client");
    private static final String CLIENT_NAME = "Eugene";
    private final By phoneNumberField = By.name("phone");
    private static final String PHONE_NUMBER = "+380957211613";
    private final By emailField = By.name("email");
    private static final String EMAIL = "golubeugene91155@gmail.com";
    private final By saveButton = By.xpath("//button[@class=\"btn btn-default save text-uppercase ng-scope\"]");
    private static final String BOOKING = "//label[@class=\"client ng-binding\"]";
    private final By bookingWithMadeButton = By.xpath("//label[@class=\"client ng-binding\"]");
    private final By delete1Button = By.xpath("//button[@class=\"btn btn-default delete text-uppercase ng-binding ng-scope\"]");
    private final By delete2Button = By.xpath("//div[@class=\"k-widget k-window\"]//button[@class=\"ok btn btn-default text-uppercase ng-binding\"]");

//не проверенно
    private final By date = By.xpath("//div[@class=\"main-menu-datepicker\"]//tr[@class=\"ng-scope\"][5]//span[contains(., '26')]");
    private final By firstBooking = By.xpath("html/body/div[5]/div/div/section/div/div/div[2]/div/div/div[1]/table/tbody/tr[2]/td[2]/div/table/tbody/tr[57]/td[1]");
    private final By weekButton = By.xpath(".//*[@id='managerApp']/div/ul[2]/li[3]/a");


    public Booking pressOnBooking() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(bookingField).click();
        //driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return this;
    }
    public Booking clickOnClientField() throws InterruptedException {
        driver.findElement(clientNameField).click();
        driver.findElement(clientNameField).sendKeys(CLIENT_NAME);
        return this;
    }

    public Booking clickOnTelephoneNumberField() throws InterruptedException {
        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).sendKeys(PHONE_NUMBER);
        return this;
    }

    public Booking clickOnEmailField() throws InterruptedException {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(EMAIL);
        return this;
    }
    public Booking pressSaveButton() throws InterruptedException {
        driver.findElement(saveButton).click();
        return this;
    }
    public String getTextt() {
        return  driver.findElement(By.xpath(BOOKING)).getText();
    }

    public Booking deleteBooking() throws InterruptedException {
        driver.findElement(bookingWithMadeButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(delete1Button).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(delete2Button).click();


        return this;
    }

    public void pressWeekButton()throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(weekButton).click();
    }
    public Booking(WebDriver driver) {
        this.driver = driver;
    }
}

