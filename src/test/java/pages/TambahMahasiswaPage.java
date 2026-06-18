package pages;

import io.appium.java_client.android.AndroidDriver;
import org.example.BasePage;
import org.example.locators.MahasiswaLocators;

public class TambahMahasiswaPage extends BasePage {

    public TambahMahasiswaPage(AndroidDriver driver) {
        super(driver);
    }


    public void bukaMenu() {
        click(MahasiswaLocators.BTN_OPEN_MENU);
    }

    public void pilihMenuTambahMahasiswa() {
        click(MahasiswaLocators.MENU_TAMBAH_MAHASISWA);
    }

    public void inputNamaLengkap(String nama) {
        sendKeys(MahasiswaLocators.INPUT_NAME_CREATE_STUDENT, nama);
    }

    public void inputUsername(String username) {
        sendKeys(MahasiswaLocators.INPUT_USERNAME_CREATE_STUDENT, username);
    }

    public void inputEmail(String email) {
        sendKeys(MahasiswaLocators.INPUT_EMAIL_CREATE_STUDENT, email);
    }

    public void inputNim(String nim) {
        sendKeys(MahasiswaLocators.INPUT_NIM_CREATE_STUDENT, nim);
    }

    public void inputProgramStudi(String prodi) {
        sendKeys(MahasiswaLocators.INPUT_PROGRAM_CREATE_STUDENT, prodi);
    }

    public void inputPassword(String password) {
        sendKeys(MahasiswaLocators.INPUT_PASSWORD_CREATE_STUDENT, password);
    }

    public void inputKonfirmasiPassword(String konfirmasiPassword) {
        sendKeys(MahasiswaLocators.INPUT_PASSWORD_CONF_CREATE_STUDENT, konfirmasiPassword);
    }

    public void klikSimpan() {
        click(MahasiswaLocators.BTN_SAVE_CREATE_STUDENT);
    }

    public void klikBack() {
        click(MahasiswaLocators.BTN_BACK_CREATE_STUDENT);
    }

    public void tambahMahasiswaBaru(String nama, String username, String email,
                                    String nim, String programStudi,
                                    String password, String konfirmasiPassword) {
        inputNamaLengkap(nama);
        inputUsername(username);
        inputEmail(email);
        inputNim(nim);
        inputProgramStudi(programStudi);
        inputPassword(password);
        inputKonfirmasiPassword(konfirmasiPassword);
        klikSimpan();
    }

    public boolean halamanTambahMahasiswaTampil() {
        return isDisplayed(MahasiswaLocators.BTN_SAVE_CREATE_STUDENT);
    }
}
