Feature: Manajemen Mata Kuliah
  Sebagai pengguna, saya ingin bisa menambahkan, mengubah, dan menghapus data mata kuliah

  Scenario: User berhasil menambahkan mata kuliah baru
    Given User berada di halaman menu Mata Kuliah
    When User klik tombol Tambah Mata Kuliah
    And User mengisi form dengan nama "Pemrograman Mobile", kode "TRPL01", dan SKS "3"
    And User klik tombol Simpan
    Then Sistem menampilkan alert dengan pesan "Berhasil"
    And User klik OK pada alert

  Scenario: User berhasil mengubah data mata kuliah
    Given User berada di halaman menu Mata Kuliah
    When User klik tombol edit mata kuliah
    And User mengubah data form menjadi nama "Pemrograman Lanjut", kode "TRPL02", dan SKS "4"
    And User klik tombol Simpan pada form edit
    Then Sistem menampilkan alert dengan pesan "Berhasil diubah"
    And User klik OK pada alert

  Scenario: User berhasil menghapus data mata kuliah
    Given User berada di halaman menu Mata Kuliah
    When User klik tombol delete untuk mata kuliah dengan ID "TRPL02"
    And User konfirmasi hapus data pada alert