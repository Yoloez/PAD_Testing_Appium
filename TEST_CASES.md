# Dokumentasi Test Case - PAD Appium BDD

Dokumen ini berisi daftar skenario pengujian (Test Cases) secara lengkap berdasarkan *user flow* pada Sistem Akademik. Pengujian ini diimplementasikan menggunakan BDD dengan format Gherkin.

---

## 1. Modul Pengumuman (Announcement)
| ID Test Case | Skenario | Kategori | Ringkasan Alur (Steps) |
| --- | --- | --- | --- |
| **TC-ANN-01** | Manager membuat pengumuman baru | Positive | 1. Buka halaman buat pengumuman<br>2. Isi judul "Libur Semester 2026"<br>3. Isi pesan "Perkuliahan diliburkan..."<br>4. Submit<br>5. Verifikasi pengumuman tersimpan dan kembali ke dashboard. |
| **TC-ANN-02** | Manager membuat pengumuman dengan kolom kosong | Negative | 1. Buka halaman buat pengumuman<br>2. Kosongkan judul dan pesan<br>3. Submit<br>4. Verifikasi muncul error validasi wajib isi<br>5. Verifikasi tetap di halaman buat pengumuman. |
| **TC-ANN-03** | Mahasiswa mengecek pengumuman | Positive | 1. Mahasiswa login dan buka halaman pemberitahuan<br>2. Klik tombol lihat pengumuman<br>3. Verifikasi pengumuman "Perkuliahan diliburkan..." terlihat. |

---

## 2. Modul Mata Kuliah (Course)
| ID Test Case | Skenario | Kategori | Ringkasan Alur (Steps) |
| --- | --- | --- | --- |
| **TC-MK-01** | Menambahkan mata kuliah baru | Positive | 1. Buka halaman menu Mata Kuliah<br>2. Klik Tambah Mata Kuliah<br>3. Isi nama, kode, dan SKS<br>4. Klik Simpan<br>5. Verifikasi alert "berhasil ditambahkan". |
| **TC-MK-02** | Mengubah data mata kuliah | Positive | 1. Klik tombol edit pada list mata kuliah<br>2. Ubah data nama, kode, dan SKS<br>3. Klik Simpan<br>4. Verifikasi alert "berhasil diperbarui". |
| **TC-MK-03** | Menghapus data mata kuliah | Positive | 1. Klik tombol delete pada list mata kuliah<br>2. Konfirmasi penghapusan di alert peringatan<br>3. Klik OK. |

---

## 3. Modul Mahasiswa (Student)
| ID Test Case | Skenario | Kategori | Ringkasan Alur (Steps) |
| --- | --- | --- | --- |
| **TC-MHS-01** | Tambah mahasiswa via Menu Navigasi | Positive | 1. Buka sidebar menu -> Tambah Mahasiswa<br>2. Isi form lengkap (nama, username, email, NIM, prodi, password)<br>3. Simpan<br>4. Verifikasi mahasiswa berhasil ditambahkan. |
| **TC-MHS-02** | Tambah mahasiswa via List Mahasiswa | Positive | 1. Buka halaman List Mahasiswa<br>2. Klik tombol Tambah Mahasiswa di list<br>3. Isi form lengkap<br>4. Simpan<br>5. Verifikasi mahasiswa berhasil ditambahkan. |
| **TC-MHS-03** | Membatalkan penambahan mahasiswa | Positive | 1. Masuk ke halaman Tambah Mahasiswa<br>2. Klik tombol Back<br>3. Verifikasi kembali ke halaman List Mahasiswa. |
| **TC-MHS-04** | Gagal tambah mahasiswa (Nama kosong) | Negative | 1. Masuk ke halaman Tambah Mahasiswa<br>2. Kosongkan field nama, isi field lainnya<br>3. Simpan<br>4. Verifikasi sistem menolak dan tetap di form. |
| **TC-MHS-05** | Gagal tambah mahasiswa (Konfirmasi Password salah) | Negative | 1. Masuk ke halaman Tambah Mahasiswa<br>2. Isi password dan konfirmasi password dengan string berbeda<br>3. Simpan<br>4. Verifikasi sistem menolak dan tetap di form. |
| **TC-MHS-06** | Menonaktifkan mahasiswa | Positive | 1. Buka halaman List Mahasiswa<br>2. Klik tombol Nonaktifkan pada mahasiswa aktif<br>3. Verifikasi status berubah menjadi nonaktif. |
| **TC-MHS-07** | Mengaktifkan mahasiswa | Positive | 1. Buka halaman List Mahasiswa<br>2. Klik tombol Aktifkan pada mahasiswa nonaktif<br>3. Verifikasi status berubah menjadi aktif. |

---

## 4. Modul Dosen (Lecturer)
| ID Test Case | Skenario | Kategori | Ringkasan Alur (Steps) |
| --- | --- | --- | --- |
| **TC-DSN-01** | Tambah dosen valid | Positive | 1. Buka menu tambah dosen lalu klik tombol tambah<br>2. Isi data valid (nama, username, email, prodi, dll)<br>3. Simpan<br>4. Verifikasi data dosen berhasil ditambahkan. |
| **TC-DSN-02** | Tambah dosen dengan email invalid | Negative | 1. Buka menu tambah dosen lalu klik tombol tambah<br>2. Isi field email dengan format salah (misal tanpa '@')<br>3. Simpan<br>4. Verifikasi muncul pesan email tidak valid. |
| **TC-DSN-03** | Menonaktifkan dosen | Positive | 1. Buka halaman daftar dosen<br>2. Klik tombol nonaktifkan pada salah satu dosen aktif<br>3. Verifikasi status dosen menjadi nonaktif. |
| **TC-DSN-04** | Mengaktifkan dosen | Positive | 1. Buka halaman daftar dosen<br>2. Klik tombol aktifkan pada salah satu dosen nonaktif<br>3. Verifikasi status dosen menjadi aktif. |
