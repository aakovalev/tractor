package ru.sbt.test.refactoring.commands.impls;

import ru.sbt.test.refactoring.behaviours.Turnable;
import ru.sbt.test.refactoring.commands.Command;

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
