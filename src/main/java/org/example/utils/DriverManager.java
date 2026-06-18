package org.example.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.net.URI;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                String appPackage = readConfig("APP_PACKAGE", "com.hananfijananto.cobanativewind");
                String appActivity = readConfig("APP_ACTIVITY", "com.hananfijananto.cobanativewind.MainActivity");
                String deviceName = readConfig("DEVICE_NAME", "Vivo V2348");
                String appiumServerUrl = readConfig("APPIUM_SERVER_URL", "http://127.0.0.1:4723");
                String appWaitActivity = readConfig("APP_WAIT_ACTIVITY", "");

                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");
                options.setAppPackage(appPackage);
                options.setAppActivity(appActivity);
                options.setDeviceName(deviceName);
                options.setNoReset(true);
                options.setAutoGrantPermissions(true);
                options.setNewCommandTimeout(Duration.ofSeconds(60));
                if (!appWaitActivity.isEmpty()) {
                    options.setAppWaitActivity(appWaitActivity);
                }

                URL url = URI.create(appiumServerUrl).toURL();
                driver = new AndroidDriver(url, options);

                driver.manage().timeouts().implicitlyWait(Duration.ZERO);
                System.out.println("LOG: Driver berhasil diinisialisasi dari folder MAIN.");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Gagal konfigurasi URL Appium Server");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("LOG: Sesi Appium Driver ditutup.");
        }
    }

    private static String readConfig(String key, String defaultValue) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isEmpty()) {
            return systemValue;
        }
        String envValue = System.getenv(key);
        if (envValue != null && !envValue.isEmpty()) {
            return envValue;
        }
        return defaultValue;
    }
}