package Biz_1;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class MobileBuilder extends AbstractPageObject {
    //private final By mobileBuilderImage = By.xpath("//img[@class=\"list-item ng-scope\"][6]");
    String MOBILE_BUILDER_IMAGE = ("//div[@class=\"content\"]//following-sibling::*//img [contains (., \"\")]");
    private static final String MOBILE_BUILDER_PAGE = "http://bizplatform.co/Venue/CommandCenter#/builder/home";
    private final By mobileAppButton = By.xpath("//span[contains(., 'При')]//following-sibling::span[@class=\"tab-name ng-binding\"]");

    public void clickMobileBuilder() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        findElementsAndClick(mobileAppButton);
    }

    public MobileBuilder refreshMobileBuilder() throws InterruptedException {
        driver.navigate().refresh();
        return this;
    }

    public void imageIsDisplayed() throws InterruptedException {
        driver.findElement(By.xpath(MOBILE_BUILDER_IMAGE)).isDisplayed();
        System.out.println("---->After the MobileBuilder Page is reloaded, the Background Images ARE displayed!!!<-------------");
    }


}
