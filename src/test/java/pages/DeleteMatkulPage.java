package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DeleteMatkulPage {

    AndroidDriver driver;
    WebDriverWait wait;

    // Constructor
    public DeleteMatkulPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void klikIkonSampahBerdasarkanId(String idMatkul) {
        WebElement tombolSampah = driver.findElement(AppiumBy.accessibilityId("btn-delete-" + idMatkul));
        tombolSampah.click();
    }

    public void klikTombolKonfirmasiHapus() {
        WebElement tombolKonfirmasi = wait.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))
        );
        tombolKonfirmasi.click();
    }

    public String getPesanSukses() {
        WebElement pesan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/message"))
        );
        return pesan.getText();
    }

    public void klikOkAlertSukses() {
        WebElement tombolOkSukses = wait.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))
        );
        tombolOkSukses.click();
    }
}