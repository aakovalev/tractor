package ru.sbt.test.refactoring.behaviours.impls;

import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.behaviours.Turnable;

import static ru.sbt.test.refactoring.SpinDirection.CLOCKWISE;

public class ClockwiseTurning implements Turnable {
    private Orientation orientation;

    public ClockwiseTurning(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void turn() {
        orientation = orientation.next(CLOCKWISE);
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }
}
