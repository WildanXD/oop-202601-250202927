# Catatan Minggu 06: UML dan SOLID

## Yang saya kerjakan
Membuat UML dan SOLID pada class.md, sequence.md, dan solid.md

## Keputusan desain
(Apa yang Anda putuskan dan kenapa. Rujuk docs/asumsi.md bila perlu.)

## Kendala
(Apa yang sulit dan bagaimana Anda mengatasinya)

## Penggunaan AI
- Alat yang dipakai: Gemini plus
- Bagian yang dibantu AI: class.md, sequence.md, dan solid.md
- Prompt utama: 
    week 6 
    Tujuan

        - Memodelkan sistem dengan Class Diagram dan Sequence Diagram.
        - Menunjukkan minimal dua prinsip SOLID di kode.

    Yang dikerjakan

        - `docs/uml/class*`: Class Diagram dari kode Anda (atribut, method, tipe, visibility, relasi, multiplicity, paket).
        - `docs/uml/sequence*`: Sequence Diagram pengajuan peminjaman, skenario sukses dan skenario bentrok (fragmen `alt`).
        - `docs/uml/solid.md`: minimal dua prinsip SOLID, tunjuk kelas dan alasan.
        - Refactor kecil di kode bila perlu agar prinsipnya terlihat.

    Aturan pasti (dipakai tes)

        - Diagram harus konsisten dengan kode, bukan sketsa ideal.
    Buat berdasarkan apa yang harus dikerjakan dan jelaskan secara rinci apa yang sudah kamu buat

- Yang saya ubah atau tolak dari saran AI, dan alasannya: banyak, karna banyak yang harus direvisi pada bagian class.md
- Satu hal yang saya pahami lebih baik sekarang: pembuatan dan penggunaan UML dan SOLID

Open/Closed Principle (OCP): class DendaFlat dan class DendaProgresif

Single Responsibility Principle (SRP): pada class aset

- aggregation dan composition adalah hubungan antar objek, bedanya aggregation itu hubungan lemah sedangkan composition itu hubungan kuat
- karna Open/Closed Principle menyatakan bahwa sebuah entitas software harus terbuka untuk ekstensi (open for extension), tetapi tertutup untuk modifikasi (closed for modification).
- karna Dependency Inversion Principle menyatakan bahwa kelas tingkat tinggi tidak boleh bergantung pada kelas tingkat rendah secara langsung, melainkan harus bergantung pada abstraksi (antarmuka/interface).