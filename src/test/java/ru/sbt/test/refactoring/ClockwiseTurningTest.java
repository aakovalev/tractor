package ru.sbt.test.refactoring;

import org.junit.Test;
import ru.sbt.test.refactoring.behaviours.impls.ClockwiseTurning;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.*;

public class ClockwiseTurningTest {
    @Test
    public void shouldTurnsClockwise() throws Exception {
        ClockwiseTurning clockwiseTurning = new ClockwiseTurning(NORTH);
        clockwiseTurning.turn();
        assertEquals(EAST, clockwiseTurning.getOrientation());

        clockwiseTurning.turn();
        assertEquals(SOUTH, clockwiseTurning.getOrientation());

        clockwiseTurning.turn();
        assertEquals(WEST, clockwiseTurning.getOrientation());

        clockwiseTurning.turn();
        assertEquals(NORTH, clockwiseTurning.getOrientation());
    }
}
