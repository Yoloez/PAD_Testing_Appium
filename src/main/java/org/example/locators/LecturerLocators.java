package org.example.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LecturerLocators {

    // --- Menu & Navigation ---

    public static final By BTN_OPEN_MENU = AppiumBy.accessibilityId("btn-open-menu");
    public static final By BTN_ADD_DOSEN = AppiumBy.accessibilityId("btn-go-add-lecturer");
    public static final By MENU_TAMBAH_DOSEN = AppiumBy.accessibilityId("menu-item-tambah-dosen");
    
    // --- Login (if needed) ---
    public static final By INPUT_EMAIL_LOGIN = AppiumBy.accessibilityId("input-email");
    public static final By INPUT_PASSWORD_LOGIN = AppiumBy.accessibilityId("input-password");
    public static final By BTN_LOGIN = AppiumBy.accessibilityId("btn-login");

    // --- Form Tambah Dosen ---
    public static final By INPUT_NAMA = AppiumBy.accessibilityId("input-name-create-lecturer");
    public static final By INPUT_USERNAME = AppiumBy.accessibilityId("input-username-create-lecturer");
    public static final By INPUT_EMAIL = AppiumBy.accessibilityId("input-email-create-lecturer");
    public static final By INPUT_PROGRAM_STUDI = AppiumBy.accessibilityId("input-program-create-lecturer");
    public static final By INPUT_PASSWORD = AppiumBy.accessibilityId("input-password-create-lecturer");
    public static final By INPUT_PASSWORD_CONF = AppiumBy.accessibilityId("input-password-conf-create-lecturer");
    public static final By BTN_SAVE = AppiumBy.accessibilityId("btn-save-create-lecturer");
    public static final By BTN_OK = AppiumBy.id("android:id/button1");
    public static final By BTN_UBAH_STATUS_DOSEN = AppiumBy.id("android:id/button1");

    // --- Aktivasi & Non-Aktivasi Dosen ---
    public static By getBtnActivate(int idUser) {
        return AppiumBy.accessibilityId("btn-activate-" + idUser);
    }

    public static By getBtnDeactivate(int idUser) {
        return AppiumBy.accessibilityId("btn-deactivate-" + idUser);
    }
}
