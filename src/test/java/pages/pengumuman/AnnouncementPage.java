package pages.pengumuman;

import io.appium.java_client.android.AndroidDriver;
import org.example.locators.DashboardLocators;
import org.example.locators.LoginLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.locators.AnnouncementLocators; // <-- Mengimpor file locator milikmu

import java.time.Duration;

public class AnnouncementPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public AnnouncementPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= METHODS MANAGER =================

    public void inputTitle(String title) {
        // Langsung panggil variabel statis dari AnnouncementLocators
        WebElement fieldTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AnnouncementLocators.INPUT_TITLE_PENGUMUMAN));
        fieldTitle.clear();
        fieldTitle.sendKeys(title);
    }

    public void inputMessage(String message) {
        WebElement fieldMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AnnouncementLocators.INPUT_MESSAGE_PENGUMUMAN));
        fieldMessage.clear();
        fieldMessage.sendKeys(message);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.BTN_SUBMIT_PENGUMUMAN)).click();
    }

    public void clickAlertOk() {
        try {
            // Appium akan mencari teks "OK" di layar lalu mengekliknya
            wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.ALERT_OK)).click();
            System.out.println("LOG: Berhasil klik alert pakai deteksi teks!");
        } catch (Exception e) {
            System.out.println("LOG: Gagal klik alert. Pastikan tulisan teksnya benar persis.");
        }
    }

    public void clickBackManager() {
        wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.BTN_BACK_PENGUMUMAN)).click();
    }

    // ================= METHODS RELOGIN & DASHBOARD =================

    public void openMenuAndLogout() {
        // 1. Klik menu dashboard
        wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.BTN_OPEN_MENU)).click();

        // 2. Klik tombol logout di dalam menu
        wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.BTN_LOGOUT)).click();

        // 3. Konfirmasi alert logout (menekan teks "Logout")
        try {
            wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.ALERT_LOGOUT)).click();
            System.out.println("LOG: Berhasil logout dari akun Manager.");
        } catch (Exception e) {
            System.out.println("LOG: Alert logout tidak muncul atau teksnya beda.");
        }
    }

    public void loginSebagai(String email, String password) {
        // Tunggu halaman login muncul dengan mengecek keberadaan input email
        WebElement fieldEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.INPUT_EMAIL));
        fieldEmail.clear();
        fieldEmail.sendKeys(email);

        WebElement fieldPass = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.INPUT_PASSWORD));
        fieldPass.clear();
        fieldPass.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(LoginLocators.BTN_LOGIN)).click();
        System.out.println("LOG: Sedang login dengan email: " + email);
    }

    // ================= METHODS MAHASISWA =================

    public void clickBtnNotification() {
        wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.BTN_NOTIFICATION)).click();
    }

    public String getNotificationTextByContent(String expectedText) {
        // Memanggil method dinamis dari file locator-mu
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AnnouncementLocators.getNotifMessageByText(expectedText)
        ));
        return messageElement.getText();
    }

    public void clickBackMahasiswa() {
        wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.BTN_BACK_NOTIFICATION)).click();
    }
}