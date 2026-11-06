# Catatan Minggu 03: Inheritance

## Yang saya kerjakan
melengkapi atau mengubah code di Ruang.java, Laptop.java, AlatLab.java
melakukan test di Minggu03HierarkiTest
membuat catatan minggu-03

## Penempatan Field pada Induk dan Subclass
- Pertanyaan: Mana yang seharusnya field di induk dan mana di subclass.
- Keputusan: Field umum (kode, nama, status, kondisi) ditempatkan di class Aset. Field spesifik ditempatkan di subclass (kapasitas di Ruang; spesifikasi dan nomorInventaris di Laptop; laboratorium dan tingkatRisiko di AlatLab).
- Alasan: ini diambil agar kode tidak berulang (prinsip DRY). Atribut yang berlaku untuk semua barang dikelola terpusat di Aset. Atribut yang unik diletakkan di subclass agar tidak tercampur dengan objek lain (menghindari kasus tidak logis seperti objek Laptop memiliki atribut kapasitas orang).
- Dampak ke kode: Kelas Aset.java menginisialisasi field dasar. Di kelas Ruang.java, Laptop.java, dan AlatLab.java, pada baris pertama konstruktor selalu memanggil super(kode, nama) agar validasi induk berjalan, baru kemudian memvalidasi field tambahannya sendiri.
- Tes yang membuktikan: Minggu03HierarkiTest.java

## Kendala
aman terkendali

## Penggunaan AI
- Alat yang dipakai: gemini plus dan ai vs code
- Bagian yang dibantu AI: code subclass ruang, laptop, dan alat lab. 
catatan dan minggu-03.md
- Prompt utama: untuk codenya menggunakan ai dari vs code yang bisa menggenerate code secara otomatis.
untuk pemakaian ai lainnya menggunakan promp: berikan aku semua opsi jawaban mana yang seharusnya field di induk dan mana di subclass.
Di catatan, tulis satu contoh di sistem ini di mana inheritance kurang tepat dibanding komposisi.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: cuma mengurangi atau mengubah kata di hasil promp opsi jawaban field karna saya merasa jawabannya terlalu ai
- Satu hal yang saya pahami lebih baik sekarang: lebih memahami tentang class dan sub class, penggunaan overide, dan lebih mengetahui fungsi super biar tidak perlu nulis ulang code
