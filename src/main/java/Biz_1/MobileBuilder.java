package Biz_1;

import org.openqa.selenium.By;

public class MobileBuilder extends AbstractPageObject {
    protected By MOBILE_BUILDER_IMAGE = By.xpath("//div[@class=\"content\"]//following-sibling::*//img[@ng-src=\"http://mobile.bizplatform.co:8083/content/standard/backgrounds/sm/PhotoStudio/18.jpg\"]");
    protected By MOBILE_BUILDER_SAMPLE = By.xpath("//div[@class=\"phone-content carousel ng-isolate-scope\"]");
    protected String MOBILE_BUILDER = "http://bizplatform.co/Venue/CommandCenter#/builder/home";
}