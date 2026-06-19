# PAD Appium BDD - Academic Management System

Repositori ini memuat kode pengujian otomatis (Automated Testing) berbasis Appium dan Cucumber BDD untuk aplikasi Sistem Akademik (React Native Android).

## Penjelasan Singkat SUT (System Under Test)

System Under Test (SUT) pada proyek ini adalah aplikasi Android **Sistem Akademik** yang dibangun menggunakan React Native. Aplikasi ini memiliki beberapa modul utama yang diuji, antara lain:

- **Manajemen Pengumuman:** Membuat dan melihat pengumuman (role Manager & Mahasiswa).
- **Manajemen Mata Kuliah:** Menambah, mengedit, dan menghapus data mata kuliah.
- **Manajemen Mahasiswa:** Mendaftarkan akun mahasiswa baru serta mengatur status aktif/nonaktif mahasiswa.
- **Manajemen Dosen:** Mendaftarkan akun dosen baru serta mengatur status aktif/nonaktif dosen.

## Penjelasan Singkat Test Suite

Test Suite dibangun menggunakan pendekatan **Behavior-Driven Development (BDD)** dengan kerangka kerja **Cucumber** dan **Appium (Java Client)**. Skenario pengujian ditulis menggunakan format Gherkin (`.feature` files) yang mudah dibaca oleh manusia.
Keunggulan dari test suite ini meliputi:

- Penggunaan **AppiumBy.androidUIAutomator** untuk interaksi UI native Android yang sangat robust.
- Laporan terminal kustom (PrettyConsolePlugin) yang rapi dengan indikator emoji sukses/gagal.
- Pattern Page Object Model (POM) untuk memisahkan logika UI (Locators & Pages) dari alur tes (Step Definitions).

## Pembagian Tugas dalam Kelompok

_(Silakan ubah tabel di bawah ini sesuai dengan nama anggota kelompok Anda)_

| Nama Anggota        | NPM / NIM          | Deskripsi Tugas / Modul yang Dikerjakan                     |
| ------------------- | ------------------ | ----------------------------------------------------------- |
| Hanan Fijananto     | 24/538946/SV/24555 | Mengerjakan pengujian modul Pengumuman & Konfigurasi Appium |
| Javian Oktaviansyah | [NIM 2]            | Mengerjakan pengujian modul Mata Kuliah & Mahasiswa         |
| Revaldo Kuncoro P.  | 24/542620/SV/25063 | Mengerjakan pengujian modul Dosen & Penyusunan Bug Report   |
| Fatimah Azzahra     | [NIM 3]            | Mengerjakan pengujian modul Dosen & Penyusunan Bug Report   |

## Struktur Repository

```text
PAD_Testing_Appium/
├── src/
│   ├── main/java/org/example/
│   │   ├── locators/         # Kumpulan ID & UiSelector (Page Elements)
│   │   └── utils/            # Utilities (DriverManager, PrettyConsolePlugin)
│   └── test/
│       ├── java/
│       │   ├── pages/        # Page Object Model (Aksi pada UI)
│       │   ├── runners/      # JUnit Test Runners per modul
│       │   └── stepDef/      # Implementasi code dari skenario Cucumber
│       └── resources/        # Folder skenario Gherkin (.feature)
│           ├── dosen/
│           ├── mahasiswa/
│           ├── matakuliah/
│           └── pengumuman/
├── target/                   # Build output dan Test Reports
├── pom.xml                   # Maven dependencies & build config
└── README.md                 # Dokumentasi Repositori
```

---

## Quick start

1. Start Appium server on your machine.
2. Connect an Android device or start an emulator.
3. Run tests with your desired configuration overrides.

## Teammate setup checklist (after git clone)

System prerequisites:

- Install Node.js (needed for `npm`).
- Install Android SDK + set `ANDROID_HOME` and `PATH` for `adb`.
- Ensure a device or emulator is available and visible to `adb`.

Appium installation (run once):

```powershell
npm install -g appium
appium driver install uiautomator2
```

Device preparation:

- Enable Developer Options and USB Debugging on the phone.
- Install the React Native app APK on the device.
- Verify device is detected:

```powershell
adb devices
```

## Configuration overrides

The driver reads values from system properties or environment variables:

- `APP_PACKAGE`
- `APP_ACTIVITY`
- `DEVICE_NAME`
- `APPIUM_SERVER_URL`

Examples:

```powershell
mvn test -DAPP_PACKAGE=com.your.app -DAPP_ACTIVITY=com.your.app.MainActivity -DDEVICE_NAME=emulator-5554
```

## Test runners

Untuk menjalankan test per modul, jalankan kelas Runner yang ada di folder `src/test/java/runners/`. Contohnya:

- `TestRunnerLecturer.java`
- `TestRunnerMahasiswa.java`
- `TestRunnerPengumuman.java`

## Dependencies (Maven)

This project uses:

- `io.appium:java-client`
- `io.cucumber:cucumber-java` & `cucumber-junit-platform-engine`
- `org.seleniumhq.selenium:selenium-java`
- `org.junit.jupiter:junit-jupiter-api`
