package Biz_1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class AbstractTest {

    protected WebDriver driver;
    protected LandingPage landingPage;
    protected LogInPage logInPage;
    protected MobileBuilder mobileBuilder;
    protected Resources resources;
    protected Booking booking;
    protected GlobalSettings globalSettings;
    protected Specialists specialists;
    protected WorkingTime workingTime;
    protected static ChromeDriverService service;
    protected static final String PATH_TO_CHROMEDRIVER_EXE = "C:\\Users\\egolub\\IdeaProjects\\BizTests\\driver\\chromedriver.exe";

    protected static final Logger log = LoggerFactory.getLogger(MakingBooking.class);
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh.mm.ss a ");
    public final String randScreenshotName = "D:\\screenshot\\" + ft.format(date)+ getClass() + "Screenshot.jpg\\";
    //----FOR CHROME
//    @BeforeClass
//    public static void createAndStartService() throws IOException {
//        service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File(PATH_TO_CHROMEDRIVER_EXE))
//                .usingAnyFreePort()
//                .build();
//        service.start();
//    }
//
//    @AfterClass
//    public static void createAndStopService() {
//        service.stop();
//    }


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

    @After
    public void testShutDown() {
        driver.close();
    }

}

