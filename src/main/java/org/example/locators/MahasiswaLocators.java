package org.example.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MahasiswaLocators {

    public static final By BTN_OPEN_MENU = AppiumBy.accessibilityId("btn-open-menu");
    public static final By MENU_TAMBAH_MAHASISWA = AppiumBy.accessibilityId("menu-item-tambah-mahasiswa");

    public static final By BTN_GO_ADD_STUDENT = AppiumBy.accessibilityId("btn-go-add-student");

    public static By btnActivate(String idUserSi) {
        return AppiumBy.accessibilityId("btn-activate-" + idUserSi);
    }

    public static By btnDeactivate(String idUserSi) {
        return AppiumBy.accessibilityId("btn-deactivate-" + idUserSi);
    }

    public static final By BTN_BACK_CREATE_STUDENT = AppiumBy.accessibilityId("btn-back-create-student");
    public static final By INPUT_NAME_CREATE_STUDENT = AppiumBy.accessibilityId("input-name-create-student");
    public static final By INPUT_USERNAME_CREATE_STUDENT = AppiumBy.accessibilityId("input-username-create-student");
    public static final By INPUT_EMAIL_CREATE_STUDENT = AppiumBy.accessibilityId("input-email-create-student");
    public static final By INPUT_NIM_CREATE_STUDENT = AppiumBy.accessibilityId("input-nim-create-student");
    public static final By INPUT_PROGRAM_CREATE_STUDENT = AppiumBy.accessibilityId("input-program-create-student");
    public static final By INPUT_PASSWORD_CREATE_STUDENT = AppiumBy.accessibilityId("input-password-create-student");
    public static final By INPUT_PASSWORD_CONF_CREATE_STUDENT = AppiumBy.accessibilityId("input-password-conf-create-student");
    public static final By BTN_SAVE_CREATE_STUDENT = AppiumBy.accessibilityId("btn-save-create-student");
}
