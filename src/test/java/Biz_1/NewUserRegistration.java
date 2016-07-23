package Biz_1;

import org.junit.Assert;

public class NewUserRegistration extends AbstractTest{

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

}
