package Biz_1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class LandingPage {
    private WebDriver driver;
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


    public String getText() {
        return  driver.findElement(By.xpath(REGISTRATION_WINDOW)).getText();
    }

    public LandingPage openBizplatform() {
        driver.manage().window().maximize();
        driver.get(BIZPLATFORM_MAIN);
        return this;
    }

    public void pressLogInButton() throws InterruptedException {
        driver.findElement(logInButton).click();
    }
    public void pressRegisterButton() throws InterruptedException {
        driver.findElement(registerButton).click();
    }

    public void registerRandomUser()throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(registrationNameField).clear();
        driver.findElement(registrationNameField).sendKeys(SEND_KEYS_TO_REGISTRATION_NAME_FIELD);
        driver.findElement(registrationEmailField).clear();
        driver.findElement(registrationEmailField).sendKeys(SEND_RANDOM_KEYS_TO_REGISTRATION_EMAIL_FIELD);
        driver.findElement(registrationPasswordField).clear();
        driver.findElement(registrationPasswordField).sendKeys(SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD);
        driver.findElement(registrationConfirmationPasswordField).clear();
        driver.findElement(registrationConfirmationPasswordField).sendKeys(SEND_KEYS_TO_REGISTRATION_PASSWORD_FIELD);
        driver.findElement(tryForFreeButton).click();
    }

    public void checkBookingButtonIsDisplayed() throws InterruptedException{
        if(( driver.findElement(bookingButton)).isDisplayed()){
            System.out.println("User Logged In successfully");
        }
    }

        public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

}