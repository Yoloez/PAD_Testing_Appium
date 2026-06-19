Feature: Alur Distribusi Pengumuman

  # --- TEST CASE ADMIN (MANAGER): POSITIVE ---
  Scenario: [Positive] Manager membuat pengumuman baru
    Given manager sudah berada di halaman buat pengumuman
    When manager mengisi judul pengumuman dengan "Libur Semester 2026"
    And manager mengisi pesan pengumuman dengan "Perkuliahan diliburkan mulai minggu depan."
    And manager menekan tombol submit pengumuman
    Then sistem berhasil menyimpan pengumuman baru
    And sistem kembali ke halaman dashboard manager

  # --- TEST CASE ADMIN (MANAGER): NEGATIVE ---
  Scenario: [NEGATIVE] Manager membuat pengumuman dengan kolom yang masih kosong
    Given manager sudah berada di halaman buat pengumuman
    When manager mengosongkan kolom judul dan pesan pengumuman
    And manager menekan tombol submit pengumuman
    Then sistem menampilkan pesan error validasi wajib isi
    And sistem tetap berada di halaman buat pengumuman
    And sistem kembali ke halaman dashboard manager

  # --- TEST CASE MAHASISWA: CEK PENGUMUMAN ---
  Scenario: Mahasiswa mengecek pengumuman yang baru didistribusikan
    Given mahasiswa melakukan login dan membuka halaman pemberitahuan
    When mahasiswa mengeklik tombol lihat pengumuman
    Then mahasiswa harus melihat pengumuman dengan pesan "Perkuliahan diliburkan mulai minggu depan."