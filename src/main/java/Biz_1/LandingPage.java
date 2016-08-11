package Biz_1;

import com.gargoylesoftware.htmlunit.WebAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LandingPage extends AbstractPageObject {
    //<<-----------------------------------BUTTONS---------------------------------------------->>
    private final By logInButton = By.xpath("//div[@id=\"wrap\"]//a[@class=\"login\"]");
    private final By registerButton = By.xpath(".//*[@id='nav']//a[@href=\"#join\"]");
    private final By tryForFreeButton = By.xpath("//button[@ng-click=\"vm.register()\"]");
    private final By bookingButton = By.xpath("//span[contains(., 'Booking')]//following-sibling::span[@class=\"tab-name ng-binding\"]");
    //<<-----------------------------------FIELDS---------------------------------------------->>
    private final By registrationNameField = By.id("joinName");
    private final By registrationEmailField = By.name("UserEmail");
    private final By registrationPasswordField = By.name("Password");
    private final By registrationConfirmationPasswordField = By.name("ConfirmPassword");
    //<<-----------------------------------String---------------------------------------------->>
    private static final String BIZPLATFORM_MAIN = "http://bizplatform.co/";
    private static final String SEND_RANDOM_KEYS_TO_REGISTRATION_EMAIL_FIELD = "test.ncube" + Math.random() + "@gmail.com";
    private static final String SEND_KEYS_TO_REGISTRATION_NAME_FIELD = "I_am_test";
    private static final String SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD = "249756210";
    protected   final By registrationWindow = By.xpath("//div[@class='gray-border']//following-sibling::p");

    public String getTextFromLocator(By element1) throws InterruptedException {
        WebDriverWait element = new WebDriverWait(driver, 10);
        Boolean until = element.until(
                (ExpectedCondition<Boolean>) d -> !d.findElement(element1).getText().equals(""));

        return until ? driver.findElement(element1).getText() : "----";

    }

    public LandingPage openBizpPlatform() {
        driver.manage().window().maximize();
        driver.get(BIZPLATFORM_MAIN);
        return this;
    }

    public void pressLogInButton() throws InterruptedException {
        waiter(logInButton, WebElement::click);
    }

    public void pressRegisterButton() throws InterruptedException {
        waiter(registerButton, WebElement::click);
    }

    public void registerRandomUser() throws InterruptedException {
        waiter(registrationNameField, WebElement::click);
        waiter(registrationNameField, WebElement::clear);
        waiter(registrationNameField, c -> c.sendKeys(SEND_KEYS_TO_REGISTRATION_NAME_FIELD));
        waiter(registrationEmailField, WebElement::clear);
        waiter(registrationEmailField, c -> c.sendKeys(SEND_RANDOM_KEYS_TO_REGISTRATION_EMAIL_FIELD));
        waiter(registrationPasswordField,WebElement::clear);
        waiter(registrationPasswordField, c -> c.sendKeys(SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD));
        waiter(registrationConfirmationPasswordField,WebElement::clear);
        waiter(registrationConfirmationPasswordField, c-> c.sendKeys(SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD));
        waiter(tryForFreeButton, WebElement::click);

    }

    public void openLogInPage() throws InterruptedException {
        openBizpPlatform().pressLogInButton();
    }






}