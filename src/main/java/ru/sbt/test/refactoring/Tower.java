package ru.sbt.test.refactoring;

import static ru.sbt.test.refactoring.Orientation.NORTH;

public class Tower implements Positionable, Turnable {
    private final Field field;
    private Orientation orientation;
    private Position position;

    public Tower(Field field, Position position, Orientation orientation) {
        this.field = field;
        this.position = position;
        this.orientation = orientation;
    }

    @Override
    public void turn() {
        if (orientation == NORTH) {
            orientation = Orientation.EAST;
        } else if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        } else if (orientation == Orientation.WEST) {
            orientation = NORTH;
        }
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }
}
