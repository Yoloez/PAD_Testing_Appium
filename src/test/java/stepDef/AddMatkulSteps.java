package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.utils.DriverManager;
//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import pages.TambahMatkulPage;

public class AddMatkulSteps {

    TambahMatkulPage tambahMatkulPage = new TambahMatkulPage(DriverManager.getDriver());

    @Given("Admin sudah berada di halaman daftar mata kuliah")
    public void adminBeradaDiHalamanDaftarMatkul() {
        tambahMatkulPage.bukaHalamanDaftarMatkul();
    }

    @When("Admin mengeklik tombol tambah {string}")
    public void adminKlikTombolTambah(String tombolTambah) {
        tambahMatkulPage.klikTambah();
    }

    @When("Admin memasukkan nama mata kuliah {string}")
    public void adminMasukkanNamaMatkul(String nama) {
        tambahMatkulPage.isiNamaMatkul(nama);
    }

    @When("Admin memasukkan kode mata kuliah {string}")
    public void adminMasukkanKodeMatkul(String kode) {
        tambahMatkulPage.isiKodeMatkul(kode);
    }

    @When("Admin memasukkan jumlah SKS {string}")
    public void adminMasukkanSks(String sks) {
        tambahMatkulPage.isiSks(sks);
    }

    @When("Admin mengeklik tombol {string}")
    public void adminKlikTombolSimpan(String tombolSimpan) {
        tambahMatkulPage.klikSimpan();
    }

    @Then("Sistem harus menampilkan alert sukses dengan pesan {string}")
    public void sistemTampilkanAlertSukses(String pesan) {
        Assert.assertEquals(pesan, tambahMatkulPage.ambilPesanAlert());
    }

    @Then("Admin mengeklik OK untuk menutup alert sukses")
    public void adminTutupAlertSukses() {
        tambahMatkulPage.tutupAlertSukses();
    }
}
