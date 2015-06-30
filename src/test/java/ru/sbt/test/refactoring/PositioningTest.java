package ru.sbt.test.refactoring;

import org.junit.Test;
import ru.sbt.test.refactoring.behaviours.impls.Positioning;

import static org.junit.Assert.assertEquals;

public class PositioningTest {
    @Test
    public void shouldPositionTurnableUnit() throws Exception {
        Positioning positioning = new Positioning(new Field(5, 5), new Position(1, 1));
        positioning.setPosition(new Position(2, 3));
        assertEquals(new Position(2, 3), positioning.getPosition());
    }

    @Test (expected = InDitchException.class)
    public void shouldThrowExceptionIfSetOutOfTheField() throws Exception {
        new Positioning(new Field(2, 2), new Position(3, 3));
    }
}
