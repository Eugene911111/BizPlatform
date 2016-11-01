package Biz_1;

import org.openqa.selenium.By;

public class LandingPage extends AbstractPageObject {
    //<<-----------------------------------BUTTONS---------------------------------------------->>
    protected final By logInButton = By.xpath("//div[@id=\"wrap\"]//a[@class=\"login\"]");
    protected final By registerButton = By.xpath(".//*[@id='nav']//a[@href=\"#join\"]");
    protected final By tryForFreeButton = By.xpath("//button[@ng-click=\"vm.register()\"]");
    protected final By userButton = By.xpath("//button[@id=\"single-button\"]");
    protected final By logOutButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@ng-click=\"command.logout()\"]");


    //<<-----------------------------------FIELDS---------------------------------------------->>
    protected final By registrationNameField = By.id("joinName");
    protected final By registrationEmailField = By.name("UserEmail");
    protected final By registrationPasswordField = By.name("Password");
    protected final By registrationConfirmationPasswordField = By.name("ConfirmPassword");

    //<<-----------------------------------String---------------------------------------------->>
    protected final String BIZPLATFORM_MAIN = "http://bizplatform.co/";
    protected final String SEND_KEYS_TO_REGISTRATION_NAME_FIELD = "I_am_test";
    protected final String SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD = "249756210";
    protected final By registrationWindow = By.xpath("//div[@class='gray-border']//following-sibling::p");
    protected String randomUserEmail = ("golubeugene91155+" + Math.random() + 0.1 + "@gmail.com");
    protected final By bizplatformLogo = By.xpath("//section[@class=\"row-fluid\"]//img[@class=\"bizplatform-logo\"]");



//    public String getTextFromLocator(By element1) throws InterruptedException {
//        WebDriverWait element = new WebDriverWait(driver, 10);
//        Boolean until = element.until(
//                (ExpectedCondition<Boolean>) d -> !d.findElement(element1).getText().equals(""));
//        return until ? driver.findElement(element1).getText() : "----";
//    }

    public void registerRandomUser() throws InterruptedException {
        waitForElementIsClickableAndClick(registrationNameField);
        waitForElementIsClickableAndClick(registrationNameField);
        sendKeysToElementWhenElementIsClickable(registrationNameField, SEND_KEYS_TO_REGISTRATION_NAME_FIELD);
        waitForElementIsClickableAndClick(registrationEmailField);
        sendKeysToElementWhenElementIsClickable(registrationEmailField, (randomUserEmail));
        waitForElementIsClickableAndClick(registrationPasswordField);
        sendKeysToElementWhenElementIsClickable(registrationPasswordField, SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD);
        waitForElementIsClickableAndClick(registrationConfirmationPasswordField);
        sendKeysToElementWhenElementIsClickable(registrationConfirmationPasswordField, SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD);
        waitForElementIsClickableAndClick(tryForFreeButton);
    }

    public void openLogInPage() throws InterruptedException {
        openUrl(BIZPLATFORM_MAIN);
        waitForElementIsPresentAndClick(logInButton);
    }
}