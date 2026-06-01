Feature: Admin Login SIA
  Sebagai seorang Admin
  Saya ingin bisa login ke dalam sistem
  Agar dapat mengakses halaman dashboard dan mengelola data

  Scenario: Admin login berhasil dengan kredensial valid
    Given Admin berada di halaman login
    When Admin memasukkan email "admin@gmail.com"
    And Admin memasukkan password "admin123"
    And Admin menekan tombol login
    Then Admin diarahkan ke halaman dashboard

  Scenario: Admin login gagal dengan password invalid
    Given Admin berada di halaman login
    When Admin memasukkan email "admin@gmail.com"
    And Admin memasukkan password "salah123"
    And Admin menekan tombol login
    Then Sistem menampilkan pesan error login