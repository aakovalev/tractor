package ru.sbt.test.refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveForwardTest {
    @Test
    public void canMoveForward() throws Exception {
        Orientation orientation = Orientation.NORTH;
        Tractor tractor = new Tractor(orientation);
        Position originalPosition = tractor.getPosition();

        tractor.apply(new MoveForward());

        Position expectedPosition = new Position(originalPosition.getX(), originalPosition.getY() + 1);
        assertEquals(expectedPosition, tractor.getPosition());
    }
}