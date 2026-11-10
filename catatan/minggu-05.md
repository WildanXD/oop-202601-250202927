# Catatan Minggu 05: Abstraction

## Yang saya kerjakan
- Membuat claass aset menjadi abstract dan juga membuat kodisi pada minggu 5 di aset.java
- mengisi code di Denda Flat dan Denda Progresif
- Mengganti method di Ruang, Laptop, dan AlatLab
- membuat tes di AturanAmbiguTest.java

## Keputusan desain
1. **Abstraksi Kelas `Aset` (`abstract class`)**
   - **Keputusan:** Deklarasi kelas diubah menjadi `public abstract class Aset implements DapatDipinjam` dengan metode abstrak `public abstract long hitungDenda(int hariTerlambat);`.
   - **Alasan:** `Aset` secara konsep domain adalah gambaran umum yang tidak boleh diinstansiasi langsung (`new Aset(...)`). Deklarasi metode abstrak memaksa setiap *subclass* (`Ruang`, `Laptop`, `AlatLab`) menyediakan logika dendanya masing-masing.

2. **Penerapan *Strategy Pattern* (`AturanDenda`)**
   - **Keputusan:** Memisahkan kalkulasi denda dari kelas model ke dalam kelas strategi terpisah (`DendaFlat` dan `DendaProgresif`).
   - **Alasan:** Memenuhi *Open/Closed Principle* (SOLID). Skema perhitungan denda baru dapat ditambahkan di masa depan tanpa merusak atau mengubah struktur kelas `Aset`.

3. **Pemanfaatan Polimorfisme pada `DendaProgresif`**
   - **Keputusan:** Memanggil `long tarifHarian = aset.hitungDenda(1);` untuk mendapatkan tarif dasar harian aset.
   - **Alasan:** Menghindari *code smell* (pengecekan tipe manual seperti `if-else` atau `instanceof`). Java secara otomatis mengeksekusi metode `hitungDenda(1)` sesuai objek konkretnya.

4. **Sentralisasi Metode `bisaDipinjam()`**
   - **Keputusan:** Mengimplementasikan metode `bisaDipinjam()` langsung di dalam kelas abstrak `Aset`.
   - **Alasan:** Syarat kelayakan peminjaman (`status == TERSEDIA` dan `kondisi != RUSAK_BERAT`) berlaku universal untuk seluruh tipe aset.

## Kendala
- Kesulitan memahami tentang abstrct class dan juga pada denda progresif.
- meminta AI untuk menjelaskan secara rinci untuk menambah pemahaman.

## Penggunaan AI
- Alat yang dipakai: Gemini plus
- Bagian yang dibantu AI: pada class aset dan subclassnya
- Prompt utama: Tugas minggu 5 
    - Yang dikerjakan
        - `core/src/main/java/id/ac/upb/asetpinjam/model/Aset.java`: isi `bisaDipinjam()` (Aset sudah mengimplementasikan `DapatDipinjam`), lalu jadikan kelas `abstract` (dan  `hitungDenda` abstrak).
        - `core/src/main/java/id/ac/upb/asetpinjam/denda/DendaFlat.java` dan `DendaProgresif.java`: implementasikan `AturanDenda`. 

    - Aturan pasti

        - `bisaDipinjam()` true hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT.
        - `DendaFlat` = `aset.hitungDenda(hari)`.
        - `DendaProgresif`: 0 hari = 0, tidak pernah lebih murah dari flat, tidak pernah turun saat hari bertambah, dan pada hari ke-30 lebih mahal dari flat.
    - Isi asumsi berdasarkan Code yang telah dibuat dan merujuk pada aturan-bisnis.md
- Yang saya ubah atau tolak dari saran AI, dan alasannya: kata atau code yang agak nguawour
- Satu hal yang saya pahami lebih baik sekarang: sedikit memahami fungsi abstrac 

# Keputusan Aturan Ambigu

## A-02: Perhitungan Denda Keterlambatan
- Pertanyaan: Bagaimana denda dihitung bila terlambat 1 menit atau 25 jam? (Sistem hanya mengenal hari bulat pada `hitungDenda`.)
- Keputusan: Denda hanya menerima satuan hari bulat penuh (bilangan positif).
- Alasan: Sistem `AturanDenda` pada minggu 5 dirancang menggunakan parameter parameter `int hariTerlambat` bulat. Oleh karena itu:
    - Hari tidak boleh negatif (melempar `IllegalArgumentException`).
    - Denda hari ke-2 dan seterusnya pada `DendaProgresif` dihitung secara akumulatif.
- Dampak ke kode: Terdapat validasi *exception* untuk hari negatif dan *loop* akumulatif pada kelas `DendaProgresif.java`.
- Tes yang membuktikan: `testDendaHariNegatifLemparException()` dan `testDendaProgresifHariKeduaLaptop()` pada `AturanAmbiguTest.java`.

## Asumsi lain
Perhitungan denda progresif menggunakan rumus deret: `Denda = (n * (n + 1) / 2) * tarifHarian`, di mana `n` adalah jumlah hari keterlambatan.