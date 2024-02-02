import java.awt.*;

    public class Garage<T> {

        private int maxCars;
        private T t;

        //private Accessibility

        public Garage(int maxCars, CommonBaseCar car) {
            this.maxCars = maxCars;

        }

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
        //paramorfism, generiska typer.
    }
