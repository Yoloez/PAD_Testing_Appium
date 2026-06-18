Feature: Alur Distribusi Pengumuman

  Scenario: Manager membuat pengumuman baru dan Mahasiswa menerima pengumuman tersebut
    # --- FLOW MANAGER ---
    Given manager sudah berada di halaman buat pengumuman
    When manager mengisi judul pengumuman dengan "Libur Semester 2026"
    And manager mengisi pesan pengumuman dengan "Perkuliahan diliburkan mulai minggu depan."
    And manager menekan tombol submit pengumuman
    Then sistem berhasil menyimpan pengumuman baru
    Then sistem kembali ke halaman dashboard manager

    # --- FLOW MAHASISWA ---
    Given mahasiswa melakukan login dan membuka halaman pemberitahuan
    When mahasiswa mengeklik tombol lihat pengumuman
    Then mahasiswa harus melihat pengumuman dengan pesan "Perkuliahan diliburkan mulai minggu depan."