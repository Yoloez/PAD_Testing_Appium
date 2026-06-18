package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LecturerPage {

    AndroidDriver driver;

    public LecturerPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // --- Tambahan Elemen Login & Dashboard ---
    By inputEmailLogin = By.id("input-email");
    By inputPasswordLogin = By.id("input-password");
    By btnLogin = By.id("btn-login");
    By btnOpenMenu = By.id("btn-open-menu");

    // Menu
    By menuTambahDosen = By.id("menu-item-tambah-dosen");

    // Form Tambah Dosen
    By inputNama = By.id("input-name-create-lecturer");
    By inputUsername = By.id("input-username-create-lecturer");
    By inputEmail = By.id("input-email-create-lecturer");
    By inputProgramStudi = By.id("input-program-create-lecturer");
    By inputPassword = By.id("input-password-create-lecturer");
    By inputKonfirmasiPassword = By.id("input-password-conf-create-lecturer");

    By btnSave = By.id("btn-save-create-lecturer");

    // --- Tambahan Method Aksi Otomatis ---
    public void melakukanLogin(String email, String password) {
        driver.findElement(inputEmailLogin).sendKeys(email);
        driver.findElement(inputPasswordLogin).sendKeys(password);
        driver.findElement(btnLogin).click();
    }

    public void bukaSidebarMenu() {
        driver.findElement(btnOpenMenu).click();
    }

    // --- Method yang Sudah Ada ---
    public void bukaMenuTambahDosen() {
        driver.findElement(menuTambahDosen).click();
    }

    public void inputNama(String nama) {
        driver.findElement(inputNama).sendKeys(nama);
    }

    public void inputUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void inputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void inputProgramStudi(String programStudi) {
        driver.findElement(inputProgramStudi).sendKeys(programStudi);
    }

    public void inputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void inputKonfirmasiPassword(String password) {
        driver.findElement(inputKonfirmasiPassword).sendKeys(password);
    }

    public void klikSimpan() {
        driver.findElement(btnSave).click();
    }

    public void klikAktifkan(String idUser) {
        driver.findElement(By.id("btn-activate-" + idUser)).click();
    }

    public void klikNonaktifkan(String idUser) {
        driver.findElement(By.id("btn-deactivate-" + idUser)).click();
    }
    public void bukaMenuListDosen() {
        // Karena halaman list dosen diakses via sidebar menu yang sama
        driver.findElement(AppiumBy.id("menu-item-tambah-dosen")).click();
    }
    public void klikAktifkanDosen() {
        // Contoh jika ID user yang mau diuji di emulator adalah user 1
        // Sesuaikan string ini dengan id_user_si asli yang muncul di layar aplikasimu
        driver.findElement(AppiumBy.id("btn-activate-1")).click();
    }
    public void klikNonaktifkan() {
        driver.findElement(AppiumBy.id("btn-deactivate-1")).click();
    }
}