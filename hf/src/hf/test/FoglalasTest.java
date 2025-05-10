package hf.test;

import hf.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;


public class FoglalasTest {

    @Test
    public void testGetUtas() {
        Utas u = new Utas("Anna", "Szeged", "XYZ");
        Jarat j = new Jarat("ABC", "BP", "LDN", "10", "12", Arrays.asList("t"), Arrays.asList());
        Foglalas f = new Foglalas(u, j, "turista", Arrays.asList());
        assertEquals(u, f.getUtas());
    }

    @Test
    public void testGetJarat() {
        Utas u = new Utas("Anna", "Szeged", "XYZ");
        Jarat j = new Jarat("ABC", "BP", "LDN", "10", "12", Arrays.asList("t"), Arrays.asList());
        Foglalas f = new Foglalas(u, j, "turista", Arrays.asList());
        assertEquals(j, f.getJarat());
    }

    @Test
    public void testGetOsztaly() {
        Foglalas f = new Foglalas(null, null, "üzleti", Arrays.asList());
        assertEquals("üzleti", f.getOsztaly());
    }

    @Test
    public void testGetSzolgaltatasok() {
        List<String> sz = Arrays.asList("wifi", "etkezes");
        Foglalas f = new Foglalas(null, null, "t", sz);
        assertEquals(sz, f.getSzolgaltatasok());
    }

    @Test
    public void testUresSzolgaltatasok() {
        Foglalas f = new Foglalas(null, null, "t", Arrays.asList());
        assertTrue(f.getSzolgaltatasok().isEmpty());
    }

    @Test
    public void testToStringNemNulla() {
        Foglalas f = new Foglalas(new Utas("A", "B", "C"), new Jarat("X", "Y", "Z", "T1", "T2", Arrays.asList(), Arrays.asList()), "t", Arrays.asList());
        assertNotNull(f.toString());
    }

    @Test
    public void testToStringTartalom() {
        Foglalas f = new Foglalas(new Utas("A", "B", "C"), new Jarat("X", "Y", "Z", "T1", "T2", Arrays.asList(), Arrays.asList()), "t", Arrays.asList("wifi"));
        String s = f.toString();
        assertTrue(s.contains("wifi"));
    }

    @Test
    public void testNullUtas() {
        Foglalas f = new Foglalas(null, new Jarat("X", "Y", "Z", "T1", "T2", Arrays.asList(), Arrays.asList()), "t", Arrays.asList());
        assertNull(f.getUtas());
    }

    @Test
    public void testNullJarat() {
        Foglalas f = new Foglalas(new Utas("A", "B", "C"), null, "t", Arrays.asList());
        assertNull(f.getJarat());
    }

    @Test
    public void testNullOsztaly() {
        Foglalas f = new Foglalas(null, null, null, Arrays.asList());
        assertNull(f.getOsztaly());
    }
}
