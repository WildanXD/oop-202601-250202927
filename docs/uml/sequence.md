# Sequence Diagram Pengajuan Peminjaman

```mermaid
sequenceDiagram
    actor Klien
    participant JadwalPeminjaman
    participant baru as Peminjaman
    participant Aset

    Klien->>JadwalPeminjaman: ajukan(baru)
    activate JadwalPeminjaman
    
    JadwalPeminjaman->>baru: getAset()
    activate baru
    baru-->>JadwalPeminjaman: aset
    deactivate baru

    JadwalPeminjaman->>Aset: bisaDipinjam()
    activate Aset
    Aset-->>JadwalPeminjaman: true (Tersedia & Tidak Rusak Berat)
    deactivate Aset

    JadwalPeminjaman->>JadwalPeminjaman: bentrok(baru)
    
    %% Skenario alternatif (alt) sesuai syarat dosen
    alt bentrok == true
        JadwalPeminjaman-->>Klien: throw PeminjamanBentrokException
    else bentrok == false
        JadwalPeminjaman->>JadwalPeminjaman: tambah(baru)
        JadwalPeminjaman-->>Klien: void (Sukses)
    end
    
    deactivate JadwalPeminjaman