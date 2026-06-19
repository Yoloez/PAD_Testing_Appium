package pages.matakuliah;

import io.appium.java_client.android.AndroidDriver;
import org.example.locators.DashboardLocators;
import org.example.locators.MatkulLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TambahMatkulPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public TambahMatkulPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigasi: buka menu → pilih menu Mata Kuliah
    public void clickMenuMatkul() {
        wait.until(ExpectedConditions.elementToBeClickable(DashboardLocators.BTN_OPEN_MENU)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MatkulLocators.MENU_MATKUL)).click();
        System.out.println("LOG: Berhasil masuk ke halaman Mata Kuliah.");
    }

    public void clickBtnTambah() {
        wait.until(ExpectedConditions.elementToBeClickable(MatkulLocators.BTN_TAMBAH)).click();
        System.out.println("LOG: Berhasil klik tombol Tambah Mata Kuliah.");
    }

    public void inputDataMatkul(String nama, String kode, String sks) {
        WebElement inputNama = wait.until(ExpectedConditions.visibilityOfElementLocated(MatkulLocators.INPUT_NAMA));
        inputNama.clear();
        inputNama.sendKeys(nama);

        WebElement inputKode = wait.until(ExpectedConditions.visibilityOfElementLocated(MatkulLocators.INPUT_KODE));
        inputKode.clear();
        inputKode.sendKeys(kode);

        WebElement inputSks = wait.until(ExpectedConditions.visibilityOfElementLocated(MatkulLocators.INPUT_SKS));
        inputSks.clear();
        inputSks.sendKeys(sks);

        System.out.println("LOG: Form tambah matkul diisi → " + nama + " | " + kode + " | SKS " + sks);
    }

    public void clickSimpan() {
        wait.until(ExpectedConditions.elementToBeClickable(MatkulLocators.BTN_SIMPAN)).click();
        System.out.println("LOG: Tombol Simpan ditekan.");
    }

    // Mengambil teks dari alert — fallback ke androidUIAutomator jika pesan berbeda
    public String getAlertMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(MatkulLocators.ALERT_MESSAGE)).getText();
        } catch (Exception e) {
            System.out.println("LOG: Gagal membaca teks alert: " + e.getMessage());
            return "";
        }
    }

    public void clickOkAlert() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(MatkulLocators.ALERT_OK)).click();
            System.out.println("LOG: Berhasil klik OK pada alert.");
        } catch (Exception e) {
            System.out.println("LOG: Gagal klik OK alert: " + e.getMessage());
        }
    }
}