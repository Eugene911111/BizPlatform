package Biz_1;

import org.apache.commons.io.FileUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpecialistCreation extends AbstractTest implements Constants {
    public SpecialistCreation(String subfolder) {
        super("specialist\\");
    }

    @org.junit.Test
    public void a_categoryCreation() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.openUrl(specialists.SPECIALISTS_PAGE);
        specialists.waitForElementIsClickableAndClick(specialists.getAddSpecialistButton());
        specialists.waitForElementIsClickableAndClick(specialists.getAddCategoryButton());
        specialists.enterNewCategoryName("Specialist");
        specialists.waitForElementIsClickableAndClick(specialists.saveButton);
    }

    @org.junit.Test
    public void b_specialistCreation() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.openUrl(Specialists.SPECIALISTS_PAGE);
        specialists.waitForElementIsClickableAndClick(specialists.getAddSpecialistButton());
        specialists.waitForElementIsClickableAndClick(specialists.specialistButton);
        specialists.sendKeysToElementWhenElementIsClickable(specialists.specialistName, "Max");
        specialists.waitForElementIsClickableAndClick(specialists.saveButton);
    }

    @org.junit.Test
    public void c_deleteCreatedSpecialist() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.openUrl(specialists.SPECIALISTS_PAGE);
//        specialists.pressCreatedSpecialist();
//        specialists.pressEditButtonForCategory();
        // specialists.deleteCreatedSpecialist();
        // specialists.pressDeleteCpecialist();

        try {
            specialists.waitForElementIsClickableAndClick(specialists.createdSpecialist);
        } catch (Exception e) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(randScreenshotName));
            log.error("5 Screenshot of the bug was saved to: " + randScreenshotName);
            throw new Exception(e);
        }
        try {
            specialists.waitForElementIsClickableAndClick(specialists.editButtonForCreatedSpecialist);
        } catch (Exception e) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(randScreenshotName));
            log.error("5 Screenshot of the bug was saved to: " + randScreenshotName);
            throw new Exception(e);
        }
        try {
            specialists.waitForElementIsClickableAndClick(specialists.deleteButtonForCreatedResource);
        } catch (Exception e) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(randScreenshotName));
            log.error("5 Screenshot of the bug was saved to: " + randScreenshotName);
            throw new Exception(e);
        }
        try {
            specialists.waitForElementIsClickableAndClick(specialists.deleteButton2ForCreatedResource);
        } catch (Exception e) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(randScreenshotName));
            log.error("6 Screenshot of the bug was saved to: " + randScreenshotName);
            throw new Exception(e);
        }
    }

    @org.junit.Test
    public void d_deleteCreatedcategory() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.openUrl(specialists.SPECIALISTS_PAGE);
        specialists.waitForElementIsClickableAndClick(specialists.editButtonForCategory);
        specialists.waitForElementIsClickableAndClick(specialists.deleteCategoryButton);
        specialists.waitForElementIsClickableAndClick(specialists.delete);

    }

}