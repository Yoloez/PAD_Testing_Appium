package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LecturerPage {

    AndroidDriver driver;

    public LecturerPage(AndroidDriver driver) {
        this.driver = driver;
    }

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
        driver.findElement(
                By.id("btn-activate-" + idUser)
        ).click();
    }

    public void klikNonaktifkan(String idUser) {
        driver.findElement(
                By.id("btn-deactivate-" + idUser)
        ).click();
    }

    public void tambahDosen(
            String nama,
            String username,
            String email,
            String programStudi,
            String password,
            String konfirmasiPassword
    ) {
        inputNama(nama);
        inputUsername(username);
        inputEmail(email);
        inputProgramStudi(programStudi);
        inputPassword(password);
        inputKonfirmasiPassword(konfirmasiPassword);
        klikSimpan();
    }
}