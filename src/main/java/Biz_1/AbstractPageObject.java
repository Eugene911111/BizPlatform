package Biz_1;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@Data
public abstract class AbstractPageObject {

    protected WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

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
    protected void findElementsAndSendKeys(By element, String sendKeys) throws InterruptedException {
        driver.findElement(element).sendKeys(sendKeys);
    }

   // driver.findElement(registrationNameField).sendKeys(SEND_KEYS_TO_REGISTRATION_NAME_FIELD);

    protected void implicitlyWait(Integer time, TimeUnit timeUnit) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    protected void checkElementIsDisplayed(By element) throws InterruptedException {
        if ((driver.findElement(element)).isDisplayed()) {
            System.out.println("Element is displayed");
        }
    }
}
