package ru.sbt.test.refactoring.behaviours.impls;

import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.Position;
import ru.sbt.test.refactoring.behaviours.Movable;
import ru.sbt.test.refactoring.behaviours.Orientable;
import ru.sbt.test.refactoring.behaviours.Positionable;

import static ru.sbt.test.refactoring.Orientation.*;

public class MovementInDirection implements Positionable, Orientable, Movable {

    private final Positioning positioning;
    private final int delta;
    private final Orientable orienting;

    public MovementInDirection(Positioning positioning, Orientable orienting) {
        this(positioning, orienting, 1);
    }

    public MovementInDirection(Positioning positioning, Orientable orienting, int delta) {
        this.positioning = positioning;
        this.orienting = orienting;
        this.delta = delta;
    }

    @Override
    public void move() {
        //@todo: consider further refactoring, replacing branches to polymorphic call of dedicated
        // moving strategies subclasses (i.e. MovingNorth, MovingEast)
        // or configurable instances of some movement class
        Position position = getPosition();
        if (NORTH == getOrientation()) {
            setPosition(new Position(position.getX(), position.getY() + delta));
        } else if (EAST == getOrientation()) {
            setPosition(new Position(position.getX() + delta, position.getY()));
        } else if (SOUTH == getOrientation()) {
            setPosition(new Position(position.getX(), position.getY() - delta));
        } else if (WEST == getOrientation()) {
            setPosition(new Position(position.getX() - delta, position.getY()));
        }
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
        return orienting.getOrientation();
    }
}