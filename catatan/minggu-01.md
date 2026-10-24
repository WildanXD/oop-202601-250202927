# Catatan Minggu 01: (Paradigma Pemrograman dan Setup)

## Yang saya kerjakan
Menyiapkan enviorenment dengan melakukan instalasi JDK21 dan Maven serta melakukan clone git ke vs code
mengubah atau menambahkan code di core/src/main/java/id/ac/upb/asetpinjam/minggu01/HelloProsedural.java, HelloOOP.java, dan HelloFungsional.java Dengan bantuan AI

## Keputusan desain
(Apa yang Anda putuskan dan kenapa. Rujuk docs/asumsi.md bila perlu.)

## Kendala
instalasi maven, karna harus setting dulu di windows agar jalan di laptop saya

## Penggunaan AI
- Alat yang dipakai: Gemini pro
- Bagian yang dibantu AI: semua code yang dikerjakan dibantu AI
- Prompt utama: Jelaskan secara rinci maksud dari code ini 

package id.ac.upb.asetpinjam.minggu01;

import id.ac.upb.asetpinjam.config.Varian;
import java.util.function.Function;

/** Minggu 1, gaya FUNGSIONAL: fungsi sebagai nilai (lambda), tanpa state yang berubah. */
public final class HelloFungsional {

    private HelloFungsional() {
    }

    /**
     * TODO minggu 1: kembalikan fungsi yang menerima NAMA dan menghasilkan sapaan
     * yang memuat "Aset-Pinjam", nama tersebut, dan NIM yang diberikan. Gunakan lambda.
     */
    public static Function<String, String> pembuatSapaan(String nim) {
        throw new UnsupportedOperationException("TODO minggu 1: HelloFungsional.pembuatSapaan");
    }

    public static void main(String[] args) {
        Varian v = Varian.aktif();
        System.out.println(pembuatSapaan(v.nim).apply(v.nama));
    }
}

dan bantu kerjakan yang diminta

- Yang saya ubah atau tolak dari saran AI, dan alasannya: ngga ada, mungkin karna masih simple jadi code yang diberikan ga banyak
- Satu hal yang saya pahami lebih baik sekarang: setelah menyelesaikan tugas pada minggu ini, saya memahami perbedaan 3 paradigma pemrograman di java. 

kelebihan dan keterbatasan tiap gaya untuk sistem peminjaman aset.
Gaya prosedural
Kelebihan: Sangat cepat dan langsung pada intinya untuk mengeksekusi tugas tunggal, seperti membuat rumus sederhana untuk menghitung denda keterlambatan pengembalian aset.

Keterbatasan: Sulit dikelola ketika sistem mulai membesar. Karena data aset dan fungsinya terpisah, melacak ratusan barang dengan status berbeda (dipinjam, rusak, tersedia) akan membuat kode berantakan.

Gaya OOP
Kelebihan: Sangat cocok memodelkan dunia nyata. Kamu bisa membuat class Aset, Laptop, atau Peminjam yang masing-masing membungkus data (seperti status barang) dan perilakunya sendiri, sehingga sistem yang kompleks jauh lebih rapi dan mudah diatur.

Keterbatasan: Cenderung membuat kode menjadi lebih panjang (verbose) dan terasa berlebihan (over-engineered) jika hanya digunakan untuk memproses fitur atau perhitungan yang sangat sepele.

Gaya Fungsional
Kelebihan: Sangat tangguh dan aman untuk memanipulasi koleksi data besar, misalnya saat kamu perlu memfilter ribuan riwayat peminjaman untuk mencari aset mana saja yang belum dikembalikan bulan ini tanpa merusak data aslinya.

Keterbatasan: Kurang alami untuk menangani logika yang menuntut banyak "perubahan status". Mengubah status aset dari "Tersedia" menjadi "Dipinjam" terasa lebih rumit di sini karena gaya fungsional pada dasarnya sangat menghindari perubahan wujud data (immutable).

Jawaban By AI