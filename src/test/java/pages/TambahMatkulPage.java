package pages;

import io.appium.java_client.android.AndroidDriver;
import org.example.BasePage;
import org.example.locators.MatkulLocators;

public class TambahMatkulPage extends BasePage {

    public TambahMatkulPage(AndroidDriver driver) {
        super(driver);
    }

    public void bukaHalamanDaftarMatkul() {
        click(MatkulLocators.MENU_MATKUL);
    }

    public void klikTambah() {
        click(MatkulLocators.BTN_TAMBAH);
    }

    public void isiNamaMatkul(String nama) {
        sendKeys(MatkulLocators.INPUT_NAMA, nama);
    }

    public void isiKodeMatkul(String kode) {
        sendKeys(MatkulLocators.INPUT_KODE, kode);
    }

    public void isiSks(String sks) {
        sendKeys(MatkulLocators.INPUT_SKS, sks);
    }

    public void klikSimpan() {
        click(MatkulLocators.BTN_SIMPAN);
    }

    public String ambilPesanAlert() {
        return getText(MatkulLocators.ALERT_MESSAGE);
    }

    public void tutupAlertSukses() {
        click(MatkulLocators.ALERT_OK);
    }
}
