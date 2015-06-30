package ru.sbt.test.refactoring.units;

import ru.sbt.test.refactoring.*;
import ru.sbt.test.refactoring.behaviours.Movable;
import ru.sbt.test.refactoring.behaviours.Positionable;
import ru.sbt.test.refactoring.behaviours.Turnable;
import ru.sbt.test.refactoring.behaviours.impls.ClockwiseTurning;
import ru.sbt.test.refactoring.behaviours.impls.MovementInDirection;
import ru.sbt.test.refactoring.behaviours.impls.Positioning;

import static ru.sbt.test.refactoring.Orientation.*;

public class Tractor implements Positionable, Movable, Turnable {

    private ClockwiseTurning clockwiseTurning;
    private MovementInDirection movement;

    public Tractor(Field field) {
        this(field, new Position(0, 0), NORTH);
    }

    public Tractor(Field field, Position position, Orientation orientation) {
        this.clockwiseTurning = new ClockwiseTurning(orientation);
        this.movement = new MovementInDirection(new Positioning(field, position), clockwiseTurning);
    }

    @Override
    public void move() {
        movement.move();
    }

    @Override
    public void turn() {
        clockwiseTurning.turn();
    }

    public Orientation getOrientation() {
        return movement.getOrientation();
    }

    public void setPosition(Position newPosition) {
        movement.setPosition(newPosition);
    }

    public Position getPosition() {
        return movement.getPosition();
    }
}