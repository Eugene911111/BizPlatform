package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MobileBuilder {

    private WebDriver driver;
     //private final By mobileBuilderImage = By.xpath("//img[@class=\"list-item ng-scope\"][6]");
    private final By mobileBuilderImage = By.xpath("//img[@src=\"http://mobile.bizplatform.co:8083/content/standard/backgrounds/sm/PhotoStudio/19.jpg\"]");
    private static final String MOBILE_BUILDER_PAGE = "http://bizplatform.co/Venue/CommandCenter#/builder/home";
    private final By mobileAppButton = By.xpath("//span[contains(., 'Mobile app')]//following-sibling::span[@class=\"tab-name ng-binding\"]");

    public void clickMobileBuilder() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(mobileAppButton).click();
    }

    public MobileBuilder refreshMobileBuilder() throws InterruptedException {
        driver.navigate().refresh();
        return this;
    }

    public void imageIsDisplayed() throws InterruptedException {
        driver.findElement(mobileBuilderImage).isDisplayed();
            System.out.println("---->After the MobileBuilder Page is reloaded, the Background Images ARE displayed!!!<-------------");
    }

    public MobileBuilder(WebDriver driver) {
        this.driver = driver;
    }
}
