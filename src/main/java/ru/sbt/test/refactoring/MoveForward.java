package ru.sbt.test.refactoring;

public class MoveForward implements Command {
    private Movable movable;

    public MoveForward(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute() {
        movable.move();
    }
}
