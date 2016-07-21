package Biz_1;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {

    protected WebDriver driver;
    protected LandingPage landingPage;
    protected LogInPage logInPage;
    protected MobileBuilder mobileBuilder;
    protected Resources resources;
    protected Booking booking;
    protected GlobalSettings globalSettings;


    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        (logInPage = new LogInPage()).setDriver(driver);
        (landingPage = new LandingPage()).setDriver(driver);
        (booking = new Booking()).setDriver(driver);
        (mobileBuilder = new MobileBuilder()).setDriver(driver);
        (globalSettings = new GlobalSettings()).setDriver(driver);
    }

    @After
    public void testShutDown() {
        driver.close();
    }

}
