package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class MobileBuilder extends AbstractPageObject {

    Date date = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh.mm.ss a zzz");


    private static final Logger log = LoggerFactory.getLogger(MobileBuilder.class);
    protected By MOBILE_BUILDER_IMAGE = By.xpath("//div[@class=\"content\"]//following-sibling::*//img[@ng-src=\"http://mobile.bizplatform.co:8083/content/standard/backgrounds/sm/PhotoStudio/18.jpg\"]");
    private static final String MOBILE_BUILDER_PAGE = "http://bizplatform.co/Venue/CommandCenter#/builder/home";
    protected final By mobileAppButton = By.xpath("//div[@class=\"panel panel-default\"]//i[@class=\"ion-iphone\"]");
    public final String screenshotName = "D:\\screenshot\\mobileBuilder\\" + ft.format(date) + getClass() + "Screenshot.jpg\\";

    public void clickMobileBuilder() throws InterruptedException {
        waiter(mobileAppButton, WebElement::click);
    }

    public MobileBuilder refreshMobileBuilder() throws InterruptedException {
        driver.navigate().refresh();
        return this;
    }

    public void imageIsDisplayed(By image) throws InterruptedException {
        waiter(image, WebElement::isDisplayed);
    }
}