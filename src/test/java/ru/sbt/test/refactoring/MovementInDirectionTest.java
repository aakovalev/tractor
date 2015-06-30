package ru.sbt.test.refactoring;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.test.refactoring.behaviours.Orientable;
import ru.sbt.test.refactoring.behaviours.impls.MovementInDirection;
import ru.sbt.test.refactoring.behaviours.impls.Positioning;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.*;

public class MovementInDirectionTest {
    private Positioning positioning;

    @Before
    public void setUp() throws Exception {
        positioning = new Positioning(new Field(5, 5), new Position(2, 2));
    }

    @Test
    public void shouldMoveToEast() throws Exception {
        checkMovementTo(EAST, new Position(3, 2));
    }

    @Test
    public void shouldMoveToSouth() throws Exception {
        checkMovementTo(SOUTH, new Position(2, 1));
    }

    @Test
    public void shouldMoveToWest() throws Exception {
        checkMovementTo(WEST, new Position(1, 2));
    }

    @Test
    public void shouldMoveToNorth() throws Exception {
        checkMovementTo(NORTH, new Position(2, 3));
    }

    @Test
    public void shouldMoveToSpecifiedDeltaInSpecifiedDirection() throws Exception {
        int delta = 2;
        MovementInDirection movement = new MovementInDirection(positioning, orientingTo(EAST) , delta);
        movement.move();

        assertEquals(new Position(4, 2), movement.getPosition());
    }

    private void checkMovementTo(Orientation orientation, Position expectedPosition) {
        Orientable constantOrienting = orientingTo(orientation);

        MovementInDirection movement = new MovementInDirection(positioning, constantOrienting);
        movement.move();

        assertEquals(expectedPosition, movement.getPosition());
    }

    private Orientable orientingTo(final Orientation orientation) {
        return new Orientable() {
                @Override
                public Orientation getOrientation() {
                    return orientation;
                }
            };
    }
}