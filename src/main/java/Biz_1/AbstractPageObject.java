package Biz_1;

import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Data
public abstract class AbstractPageObject {
    protected WebElement element;
    protected WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh.mm.ss a ");
    protected final String randScreenshotName = "D:\\screenshot\\" + ft.format(new Date()) + getClass() + "Screenshot.jpg\\";

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

    // !!!!!!!!!!!!проверить !!!!!!!!!!!!!!!!!!!!!!!!!!--------------------------------------------------------------------------------------------------------------------------------------
    public void waitForElementIsClickableAndClick(By byElement) throws InterruptedException {
        try {
            waiter(byElement, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
        } catch (Exception e) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebElement username = driver.findElement(byElement);
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", username);
                // Thread.sleep(4000);
                logger.debug("Element is highlighted");
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(randScreenshotName));
                logger.debug("screen saved");
   //---------NEW- - Check how it workes
                Thread.sleep(2000);
                driver.findElement(byElement).click();
            } catch (Exception e2) {
                logger.error("such element don't exist: " + byElement);
                throw new InterruptedException();
            }
        }
    }

    // !!!!!!!!!!!!проверить !!!!!!!!!!!!!!!!!!!!!!!!!!------------------------------------------------------------------------------------------------------------------------------------
    public void waitForElementIsPresentAndClick(By byElement) throws InterruptedException {
        try {
            waiter(byElement, WebElement::click, ExpectedConditions::elementToBeClickable, 10);
        } catch (Exception e) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebElement username = driver.findElement(byElement);
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", username);

                //  Thread.sleep(4000);
                logger.debug("Element is highlighted");
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(randScreenshotName));
                logger.debug("screen saved");
                Thread.sleep(2000);
                driver.findElement(byElement).click();
            } catch (Exception e2) {
                logger.error("such element don't exist");
                throw new InterruptedException();
            }
        }
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

    public static void fnHighlightMe(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // find element using id attribute
        WebElement username = driver.findElement((By) element);

        // call the executeScript method
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", username);
    }
}


