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
    private final String screenshotName = "D:\\screenshot\\specialist\\" + ft.format(date) + getClass() + "Screenshot.jpg\\";

    @org.junit.Test
    public void a_categoryCreation() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.getSpecialistsPage();
        specialists.addNewSpecialist();
        specialists.addNewCategory();
        specialists.enterNewCategoryName("Specialist");
        specialists.pressSaveButton();
    }

    @org.junit.Test
    public void b_specialistCreation() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.getSpecialistsPage();
        specialists.addNewSpecialist();
        specialists.addSpecislist();
        specialists.enterSpecialistName();
        specialists.pressSaveButton();
    }

    @org.junit.Test
    public void c_deleteCreatedSpecialist() throws Exception {
        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.getSpecialistsPage();
//        specialists.pressCreatedSpecialist();
//        specialists.pressEditButtonForCategory();
       // specialists.deleteCreatedSpecialist();
       // specialists.pressDeleteCpecialist();

        try {
            specialists.pressCreatedSpecialist();
        } catch (Exception e) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotName));
            log.error("5 Screenshot of the bug was saved to: " + screenshotName);
            throw new Exception(e);
        }
        try {
            specialists.pressEditButtonForCategory();
        } catch (Exception e) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotName));
            log.error("5 Screenshot of the bug was saved to: " + screenshotName);
            throw new Exception(e);
        }
        try {
            specialists.deleteCreatedSpecialist();
        } catch (Exception e) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotName));
            log.error("5 Screenshot of the bug was saved to: " + screenshotName);
            throw new Exception(e);
        }
        try {
            specialists.pressDeleteCpecialist();
        } catch (Exception e) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotName));
            log.error("6 Screenshot of the bug was saved to: " + screenshotName);
            throw new Exception(e);
        }
    }

    @org.junit.Test
    public void d_deleteCreatedcategory() throws InterruptedException {

        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.getSpecialistsPage();
        specialists.pressEditForCategory();
        specialists.deleteCreatedCategory();
        specialists.pressDelete();

    }

}