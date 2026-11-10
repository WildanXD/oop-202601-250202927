package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa ruang. Kapasitas harus lebih dari 0 (IllegalArgumentException). */
public class Ruang extends Aset {

    // TODO minggu 3: field kapasitas.
    private int kapasitas;

    public Ruang(String kode, String nama, int kapasitas) {
        super(kode, nama);

            if (kapasitas <= 0) {
        throw new IllegalArgumentException("Kapasitas harus lebih dari 0.");
    }
        this.kapasitas = kapasitas;
}

    public int getKapasitas() {
        return this.kapasitas;
    }

    // TODO minggu 3: override getJenis(). Minggu 4: override hitungDenda(int).
    @Override 
    public JenisAset getJenis() {
        return JenisAset.RUANG;
    }

    @Override
    public long hitungDenda(int hari) {
        if (hari < 0) throw new IllegalArgumentException("Hari tidak boleh negatif");
        if (hari == 0) return 0;
        return (long) hari * id.ac.upb.asetpinjam.config.Varian.aktif().dendaPerHari * 1; 
    }
}
