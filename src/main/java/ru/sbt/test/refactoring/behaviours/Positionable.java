package ru.sbt.test.refactoring.behaviours;

import ru.sbt.test.refactoring.Position;

public interface Positionable {
    void setPosition(Position position);
    Position getPosition();
}
