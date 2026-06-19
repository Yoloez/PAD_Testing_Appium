package org.example.locators;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AnnouncementLocators {

    // --- HALAMAN BUAT PENGUMUMAN (MANAGER) ---
    public static final By BTN_BACK_PENGUMUMAN = AppiumBy.accessibilityId("btn-back-pengumuman");
    public static final By INPUT_TITLE_PENGUMUMAN = AppiumBy.accessibilityId("input-title-pengumuman");
    public static final By INPUT_MESSAGE_PENGUMUMAN = AppiumBy.accessibilityId("input-message-pengumuman");
    public static final By BTN_SUBMIT_PENGUMUMAN = AppiumBy.accessibilityId("btn-submit-pengumuman");


    // --- ALERT ---
    public static final By ALERT_OK = AppiumBy.androidUIAutomator("new UiSelector().text(\"OK\")");

    // --- PESAN ERROR VALIDASI (form kosong) ---
    // Mendeteksi teks error validasi apapun yang mengandung kata "kosong" atau "wajib"
    public static final By ERROR_VALIDASI_JUDUL = AppiumBy.androidUIAutomator(
            "new UiSelector().textContains(\"kosong\")");
    public static final By ERROR_VALIDASI_WAJIB = AppiumBy.androidUIAutomator(
            "new UiSelector().textContains(\"wajib\")");
    public static final By ERROR_VALIDASI_REQUIRED = AppiumBy.androidUIAutomator(
            "new UiSelector().textContains(\"required\")");
    public static final By ERROR_PERINGATAN = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Peringatan\")");

    // --- HALAMAN CEK PENGUMUMAN (MAHASISWA) ---
    public static final By BTN_NOTIFICATION = AppiumBy.accessibilityId("btn-notification");
    public static final By BTN_BACK_NOTIFICATION = AppiumBy.accessibilityId("btn-back-notification");

    public static By getNotifMessageByText(String expectedText) {
        return AppiumBy.androidUIAutomator("new UiSelector().textContains(\"" + expectedText + "\")");
    }

    public static By getNotifCardById(int idNotification) {
        return AppiumBy.accessibilityId("notif-message-" + idNotification);
    }
}