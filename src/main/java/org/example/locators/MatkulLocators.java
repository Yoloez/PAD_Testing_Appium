package org.example.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public final class MatkulLocators {

    // Menggunakan accessibilityId karena jauh lebih stabil untuk React Native
    public static final By MENU_MATKUL = AppiumBy.accessibilityId("menu_matkul");
    public static final By BTN_TAMBAH = AppiumBy.accessibilityId("btn_add");
    public static final By INPUT_NAMA = AppiumBy.accessibilityId("input-name-create-subject");
    public static final By INPUT_KODE = AppiumBy.accessibilityId("input-code-create-subject");
    public static final By INPUT_SKS = AppiumBy.accessibilityId("input-sks-create-subject");
    public static final By BTN_SIMPAN = AppiumBy.accessibilityId("btn-save-create-subject");
    public static final By BTN_EDIT = AppiumBy.accessibilityId("btn_edit");

    // Khusus untuk Alert bawaan sistem Android (Native Dialog)
    public static final By ALERT_MESSAGE = AppiumBy.id("android:id/message");
    public static final By ALERT_OK = AppiumBy.id("android:id/button1");

    private MatkulLocators() {
        // Mencegah instansiasi kelas utility
    }
}