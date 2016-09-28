package Biz_1;

public class GlobalSettings extends AbstractPageObject implements Constants {

    public String getTextFromGlobalSettingsPageTitle() {
        return driver.findElement(GLOBAL_PAGE_TITLE).getText();
    }
}
