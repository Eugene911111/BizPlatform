package Biz_1;

import org.openqa.selenium.By;

public class LandingPage extends AbstractPageObject {
    //<<-----------------------------------BUTTONS---------------------------------------------->>
    protected final By logInButton = By.xpath("//div[@id=\"wrap\"]//a[@class=\"login\"]");
    protected final By registerButton = By.xpath(".//*[@id='nav']//a[@href=\"#join\"]");
    private final By tryForFreeButton = By.xpath("//button[@ng-click=\"vm.register()\"]");
    protected final By userButton = By.xpath("//div[@class=\"btn-group dropdown\"]//button[@id=\"single-button\"]");
    protected final By logOutButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@ng-click=\"command.logout()\"]");

    //<<-----------------------------------FIELDS---------------------------------------------->>
    private final By registrationNameField = By.id("joinName");
    private final By registrationEmailField = By.name("UserEmail");
    private final By registrationPasswordField = By.name("Password");
    private final By registrationConfirmationPasswordField = By.name("ConfirmPassword");

    //<<-----------------------------------String---------------------------------------------->>
    protected final String BIZPLATFORM_MAIN = "http://bizplatform.co/";
    private final String SEND_KEYS_TO_REGISTRATION_NAME_FIELD = "I_am_test";
    private final String SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD = "249756210";
    protected final By registrationWindow = By.xpath("//div[@class='gray-border']//following-sibling::p");
    protected String randomUserEmail = ("test.ncube" + Math.random() + 0.1 + "@gmail.com");

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