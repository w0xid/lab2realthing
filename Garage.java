import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

public class Garage<T extends CommonBaseCar> {

    private int maxCars;
    private ArrayList<T> cars;

    public Garage(T garage) {;
        this.maxCars = maxCars;
    }

    public void receiveCar(T car) {
        if (cars.size() < maxCars && isCorrectCar(car)) {
            cars.add(car);
        } else {
            System.err.println("Cannot receive car");
        }
    }

    public Optional<T> returnCar() {
        if (!cars.isEmpty()) {
            T car = cars.remove(cars.size() - 1);
            return Optional.of(car);
        } else {
            System.err.println("Cannot return car");
            return Optional.empty();
        }
    }

    public boolean isCorrectCar(T car) {
       /* // ???
        if (car instanceof Volvo240) {
            (????????)
        }*/

        return true;
    }
}
