package ru.sbt.test.refactoring.behaviours.impls;

import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.behaviours.Turnable;

import static ru.sbt.test.refactoring.Orientation.*;

public class ClockwiseTurning implements Turnable {
    private Orientation orientation;

    public ClockwiseTurning(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void turn() {
        if (orientation == NORTH) {
            orientation = EAST;
        } else if (orientation == EAST) {
            orientation = SOUTH;
        } else if (orientation == SOUTH) {
            orientation = WEST;
        } else if (orientation == WEST) {
            orientation = NORTH;
        }
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }
}
