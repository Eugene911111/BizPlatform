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

    public void checkElementIsDisplayed(By element) throws InterruptedException {
        //waiter(element, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        //check it
        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void imageIsDisplayed(By image) throws InterruptedException {
        waiter(image, WebElement::isEnabled, ExpectedConditions::presenceOfElementLocated, 15);
    }

    public void checkElementIsNotDisplayed(By element) throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitForElementIsClickableAndClick(By byElement) throws InterruptedException {
        waiter(byElement, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }
    public void waitForElementIsPresentAndClick(By byElement) throws InterruptedException {
        waiter(byElement, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
    }
    protected void waiter(By selector, Consumer<WebElement> consumer, Function<By, ExpectedCondition<WebElement>> function, long seconds) throws InterruptedException {
        WebElement element = new WebDriverWait(driver, (int) seconds).until(function.apply(selector));
        consumer.accept(element);
    }
    public void sendKeysToElementWhenElementIsClickable(By element, String string) throws InterruptedException {
        waiter(element, c -> c.sendKeys(string), ExpectedConditions::elementToBeClickable, 10);
    }
    public void sendKeysToElementWhenElementIsPresent(By element, String string) throws InterruptedException {
        waiter(element, c -> c.sendKeys(string), ExpectedConditions::presenceOfElementLocated, 10);
    }
    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }
    public AbstractPageObject refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        return this;
    }

    protected String getTextFromElement(By element) throws InterruptedException {
        waiter(element, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, 10);
        return driver.findElement(element).getText();
    }

    // Maybe this method for getting text is better
    public String getTextFromLocator(By element1) throws InterruptedException {
        WebDriverWait element = new WebDriverWait(driver, 10);
        Boolean until = element.until(
                (ExpectedCondition<Boolean>) d -> !d.findElement(element1).getText().equals(""));
        return until ? driver.findElement(element1).getText() : "----";
    }
}

