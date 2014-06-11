package de.klotzsche.playground.test;

import de.klotzsche.playground.Geldbetrag;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeldbetragTest {

    @Test
    public void testWechselGeld0Euro() throws Exception {
        int[] expected = {0,0,0,0,0,0,0,0};
        int[] result = Geldbetrag.wechselGeld(0.00);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWechselGeld1Cent() throws Exception {
        int[] expected = {0,0,0,0,0,0,0,1};
        int[] result = Geldbetrag.wechselGeld(0.01);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWechselGeld2Cent() throws Exception {
        int[] expected = {0,0,0,0,0,0,1,0};
        int[] result = Geldbetrag.wechselGeld(0.02);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWechselGeld10Cent() throws Exception {
        int[] expected = {0,0,0,0,1,0,0,0};
        int[] result = Geldbetrag.wechselGeld(0.10);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWechselGeld199Cent() throws Exception{
        int[] expected = {0,1,1,2,0,1,2,0};
        int[] result = Geldbetrag.wechselGeld(1.99);
        assertArrayEquals(expected, result);
    }
}