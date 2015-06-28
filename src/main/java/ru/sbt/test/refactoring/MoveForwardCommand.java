package ru.sbt.test.refactoring;

public class MoveForwardCommand implements Command {
    @Override
    public void execute(Tractor tractor) {
        tractor.move();
    }
}
