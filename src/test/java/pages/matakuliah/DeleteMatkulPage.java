package pages.matakuliah;

import io.appium.java_client.android.AndroidDriver;
import org.example.locators.MatkulLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteMatkulPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public DeleteMatkulPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickBtnDelete(Integer idMatkul) {
        wait.until(ExpectedConditions.elementToBeClickable(MatkulLocators.BTN_DELETE(idMatkul))).click();
        System.out.println("LOG: Tombol Delete untuk matkul ID '" + idMatkul + "' ditekan.");
    }

    public void confirmDelete() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(MatkulLocators.ALERT_OK)).click();
            System.out.println("LOG: Konfirmasi hapus berhasil (klik OK pada alert).");
        } catch (Exception e) {
            System.out.println("LOG: Gagal klik OK pada alert konfirmasi hapus: " + e.getMessage());
        }
    }
}