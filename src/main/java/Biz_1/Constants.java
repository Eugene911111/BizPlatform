package Biz_1;

import org.openqa.selenium.By;

public interface Constants {

    By GLOBAL_PAGE_TITLE = By.xpath( "//p[@class=\"page-title ng-scope\"]");
    By GLOBAL_RUSSIAN_LANGUAGE = By.xpath( "//div[@class=\"bz-dropdown lang dropdown open\"]//ul[@class=\"dropdown-menu\"]//a[@ng-click=\"glsCtrl.changeLanguageTo('ru')\"]");
    By GLOBAL_ENGLISH_LANGUAGE = By.xpath( "//div[@class=\"bz-dropdown lang dropdown open\"]//ul[@class=\"dropdown-menu\"]//a[@ng-click=\"glsCtrl.changeLanguageTo('en')\"]");
    String GLOBAL_SETTINGS = "http://bizplatform.co/Venue/CommandCenter#/global_settings";
    By GLOBAL_LANGUAGE_BUTTON = By.xpath("//div[@class=\"bz-dropdown lang dropdown\"]//button[@id=\"language\"]");
    By GLOBAL_SAVE_BUTTON = By.xpath( "//button[@ng-click=\"glsCtrl.saveSettings()\"]");
    By BOOKING_BUTTON = By.xpath("//span[@class=\"ng-binding\"]//div[@class=\"heading-wrapper ng-scope\"]//span");

}
