package pages.matakuliah;

import org.example.locators.MatkulLocators;
import org.example.BasePage; // Pastikan package ini sesuai dengan punyamu
import io.appium.java_client.android.AndroidDriver;

public class DeleteMatkulPage extends BasePage {

    public DeleteMatkulPage(AndroidDriver driver) {
        super(driver);
    }

    // Method ini sekarang meminta input berupa ID Mata Kuliah
    public void clickBtnDelete(String idMatkul) {
        driver.findElement(MatkulLocators.BTN_DELETE(idMatkul)).click();
    }

    public void confirmDelete() {
        driver.findElement(MatkulLocators.ALERT_OK).click();
    }
}