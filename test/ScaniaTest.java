import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaTest {

    @Test
    public void flapAngleTest40Degrees() {
        Scania scania = new Scania(); // Skapar ett nytt objekt
        double initialFlapAngle = 0;
        for (int i = 0; i < 4; i++) {
            scania.raiseFlap();
        }
        double expectedFlapAngle = 40;
        assertEquals(expectedFlapAngle, scania.getFlapAngle(), 0);
    }

    @Test
    public void flapAngleNegativeTest() {
        Scania scania = new Scania(); // Skapar ett nytt objekt
        double initialFlapAngle = 30;
        for (int i = 0; i < 4; i++) {
            scania.lowerFlap();
        }
        double expectedFlapAngle = 0;
        assertEquals(expectedFlapAngle, scania.getFlapAngle(), 0);
    }
}
