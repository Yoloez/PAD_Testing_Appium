package org.example;

import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final AndroidDriver driver;
    protected final WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void click(By by) {
        waitForVisible(by).click();
    }

    protected void sendKeys(By by, String text) {
        waitForVisible(by).sendKeys(text);
    }

    protected void clearAndSendKeys(By by, String text) {
        WebElement element = waitForVisible(by);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By by) {
        return waitForVisible(by).getText();
    }
}

