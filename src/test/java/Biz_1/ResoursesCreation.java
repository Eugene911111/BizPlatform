package Biz_1;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResoursesCreation extends AbstractTest {
    public static final String RESOURSES_PAGE = "http://bizplatform.co/Venue/CommandCenter#/bookings/resources";

    @org.junit.Test
    public void a_addNewResourceCategory() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(RESOURSES_PAGE);
        resources.addNewCategory();
        resources.checkElementIsDisplayed(resources.createdCategory);
    }

    @org.junit.Test
    public void b_addNewResource() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(RESOURSES_PAGE);
        resources.waitForElementIsClickableAndClick(resources.addResourceButton);
        resources.waitForElementIsClickableAndClick(resources.resourceButton);
        resources.sendKeysToElementWhenElementIsClickable(resources.fieldForResourceName, "NEW TEST RESOURCE");
        resources.waitForElementIsClickableAndClick(resources.dropDownButtonToSelectCategory);
        resources.waitForElementIsClickableAndClick(resources.selectCategoryInDropDown);
        resources.waitForElementIsClickableAndClick(resources.saveButton);
        resources.checkElementIsDisplayed(resources.createdResource1);
    }

    @org.junit.Test
    public void c_deleteCreatedResource() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(RESOURSES_PAGE);
        resources.deleteCreatedResource();
    }

    @org.junit.Test
    public void d_deleteCreatedCategory() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        driver.get(RESOURSES_PAGE);
        new WebDriverWait(driver, 25).until((WebDriver d) -> ExpectedConditions.presenceOfElementLocated(resources.createdCategory).apply(d));
        List<WebElement> list = driver.findElements(resources.createdCategory);
        System.out.println(list.size());
        System.out.println(list);
        for (WebElement e : list) {
            resources.deleteCreatedCategory();
        }
/*
        list.forEach(s resources.deleteCreatedCategory);
        (resources.checkElementIsDisplayed(resources.createdCategory)) {
                resources.deleteCreatedCategory();
                log.debug("---------Created CATEGORY is Deleted-------------");
            }
*/

    }
}
