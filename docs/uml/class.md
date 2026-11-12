# Class Diagram Aset-Pinjam (Minggu 06)

```mermaid
classDiagram
    %% --- PAKET KONTRAK ---
    namespace kontrak {
        class DapatDipinjam {
            <<interface>>
            +bisaDipinjam() boolean
        }
        class AturanDenda {
            <<interface>>
            +hitung(aset: Aset, hari: int) long
        }
    }

    %% --- PAKET MODEL ---
    namespace model {
        class Peminjam {
            <<record>>
            +id: String
            +nama: String
        }
        class JenisAset {
            <<enumeration>>
            RUANG
            LAPTOP
            ALAT_LAB
        }
        class StatusAset {
            <<enumeration>>
            TERSEDIA
            DIPINJAM
            RUSAK
        }
        class Kondisi {
            <<enumeration>>
            BAIK
            RUSAK_RINGAN
            RUSAK_BERAT
        }
        class Aset {
            <<abstract>>
            -kode: String
            -nama: String
            -status: StatusAset
            -kondisi: Kondisi
            +getJenis() JenisAset
            +hitungDenda(hari: int) long
            +bisaDipinjam() boolean
        }
        class Ruang {
            -kapasitas: int
            +getKapasitas() int
            +getJenis() JenisAset
            +hitungDenda(hari: int) long
        }
        class Laptop {
            -spesifikasi: String
            -nomorInventaris: String
            +getSpesifikasi() String
            +getNomorInventaris() String
            +getJenis() JenisAset
            +hitungDenda(hari: int) long
        }
        class AlatLab {
            -laboratorium: String
            -tingkatRisiko: TingkatRisiko
            +getLaboratorium() String
            +getTingkatRisiko() TingkatRisiko
            +getJenis() JenisAset
            +hitungDenda(hari: int) long
        }
        class Peminjaman {
            -id: String
            -peminjam: Peminjam
            -aset: Aset
            -mulai: LocalDateTime
            -selesai: LocalDateTime
            -status: StatusPeminjaman
            +getId() String
            +getPeminjam() Peminjam
            +getAset() Aset
            +getMulai() LocalDateTime
            +getSelesai() LocalDateTime
            +getStatus() StatusPeminjaman
        }
    }

    %% --- PAKET JADWAL ---
    namespace jadwal {
        class JadwalPeminjaman {
            +tambah(p: Peminjaman) void
            +bentrok(baru: Peminjaman) boolean
            +semuaUrutMulai() List~Peminjaman~
            +hapus(id: String) boolean
            +ajukan(baru: Peminjaman) void
        }
    }

    %% --- PAKET DENDA ---
    namespace denda {
        class DendaFlat {
            +hitung(aset: Aset, hari: int) long
        }
        class DendaProgresif {
            +hitung(aset: Aset, hari: int) long
        }
    }

    %% --- RELASI & MULTIPLICITY ---
    DapatDipinjam <|.. Aset : implements
    Aset <|-- Ruang : extends
    Aset <|-- Laptop : extends
    Aset <|-- AlatLab : extends
    
    Aset ..> JenisAset : uses
    Aset --> StatusAset : uses
    Aset --> Kondisi : uses
    
    %% Multiplicity: 1 Peminjaman punya 1 Peminjam & 1 Aset
    Peminjaman "1" --> "1" Peminjam : uses
    Peminjaman "*" --> "1" Aset : uses
    
    %% Multiplicity: 1 Jadwal mengelola Banyak (*) Peminjaman
    JadwalPeminjaman "1" o-- "*" Peminjaman : manages

    AturanDenda <|.. DendaFlat : implements
    AturanDenda <|.. DendaProgresif : implements