import java.awt.*;

public class Scania extends CommonBaseCar {

    private int flapAngle;
    private boolean currentlyMoving;
    public Scania() {
        super(2, Color.blue, 220, "Scania", 0.0, 0.0, 0.0);
        this.flapAngle = 0;
        this.currentlyMoving = false;
    }

    public double getFlapAngle() {
        return flapAngle;
    }

    public void raiseFlap() {
        if (!currentlyMoving) {
            flapAngle = Math.min(flapAngle + 10, 70);
        }
    }

    public void lowerFlap() {
        if (!currentlyMoving) {
            flapAngle = Math.max(flapAngle - 10, 0);
        }
    }

    private boolean isFlapDown() {
        if (flapAngle == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void startEngine() {
        if (isFlapDown()) {
            super.startEngine();
        } else {
            System.err.println("You can't start the truck while trailer is open");
        }
    }

    @Override
    public void gas(double amount) {
        if (isFlapDown()) {
            super.gas(amount);
        } else {
            System.err.println("You can't move while trailer is open");
        }
    }
}