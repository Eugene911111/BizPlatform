package Biz_1;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpecialistCreation extends AbstractTest implements Constants {

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
    public void c_deleteCreatedSpecialist() throws InterruptedException {
        landingPage.openLogInPage();
        logInPage.logIn();
        specialists.getSpecialistsPage();
        specialists.pressCreatedSpecialist();
        specialists.pressEditButtonForCategory();
        specialists.deleteCreatedSpecialist();
        specialists.pressDeleteCpecialist();
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