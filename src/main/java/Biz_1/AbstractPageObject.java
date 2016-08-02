package Biz_1;

import lombok.Data;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@Data
public abstract class AbstractPageObject {
    protected WebElement element;
    protected WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public void findElementsAndClick(By... elements) throws InterruptedException {
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

    protected void implicitlyWait(Integer time, TimeUnit timeUnit) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    protected void checkElementIsDisplayed(By element) throws InterruptedException {
        driver.findElement(element).isDisplayed();
    }
    protected void implTest(By element) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(element).click();
    }
}

