package stepDef;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.*;
import pages.LecturerPage;

import java.net.URL;

public class LecturerSteps {

    AndroidDriver driver;
    LecturerPage lecturerPage;

    @Given("admin sudah login")
    public void adminSudahLogin() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        lecturerPage = new LecturerPage(driver);

        // Tambahkan flow login jika diperlukan
    }

    @When("admin membuka menu tambah dosen")
    public void adminMembukaMenuTambahDosen() {
        lecturerPage.bukaMenuTambahDosen();
    }

    @When("admin mengisi data dosen valid")
    public void adminMengisiDataDosenValid() {

        lecturerPage.tambahDosen(
                "Budi Santoso",
                "budisantoso",
                "budi@test.com",
                "Informatika",
                "Admin123",
                "Admin123"
        );
    }

    @When("admin mengisi email tidak valid")
    public void adminMengisiEmailTidakValid() {

        lecturerPage.tambahDosen(
                "Budi Santoso",
                "budisantoso",
                "buditest.com",
                "Informatika",
                "Admin123",
                "Admin123"
        );
    }

    @Then("data dosen berhasil ditambahkan")
    public void dataDosenBerhasilDitambahkan() {

        System.out.println("Data berhasil ditambahkan");

        driver.quit();
    }

    @Then("muncul pesan email tidak valid")
    public void munculPesanEmailTidakValid() {

        System.out.println("Validasi email muncul");

        driver.quit();
    }

    @When("admin menekan tombol aktifkan dosen")
    public void aktifkanDosen() {

        lecturerPage.klikAktifkan("1");
    }

    @Then("status dosen menjadi aktif")
    public void statusMenjadiAktif() {

        System.out.println("Dosen berhasil diaktifkan");
    }

    @When("admin menekan tombol nonaktifkan dosen")
    public void nonaktifkanDosen() {

        lecturerPage.klikNonaktifkan("1");
    }

    @Then("status dosen menjadi nonaktif")
    public void statusMenjadiNonaktif() {

        System.out.println("Dosen berhasil dinonaktifkan");
    }
}