package Biz_1;

import org.junit.Assert;

public class NewUserRegistration extends AbstractTest {

    @org.junit.Test
    public void newUserRegistration() throws InterruptedException {
        landingPage.openUrl(landingPage.BIZPLATFORM_MAIN);
        landingPage.waitForElementIsPresentAndClick(landingPage.registerButton);

        landingPage.registerRandomUser();
        String actualEmailErrorMessage = landingPage.getTextFromLocator(landingPage.registrationWindow);
        String expectedErrorMessage = "Мы выслали письмо на указанный Вами электронный адрес. Пожалуйста, подтвердите регистрацию нажав ссылку в высланном письме";
        Assert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
        log.info("---------New user registration test passed successfully-------------- ");
    }
}