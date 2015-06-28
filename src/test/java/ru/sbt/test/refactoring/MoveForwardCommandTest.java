package ru.sbt.test.refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveForwardCommandTest {
    @Test
    public void canMoveForward() throws Exception {
        Orientation orientation = Orientation.NORTH;
        int initialY = 0;
        Tractor tractor = new Tractor(orientation);
        tractor.move(new MoveForwardCommand());
        assertEquals(initialY + 1, tractor.getPositionY());
    }
}
