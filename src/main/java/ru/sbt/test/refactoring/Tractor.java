package ru.sbt.test.refactoring;

import static ru.sbt.test.refactoring.Orientation.NORTH;

public class Tractor implements Positionable, Movable, Turnable {

    private Field field;
    private Orientation orientation = NORTH;
    private Position position = new Position(0, 0);

    public Tractor(Field field) {
        this(field, new Position(0, 0), NORTH);
    }

    public Tractor(Field field, Orientation orientation) {
        this(field, new Position(0, 0), orientation);
    }

    public Tractor(Field field, Position position, Orientation orientation) {
        this.field = field;
        this.position = position;
        this.orientation = orientation;
    }

    public void apply(Command command) {
        command.execute(this);
    }

    @Override
    public void move() {
        if (orientation == NORTH) {
            setPosition(new Position(position.getX(), position.getY() + 1));
        } else if (orientation == Orientation.EAST) {
            setPosition(new Position(position.getX() + 1, position.getY()));
        } else if (orientation == Orientation.SOUTH) {
            setPosition(new Position(position.getX(), position.getY() - 1));
        } else if (orientation == Orientation.WEST) {
            setPosition(new Position(position.getX() - 1, position.getY()));
        }

        if (isOutOfField()) {
            throw new TractorInDitchException();
        }
    }

    private boolean isOutOfField() {
        return position.getX() > field.getWidth() || position.getY() > field.getHeight();
    }

    @Override
    public void turn() {
        turnClockwise();
    }

    public void turnClockwise() {
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

    public Orientation getOrientation() {
        return orientation;
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }

    public Position getPosition() {
        return position;
    }
}