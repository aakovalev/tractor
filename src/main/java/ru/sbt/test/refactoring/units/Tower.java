package ru.sbt.test.refactoring.units;

import ru.sbt.test.refactoring.Field;
import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.Position;
import ru.sbt.test.refactoring.behaviours.Positionable;
import ru.sbt.test.refactoring.behaviours.Turnable;
import ru.sbt.test.refactoring.behaviours.impls.ClockwiseTurning;
import ru.sbt.test.refactoring.behaviours.impls.Positioning;

public class Tower implements Positionable, Turnable {
    private Positioning positioning;
    private ClockwiseTurning clockwiseTurning;

    public Tower(Field field, Position position, Orientation orientation) {
        this.positioning = new Positioning(field, position);
        this.clockwiseTurning = new ClockwiseTurning(orientation);
    }

    @Override
    public void turn() {
        clockwiseTurning.turn();
    }

    @Override
    public void setPosition(Position position) {
        positioning.setPosition(position);
    }

    @Override
    public Position getPosition() {
        return positioning.getPosition();
    }

    @Override
    public Orientation getOrientation() {
        return clockwiseTurning.getOrientation();
    }
}