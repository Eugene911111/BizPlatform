package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LogInPage {
    private WebDriver driver;

    //<<-----------------------------------FIELDS---------------------------------------------->>
    private final By emailLogInField = By.id("Email");
    private final By passLogInField = By.id("Password");
    private final By authoriseButton = By.id("sbmtBtn");

    //<<-----------------------------------String---------------------------------------------->>
    private static final String SEND_KEYS_TO_EMAIL_FIELD = "test.ncube@gmail.com";
    private static final String SEND_KEYS_TO_PASSWORD_FIELD = "249756210";

    public void enterEmailField() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(emailLogInField).clear();
        driver.findElement(emailLogInField).sendKeys(SEND_KEYS_TO_EMAIL_FIELD);
    }
    public void enterPassword() throws InterruptedException {
        driver.findElement(passLogInField).clear();
        driver.findElement(passLogInField).sendKeys(SEND_KEYS_TO_PASSWORD_FIELD);
    }
    public void pressAuthoriseButton() throws InterruptedException {
        driver.findElement(authoriseButton).click();
    }

    public void fillLogInForm() throws InterruptedException {
        enterEmailField();
        enterPassword();
        pressAuthoriseButton();
    }



    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }
}
