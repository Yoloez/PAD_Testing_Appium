package stepDef.pengumuman;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.DriverManager;
import pages.pengumuman.AnnouncementPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PengumumanSteps {

    private AndroidDriver driver = DriverManager.getDriver();
    private AnnouncementPage announcementPage = new AnnouncementPage(driver);

    @Given("manager sudah berada di halaman buat pengumuman")
    public void managerSudahBeradaDiHalamanBuatPengumuman() {
        announcementPage.masukKePengumuman();
        System.out.println("LOG: Manager stand-by di halaman pengumuman.");
    }

    @And("manager menekan tombol submit pengumuman")
    public void managerMenekanTombolSubmitPengumuman() {
        announcementPage.clickSubmit();
    }

    // ================= FLOW MANAGER: POSITIVE =================

    @When("manager mengisi judul pengumuman dengan {string}")
    public void managerMengisiJudulPengumumanDengan(String title) {
        announcementPage.inputTitle(title);
    }

    @And("manager mengisi pesan pengumuman dengan {string}")
    public void managerMengisiPesanPengumumanDengan(String message) {
        announcementPage.inputMessage(message);
    }

    @Then("sistem berhasil menyimpan pengumuman baru")
    public void sistemBerhasilMenyimpanPengumumanBaru() {
        announcementPage.clickAlertOk();
        System.out.println("LOG: Pengumuman berhasil disimpan oleh Manager!");
    }

    @Then("sistem kembali ke halaman dashboard manager")
    public void sistemKembaliKeHalamanDashboardManager() {
        announcementPage.clickBackManager();
        System.out.println("LOG: Berhasil menekan tombol back, kembali ke Dashboard Manager.");
    }

    // ================= FLOW MANAGER: NEGATIVE =================

    @When("manager mengosongkan kolom judul dan pesan pengumuman")
    public void managerMengosongkanKolomJudulDanPesanPengumuman() {
        announcementPage.inputTitle("");
        announcementPage.inputMessage("");
    }

    @Then("sistem menampilkan pesan error validasi wajib isi")
    public void sistemMenampilkanPesanErrorValidasiWajibIsi() {
        assertTrue(announcementPage.isErrorMessageVisible(),
                "Pesan error validasi tidak muncul di layar saat form kosong!");
        // Alert "Peringatan" muncul dan sudah tervalidasi → dismiss dulu
        // agar step berikutnya bisa verifikasi kita masih di halaman form
        announcementPage.clickAlertOk();
        System.out.println("LOG: Alert peringatan berhasil di-dismiss.");
    }

    @And("sistem tetap berada di halaman buat pengumuman")
    public void sistemTetapBeradaDiHalamanBuatPengumuman() {
        assertTrue(announcementPage.isOnAnnouncementPage(),
                "Kirim Pengumuman");
    }

    // ================= FLOW MAHASISWA =================

    @Given("mahasiswa melakukan login dan membuka halaman pemberitahuan")
    public void mahasiswaMelakukanLoginDanMembukaHalamanPemberitahuan() {
        System.out.println("LOG: Memulai proses relogin ke akun Mahasiswa...");

        // Buka menu lalu logout dari admin
        announcementPage.openMenuAndLogout();

        // Login menggunakan akun mahasiswa
        announcementPage.loginSebagai("handoko@gmail.com", "hanan123");

        try {
            // Jeda loading login
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("mahasiswa mengeklik tombol lihat pengumuman")
    public void mahasiswaMengeklikTombolLihatPengumuman() {
        announcementPage.clickBtnNotification();
    }

    @Then("mahasiswa harus melihat pengumuman dengan pesan {string}")
    public void mahasiswaHarusMelihatPengumumanDenganPesan(String pesanDiharapkan) {
        String pesanAktif = announcementPage.getNotificationTextByContent(pesanDiharapkan);
        assertEquals(pesanDiharapkan, pesanAktif, "Pesan pengumuman yang diterima tidak sesuai!");
        System.out.println("LOG: Validasi pengumuman mahasiswa BERHASIL!");
    }
}