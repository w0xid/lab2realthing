import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Volvo240Test {
    @Test
    public void testMoveInSpecificDirection() {
        Volvo240 volvo = new Volvo240(); // Skapar ett nytt objekt
        double initialX = volvo.getXPosition(); // Initierar X,Y positioner
        double initialY = volvo.getYPosition();
        volvo.direction = 45;
        volvo.currentSpeed = 10;
        volvo.move(); // Kör metoden
        double expectedX = (initialX + 7.07);
        double expectedY = (initialY + 7.07);
        assertEquals(expectedX, volvo.getXPosition(), 0.01); // Om det initiella värden olikt det nya = true
        assertEquals(expectedY, volvo.getYPosition(), 0.01);
    }

    @Test
    public void testTurnLeft15degrees() {
        Volvo240 volvo = new Volvo240(); // Skapar ett nytt objekt
        double initialDirection = volvo.getDirection(); // Initierar vinkel i grader
        volvo.turnLeft(); // Kör metoden
        double expectedDirection = (initialDirection - 15) + 360; // Förväntad ny vinkel
        assertEquals(expectedDirection, volvo.getDirection(), 0.001); // Om värdet är samma som det initiella = true
    }

    @Test
    public void testTurnRight15degrees() {
        Volvo240 volvo = new Volvo240(); // Skapar ett nytt objekt
        double initialDirection = volvo.getDirection(); // Initierar vinkel i grader
        volvo.turnRight(); // Kör metoden
        double expectedDirection = (initialDirection + 15) % 360; // Förväntad ny vinkel
        assertEquals(expectedDirection, volvo.getDirection(), 0.001); // Om värdet är samma som det initiella = true
    }

    @Test
    public void testGas() {
        Volvo240 volvo = new Volvo240(); // Skapar ett nytt objekt
        double initialSpeed = volvo.getCurrentSpeed(); // Initierar ett värde för currentSpeed
        double gasAmount = 0.5; //Input
        volvo.gas(gasAmount); // Kör metoden
        double expectedSpeed = initialSpeed + volvo.speedFactor() * gasAmount; // Förväntad hastighet
        assertEquals(expectedSpeed, volvo.getCurrentSpeed(), 0.001); // Om värdet är samma som det initiella = true
    }

    @Test
    public void testBrake() {
        Volvo240 volvo = new Volvo240(); // Skapar ett nytt objekt
        double initialSpeed = volvo.getCurrentSpeed(); // Initierar ett värde för currentSpeed
        double brakeAmount = 0.5; //Input
        volvo.brake(brakeAmount); // Kör metoden
        double expectedSpeed = Math.max(0, initialSpeed - volvo.speedFactor() * brakeAmount); // Förväntad hastighet
        assertEquals(expectedSpeed, volvo.getCurrentSpeed(), 0.001); // Om värdet är samma som det initiella = true

    }
}