import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class CarTransport extends CommonBaseCar {

    private double loadingRadius = 14;
    private boolean rampUp;
    private ArrayList<CommonBaseCar> carsLoaded = new ArrayList<>();
    private final int maxCars = 6;

    @Override
    public void move() {
        double radians = Math.toRadians(direction);
        double newX = currentSpeed * Math.sin(radians);
        double newY = currentSpeed * Math.cos(radians);

        xPosition += newX;
        yPosition += newY;

        if (!carsLoaded.isEmpty()) {
            for (int i = 0; i < carsLoaded.size(); i++) {
                CommonBaseCar car = carsLoaded.get(i);
                car.xPosition = xPosition;
                car.yPosition = yPosition;
            }
        }
    }

    public CarTransport() {
        super(2, Color.blue, 220, "carTransport", 0.0, 0.0, 0.0);
        rampUp = true;
    }

    private boolean isRampUp() {
        return rampUp;
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            rampUp = true;
        }
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0){
            rampUp = false;
        }
    }

    public int getLoadedCars() {
        if (carsLoaded.size() <= maxCars) {
            return carsLoaded.size();
        } else {
            return maxCars;
        }
    }

    public void loadCar(CommonBaseCar car) {
        if (!Objects.equals(car.modelName, "carTransport")) {
            if (isInVicinity(car) && !isRampUp() && getCurrentSpeed() == 0 && carsLoaded.size() < maxCars) {
                carsLoaded.add(car);
            } else {
                System.err.println("CarTransport cannot load car");
            }
        } else {
            System.err.println("CarTransport cannot load another carTransport");
        }
    }

    public void unloadCar() {
        int lastCar = carsLoaded.size() - 1;
        if (!isRampUp() && getCurrentSpeed() == 0 && !carsLoaded.isEmpty()) {
            CommonBaseCar unloadedCar = carsLoaded.remove(lastCar);
            unloadedCar.yPosition = unloadedCar.getYPosition() - 18;
        } else {
            System.err.println("Cannot unload car");
        }
    }

    public boolean isInVicinity(CommonBaseCar car) {
        double xValueVicinityMax = getXPosition() + loadingRadius;
        double xValueVicinityMin = getXPosition() - loadingRadius;

        double yValueVicinityMax = getYPosition() + loadingRadius;
        double yValueVicinityMin = getYPosition() - loadingRadius;

        if (xValueVicinityMin <= car.xPosition && car.xPosition <= xValueVicinityMax) {
            if (yValueVicinityMin <= car.yPosition && car.yPosition <= yValueVicinityMax) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
