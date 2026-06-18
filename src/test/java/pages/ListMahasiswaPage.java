package pages;

import io.appium.java_client.android.AndroidDriver;
import org.example.BasePage;
import org.example.locators.MahasiswaLocators;

public class ListMahasiswaPage extends BasePage {

    public ListMahasiswaPage(AndroidDriver driver) {
        super(driver);
    }

    public void klikTambahMahasiswa() {
        click(MahasiswaLocators.BTN_GO_ADD_STUDENT);
    }

    public void aktifkanMahasiswa(String idUserSi) {
        click(MahasiswaLocators.btnActivate(idUserSi));
    }

    public void nonaktifkanMahasiswa(String idUserSi) {
        click(MahasiswaLocators.btnDeactivate(idUserSi));
    }

    public boolean tombolAktifkanTampil(String idUserSi) {
        return isDisplayed(MahasiswaLocators.btnActivate(idUserSi));
    }

    public boolean tombolNonaktifkanTampil(String idUserSi) {
        return isDisplayed(MahasiswaLocators.btnDeactivate(idUserSi));
    }

    public boolean halamanListMahasiswaTampil() {
        return isDisplayed(MahasiswaLocators.BTN_GO_ADD_STUDENT);
    }
}
