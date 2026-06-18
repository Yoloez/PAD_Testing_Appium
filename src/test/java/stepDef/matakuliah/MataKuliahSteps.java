package stepDef.matakuliah ;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions; // Menggunakan JUnit 5
import pages.matakuliah.DeleteMatkulPage;
import pages.matakuliah.EditMatkulPage;
import pages.matakuliah.TambahMatkulPage;
import org.example.BasePage; // Sesuaikan dengan lokasi file BasePage kamu

public class MataKuliahSteps {

    // Inisiasi semua class Pages menggunakan driver dari BasePage
    // (Pastikan variabel driver di BasePage sudah di-set menjadi 'public static AndroidDriver driver;')
    TambahMatkulPage tambahPage = new TambahMatkulPage(BasePage.driver);
    EditMatkulPage editPage = new EditMatkulPage(BasePage.driver);
    DeleteMatkulPage deletePage = new DeleteMatkulPage(BasePage.driver);

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
        // Format JUnit 5: Assertions.assertTrue(kondisi, pesanErrorJikaGagal)
        Assertions.assertTrue(
                actualPesan.contains(expectedPesan),
                "Error: Pesan alert tidak sesuai. Actual: " + actualPesan + ", Expected: " + expectedPesan
        );
    }

    @And("User klik OK pada alert")
    public void userKlikOKPadaAlert() {
        tambahPage.clickOkAlert();
    }

    // === STEPS: EDIT MATKUL ===
    @When("User klik tombol edit mata kuliah")
    public void userKlikTombolEditMataKuliah() {
        editPage.clickBtnEdit();
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
    @When("User klik tombol delete untuk mata kuliah dengan ID {string}")
    public void userKlikTombolDeleteUntukMataKuliahDenganID(String idMatkul) {
        deletePage.clickBtnDelete(idMatkul);
    }

    @And("User konfirmasi hapus data pada alert")
    public void userKonfirmasiHapusDataPadaAlert() {
        deletePage.confirmDelete();
    }
}