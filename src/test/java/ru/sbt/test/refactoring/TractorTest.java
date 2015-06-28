package ru.sbt.test.refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.NORTH;

public class TractorTest {

    @Test
    public void testShouldMoveForward() {
        Tractor tractor = new Tractor();
        tractor.apply("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
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
        tractor.apply("F");
        assertEquals(1, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
        tractor.apply("T");
        tractor.apply("F");
        assertEquals(1, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());
        tractor.apply("T");
        tractor.apply("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());
        tractor.apply("T");
        tractor.apply("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
    }

    @Test (expected = TractorInDitchException.class)
    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Tractor tractor = new Tractor();
        tractor.apply("F");
        tractor.apply("F");
        tractor.apply("F");
        tractor.apply("F");
        tractor.apply("F");

        // this move makes tractor is out of the game field
        tractor.apply("F");
    }
}
