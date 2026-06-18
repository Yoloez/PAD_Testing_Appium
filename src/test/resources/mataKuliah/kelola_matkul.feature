Feature: Tambah Mata Kuliah
  Sebagai seorang Admin
  Aku ingin bisa menambah mata kuliah baru ke dalam sistem

  Scenario: Admin menambah mata kuliah
    Given Admin sudah berada di halaman daftar mata kuliah
    When Admin mengeklik tombol tambah "Add"
    And Admin memasukkan nama mata kuliah "PPPL"
    And Admin memasukkan kode mata kuliah "PPPL01"
    And Admin memasukkan jumlah SKS "3"
    And Admin mengeklik tombol "Save"
    Then Sistem harus menampilkan alert sukses dengan pesan "Mata kuliah berhasil ditambahkan."
    And Admin mengeklik OK untuk menutup alert sukses