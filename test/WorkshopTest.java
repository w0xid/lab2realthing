import static org.junit.Assert.*;
import org.junit.Test;

public class WorkshopTest {

    Volvo240 volvo240 = new Volvo240();
    Saab95 saab95 = new Saab95();

    @Test
    public void Volvo240WorkshopReceiveAndReturnCars() {
        Workshop<Volvo240> volvo240Workshop = new Workshop<>(10);
        Workshop<Saab95> saab95Workshop = new Workshop<>(10);

        volvo240Workshop.receiveCar(volvo240);
        assertEquals(1, volvo240Workshop.getCarsAmount(), 0.0);

        for (int i = 0; i < 9; i++) {
            volvo240Workshop.receiveCar(volvo240);
        }
        assertEquals(10, volvo240Workshop.getCarsAmount(), 0.0);

        volvo240Workshop.returnCar();
        assertEquals(9, volvo240Workshop.getCarsAmount(), 0.0);
    }
}
