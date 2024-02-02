import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {
    /*@Test
    public void testMoveInSpecificDirection() {
        Saab95 saab = new Saab95(); // Skapar ett nytt objekt
        double initialX = saab.getXPosition(); // Initierar X,Y positioner
        double initialY = saab.getYPosition();
        saab.direction = 45;
        saab.currentSpeed = 10;
        saab.move(); // Kör metoden
        double expectedX = (initialX + 7.07);
        double expectedY = (initialY + 7.07);
        assertEquals(expectedX, saab.getXPosition(), 0.01);
        assertEquals(expectedY, saab.getYPosition(), 0.01);
    }*/

    @Test
    public void testMoveAtDifferentAnglesAndSpeeds() {
        Saab95 saab = new Saab95();

        testMoveWithAngleAndSpeed(saab, 45, 10, 7.07, 7.07);
        testMoveWithAngleAndSpeed(saab, -30, 5, -2.5, 4.33);
    }

    private void testMoveWithAngleAndSpeed(Saab95 saab, double angle, double speed, double expectedX, double expectedY) {
        double initialX = saab.getXPosition();
        double initialY = saab.getYPosition();

        saab.direction = angle;
        saab.currentSpeed = speed;

        saab.move();

        assertEquals(initialX + expectedX, saab.getXPosition(), 0.01);
        assertEquals(initialY + expectedY, saab.getYPosition(), 0.01);
    }

    @Test
    public void testTurnLeft15degrees() {
        Saab95 saab = new Saab95(); // Skapar ett nytt objekt
        double initialDirection = saab.getDirection(); // Initierar vinkel i grader
        saab.turnLeft(); // Kör metoden
        double expectedDirection = (initialDirection - 15) + 360; // Förväntad ny vinkel
        assertEquals(expectedDirection, saab.getDirection(), 0.001); // Om värdet är samma som det initiella = true
    }

    @Test
    public void testTurnRight15degrees() {
        Saab95 saab = new Saab95(); // Skapar ett nytt objekt
        double initialDirection = saab.getDirection(); // Initierar vinkel i grader
        saab.turnRight(); // Kör metoden
        double expectedDirection = (initialDirection + 15) % 360; // Förväntad ny vinkel
        assertEquals(expectedDirection, saab.getDirection(), 0.001); // Om värdet är samma som det initiella = true
    }

    @Test
    public void testGas() {
        Saab95 saab = new Saab95(); // Skapar ett nytt objekt
        double initialSpeed = saab.getCurrentSpeed(); // Initierar ett värde för currentSpeed
        double gasAmount = 0.5; // Input
        saab.gas(gasAmount); // Kör metoden
        double expectedSpeed = initialSpeed + saab.speedFactor() * gasAmount; // Förväntad hastighet
        assertEquals(expectedSpeed, saab.getCurrentSpeed(), 0.001); // Om värdet är samma som det initiella = true
    }

    @Test
    public void testBrake() {
        Saab95 saab = new Saab95(); // Skapar ett nytt objekt
        double initialSpeed = saab.getCurrentSpeed(); // Initierar ett värde för currentSpeed
        double brakeAmount = 0.5; // Input
        saab.brake(brakeAmount); // Kör metoden
        double expectedSpeed = Math.max(0, initialSpeed - saab.speedFactor() * brakeAmount); // Förväntad hastighet
        assertEquals(expectedSpeed, saab.getCurrentSpeed(), 0.001); // Om värdet är samma som det initiella = true
    }
}
