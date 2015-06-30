package ru.sbt.test.refactoring.behaviours.impls;

import ru.sbt.test.refactoring.Orientation;
import ru.sbt.test.refactoring.Position;
import ru.sbt.test.refactoring.behaviours.Movable;
import ru.sbt.test.refactoring.behaviours.Orientable;
import ru.sbt.test.refactoring.behaviours.Positionable;

import static ru.sbt.test.refactoring.Orientation.*;

public class MovementInDirection implements Positionable, Orientable, Movable {

    private final Positioning positioning;
    private final Orientable orienting;

    public MovementInDirection(Positioning positioning, Orientable orienting) {
        this.positioning = positioning;
        this.orienting = orienting;
    }

    @Override
    public void move() {
        Position position = getPosition();
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