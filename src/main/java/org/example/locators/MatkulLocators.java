package org.example.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MatkulLocators {

    // === NAVIGASI MENU ===
    public static final By MENU_MATKUL = AppiumBy.accessibilityId("menu-item-tambah-mata-kuliah");

    // === TAMBAH MATA KULIAH ===
    public static final By BTN_TAMBAH       = AppiumBy.accessibilityId("btn-go-add-subject");
    public static final By BTN_BACK         = AppiumBy.accessibilityId("btn-back-create-subject");
    public static final By INPUT_NAMA       = AppiumBy.accessibilityId("input-name-create-subject");
    public static final By INPUT_KODE       = AppiumBy.accessibilityId("input-code-create-subject");
    public static final By INPUT_SKS        = AppiumBy.accessibilityId("input-sks-create-subject");
    public static final By BTN_SIMPAN       = AppiumBy.accessibilityId("btn-save-create-subject");

    // === EDIT MATA KULIAH ===
    public static By BTN_EDIT(int idMatkul) {
        return AppiumBy.accessibilityId("btn-edit-" + idMatkul);
    }
    public static final By INPUT_NAMA_EDIT  = AppiumBy.accessibilityId("input-name-edit-subject");
    public static final By INPUT_KODE_EDIT  = AppiumBy.accessibilityId("input-code-edit-subject");
    public static final By INPUT_SKS_EDIT   = AppiumBy.accessibilityId("input-sks-edit-subject");
    public static final By BTN_SIMPAN_EDIT  = AppiumBy.accessibilityId("btn-save-edit-subject");

    // === DELETE MATA KULIAH ===
    public static By BTN_DELETE(int idMatkul) {
        return AppiumBy.accessibilityId("btn-delete-" + idMatkul);
    }

    // === ALERT DIALOG ===
    // Menggunakan androidUIAutomator agar handal (sama seperti AnnouncementLocators)
    public static final By ALERT_OK = AppiumBy.id("android:id/button1");
    public static final By ALERT_MESSAGE = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Berhasil\")");
}