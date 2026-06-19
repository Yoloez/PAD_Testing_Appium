Feature: Manage Lecturer

  Scenario: Tambah dosen valid
#    Given admin sudah login
    When admin membuka menu tambah dosen
    Then admin klik tombol tambah dosen
    And admin mengisi data dosen valid
    And admin menekan tombol simpan
    Then data dosen berhasil ditambahkan

  Scenario: Email invalid
#    Given admin sudah login
    When admin membuka menu tambah dosen
    Then admin klik tombol tambah dosen
    And admin mengisi email tidak valid
    And admin menekan tombol simpan
    Then muncul pesan email tidak valid

  Scenario: Nonaktifkan dosen
    Given admin berada di halaman daftar dosen
    When admin menekan tombol nonaktifkan dosen
    Then status dosen menjadi nonaktif

  Scenario: Aktifkan dosen
    Given admin berada di halaman daftar dosen
    When admin menekan tombol aktifkan dosen
    Then status dosen menjadi aktif

