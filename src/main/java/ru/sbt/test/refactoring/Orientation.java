package ru.sbt.test.refactoring;

import static ru.sbt.test.refactoring.SpinDirection.CLOCKWISE;

public enum Orientation {
    NORTH {
        @Override
        public Orientation next(SpinDirection direction) {
            return CLOCKWISE == direction ? EAST : WEST;
        }
    }, EAST {
        @Override
        public Orientation next(SpinDirection direction) {
            return CLOCKWISE == direction ? SOUTH : NORTH;
        }
    }, SOUTH {
        @Override
        public Orientation next(SpinDirection direction) {
            return CLOCKWISE == direction ? WEST : EAST;
        }
    }, WEST {
        @Override
        public Orientation next(SpinDirection direction) {
            return CLOCKWISE == direction ? NORTH : SOUTH;
        }
    };

    abstract public Orientation next(SpinDirection direction);
}