package hf.test;

import hf.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class JaratTest {

    @Test
    public void testGetJaratszam() {
        Jarat j = new Jarat("ABC123", "Budapest", "London", "10:00", "12:00", Arrays.asList("turista"), Arrays.asList("wifi"));
        assertEquals("ABC123", j.getJaratszam());
    }

    @Test
    public void testGetIndulasiRepter() {
        Jarat j = new Jarat("ABC123", "Budapest", "London", "10:00", "12:00", Arrays.asList("turista"), Arrays.asList("wifi"));
        assertEquals("Budapest", j.getIndulasiRepter());
    }

    @Test
    public void testGetErkezesiRepter() {
        Jarat j = new Jarat("ABC123", "Budapest", "London", "10:00", "12:00", Arrays.asList("turista"), Arrays.asList("wifi"));
        assertEquals("London", j.getErkezesiRepter());
    }

    @Test
    public void testGetIndulasiIdo() {
        Jarat j = new Jarat("ABC123", "Budapest", "London", "10:00", "12:00", Arrays.asList("turista"), Arrays.asList("wifi"));
        assertEquals("10:00", j.getIndulasiIdo());
    }

    @Test
    public void testGetErkezesiIdo() {
        Jarat j = new Jarat("ABC123", "Budapest", "London", "10:00", "12:00", Arrays.asList("turista"), Arrays.asList("wifi"));
        assertEquals("12:00", j.getErkezesiIdo());
    }

    @Test
    public void testGetOsztalyok() {
        List<String> oszt = Arrays.asList("turista", "uzleti");
        Jarat j = new Jarat("ABC123", "Budapest", "London", "10:00", "12:00", oszt, Arrays.asList("wifi"));
        assertEquals(oszt, j.getOsztalyok());
    }

    @Test
    public void testGetSzolgaltatasok() {
        List<String> szol = Arrays.asList("wifi", "etkezes");
        Jarat j = new Jarat("ABC123", "Budapest", "London", "10:00", "12:00", Arrays.asList("turista"), szol);
        assertEquals(szol, j.getSzolgaltatasok());
    }

    @Test
    public void testToStringNemNulla() {
        Jarat j = new Jarat("ABC123", "Budapest", "London", "10:00", "12:00", Arrays.asList("turista"), Arrays.asList("wifi"));
        assertNotNull(j.toString());
    }

    @Test
    public void testUresListaSzolgaltatas() {
        Jarat j = new Jarat("X", "A", "B", "X", "X", Arrays.asList("t"), Arrays.asList());
        assertTrue(j.getSzolgaltatasok().isEmpty());
    }

    @Test
    public void testUresListaOsztalyok() {
        Jarat j = new Jarat("X", "A", "B", "X", "X", Arrays.asList(), Arrays.asList("wifi"));
        assertTrue(j.getOsztalyok().isEmpty());
    }
}
