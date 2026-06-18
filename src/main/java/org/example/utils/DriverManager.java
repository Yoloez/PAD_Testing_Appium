package org.example.utils; // Sesuaikan dengan package-mu

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");

                // 1. Masukkan UDID HP yang kamu dapat dari Langkah 1
                options.setUdid("9eef12cf");

                // 2. Masukkan appPackage dan appActivity dari Langkah 2
                options.setAppPackage("com.hananfijananto.cobanativewind");
                options.setAppActivity("com.hananfijananto.cobanativewind.MainActivity"); // Untuk React Native biasanya selalu MainActivity

                // (Opsional tapi penting) Agar aplikasi tidak di-reset/dihapus datanya setiap kali tes jalan
                options.setNoReset(true);

                // Tembak ke server Appium lokal
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            } catch (MalformedURLException e) {
                throw new RuntimeException("URL Appium Server Salah!", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}