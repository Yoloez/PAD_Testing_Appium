package pages.matakuliah;

import io.appium.java_client.android.AndroidDriver;
import org.example.locators.MatkulLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditMatkulPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public EditMatkulPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickBtnEdit(int idMatkul) {
        wait.until(ExpectedConditions.elementToBeClickable(MatkulLocators.BTN_EDIT(idMatkul))).click();
        System.out.println("LOG: Tombol Edit mata kuliah ditekan.");
    }

    public void editDataMatkul(String namaBaru, String kodeBaru, String sksBaru) {
        WebElement inputNama = wait.until(ExpectedConditions.visibilityOfElementLocated(MatkulLocators.INPUT_NAMA_EDIT));
        inputNama.clear();
        inputNama.sendKeys(namaBaru);

        WebElement inputKode = wait.until(ExpectedConditions.visibilityOfElementLocated(MatkulLocators.INPUT_KODE_EDIT));
        inputKode.clear();
        inputKode.sendKeys(kodeBaru);

        WebElement inputSks = wait.until(ExpectedConditions.visibilityOfElementLocated(MatkulLocators.INPUT_SKS_EDIT));
        inputSks.clear();
        inputSks.sendKeys(sksBaru);

        System.out.println("LOG: Form edit matkul diisi → " + namaBaru + " | " + kodeBaru + " | SKS " + sksBaru);
    }

    public void clickSimpanEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(MatkulLocators.BTN_SIMPAN_EDIT)).click();
        System.out.println("LOG: Tombol Simpan Edit ditekan.");
    }
}