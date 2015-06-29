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

        turnAndMove(tractor);
        assertEquals(new Position(1, 0), tractor.getPosition());

        turnAndMove(tractor);
        assertEquals(new Position(1, -1), tractor.getPosition());

        turnAndMove(tractor);
        assertEquals(new Position(0, -1), tractor.getPosition());

        turnAndMove(tractor);
        assertEquals(new Position(0, 0), tractor.getPosition());
    }

    private void turnAndMove(Tractor tractor) {
        Turn turn = new Turn(tractor);
        MoveForward moveForward = new MoveForward(tractor);
        turn.execute();
        moveForward.execute();
    }

    @Test (expected = TractorInDitchException.class)
    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Tractor tractor = new Tractor(new Field(3, 3), new Position(3, 0), EAST);
        MoveForward forward = new MoveForward(tractor);

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
