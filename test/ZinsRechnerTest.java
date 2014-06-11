import org.junit.Test;

import static org.junit.Assert.*;

public class ZinsRechnerTest {

    @Test
    public void testZinsRechner(){
        double kapital = 20000.00;
        double zinsSatz = 5.0;
        int anlageDauer = 12;
        double zins = ZinsRechner.berechneZins(kapital, zinsSatz, anlageDauer);
        assertEquals(1000.00, kapital * zinsSatz * anlageDauer /(12*100), -1e16);
    }

}