package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver driver;

    private By emailInput = AppiumBy.id("input-email");
    private By passwordInput = AppiumBy.id("input-password");
    private By loginButton = AppiumBy.id("btn-login");

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}