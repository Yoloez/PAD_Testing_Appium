package pages.matakuliah;

import org.example.locators.MatkulLocators;
import org.example.BasePage; // Pastikan path import BasePage ini sudah sesuai dengan punyamu
import io.appium.java_client.android.AndroidDriver; // Ganti import ke AndroidDriver

public class TambahMatkulPage extends BasePage {

    // 1. Parameter diubah menjadi AndroidDriver agar cocok dengan BasePage
    public TambahMatkulPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickMenuMatkul() {
        // Asumsi method click() ada di BasePage kamu. Kalau merah juga, ganti jadi:
        // driver.findElement(MatkulLocators.MENU_MATKUL).click();
        click(MatkulLocators.MENU_MATKUL);
    }

    public void clickBtnTambah() {
        click(MatkulLocators.BTN_TAMBAH);
    }

    public void inputDataMatkul(String nama, String kode, String sks) {
        // 2. Menggunakan method native Appium/Selenium (sendKeys) karena 'type' tidak ada
        driver.findElement(MatkulLocators.INPUT_NAMA).sendKeys(nama);
        driver.findElement(MatkulLocators.INPUT_KODE).sendKeys(kode);
        driver.findElement(MatkulLocators.INPUT_SKS).sendKeys(sks);
    }

    public void clickSimpan() {
        click(MatkulLocators.BTN_SIMPAN);
    }

    public String getAlertMessage() {
        // Jika method getText() tidak ada di BasePage, gunakan cara native ini:
        return driver.findElement(MatkulLocators.ALERT_MESSAGE).getText();
    }

    public void clickOkAlert() {
        click(MatkulLocators.ALERT_OK);
    }
}