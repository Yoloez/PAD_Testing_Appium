//package stepDef.mahasiswa;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.example.utils.DriverManager;
//import org.junit.Assert;
//import pages.ListMahasiswaPage;
//import pages.TambahMahasiswaPage;
//
//import java.util.Map;
//
//public class MahasiswaSteps {
//
//    private final TambahMahasiswaPage tambahMahasiswaPage = new TambahMahasiswaPage(DriverManager.getDriver());
//    private final ListMahasiswaPage listMahasiswaPage = new ListMahasiswaPage(DriverManager.getDriver());
//
//    private String idUserSiTerakhir;
//
//    @Given("admin membuka menu navigasi")
//    public void admin_membuka_menu_navigasi() {
//        tambahMahasiswaPage.bukaMenu();
//    }
//
//    @When("admin memilih menu Tambah Mahasiswa")
//    public void admin_memilih_menu_tambah_mahasiswa() {
//        tambahMahasiswaPage.pilihMenuTambahMahasiswa();
//    }
//
//
//    @Given("admin berada di halaman List Mahasiswa")
//    public void admin_berada_di_halaman_list_mahasiswa() {
//        Assert.assertTrue("Halaman List Mahasiswa tidak tampil",
//                listMahasiswaPage.halamanListMahasiswaTampil());
//    }
//
//    @When("admin menekan tombol Tambah Mahasiswa pada halaman list")
//    public void admin_menekan_tombol_tambah_mahasiswa_pada_halaman_list() {
//        listMahasiswaPage.klikTambahMahasiswa();
//    }
//
//    @Then("admin kembali ke halaman List Mahasiswa")
//    public void admin_kembali_ke_halaman_list_mahasiswa() {
//        Assert.assertTrue("Halaman List Mahasiswa tidak tampil setelah klik Back",
//                listMahasiswaPage.halamanListMahasiswaTampil());
//    }
//
//    @When("admin mengisi form tambah mahasiswa dengan data berikut:")
//    public void admin_mengisi_form_tambah_mahasiswa_dengan_data_berikut(DataTable dataTable) {
//        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
//
//        tambahMahasiswaPage.inputNamaLengkap(data.get("nama"));
//        tambahMahasiswaPage.inputUsername(data.get("username"));
//        tambahMahasiswaPage.inputEmail(data.get("email"));
//        tambahMahasiswaPage.inputNim(data.get("nim"));
//        tambahMahasiswaPage.inputProgramStudi(data.get("program_studi"));
//        tambahMahasiswaPage.inputPassword(data.get("password"));
//        tambahMahasiswaPage.inputKonfirmasiPassword(data.get("konfirmasi_password"));
//    }
//
//    @When("admin menekan tombol Simpan pada form tambah mahasiswa")
//    public void admin_menekan_tombol_simpan_pada_form_tambah_mahasiswa() {
//        tambahMahasiswaPage.klikSimpan();
//    }
//
//    @When("admin menekan tombol Back pada form tambah mahasiswa")
//    public void admin_menekan_tombol_back_pada_form_tambah_mahasiswa() {
//        tambahMahasiswaPage.klikBack();
//    }
//
//    @Then("mahasiswa baru berhasil ditambahkan")
//    public void mahasiswa_baru_berhasil_ditambahkan() {
//        Assert.assertTrue("Halaman List Mahasiswa tidak tampil setelah menyimpan data mahasiswa baru",
//                listMahasiswaPage.halamanListMahasiswaTampil());
//    }
//
//    @Then("admin tetap berada di halaman Tambah Mahasiswa")
//    public void admin_tetap_berada_di_halaman_tambah_mahasiswa() {
//        Assert.assertTrue("Halaman Tambah Mahasiswa tidak tampil, kemungkinan validasi gagal diproses",
//                tambahMahasiswaPage.halamanTambahMahasiswaTampil());
//    }
//
//    @When("admin menekan tombol Aktifkan pada mahasiswa dengan id {string}")
//    public void admin_menekan_tombol_aktifkan_pada_mahasiswa_dengan_id(String idUserSi) {
//        idUserSiTerakhir = idUserSi;
//        listMahasiswaPage.aktifkanMahasiswa(idUserSi);
//    }
//
//    @When("admin menekan tombol Nonaktifkan pada mahasiswa dengan id {string}")
//    public void admin_menekan_tombol_nonaktifkan_pada_mahasiswa_dengan_id(String idUserSi) {
//        idUserSiTerakhir = idUserSi;
//        listMahasiswaPage.nonaktifkanMahasiswa(idUserSi);
//    }
//
//    @Then("status mahasiswa berubah menjadi aktif")
//    public void status_mahasiswa_berubah_menjadi_aktif() {
//        Assert.assertTrue(
//                "Tombol Nonaktifkan tidak muncul, status mahasiswa belum berubah menjadi aktif",
//                listMahasiswaPage.tombolNonaktifkanTampil(idUserSiTerakhir));
//    }
//
//    @Then("status mahasiswa berubah menjadi nonaktif")
//    public void status_mahasiswa_berubah_menjadi_nonaktif() {
//        Assert.assertTrue(
//                "Tombol Aktifkan tidak muncul, status mahasiswa belum berubah menjadi nonaktif",
//                listMahasiswaPage.tombolAktifkanTampil(idUserSiTerakhir));
//    }
//}
