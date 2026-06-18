package pages.matakuliah;

import org.example.locators.MatkulLocators;
import org.example.BasePage; // Sesuaikan import jika berbeda
import io.appium.java_client.android.AndroidDriver;

public class EditMatkulPage extends BasePage {

    public EditMatkulPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickBtnEdit() {
        driver.findElement(MatkulLocators.BTN_EDIT).click();
    }

    public void editDataMatkul(String namaBaru, String kodeBaru, String sksBaru) {
        // Hapus data lama terlebih dahulu, lalu masukkan data baru
        driver.findElement(MatkulLocators.INPUT_NAMA_EDIT).clear();
        driver.findElement(MatkulLocators.INPUT_NAMA_EDIT).sendKeys(namaBaru);

        driver.findElement(MatkulLocators.INPUT_KODE_EDIT).clear();
        driver.findElement(MatkulLocators.INPUT_KODE_EDIT).sendKeys(kodeBaru);

        driver.findElement(MatkulLocators.INPUT_SKS_EDIT).clear();
        driver.findElement(MatkulLocators.INPUT_SKS_EDIT).sendKeys(sksBaru);
    }

    public void clickSimpanEdit() {
        driver.findElement(MatkulLocators.BTN_SIMPAN_EDIT).click();
    }
}