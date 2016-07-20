package Biz_1;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@Data
public abstract class AbstractPageObject {

    protected WebDriver driver;

    protected void findElementsAndClick(By... elements) throws InterruptedException {
        for (By element : elements) {
            driver.findElement(element).click();
        }
    }

    protected void findElementsAndClear(By... elements) throws InterruptedException {
        for (By element : elements) {
            driver.findElement(element).clear();
        }
    }

    protected void implicitlyWait(Integer time, TimeUnit timeUnit) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    public void checkElementIsDisplayed(By element) throws InterruptedException {
        if ((driver.findElement(element)).isDisplayed()) {
            System.out.println("Element is displayed");
        }
}
}
