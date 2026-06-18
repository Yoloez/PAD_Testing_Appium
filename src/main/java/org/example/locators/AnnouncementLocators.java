package org.example.locators;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AnnouncementLocators {

    // --- HALAMAN BUAT PENGUMUMAN (MANAGER) ---
    public static final By BTN_BACK_PENGUMUMAN = AppiumBy.accessibilityId("btn-back-pengumuman");
    public static final By INPUT_TITLE_PENGUMUMAN = AppiumBy.accessibilityId("input-title-pengumuman");
    public static final By INPUT_MESSAGE_PENGUMUMAN = AppiumBy.accessibilityId("input-message-pengumuman");
    public static final By BTN_SUBMIT_PENGUMUMAN = AppiumBy.accessibilityId("btn-submit-pengumuman");

    // --- HALAMAN CEK PENGUMUMAN (MAHASISWA) ---
    public static final By BTN_NOTIFICATION = AppiumBy.accessibilityId("btn-notification");
    public static final By BTN_BACK_NOTIFICATION = AppiumBy.accessibilityId("btn-back-notification");

    // --- LOCATOR DINAMIS (MAHASISWA) ---
    /**
     * Karena ID notifikasi mengandung {id_notification} yang berubah-ubah,
     * kita buatkan method statis yang mengembalikan By.xpath secara dinamis berdasarkan teks pesan.
     */
    public static By getNotifMessageByText(String expectedText) {
        return AppiumBy.xpath("//android.widget.TextView[contains(@content-desc, 'notif-message-') and @text='" + expectedText + "']");
    }

    public static By getNotifCardById(String idNotification) {
        return AppiumBy.accessibilityId("notif-item-" + idNotification);
    }
}