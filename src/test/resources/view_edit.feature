Feature: Kelola Mata Kuliah

  Scenario: Admin melihat daftar mata kuliah
    Given admin sudah login
    When admin membuka halaman mata kuliah
    Then daftar mata kuliah tampil

  Scenario: Admin mengedit mata kuliah
    Given admin berada di halaman mata kuliah
    When admin memilih mata kuliah
    And admin mengubah nama mata kuliah menjadi "Pemrograman Mobile"
    And admin menyimpan perubahan
    Then data mata kuliah berhasil diperbarui