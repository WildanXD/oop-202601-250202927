package id.ac.upb.asetpinjam;

import id.ac.upb.asetpinjam.denda.DendaProgresif;
import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Laptop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AturanAmbiguTest {

    @Test
    @DisplayName("Tes Asumsi: Denda progresif Laptop pada hari ke-2 bernilai 3x tarif harian")
    void testDendaProgresifHariKeduaLaptop() {
        Laptop laptop = new Laptop("L-01", "ThinkPad", "i5/16GB", "INV-01");
        AturanDenda dendaProgresif = new DendaProgresif();

        // Hari 1: 1x tarif laptop (20.000)
        // Hari 2: 1x + 2x = 3x tarif laptop (60.000)
        long dendaHari2 = dendaProgresif.hitung(laptop, 2);

        // Tarif laptop 1 hari = 10.000 (Varian NIM 2/7) * 2 (multiplier Laptop) = 20.000
        long tarifLaptopSatuHari = laptop.hitungDenda(1);

        assertEquals(tarifLaptopSatuHari * 3, dendaHari2, 
            "Denda progresif hari ke-2 harus bernilai 3 kali lipat tarif harian laptop.");
    }

    @Test
    @DisplayName("Tes Asumsi: Pengecekan denda hari negatif melempar IllegalArgumentException")
    void testDendaHariNegatifLemparException() {
        Laptop laptop = new Laptop("L-02", "Dell", "i7/16GB", "INV-02");
        AturanDenda dendaProgresif = new DendaProgresif();

        assertThrows(IllegalArgumentException.class, () -> {
            dendaProgresif.hitung(laptop, -1);
        }, "Keterlambatan negatif wajib melempar Exception.");
    }
}