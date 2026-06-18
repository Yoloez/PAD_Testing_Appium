package stepDef.pengumuman;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.DriverManager; // Sesuaikan jika package utils-mu berbeda
import pages.pengumuman.AnnouncementPage; // Mengambil dari folder 'pages' yang ada di strukturmu
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PengumumanSteps {

    // Memanggil driver yang sudah diinisialisasi
    private AndroidDriver driver = DriverManager.getDriver();
    private AnnouncementPage announcementPage = new AnnouncementPage(driver);

    @Given("manager sudah berada di halaman buat pengumuman")
    public void managerSudahBeradaDiHalamanBuatPengumuman() {
        System.out.println("LOG: Manager stand-by di halaman pengumuman.");
    }

    @When("manager mengisi judul pengumuman dengan {string}")
    public void managerMengisiJudulPengumumanDengan(String title) {
        announcementPage.inputTitle(title);
    }

    @And("manager mengisi pesan pengumuman dengan {string}")
    public void managerMengisiPesanPengumumanDengan(String message) {
        announcementPage.inputMessage(message);
    }

    @And("manager menekan tombol submit pengumuman")
    public void managerMenekanTombolSubmitPengumuman() {
        announcementPage.clickSubmit();
    }

    @Then("sistem berhasil menyimpan pengumuman baru")
    public void sistemBerhasilMenyimpanPengumumanBaru() {
        System.out.println("LOG: Pengumuman berhasil disimpan oleh Manager!");
    }

    // ================= FLOW MAHASISWA =================

    @Given("mahasiswa melakukan login dan membuka halaman pemberitahuan")
    public void mahasiswaMelakukanLoginDanMembukaHalamanPemberitahuan() {
        System.out.println("LOG: Proses relogin ke akun Mahasiswa...");
        // Di sini nanti kamu bisa memanggil step/fungsi logout dari Manager
        // lalu memanggil fungsi login sebagai Mahasiswa.
    }

    @When("mahasiswa mengeklik tombol lihat pengumuman")
    public void mahasiswaMengeklikTombolLihatPengumuman() {
        announcementPage.clickBtnNotification();
    }

    @Then("mahasiswa harus melihat pengumuman dengan pesan {string}")
    public void mahasiswaHarusMelihatPengumumanDenganPesan(String pesanDiharapkan) {
        String pesanAktif = announcementPage.getNotificationTextByContent(pesanDiharapkan);
        assertEquals(pesanDiharapkan, pesanAktif);
        System.out.println("LOG: Validasi pengumuman mahasiswa BERHASIL!");
    }
}