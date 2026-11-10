package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 5: denda yang makin berat bila makin lama terlambat.
 *
 * <p>Rumus progresifnya KEPUTUSAN ANDA (catat di docs/asumsi.md). Syarat minimal yang diuji:
 * 0 hari = 0; tidak pernah lebih murah dari DendaFlat; tidak pernah turun saat hari bertambah.
 */
public class DendaProgresif implements AturanDenda {

    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        if (hariTerlambat < 0) {
            throw new IllegalArgumentException("Hari terlambat tidak boleh negatif.");
        }
        if (hariTerlambat == 0) {
            return 0;
        }
        
        long tarifHarianAset = aset.hitungDenda(1); 
        
        long totalDenda = 0;
        for (int i = 1; i <= hariTerlambat; i++) {
            // Progresif: hari ke-1 bayar 1x tarif, hari ke-2 bayar 2x tarif, dst.
            totalDenda += tarifHarianAset * i; 
        }
        
        return totalDenda;
    }
}
