# Analisis Prinsip SOLID pada Aset-Pinjam

## 1. Open/Closed Principle (OCP)
- **Kelas Terkait:** Antarmuka `AturanDenda`, kelas `DendaFlat`, dan `DendaProgresif`.
- **Penjelasan:** Sistem terbuka untuk ekstensi (*open for extension*) tetapi tertutup untuk modifikasi (*closed for modification*). Karena algoritma denda dipisahkan melalui antarmuka `AturanDenda`, kita bisa menambahkan jenis denda baru di masa depan (misal: `DendaKhususLibur`) dengan membuat kelas baru yang meng-implements `AturanDenda`. Kita **tidak perlu mengubah** kode apa pun di dalam kelas `Aset`, `Laptop`, atau `Ruang`. 

## 2. Single Responsibility Principle (SRP)
- **Kelas Terkait:** Kelas abstrak `Aset` (dan turunannya) serta `AturanDenda`.
- **Penjelasan:** Setiap kelas memiliki satu alasan untuk berubah (*one reason to change*). Kelas `Aset` murni hanya bertanggung jawab untuk menyimpan data *state* aset (seperti kode, nama, status, kondisi) dan memeriksa kelayakan pinjam (`bisaDipinjam()`). Kelas `Aset` tidak lagi mempedulikan **bagaimana** cara menghitung rumitnya denda progresif, karena tanggung jawab perhitungan matematis tersebut telah diserahkan sepenuhnya ke kelas implementasi dari `AturanDenda`.