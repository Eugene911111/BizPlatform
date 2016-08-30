package Biz_1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.By.xpath;

public class GlobalSettings extends AbstractPageObject implements Constants {

    public void pressLanguageDropDown() throws InterruptedException {
        waiter(xpath(GLOBAL_LANGUAGE_BUTTON), WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void selectRussianLanguage() throws InterruptedException {
        waiter(xpath(GLOBAL_RUSSIAN_LANGUAGE),WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }
    public void selectEnglishLanguage() throws InterruptedException {
        waiter(xpath(GLOBAL_ENGLISH_LANGUAGE), WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }

    public void pressSaveButton() throws InterruptedException {
        waiter(xpath(GLOBAL_SAVE_BUTTON),WebElement::click, ExpectedConditions::elementToBeClickable, 10);
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
