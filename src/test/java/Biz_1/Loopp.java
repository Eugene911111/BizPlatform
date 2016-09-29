package Biz_1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Loopp {

    protected WebDriver driver;
    protected LandingPage landingPage;
    protected LogInPage logInPage;
    protected MobileBuilder mobileBuilder;
    protected Resources resources;
    protected Booking booking;
    protected GlobalSettings globalSettings;
    protected Specialists specialists;
    protected WorkingTime workingTime;


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

    @Test
    public void test() throws InterruptedException {
        for (int i = 1; i <= 8; i++) {
            landingPage.openUrl(landingPage.BIZPLATFORM_MAIN);
            landingPage.waitForElementIsPresentAndClick(landingPage.registerButton);
            landingPage.registerRandomUser();
            String actualEmailErrorMessage = landingPage.getTextFromElement(landingPage.registrationWindow);
            String expectedErrorMessage = "Мы выслали письмо на указанный Вами электронный адрес. Пожалуйста, подтвердите регистрацию нажав ссылку в высланном письме";
            Assert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
            System.out.println("--------- New user registration test # " + i + " passed successfully -------------- ");
        }
    }
}
