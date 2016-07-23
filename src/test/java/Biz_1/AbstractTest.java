package Biz_1;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;

public abstract class AbstractTest {

    protected WebDriver driver;
    protected LandingPage landingPage;
    protected LogInPage logInPage;
    protected MobileBuilder mobileBuilder;
    protected Resources resources;
    protected Booking booking;
    protected GlobalSettings globalSettings;

    private static ChromeDriverService service;
    private static final String PATH_TO_CHROMEDRIVER_EXE = "C:\\Users\\egolub\\IdeaProjects\\BizTests\\driver\\chromedriver.exe";

   // public String setBrowser(String browser) {
      //  return driver.findElement(By.xpath(CREATED_CATEGORY_IN_LIST)).getText();

   // }

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
        driver = new ChromeDriver(service);

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

