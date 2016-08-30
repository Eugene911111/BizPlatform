package Biz_1;

import lombok.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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

    protected void checkElementIsDisplayed(By element) throws InterruptedException {
        driver.findElement(element).isDisplayed();
    }

    protected void checkElementIsNotDisplayed(By element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waiter(By selector, Consumer<WebElement> consumer, Function<By, ExpectedCondition<WebElement>> function, long seconds) throws InterruptedException {
        WebElement element = new WebDriverWait(driver, (int)seconds).until(function.apply(selector));
        consumer.accept(element);
    }
}

