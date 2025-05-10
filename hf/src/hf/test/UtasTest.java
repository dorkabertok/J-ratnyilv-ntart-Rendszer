package hf.test;

import hf.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class UtasTest {

    @Test
    public void testGetNev() {
        Utas u = new Utas("Kiss Péter", "Budapest", "AB123");
        assertEquals("Kiss Péter", u.getNev());
    }

    @Test
    public void testGetLakcim() {
        Utas u = new Utas("Kiss Péter", "Budapest", "AB123");
        assertEquals("Budapest", u.getLakcim());
    }

    @Test
    public void testGetOkmanySzam() {
        Utas u = new Utas("Kiss Péter", "Budapest", "AB123");
        assertEquals("AB123", u.getOkmanySzam());
    }

    @Test
    public void testToString() {
        Utas u = new Utas("Kiss Péter", "Budapest", "AB123");
        assertEquals("Kiss Péter, Budapest, AB123", u.toString());
    }

    // ismétléssel más értékekre
    @Test
    public void testNevKulonbozo() {
        Utas u = new Utas("Nagy Anna", "Debrecen", "CD456");
        assertEquals("Nagy Anna", u.getNev());
    }

    @Test
    public void testCimKulonbozo() {
        Utas u = new Utas("Nagy Anna", "Debrecen", "CD456");
        assertEquals("Debrecen", u.getLakcim());
    }

    @Test
    public void testOkmanyKulonbozo() {
        Utas u = new Utas("Nagy Anna", "Debrecen", "CD456");
        assertEquals("CD456", u.getOkmanySzam());
    }

    @Test
    public void testEmptyNe() {
        Utas u = new Utas("", "Győr", "EF789");
        assertEquals("", u.getNev());
    }

    @Test
    public void testEmptyCi() {
        Utas u = new Utas("Kovács Béla", "", "GH012");
        assertEquals("", u.getLakcim());
    }
    // ismétléssel más értékekre
    @Test
    public void testNevKulonboz() {
        Utas u = new Utas("Kovács István", "Debrecen", "FG567");
        assertEquals("Kovács István", u.getNev());
    }

    @Test
    public void testCimKulonboz() {
        Utas u = new Utas("Kovács István", "Debrecen", "FG567");
        assertEquals("Debrecen", u.getLakcim());
    }

    @Test
    public void testOkmanyKulonboz() {
        Utas u = new Utas("Kovács István", "Debrecen", "FG567");
        assertEquals("FG567", u.getOkmanySzam());
    }

    @Test
    public void testEmptyNev() {
        Utas u = new Utas("", "Hatvan", "EF239");
        assertEquals("", u.getNev());
    }

    @Test
    public void testEmptyCim() {
        Utas u = new Utas("Kis Géza", "", "GH032");
        assertEquals("", u.getLakcim());
}
}