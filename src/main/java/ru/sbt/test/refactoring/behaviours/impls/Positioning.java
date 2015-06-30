package ru.sbt.test.refactoring.behaviours.impls;

import ru.sbt.test.refactoring.Field;
import ru.sbt.test.refactoring.Position;
import ru.sbt.test.refactoring.InDitchException;
import ru.sbt.test.refactoring.behaviours.Positionable;

public class Positioning implements Positionable {
    private Field field;
    private Position position;

    public Positioning(Field field, Position position) {
        this.field = field;
        setPosition(position);
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;

        if (isOutOfField()) {
            throw new InDitchException();
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

    private boolean isOutOfField() {
        return position.getX() > field.getWidth() || position.getY() > field.getHeight()
                || position.getX() < 0 || position.getY() < 0;
    }
}
