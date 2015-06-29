package ru.sbt.test.refactoring;

import org.junit.Test;
import ru.sbt.test.refactoring.commands.impls.Turn;
import ru.sbt.test.refactoring.units.Tower;

import static org.junit.Assert.assertEquals;
import static ru.sbt.test.refactoring.Orientation.*;

public class TowerTest {
    @Test
    public void shouldTurnTowerClockwise() throws Exception {
        Tower tower = new Tower(new Field(3, 3), new Position(1, 1), NORTH);
        Turn turn = new Turn(tower);
        turn.execute();
        assertEquals(EAST, tower.getOrientation());

        turn.execute();
        assertEquals(SOUTH, tower.getOrientation());

        turn.execute();
        assertEquals(WEST, tower.getOrientation());

        turn.execute();
        assertEquals(NORTH, tower.getOrientation());
    }
}
