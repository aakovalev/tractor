package ru.sbt.test.refactoring.units;

import ru.sbt.test.refactoring.*;
import ru.sbt.test.refactoring.behaviours.Movable;
import ru.sbt.test.refactoring.behaviours.Positionable;
import ru.sbt.test.refactoring.behaviours.Turnable;
import ru.sbt.test.refactoring.behaviours.impls.ClockwiseTurning;

import static ru.sbt.test.refactoring.Orientation.*;

public class Tractor implements Positionable, Movable, Turnable {

    private Field field;
    private Position position;
    private Turnable clockwiseTurning;

    public Tractor(Field field) {
        this(field, new Position(0, 0), NORTH);
    }

    public Tractor(Field field, Orientation orientation) {
        this(field, new Position(0, 0), orientation);
    }

    public Tractor(Field field, Position position, Orientation orientation) {
        this.field = field;
        this.clockwiseTurning = new ClockwiseTurning(orientation);
        setPosition(position);
    }

    @Override
    public void move() {
        if (NORTH == getOrientation()) {
            setPosition(new Position(position.getX(), position.getY() + 1));
        } else if (EAST == getOrientation()) {
            setPosition(new Position(position.getX() + 1, position.getY()));
        } else if (SOUTH == getOrientation()) {
            setPosition(new Position(position.getX(), position.getY() - 1));
        } else if (WEST == getOrientation()) {
            setPosition(new Position(position.getX() - 1, position.getY()));
        }
    }

    @Override
    public void turn() {
        clockwiseTurning.turn();
    }

    public Orientation getOrientation() {
        return clockwiseTurning.getOrientation();
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;

        if (isOutOfField()) {
            throw new TractorInDitchException();
        }
    }

    public Position getPosition() {
        return position;
    }

    private boolean isOutOfField() {
        return position.getX() > field.getWidth() || position.getY() > field.getHeight();
    }
}