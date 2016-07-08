package Biz_1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewUserRegistration {
    private FirefoxDriver driver;
    private LandingPage landingPage;

    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        landingPage = new LandingPage(driver);
    }

    @org.junit.Test
    public void firstTest() throws InterruptedException {
        landingPage.openBizplatform();
        landingPage.pressRegisterButton();
        landingPage.registerRandomUser();
        Thread.sleep(3000);
        String actualEmailErrorMessage = landingPage.getText();
        String expectedErrorMessage = "Мы выслали письмо на указанный Вами электронный адрес. Пожалуйста, подтвердите регистрацию нажав ссылку в высланном письме";
        Assert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
        System.out.println("---------New user registration test passed successfully-------------- ");
    }

       @After
       public void postcondition() {
       driver.close();
    }

}
