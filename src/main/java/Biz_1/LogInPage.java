package Biz_1;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;

@AllArgsConstructor
public class LogInPage extends AbstractPageObject {

    //<<-----------------------------------FIELDS---------------------------------------------->>
    private final By emailLogInField = By.id("Email");
    private final By passLogInField = By.id("Password");
    private final By authoriseButton = By.id("sbmtBtn");

    //<<-----------------------------------String---------------------------------------------->>
    private static final String SEND_KEYS_TO_EMAIL_FIELD = "test.ncube@gmail.com";
    private static final String SEND_KEYS_TO_PASSWORD_FIELD = "249756210";

    public void enterEmailField() throws InterruptedException {
        findElementsAndClear(emailLogInField);
        driver.findElement(emailLogInField).sendKeys(SEND_KEYS_TO_EMAIL_FIELD);
    }

    public void enterPassword() throws InterruptedException {
        findElementsAndClear(passLogInField);
        findElementsAndSendKeys(passLogInField, SEND_KEYS_TO_PASSWORD_FIELD);
    }

    public void pressAuthoriseButton() throws InterruptedException {
        findElementsAndClick(authoriseButton);
    }

    public void fillLogInForm() throws InterruptedException {
        enterEmailField();
        enterPassword();
        pressAuthoriseButton();
    }
}
