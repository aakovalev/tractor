package ru.sbt.test.refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.NORTH;

public class MoveForwardTest {
    @Test
    public void canMoveForward() throws Exception {
        Tractor tractor = new Tractor(new Field(5, 5), NORTH);
        Position originalPosition = tractor.getPosition();

        MoveForward moveForward = new MoveForward(tractor);
        moveForward.execute();

        Position expectedPosition = new Position(originalPosition.getX(), originalPosition.getY() + 1);
        assertEquals(expectedPosition, tractor.getPosition());
    }
}