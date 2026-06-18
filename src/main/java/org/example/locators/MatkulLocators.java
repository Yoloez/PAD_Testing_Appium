package org.example.locators;

import org.openqa.selenium.By;

public class MatkulLocators {
    // === LOCATOR UTAMA / MENU ===
    public static final By MENU_MATKUL = By.id("menu-item-tambah-mata-kuliah");

    // === LOCATOR TAMBAH MATKUL ===
    public static final By BTN_TAMBAH = By.id("btn-go-add-subject");
    public static final By BTN_BACK = By.id("btn-back-create-subject");
    public static final By INPUT_NAMA = By.id("input-name-create-subject");
    public static final By INPUT_KODE = By.id("input-code-create-subject");
    public static final By INPUT_SKS = By.id("input-sks-create-subject");
    public static final By BTN_SIMPAN = By.id("btn-save-create-subject");

    // === LOCATOR EDIT MATKUL ===
    public static final By BTN_EDIT = By.xpath("//*[contains(@id,'btn-edit-')]");
    public static final By INPUT_NAMA_EDIT = By.id("input-name-edit-subject");
    public static final By INPUT_KODE_EDIT = By.id("input-code-edit-subject");
    public static final By INPUT_SKS_EDIT = By.id("input-sks-edit-subject");
    public static final By BTN_SIMPAN_EDIT = By.id("btn-save-edit-subject");

    // === LOCATOR DELETE MATKUL ===
    public static By BTN_DELETE(String idMatkul) {
        return By.id("btn-delete-" + idMatkul);
    }
    // === SYSTEM ALERT DIALOG (Bawaan Android) ===
    public static final By ALERT_MESSAGE = By.id("android:id/message");
    public static final By ALERT_OK = By.id("android:id/button1");
}