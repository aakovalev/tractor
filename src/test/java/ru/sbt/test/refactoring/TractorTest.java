package ru.sbt.test.refactoring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.NORTH;

public class TractorTest {
    private Field field;

    @Before
    public void setUp() throws Exception {
        field = new Field(5, 5);
    }

    @Test
    public void testShouldMoveForward() {
        Tractor tractor = new Tractor(field);
        tractor.apply(new MoveForward());
        assertEquals(new Position(0, 1), tractor.getPosition());
    }

    @Test
    public void testShouldTurn() {
        Tractor tractor = new Tractor(field);
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
        Tractor tractor = new Tractor(field, NORTH);
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
        Tractor tractor = new Tractor(field);
        MoveForward forward = new MoveForward();
        tractor.apply(forward);
        tractor.apply(forward);
        tractor.apply(forward);
        tractor.apply(forward);
        tractor.apply(forward);

        // this move makes tractor is out of the game field
        tractor.apply(forward);
    }

    @Test
    public void testShouldBeSetAtSpecifiedPosition() throws Exception {
        Tractor tractor = new Tractor(field);
        tractor.setPosition(new Position(1,2));

        assertEquals(new Position(1,2), tractor.getPosition());
    }
}
