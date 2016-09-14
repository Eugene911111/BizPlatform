package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends AbstractPageObject {
    //<<-----------------------------------BUTTONS---------------------------------------------->>
    private final By logInButton = By.xpath("//div[@id=\"wrap\"]//a[@class=\"login\"]");
    private final By registerButton = By.xpath(".//*[@id='nav']//a[@href=\"#join\"]");
    private final By tryForFreeButton = By.xpath("//button[@ng-click=\"vm.register()\"]");
    private final By bookingButton = By.xpath("//span[contains(., 'Booking')]//following-sibling::span[@class=\"tab-name ng-binding\"]");
    protected final By userButton = By.xpath("//div[@class=\"btn-group dropdown\"]//button[@id=\"single-button\"]");
    private final By logOutButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@ng-click=\"command.logout()\"]");


    //<<-----------------------------------FIELDS---------------------------------------------->>
    private final By registrationNameField = By.id("joinName");
    private final By registrationEmailField = By.name("UserEmail");
    private final By registrationPasswordField = By.name("Password");
    private final By registrationConfirmationPasswordField = By.name("ConfirmPassword");

    //<<-----------------------------------String---------------------------------------------->>
    private static final String BIZPLATFORM_MAIN = "http://bizplatform.co/";
    private String SEND_RANDOM_KEYS_TO_REGISTRATION_EMAIL_FIELD = "test.ncube" + Math.random() + "@gmail.com";
    private static final String SEND_KEYS_TO_REGISTRATION_NAME_FIELD = "I_am_test";
    private static final String SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD = "249756210";
    protected final By registrationWindow = By.xpath("//div[@class='gray-border']//following-sibling::p");

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
        waiter(logInButton, WebElement::click, ExpectedConditions::presenceOfElementLocated, 10);

    }

    public void pressRegisterButton() throws InterruptedException {
        waiter(registerButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);

    }

    public void registerRandomUser() throws InterruptedException {
        waiter(registrationNameField, WebElement::click, ExpectedConditions::elementToBeClickable, 10);

        waiter(registrationNameField, WebElement::clear, ExpectedConditions::elementToBeClickable, 10);

        waiter(registrationNameField, c -> c.sendKeys(SEND_KEYS_TO_REGISTRATION_NAME_FIELD), ExpectedConditions::elementToBeClickable, 10);

        waiter(registrationEmailField, WebElement::clear, ExpectedConditions::elementToBeClickable, 10);

        waiter(registrationEmailField, c -> c.sendKeys("test.ncube" + Math.random() + 0.1 + "@gmail.com"), ExpectedConditions::elementToBeClickable, 10);


        waiter(registrationPasswordField, WebElement::clear, ExpectedConditions::elementToBeClickable, 10);

        waiter(registrationPasswordField, c -> c.sendKeys(SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD), ExpectedConditions::elementToBeClickable, 10);

        waiter(registrationConfirmationPasswordField, WebElement::clear, ExpectedConditions::elementToBeClickable, 10);

        waiter(registrationConfirmationPasswordField, c -> c.sendKeys(SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD), ExpectedConditions::elementToBeClickable, 10);

        waiter(tryForFreeButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);

    }

    public void openLogInPage() throws InterruptedException {
        openBizpPlatform().pressLogInButton();
    }
    public void pressUserButton() throws InterruptedException {
        waiter(userButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }
    public void pressLogOutButton() throws InterruptedException {
        waiter(logOutButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

}