package ru.sbt.test.refactoring;

public class MoveForward implements Command {
    @Override
    public void execute(Movable unit) {
        unit.move();
    }
}
