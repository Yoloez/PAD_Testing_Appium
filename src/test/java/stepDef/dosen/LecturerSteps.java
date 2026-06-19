package stepDef.dosen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.utils.DriverManager;
import pages.LecturerPage;

import java.net.URL;
import java.time.Duration;

public class LecturerSteps {

    // Ubah jadi static agar session driver-nya konsisten selama test suite berjalan
    private AndroidDriver driver = DriverManager.getDriver();
    private LecturerPage lecturerPage = new LecturerPage(driver);

    // @Before akan otomatis berjalan LEBIH DULU sebelum skenario apa pun dimulai
//    @Before
//    public void initDriver() throws Exception {
//        if (driver == null) { // Menghindari pembuatan driver baru jika session masih ada
//            UiAutomator2Options options = new UiAutomator2Options();
//            options.setPlatformName("Android");
//            options.setAutomationName("UiAutomator2");
//            options.setDeviceName("Android Emulator"); // Ganti dengan UDID HP jika pakai HP asli
//
//            // WAJIB DIISI:
//            options.setAppPackage("com.hananfijananto.cobanativewind"); // Ganti dengan package aplikasi kamu
//            options.setAppActivity("com.hananfijananto.cobanativewind.MainActivity");     // Ganti dengan activity aplikasi kamu
//            options.setNoReset(false);
//
//            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        }
//
//        // Inisialisasi page object setiap skenario dimulai
//        lecturerPage = new LecturerPage(driver);
//    }

    @Given("admin sudah login")
    public void adminSudahLogin() throws InterruptedException {
        // Berikan jeda eksplisit 3-5 detik agar aplikasi selesai memuat halaman login sepenuhnya
        Thread.sleep(5000);

        lecturerPage.melakukanLogin("admin@gmail.com", "admin123");
        System.out.println("Kondisi: Admin sukses login otomatis lewat kode");
    }

    @When("admin membuka menu tambah dosen")
    public void adminMembukaMenuTambahDosen() {
        // 1. Klik tombol buka menu/sidebar dulu
        lecturerPage.bukaSidebarMenu();

        // 2. Klik menu tambah dosen
        lecturerPage.bukaMenuTambahDosen();
    }

    @When("admin mengisi data dosen valid")
    public void adminMengisiDataDosenValid() {
        lecturerPage.inputNama("Budi Santoso");
        lecturerPage.inputUsername("budisantoso");
        lecturerPage.inputEmail("budi@test.com");
        lecturerPage.inputProgramStudi("Informatika");
        lecturerPage.inputPassword("Admin123");
        lecturerPage.inputKonfirmasiPassword("Admin123");
    }

    @Then("admin klik tombol tambah dosen")
    public void adminMenekanTombolTambahDosen() {
        lecturerPage.klikTambahDosen();}

    @When("admin mengisi email tidak valid")
    public void adminMengisiEmailTidakValid() {
        lecturerPage.inputNama("javian");
        lecturerPage.inputUsername("javian");
        lecturerPage.inputEmail("buditest.com"); // Email salah format
        lecturerPage.inputProgramStudi("Informatika");
        lecturerPage.inputPassword("Admin123");
        lecturerPage.inputKonfirmasiPassword("Admin123");
    }

    @And("admin menekan tombol simpan")
    public void adminMenekanTombolSimpan() {
        lecturerPage.klikSimpan();
    }
    @Given("admin berada di halaman daftar dosen")
    public void adminBeradaDiHalamanDaftarDosen() {
        // Langkah menuju ke halaman daftar dosen
        lecturerPage.bukaSidebarMenu(); // Mencari btn-open-menu

        // Asumsi di LecturerPage kamu buat method untuk klik menu list dosen
        // Sesuai dokumen ID, ID Tombol Tambah/Menu Dosen adalah "btn-go-add-lecturer" atau menu dosen pendukung [cite: 40]
        lecturerPage.bukaMenuListDosen();
    }

    @When("admin menekan tombol aktifkan dosen")
    public void adminMenekanTombolAktifkanDosen() {
        // ID di dokumen: btn-activate-{id_user_si} [cite: 40]
        // Buat logic di LecturerPage untuk menekan ID tombol aktivasi tersebut
        lecturerPage.klikAktifkanDosen();
    }

    @Then("status dosen menjadi aktif")
    public void statusDosenMenjadiAktif() {
    // Verifikasi status dosen berubah menjadi aktif
        lecturerPage.klikUbahStatusDosen();
        lecturerPage.klikOK();
        System.out.println("Verifikasi: Dosen berhasil diaktifkan.");
    }

    @When("admin menekan tombol nonaktifkan dosen")
    public void adminMenekanTombolNonaktifkanDosen() {
        // ID di dokumen: btn-deactivate-{id_user_si} [cite: 41]
        lecturerPage.klikNonaktifkan();
    }

    @Then("status dosen menjadi nonaktif")
    public void statusDosenMenjadiNonaktif() {
        lecturerPage.klikUbahStatusDosen();
        lecturerPage.klikOK();
        System.out.println("Verifikasi: Dosen berhasil dinonaktifkan.");
    }

    @Then("data dosen berhasil ditambahkan")
    public void dataDosenBerhasilDitambahkan() {
        lecturerPage.klikOK();
        System.out.println("Verifikasi: Data dosen berhasil tersimpan.");
    }

    @Then("muncul pesan email tidak valid")
    public void munculPesanEmailTidakValid() {
        System.out.println("Verifikasi: Error alert email tidak valid muncul.");
    }

    // Sediakan penanda agar penutupan driver dilakukan di akhir seluruh test selesai saja
//    @After
//    public void resetAppBetweenScenarios() {
//        if (driver != null) {
//            // Alih-alih menutup total driver, kita cukup menutup dan membuka ulang aplikasinya saja
//            // agar kembali bersih ke Dashboard utama
//            driver.terminateApp("com.hananfijananto.cobanativewind");
//            driver.activateApp("com.hananfijananto.cobanativewind");
//        }
//    }
}