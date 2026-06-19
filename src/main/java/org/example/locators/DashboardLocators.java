package org.example.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class DashboardLocators {
    // --- DASHBOARD & MENU ---
// --- DASHBOARD & MENU ---
    public static final By BTN_OPEN_MENU = AppiumBy.accessibilityId("btn-open-menu");
    public static final By BTN_LOGOUT = AppiumBy.accessibilityId("btn-logout");
    // Menggunakan trik XPath pendeteksi teks untuk alert konfirmasi Logout
    public static final By ALERT_LOGOUT = AppiumBy.xpath("//*[@text='Logout']");
    public static final By MENU_PENGUMUMAN = AppiumBy.accessibilityId("menu-item-buat-pengumuman");
}
