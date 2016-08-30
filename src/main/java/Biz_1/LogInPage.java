package Biz_1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@AllArgsConstructor
public class LogInPage extends AbstractPageObject {

    //<<-----------------------------------FIELDS---------------------------------------------->>
    private
    @Getter
    final By emailLogInField = By.id("Email");
    private
    @Getter
    final By passLogInField = By.id("Password");
    private
    @Getter
    final By authoriseButton = By.id("sbmtBtn");

    //<<-----------------------------------String---------------------------------------------->>
    private static final String SEND_KEYS_TO_EMAIL_FIELD = "test.ncube@gmail.com";
    private static final String SEND_KEYS_TO_PASSWORD_FIELD = "249756210";

//    <-------------------logIn method
//    public void enterEmailField() throws InterruptedException {
//        findElementsAndClear(emailLogInField);
//        findElementsAndSendKeys(emailLogInField,SEND_KEYS_TO_EMAIL_FIELD);
//    }
//
//    public void enterPassword() throws InterruptedException {
//        findElementsAndClear(passLogInField);
//        findElementsAndSendKeys(passLogInField, SEND_KEYS_TO_PASSWORD_FIELD);
//    }
//
//    public void pressAuthoriseButton() throws InterruptedException {
//        findElementsAndClick(authoriseButton);
//    }

    public void logIn() throws InterruptedException {
        waiter(emailLogInField, c -> c.sendKeys(SEND_KEYS_TO_EMAIL_FIELD), ExpectedConditions::elementToBeClickable, 10);
        waiter(passLogInField, c -> c.sendKeys(SEND_KEYS_TO_PASSWORD_FIELD), ExpectedConditions::elementToBeClickable, 10);
        waiter(authoriseButton, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }
}
