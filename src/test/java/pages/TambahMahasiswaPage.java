package pages;

import io.appium.java_client.android.AndroidDriver;
import org.example.BasePage;
import org.example.locators.MahasiswaLocators;
import org.example.locators.MatkulLocators;

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

    private String parseValue(String val) {
        return (val == null || val.equals("[empty]")) ? "" : val;
    }

    public void inputNamaLengkap(String nama) {
        sendKeys(MahasiswaLocators.INPUT_NAME_CREATE_STUDENT, parseValue(nama));
    }

    public void inputUsername(String username) {
        sendKeys(MahasiswaLocators.INPUT_USERNAME_CREATE_STUDENT, parseValue(username));
    }

    public void inputEmail(String email) {
        sendKeys(MahasiswaLocators.INPUT_EMAIL_CREATE_STUDENT, parseValue(email));
    }

    public void inputNim(String nim) {
        sendKeys(MahasiswaLocators.INPUT_NIM_CREATE_STUDENT, parseValue(nim));
    }

    public void inputProgramStudi(String prodi) {
        String finalProdi = parseValue(prodi);
        if (!finalProdi.isEmpty()) {
            // Klik dropdown Picker terlebih dahulu
            click(MahasiswaLocators.INPUT_PROGRAM_CREATE_STUDENT);
            
            // Tunggu sebentar sampai dialog native muncul, lalu klik teks opsinya
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            
            click(io.appium.java_client.AppiumBy.androidUIAutomator("new UiSelector().text(\"" + finalProdi + "\")"));
        }
    }

    public void inputPassword(String password) {
        sendKeys(MahasiswaLocators.INPUT_PASSWORD_CREATE_STUDENT, parseValue(password));
    }

    public void inputKonfirmasiPassword(String konfirmasiPassword) {
        sendKeys(MahasiswaLocators.INPUT_PASSWORD_CONF_CREATE_STUDENT, parseValue(konfirmasiPassword));
    }

    public void klikSimpan() {
        click(MahasiswaLocators.BTN_SAVE_CREATE_STUDENT);
    }

    public void klikBack() {
        click(MahasiswaLocators.BTN_BACK_CREATE_STUDENT);
    }

    public void klikOK() {
        click(MatkulLocators.ALERT_OK);
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
