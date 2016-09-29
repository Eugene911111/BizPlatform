package Biz_1;
//Opennig time should be specified fro 00.00-23.59
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingCreationLoop {

    protected WebDriver driver;
    protected LandingPage landingPage;
    protected LogInPage logInPage;
    protected MobileBuilder mobileBuilder;
    protected Resources resources;
    protected Booking booking;
    protected GlobalSettings globalSettings;
    protected Specialists specialists;
    protected WorkingTime workingTime;
    protected static final Logger log = LoggerFactory.getLogger(MakingBooking.class);
    protected int rowsNumber = 89;
    protected int delta = 3; // change the number of bookings (delta-1)
    protected int p = rowsNumber - delta;
    protected int count = 1;


    @Before
    public void precondition() {

        driver = new FirefoxDriver();
        (logInPage = new LogInPage()).setDriver(driver);
        (landingPage = new LandingPage()).setDriver(driver);
        (booking = new Booking()).setDriver(driver);
        (mobileBuilder = new MobileBuilder()).setDriver(driver);
        (globalSettings = new GlobalSettings()).setDriver(driver);
        (resources = new Resources()).setDriver(driver);
        (specialists = new Specialists()).setDriver(driver);
        (workingTime = new WorkingTime()).setDriver(driver);

    }


    @Test
    public void bookingCreation() throws InterruptedException {

        for (int u = rowsNumber; u >= p; u--) {
            landingPage.openLogInPage();
            logInPage.logIn();
            By xpathSelector = By.xpath("//div[@class=\"k-scheduler-content listen-scroll\"]//tr[" + Integer.toString(u) + "]//td[@class=\"k-today k-nonwork-hour\"]");
            WebDriverWait waitbooking = new WebDriverWait(driver, 10);
            waitbooking.until(ExpectedConditions.visibilityOfElementLocated(xpathSelector));
            driver.findElement(xpathSelector).click();
            booking.sendKeysToElementWhenElementIsClickable(booking.clientNameField, booking.CLIENT_NAME);
            booking.waitForElementIsPresentAndClick(booking.phoneNumberField);
            booking.sendKeysToElementWhenElementIsClickable(booking.emailField, booking.EMAIL);
            booking.waitForElementIsPresentAndClick(booking.saveButton);
            log.debug("---------Booking # " + (count++) + " is made-------------- ");
            Thread.sleep(1500); //do not delete, it may not delete the booking
        }
    }

    @Test
    public void bookingsDelete() throws InterruptedException {
        for (int u = rowsNumber; u >= p; u--) {
            try {
                landingPage.openLogInPage();
                logInPage.logIn();
                booking.deleteBooking();
                System.out.println("Booking # " + (count++) + " deleted");
            } catch (Exception e) {
                return;
            }
        }
    }

    @After
    public void testShutDown() {
        driver.quit();
    }

}



