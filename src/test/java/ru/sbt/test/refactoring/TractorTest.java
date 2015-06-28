package ru.sbt.test.refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.NORTH;

public class TractorTest {

    @Test
    public void testShouldMoveForward() {
        Tractor tractor = new Tractor();
        tractor.apply(new MoveForward());
        assertEquals(new Position(0, 1), tractor.getPosition());
    }

    @Test
    public void testShouldTurn() {
        Tractor tractor = new Tractor();
        tractor.apply("T");
        assertEquals(Orientation.EAST, tractor.getOrientation());

        tractor.apply("T");
        assertEquals(Orientation.SOUTH, tractor.getOrientation());

        tractor.apply("T");
        assertEquals(Orientation.WEST, tractor.getOrientation());

        tractor.apply("T");
        assertEquals(NORTH, tractor.getOrientation());
    }

    @Test
    public void testShouldTurnAndMoveInTheRightDirection() {
        Tractor tractor = new Tractor(NORTH);
        tractor.apply("T");
        tractor.apply(new MoveForward());
        assertEquals(new Position(1, 0), tractor.getPosition());

        tractor.apply("T");
        tractor.apply(new MoveForward());
        assertEquals(new Position(1, -1), tractor.getPosition());

        tractor.apply("T");
        tractor.apply(new MoveForward());
        assertEquals(new Position(0, -1), tractor.getPosition());

        tractor.apply("T");
        tractor.apply(new MoveForward());
        assertEquals(new Position(0, 0), tractor.getPosition());
    }

    @Test (expected = TractorInDitchException.class)
    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Tractor tractor = new Tractor();
        tractor.apply(new MoveForward());
        tractor.apply(new MoveForward());
        tractor.apply(new MoveForward());
        tractor.apply(new MoveForward());
        tractor.apply(new MoveForward());

        // this move makes tractor is out of the game field
        tractor.apply(new MoveForward());
    }

    @Test
    public void testShouldBeSetAtSpecifiedPosition() throws Exception {
        Tractor tractor = new Tractor();
        tractor.setPosition(new Position(1,2));

        assertEquals(new Position(1,2), tractor.getPosition());
    }
}
