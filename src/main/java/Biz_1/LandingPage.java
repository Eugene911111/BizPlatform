package Biz_1;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;
public class LandingPage extends AbstractPageObject {
    //<<-----------------------------------BUTTONS---------------------------------------------->>
    private final By logInButton = By.xpath(".//*[@id='nav']/div/nav/div[2]/div/ul/li[7]/a");
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
    private static final String REGISTRATION_WINDOW = "//div[@class='gray-border']//following-sibling::p";
    private static final String BOOKING_BUTTON = ("//span[@class=\"ng-binding\"]//div[@class=\"heading-wrapper ng-scope\"]//span"); ////rewright selector

    public String getText() {
        return driver.findElement(By.xpath(REGISTRATION_WINDOW)).getText();
    }

    public LandingPage openBizpPlatform() {
        driver.manage().window().maximize();
        driver.get(BIZPLATFORM_MAIN);
        return this;
    }

    public void pressLogInButton() throws InterruptedException {
        driver.findElement(logInButton).click();
    }

    public void pressRegisterButton() throws InterruptedException {
        findElementsAndClick(registerButton);
    }

    public void registerRandomUser() throws InterruptedException {
        implicitlyWait(3, TimeUnit.SECONDS);
        findElementsAndClear(registrationNameField);
        findElementsAndSendKeys(registrationNameField, SEND_KEYS_TO_REGISTRATION_NAME_FIELD);
        findElementsAndClear(registrationEmailField);
        findElementsAndSendKeys(registrationEmailField, SEND_RANDOM_KEYS_TO_REGISTRATION_EMAIL_FIELD);
        findElementsAndClear(registrationPasswordField);
        findElementsAndSendKeys(registrationPasswordField, SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD);
        findElementsAndClear(registrationConfirmationPasswordField);
        findElementsAndSendKeys(registrationConfirmationPasswordField, SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD);
        findElementsAndClick(tryForFreeButton);
        try {
            //try something
        } catch(Exception e){
            //Actual logging of error
            logger.error("some message", e);
        }
    }

    public void checkBookingButtonIsDisplayed() throws InterruptedException {
        if ((driver.findElement(bookingButton)).isDisplayed()) {

            System.out.println("User Logged In successfully");
        }
    }

    public void openLogInPage() throws InterruptedException {
        openBizpPlatform().pressLogInButton();
    }






}