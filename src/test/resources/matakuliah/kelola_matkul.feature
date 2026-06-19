Feature: Manajemen Mata Kuliah
  Sebagai pengguna, saya ingin bisa menambahkan, mengubah, dan menghapus data mata kuliah

  Scenario: User berhasil menambahkan mata kuliah baru
    Given User berada di halaman menu Mata Kuliah
    When User klik tombol Tambah Mata Kuliah
    And User mengisi form dengan nama "Pemrograman Mobile", kode "TRPL01", dan SKS "3"
    And User klik tombol Simpan
    Then Sistem menampilkan alert dengan pesan "berhasil ditambahkan"
    And User klik OK pada alert

  Scenario: User berhasil mengubah data mata kuliah
#    Given User berada di halaman menu Mata Kuliah
    When User klik tombol edit mata kuliah dengan ID 1
    And User mengubah data form menjadi nama "Pemrograman Lanjut", kode "TRPL03", dan SKS "5"
    And User klik tombol Simpan pada form edit
    Then Sistem menampilkan alert dengan pesan "berhasil diperbarui"
    And User klik OK pada alert

  Scenario: User berhasil menghapus data mata kuliah
#    Given User berada di halaman menu Mata Kuliah
    When User klik tombol delete untuk mata kuliah dengan ID 13
    And User konfirmasi hapus data pada alert
    And User klik OK pada alert