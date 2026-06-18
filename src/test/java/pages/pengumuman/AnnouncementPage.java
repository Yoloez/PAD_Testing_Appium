package pages.pengumuman;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.locators.AnnouncementLocators; // <-- Mengimpor file locator milikmu

import java.time.Duration;

public class AnnouncementPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public AnnouncementPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= METHODS MANAGER =================

    public void inputTitle(String title) {
        // Langsung panggil variabel statis dari AnnouncementLocators
        WebElement fieldTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AnnouncementLocators.INPUT_TITLE_PENGUMUMAN));
        fieldTitle.clear();
        fieldTitle.sendKeys(title);
    }

    public void inputMessage(String message) {
        WebElement fieldMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AnnouncementLocators.INPUT_MESSAGE_PENGUMUMAN));
        fieldMessage.clear();
        fieldMessage.sendKeys(message);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.BTN_SUBMIT_PENGUMUMAN)).click();
    }

    public void clickBackManager() {
        wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.BTN_BACK_PENGUMUMAN)).click();
    }

    // ================= METHODS MAHASISWA =================

    public void clickBtnNotification() {
        wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.BTN_NOTIFICATION)).click();
    }

    public String getNotificationTextByContent(String expectedText) {
        // Memanggil method dinamis dari file locator-mu
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AnnouncementLocators.getNotifMessageByText(expectedText)
        ));
        return messageElement.getText();
    }

    public void clickBackMahasiswa() {
        wait.until(ExpectedConditions.elementToBeClickable(AnnouncementLocators.BTN_BACK_NOTIFICATION)).click();
    }
}