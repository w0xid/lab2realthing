import org.junit.Test;
import static org.junit.Assert.*;

public class CarTransportTest {

    private CarTransport carTransport = new CarTransport();
    private Saab95 saab = new Saab95();

    public void loadHelper() {
        carTransport.isInVicinity(saab);
        carTransport.lowerRamp();

        for (int i = 0; i < 6; i++) {
            carTransport.loadCar(saab);
        }
    }
    @Test
    public void loadCarTest() {
        loadHelper();

        assertEquals(6, carTransport.getLoadedCars(), 0.0);
    }

    @Test
    public void unloadCarTest() {
        loadHelper();

        carTransport.unloadCar();

        assertEquals(5, carTransport.getLoadedCars(), 0.0);
    }

    @Test
    public void loadedCarPositionWhileMoving() {
        loadHelper();
        carTransport.raiseRamp();

        carTransport.direction = 45;
        carTransport.currentSpeed = 10;
        carTransport.move();

        assertEquals(saab.xPosition, carTransport.xPosition, 0.01);
        assertEquals(saab.yPosition, carTransport.yPosition, 0.01);
    }

}