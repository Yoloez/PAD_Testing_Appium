package stepDef.matakuliah;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.utils.DriverManager;
import org.junit.jupiter.api.Assertions;
import pages.matakuliah.DeleteMatkulPage;
import pages.matakuliah.EditMatkulPage;
import pages.matakuliah.TambahMatkulPage;

public class MataKuliahSteps {

    // Ambil driver dari DriverManager (bukan dari BasePage.driver yang bisa null)
    private final AndroidDriver driver = DriverManager.getDriver();
    private final TambahMatkulPage tambahPage  = new TambahMatkulPage(driver);
    private final EditMatkulPage   editPage    = new EditMatkulPage(driver);
    private final DeleteMatkulPage deletePage  = new DeleteMatkulPage(driver);

    // === STEP: NAVIGASI ===

    @Given("User berada di halaman menu Mata Kuliah")
    public void userBeradaDiHalamanMenuMataKuliah() {
        tambahPage.clickMenuMatkul();
    }

    // === STEPS: TAMBAH MATKUL ===

    @When("User klik tombol Tambah Mata Kuliah")
    public void userKlikTombolTambahMataKuliah() {
        tambahPage.clickBtnTambah();
    }

    @And("User mengisi form dengan nama {string}, kode {string}, dan SKS {string}")
    public void userMengisiFormDenganNamaKodeDanSKS(String nama, String kode, String sks) {
        tambahPage.inputDataMatkul(nama, kode, sks);
    }

    @And("User klik tombol Simpan")
    public void userKlikTombolSimpan() {
        tambahPage.clickSimpan();
    }

    @Then("Sistem menampilkan alert dengan pesan {string}")
    public void sistemMenampilkanAlertDenganPesan(String expectedPesan) {
        String actualPesan = tambahPage.getAlertMessage();
        Assertions.assertTrue(
                actualPesan.contains(expectedPesan),
                "Pesan alert tidak sesuai. Actual: \"" + actualPesan + "\", Expected mengandung: \"" + expectedPesan + "\""
        );
        System.out.println("LOG: Validasi alert berhasil → \"" + actualPesan + "\"");
    }

    @And("User klik OK pada alert")
    public void userKlikOKPadaAlert() {
        tambahPage.clickOkAlert();
    }

    // === STEPS: EDIT MATKUL ===

    @When("User klik tombol edit mata kuliah dengan ID {int}")
    public void userKlikTombolEditMataKuliah(int idMatkul) {
        editPage.clickBtnEdit(idMatkul);
    }

    @And("User mengubah data form menjadi nama {string}, kode {string}, dan SKS {string}")
    public void userMengubahDataFormMenjadiNamaKodeDanSKS(String nama, String kode, String sks) {
        editPage.editDataMatkul(nama, kode, sks);
    }

    @And("User klik tombol Simpan pada form edit")
    public void userKlikTombolSimpanPadaFormEdit() {
        editPage.clickSimpanEdit();
    }

    // === STEPS: DELETE MATKUL ===

    @When("User klik tombol delete untuk mata kuliah dengan ID {int}")
    public void userKlikTombolDeleteUntukMataKuliahDenganID(Integer idMatkul) {
        deletePage.clickBtnDelete(idMatkul);
    }

    @And("User konfirmasi hapus data pada alert")
    public void userKonfirmasiHapusDataPadaAlert() {
        deletePage.confirmDelete();
    }
}