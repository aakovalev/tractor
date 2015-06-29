package ru.sbt.test.refactoring;

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
