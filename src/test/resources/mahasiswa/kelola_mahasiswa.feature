Feature: Mengelola Mahasiswa
  Sebagai admin, saya ingin dapat menambahkan, mengaktifkan, dan menonaktifkan
  akun mahasiswa pada sistem akademik.

#  Background:
#    Given saya membuka aplikasi
#    And saya login sebagai admin dengan email "admin@gmail.com" dan password "admin123"

  @TambahMahasiswa
  Scenario: Admin berhasil menambahkan mahasiswa baru melalui menu navigasi Dashboard
    Given admin membuka menu navigasi
    When admin memilih menu Tambah Mahasiswa
    When admin menekan tombol Tambah Mahasiswa pada halaman list
    And admin mengisi form tambah mahasiswa dengan data berikut:
      | nama            | username   | email               | nim      | program_studi      | password  | konfirmasi_password |
      | Fatimah Azzahra | fatimah123 | fatimah@gmail.com | 21051001 | Teknik Informatika | Pass1234! | Pass1234!            |
    And admin menekan tombol Simpan pada form tambah mahasiswa
    Then mahasiswa baru berhasil ditambahkan

  @TambahMahasiswa
  Scenario: Admin berhasil menambahkan mahasiswa baru melalui halaman List Mahasiswa
    Given admin berada di halaman List Mahasiswa
    When admin menekan tombol Tambah Mahasiswa pada halaman list
    And admin mengisi form tambah mahasiswa dengan data berikut:
      | nama         | username | email            | nim      | program_studi    | password  | konfirmasi_password |
      | Budi Tabudie | budi456  | budi@gmail.com | 21051002 | Sistem Informasi | Pass5678! | Pass5678!            |
    And admin menekan tombol Simpan pada form tambah mahasiswa
    Then mahasiswa baru berhasil ditambahkan

  @TambahMahasiswa
  Scenario: Admin membatalkan penambahan mahasiswa dengan tombol Back
    Given admin berada di halaman List Mahasiswa
    When admin menekan tombol Tambah Mahasiswa pada halaman list
    And admin menekan tombol Back pada form tambah mahasiswa
    Then admin kembali ke halaman List Mahasiswa

  @TambahMahasiswa @Validasi
  Scenario Outline: Admin gagal menambahkan mahasiswa karena data tidak lengkap
    Given admin berada di halaman List Mahasiswa
    When admin menekan tombol Tambah Mahasiswa pada halaman list
    And admin mengisi form tambah mahasiswa dengan data berikut:
      | nama   | username   | email   | nim   | program_studi   | password   | konfirmasi_password   |
      | <nama> | <username> | <email> | <nim> | <program_studi> | <password> | <konfirmasi_password> |
    And admin menekan tombol Simpan pada form tambah mahasiswa
    Then admin tetap berada di halaman Tambah Mahasiswa

    Examples:
      | nama        | username | email                 | nim      | program_studi      | password  | konfirmasi_password |
      |             | rina123  | rina@gmail.com      | 21051003 | Teknik Informatika | Pass1234! | Pass1234!            |
      | Rina Wijaya | rina123  | rina@gmail.com      | 21051003 | Teknik Informatika | Pass1234! | Pass0000!            |

  @KelolaStatusMahasiswa
  Scenario: Admin menonaktifkan mahasiswa yang sedang aktif
    Given admin berada di halaman List Mahasiswa
    When admin menekan tombol Nonaktifkan pada mahasiswa dengan id 4
    Then status mahasiswa berubah menjadi nonaktif

  @KelolaStatusMahasiswa
  Scenario: Admin mengaktifkan kembali mahasiswa yang sebelumnya nonaktif
    Given admin berada di halaman List Mahasiswa
    When admin menekan tombol Aktifkan pada mahasiswa dengan id "21051001"
    Then status mahasiswa berubah menjadi aktif
