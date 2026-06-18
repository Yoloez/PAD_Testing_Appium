package pages.matakuliah;

import io.appium.java_client.android.AndroidDriver;
import org.example.BasePage;
import org.example.locators.MatkulLocators;

public class EditMatkulPage extends BasePage {

    public EditMatkulPage(AndroidDriver driver) {
        super(driver);
    }

    public void bukaHalamanMatkul() {
        click(MatkulLocators.MENU_MATKUL);
    }

    public void klikEdit() {
        click(MatkulLocators.BTN_EDIT);
    }

    public void ubahNamaMatkul(String nama) {
        clearAndSendKeys(MatkulLocators.INPUT_NAMA, nama);
    }

    public void simpanPerubahan() {
        click(MatkulLocators.BTN_SIMPAN);
    }
}