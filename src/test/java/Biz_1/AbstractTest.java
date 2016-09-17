package Biz_1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractTest implements Constants {

    protected WebDriver driver;
    protected LandingPage landingPage;
    protected LogInPage logInPage;
    protected MobileBuilder mobileBuilder;
    protected Resources resources;
    protected Booking booking;
    protected GlobalSettings globalSettings;
    protected Specialists specialists;
    protected WorkingTime workingTime;
    protected PromoteOnSite promoteOnSite;
    protected static ChromeDriverService service;
    protected Catalogue catalogue;
    protected Offers offers;
    protected static final String PATH_TO_CHROMEDRIVER_EXE = "C:\\Users\\egolub\\IdeaProjects\\BizTests\\driver\\chromedriver.exe";
    String driverNAme = "firefox";

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh.mm.ss a ");
    public final String randScreenshotName = "D:\\screenshot\\" + ft.format(date) + getClass() + "Screenshot.jpg\\";

    //----FOR CHROME
    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(PATH_TO_CHROMEDRIVER_EXE))
                .usingAnyFreePort()
                .build();
        service.start();
    }


    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void precondition() {
        if (driverNAme == "chrome") {
            driver = new RemoteWebDriver(service.getUrl(),
                    DesiredCapabilities.chrome());
        } else if (driverNAme == "IE") {
            driver = new InternetExplorerDriver();
        } else {
            //Create object of FirefoxProfile in built class to access Its properties.
            FirefoxProfile fprofile = new FirefoxProfile();
            //Set Location to store files after downloading.
            fprofile.setPreference("browser.download.dir", "D:\\WebDriverdownloads");
            fprofile.setPreference("browser.download.folderList", 2);
            fprofile.setPreference("browser.startup.homepage", "http://bizplatform.co/");
            //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
            fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"//MIME types Of MS Excel File.
                            + "application/pdf;" //MIME types Of PDF File.
                            + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" //MIME types Of MS doc File.
                            + "text/plain;" //MIME types Of text File.
                            + "text/csv"); //MIME types Of CSV File.
            fprofile.setPreference("browser.download.manager.showWhenStarting", false);
            fprofile.setPreference("pdfjs.disabled", true);
            //Pass fprofile parameter In webdriver to use preferences to download file.
            driver = new FirefoxDriver(fprofile);


            //  driver = new FirefoxDriver();
        }
        (logInPage = new LogInPage()).setDriver(driver);
        (landingPage = new LandingPage()).setDriver(driver);
        (booking = new Booking()).setDriver(driver);
        (mobileBuilder = new MobileBuilder()).setDriver(driver);
        (globalSettings = new GlobalSettings()).setDriver(driver);
        (resources = new Resources()).setDriver(driver);
        (specialists = new Specialists()).setDriver(driver);
        (workingTime = new WorkingTime()).setDriver(driver);
        (promoteOnSite = new PromoteOnSite()).setDriver(driver);
        (catalogue = new Catalogue()).setDriver(driver);
        (offers = new Offers()).setDriver(driver);
    }

    @After
    public void testShutDown() {
        driver.close();
    }

}

