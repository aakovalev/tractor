package ru.sbt.test.refactoring;

public class Turn implements Command {
    private Turnable turnable;

    public Turn(Turnable turnable) {
        this.turnable = turnable;
    }

    @Override
    public void execute() {
        turnable.turn();
    }
}
