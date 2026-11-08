# Catatan Minggu 04: Polymorphism

## Yang saya kerjakan
membuat atribut pada minggu ke 4 di aset.java
melakukan override pada subclass laptop, asetlab, dan ruang
membuat aset menggunakan list pada KatalogAset.java
melakukan pengujian di Minggu04PolimorfismeTest.java

## Keputusan desain
(Apa yang Anda putuskan dan kenapa. Rujuk docs/asumsi.md bila perlu.)

## Kendala
(Apa yang sulit dan bagaimana Anda mengatasinya)

## Penggunaan AI
- Alat yang dipakai: Gemini plus dan vs code
- Bagian yang dibantu AI: class aset, KatalogAset, subclass ruang, laptop, asetlab, 
- Prompt utama: bantu dan jelaskaan secara rinci tentang minggu ke 4 tentang polymorphism yang berisi 
    - Denda = hari x multiplier jenis x tarif varian Anda. Ruang 1x, Laptop 2x, AlatLab 4x.
    - 0 hari = 0. Hari negatif: `IllegalArgumentException`.
    - `cari(kata)` mencocokkan nama yang memuat kata tanpa membedakan huruf besar atau kecil.
    - `cari(kata, jenis)` sama, tetapi hanya untuk jenis tersebut.
    - bantu lengkapi code pada 
    - `core/src/main/java/id/ac/upb/asetpinjam/model/Aset.java` dan tiga subclass: override `hitungDenda(int)`.
    - `core/src/main/java/id/ac/upb/asetpinjam/katalog/KatalogAset.java`: dua overload `cari(...)`.

- Yang saya ubah atau tolak dari saran AI, dan alasannya: beberapa code yang dibuat oleh ai vs code yang mengalami error
- Satu hal yang saya pahami lebih baik sekarang: perbedaan overloading dan overriding
    - penggunaan overloading yang digunakan pada satu class menggunakan atribut list
