package ru.sbt.test.refactoring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.*;

public class TractorTest {
    private Field field;

    @Before
    public void setUp() throws Exception {
        field = new Field(5, 5);
    }

    @Test
    public void testShouldMoveForward() {
        Tractor tractor = new Tractor(field);
        MoveForward moveForward = new MoveForward(tractor);
        moveForward.execute();
        assertEquals(new Position(0, 1), tractor.getPosition());
    }

    @Test
    public void testShouldTurn() {
        Tractor tractor = new Tractor(field);
        Turn turn = new Turn(tractor);
        turn.execute();
        assertEquals(EAST, tractor.getOrientation());

        turn.execute();
        assertEquals(SOUTH, tractor.getOrientation());

        turn.execute();
        assertEquals(WEST, tractor.getOrientation());

        turn.execute();
        assertEquals(NORTH, tractor.getOrientation());
    }

    @Test
    public void testShouldTurnAndMoveInTheRightDirection() {
        Tractor tractor = new Tractor(field, NORTH);
        Turn turn = new Turn(tractor);
        turn.execute();
        MoveForward moveForward = new MoveForward(tractor);
        moveForward.execute();
        assertEquals(new Position(1, 0), tractor.getPosition());

        turn.execute();
        moveForward.execute();
        assertEquals(new Position(1, -1), tractor.getPosition());

        turn.execute();
        moveForward.execute();
        assertEquals(new Position(0, -1), tractor.getPosition());

        turn.execute();
        moveForward.execute();
        assertEquals(new Position(0, 0), tractor.getPosition());
    }

    @Test (expected = TractorInDitchException.class)
    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Tractor tractor = new Tractor(field);
        MoveForward forward = new MoveForward(tractor);
        forward.execute();
        forward.execute();
        forward.execute();
        forward.execute();
        forward.execute();

        // this move makes tractor is out of the game field
        forward.execute();
    }

    @Test
    public void testShouldBeSetAtSpecifiedPosition() throws Exception {
        Tractor tractor = new Tractor(field);
        tractor.setPosition(new Position(1, 2));

        assertEquals(new Position(1, 2), tractor.getPosition());
    }
}
