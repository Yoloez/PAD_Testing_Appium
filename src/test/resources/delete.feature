@DeleteMatkul
Feature: Menghapus Mata Kuliah oleh Admin
  Sebagai Admin
  Saya ingin menghapus data mata kuliah dari sistem
  Agar daftar mata kuliah tetap up-to-date

  Background:
    Given Admin sudah login dan berada di halaman daftar mata kuliah

@PositiveTest
  Scenario: Admin berhasil menghapus mata kuliah
    When Admin menekan ikon "Sampah" pada matkul dengan ID "1"
    And Admin mengklik tombol konfirmasi Hapus pada pop-up
    Then Sistem menampilkan pesan sukses "Mata kuliah berhasil dihapus" dan Admin menekan OK

  @NegativeTest
  Scenario: Admin membatalkan proses penghapusan mata kuliah
    When Admin mencari mata kuliah yang ingin dihapus
    And Admin menekan ikon "Sampah" pada baris mata kuliah tersebut
    And Admin mengklik tombol "Batal" pada pop-up konfirmasi
    Then Data mata kuliah tersebut tetap aman tersedia di dalam daftar