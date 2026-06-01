package stepDef;

import io.cucumber.java.en.When;
import pages.EditMatkulPage;

public class EditSteps {

    EditMatkulPage editPage;

    @When("admin membuka halaman mata kuliah")
    public void bukaHalamanMatkul() {
        editPage.bukaHalamanMatkul();
    }

    @When("admin memilih mata kuliah")
    public void pilihMatkul() {
        editPage.klikEdit();
    }

    @When("admin mengubah nama mata kuliah menjadi {string}")
    public void ubahNama(String nama) {
        editPage.ubahNamaMatkul(nama);
    }

    @When("admin menyimpan perubahan")
    public void simpanPerubahan() {
        editPage.simpanPerubahan();
    }
}
