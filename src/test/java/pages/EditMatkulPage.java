package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EditMatkulPage {

    AndroidDriver driver;

    By menuMatkul = By.id("menu_matkul");
    By btnEdit = By.id("btn_edit");
    By txtNamaMatkul = By.id("et_nama_matkul");
    By btnSimpan = By.id("btn_simpan");

    public EditMatkulPage(AndroidDriver driver){
        this.driver = driver;
    }

    public void bukaHalamanMatkul(){
        driver.findElement(menuMatkul).click();
    }

    public void klikEdit(){
        driver.findElement(btnEdit).click();
    }

    public void ubahNamaMatkul(String nama){
        driver.findElement(txtNamaMatkul).clear();
        driver.findElement(txtNamaMatkul).sendKeys(nama);
    }

    public void simpanPerubahan(){
        driver.findElement(btnSimpan).click();
    }
}