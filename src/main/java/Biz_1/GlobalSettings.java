package Biz_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GlobalSettings {
    private WebDriver driver;
    public GlobalSettings (WebDriver driver) {
        this.driver = driver;
    }

    private static final String PAGE_TITLE = "//h4[@class=\"page-title ng-scope\"]";
    private final By russianLanguage = By.xpath(".//*[@id='commandViews']/div/div/div[1]/div/div[7]/div[2]/div/ul/li[2]/a");
    private static final String GLOBAL_SETTINGS = "http://bizplatform.co/Venue/CommandCenter#/global_settings";
    private final By languageButton = By.xpath("//div[@class=\"col-md-7\"]//div[@class=\"dropdown lang\"]");
    private final By saveButton = By.xpath("//div[@class=\"col-md-8 col-xs-12\"]//button[@class=\"btn btn-green ng-scope\"]");

    public void pressLanguageDropDown() throws InterruptedException {
        driver.findElement(languageButton).click();
    }

    public void selectRussianLanguage() throws InterruptedException {
        driver.findElement(russianLanguage).click();
    }

    public void pressSaveButton() throws InterruptedException {
        driver.findElement(saveButton).click();
    }

    public GlobalSettings openGlobalSettings() {
        driver.get(GLOBAL_SETTINGS);
        return this;
    }

    public GlobalSettings refreshGlobalSettings() throws InterruptedException {
        driver.navigate().refresh();
        return this;
    }

    public String getTextFromGlobalSettingsPageTitle() {
        return  driver.findElement(By.xpath(PAGE_TITLE)).getText();
    }
}
