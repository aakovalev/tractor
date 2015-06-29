package ru.sbt.test.refactoring.commands.impls;

import ru.sbt.test.refactoring.behaviours.Movable;
import ru.sbt.test.refactoring.commands.Command;

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
