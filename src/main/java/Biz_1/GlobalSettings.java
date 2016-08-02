package Biz_1;

import static org.openqa.selenium.By.xpath;

public class GlobalSettings extends AbstractPageObject implements Constants {

    public void pressLanguageDropDown() throws InterruptedException {
        findElementsAndClick(xpath(GLOBAL_LANGUAGE_BUTTON));
    }

    public void selectRussianLanguage() throws InterruptedException {
        findElementsAndClick(xpath(GLOBAL_RUSSIAN_LANGUAGE));
    }
    public void selectEnglishLanguage() throws InterruptedException {
        findElementsAndClick(xpath(GLOBAL_ENGLISH_LANGUAGE));
    }

    public void pressSaveButton() throws InterruptedException {
        findElementsAndClick(xpath(GLOBAL_SAVE_BUTTON));
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
        return driver.findElement(xpath(GLOBAL_PAGE_TITLE)).getText();
    }
}
