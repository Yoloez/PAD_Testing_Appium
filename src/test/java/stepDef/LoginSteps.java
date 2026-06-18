package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Given("Admin berada di halaman login")
    public void adminBeradaDiHalamanLogin() {
        // Asumsi variabel 'driver' nanti diwariskan dari konfigurasi utils/hooks tim
        // loginPage = new LoginPage(driver);
        System.out.println("Sistem membuka halaman login");
    }

    @When("Admin memasukkan email {string}")
    public void adminMemasukkanEmail(String email) {
        loginPage.inputEmail(email);
    }

    @And("Admin memasukkan password {string}")
    public void adminMemasukkanPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("Admin menekan tombol login")
    public void adminMenekanTombolLogin() {
        loginPage.clickLogin();
    }

    @Then("Admin diarahkan ke halaman dashboard")
    public void adminDiarahkanKeHalamanDashboard() {
        // TODO: Tambahkan assertion untuk mengecek elemen di dashboard muncul
        System.out.println("Berhasil masuk dashboard sebagai admin");
    }

    @Then("Sistem menampilkan pesan error login")
    public void sistemMenampilkanPesanErrorLogin() {
        // TODO: Tambahkan assertion untuk memastikan pesan error muncul
        System.out.println("Pesan error muncul");
    }
}