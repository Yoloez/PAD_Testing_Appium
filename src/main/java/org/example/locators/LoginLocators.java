package org.example.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginLocators {

    // --- HALAMAN LOGIN ---
    public static final By INPUT_EMAIL = AppiumBy.accessibilityId("input-email");
    public static final By INPUT_PASSWORD = AppiumBy.accessibilityId("input-password");
    public static final By BTN_LOGIN = AppiumBy.accessibilityId("btn-login");
}
