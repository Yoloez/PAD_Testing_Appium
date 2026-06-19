package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.locators.LecturerLocators;

import java.time.Duration;

public class LecturerPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public LecturerPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected void click(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void sendKeys(By by, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
    }

    // --- Method Aksi Otomatis ---
    public void melakukanLogin(String email, String password) {
        sendKeys(LecturerLocators.INPUT_EMAIL_LOGIN, email);
        sendKeys(LecturerLocators.INPUT_PASSWORD_LOGIN, password);
        click(LecturerLocators.BTN_LOGIN);
    }

    public void bukaSidebarMenu() {
        click(LecturerLocators.BTN_OPEN_MENU);
    }

    public void klikTambahDosen() {
        click(LecturerLocators.BTN_ADD_DOSEN);
    }

    public void bukaMenuTambahDosen() {
        click(LecturerLocators.MENU_TAMBAH_DOSEN);
    }

    public void inputNama(String nama) {
        sendKeys(LecturerLocators.INPUT_NAMA, nama);
    }

    public void inputUsername(String username) {
        sendKeys(LecturerLocators.INPUT_USERNAME, username);
    }

    public void inputEmail(String email) {
        sendKeys(LecturerLocators.INPUT_EMAIL, email);
    }

    public void klikOK() {
        click(LecturerLocators.BTN_OK);
    }

    public void inputProgramStudi(String programStudi) {
        click(LecturerLocators.INPUT_PROGRAM_STUDI);
        
        // Tunggu sebentar sampai dialog native muncul
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        
        // Pilih opsi pertama dari dropdown menggunakan class CheckedTextView bawaan Android
        click(io.appium.java_client.AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.CheckedTextView\").instance(1)"));
    }

    public void inputPassword(String password) {
        sendKeys(LecturerLocators.INPUT_PASSWORD, password);
    }

    public void inputKonfirmasiPassword(String password) {
        sendKeys(LecturerLocators.INPUT_PASSWORD_CONF, password);
    }

    public void klikSimpan() {
        click(LecturerLocators.BTN_SAVE);
    }

    public void klikAktifkan(int idUser) {
        click(LecturerLocators.getBtnActivate(idUser));
    }

    public void klikNonaktifkan(int idUser) {
        click(LecturerLocators.getBtnDeactivate(idUser));
    }

    public void bukaMenuListDosen() {
        click(LecturerLocators.MENU_TAMBAH_DOSEN); // Sesuai dengan instruksi
    }

    public void klikAktifkanDosen() {
        klikAktifkan(18);
    }

    public void klikNonaktifkan() {
        klikNonaktifkan(18);
    }

    public void klikUbahStatusDosen() {
        click(LecturerLocators.BTN_UBAH_STATUS_DOSEN);
    }
}